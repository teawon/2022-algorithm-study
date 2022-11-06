import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/2573
 * 
 * 문제 접근 방법 & 사용 알고리즘: 
 * 1) 빙산을 녹이기 (BFS)
 * 2) 빙산이 2개로 나뉘어졌는 지 확인하기 - 처음 BFS를 돌릴 때 빙산이 이어져있다면 한번의 BFS로 모든 값을 방문할 수 있다. 
 * 따라서 Flag변수를 통해 BFS를 돌린 이후에 방문하지 않은 지역이 있다면 빙산이 갈라졌다는 의미
 */

public class P_2573 {

    public static int[][] array = new int[300][300]; //빙산 정보
    public static boolean[][] visited = new boolean[300][300]; //방문 정보
    public static int N;
    public static int M;
    public static int[] dy = { -1 ,0, 1, 0 }; //위에부터 시계방향 검색
    public static int[] dx = {0, 1, 0, -1};
 

    public static class Node {
        int x;
        int y;

        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }

        public int getX(){
            return x;
        }

        public int getY(){
            return y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 행의 수
        M = Integer.parseInt(st.nextToken()); // 열의 수

        
        for(int y=0; y<N; y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<M; x++){       
                array[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int time = -1; //빙산이 녹는데 걸리는 시간

        boolean isDivided = false; //빙산이 2개 이상으로 나뉘어졌는지 확인

        while(!isDivided){
            int y=0;
            int x=0;
            time++;
            boolean flag = false; //한번의 BFS로 방문하지 않은 지역이 있는지 확인

            for(y=0; y<N; y++){
                for(x=0; x<M; x++){
                    if(array[y][x]!=0 && visited[y][x] == false){
                        if(flag == true){ //첫번째 BFS로 방문하지 않은 지역이 온다면 두개 이상의 빙산으로 나뉘어졌다는 의미
                            isDivided = true;
                            break;
                        }
                        flag = true; 
                        bfs(x,y);
                    }
                }
            }
            if(flag == false){ //만약 한번에 녹았다면 =(모든 노드값이 0이라면)
                time = 0;
                isDivided = true;
                break;
            }

            for(int i =0; i<N; i++){ //값을 초기화하고 다시 빙산을 녹이러간다.
                Arrays.fill(visited[i],false);
            }
            flag = false;

        }
        
        System.out.println(time);
    }

    public static void bfs(int x_, int y_){ //빙산이 녹는다.

        visited[y_][x_] = true;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x_,y_));

        while(!q.isEmpty()) {
            int count = 0; //빙산과 맞닿아있는 바다의 개수
            Node node = q.poll();
            int y= node.getY();
            int x= node.getX();
            
            
            
            for(int d=0; d<4; d++){
                if(x+dx[d] < 0 || x+dx[d] >= M || y+dy[d] <0 || y+dy[d] >=N || visited[y+dy[d]][x+dx[d]] == true )  continue;
                    if(array[y+dy[d]][x+dx[d]] == 0) {
                        count++; 
                    }
                    else{
                        visited[ y+dy[d]][x+dx[d]] = true; //방문지역 확인 
                        q.offer(new Node(x+dx[d],y+dy[d])); // 큐에 데이터 넣기
                    }
            
                }

                array[y][x] = array[y][x]-count>=0 ? array[y][x]-count : 0; 
            }
        }
    }





