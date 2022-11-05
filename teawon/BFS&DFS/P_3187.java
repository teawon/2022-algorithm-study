import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/3187
 * 
 * 문제 접근 방법 & 사용 알고리즘: BFS로 각 공간을 순회하는데 각 공간마다 늑대나 양의 개수를 카운팅했다.
 * BFS로 푼 이유는 특별하게 경로를 찾는 문제도 아니고 특정 공간을 차례대로 탐색해가야한다고 생각해서 BFS사용
 */

public class P_3187{

    
    public static int N;
    public static int M;
    public static int[] dy = { -1 ,0, 1, 0 }; //위에부터 시계방향 검색
    public static int[] dx = {0, 1, 0, -1};
    public static int min = 99999;

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

        int N = Integer.parseInt(st.nextToken()); // 행의 수
        int M = Integer.parseInt(st.nextToken()); // 열의 수

        char[][] array = new char[N][M]; //농장 정보
        for(int y=0; y<N; y++){
            String line = br.readLine();
            for(int x=0; x<M; x++){       
                array[y][x] = line.charAt(x);
            }
        }


        int sheepCount = 0;
        int wolfCount = 0;

        for(int y_=0; y_<N; y_++){
            for(int x_=0; x_<M; x_++){   
                int sheep = 0;
                int wolf = 0;   
               
                if(array[y_][x_] != '#'){ //벽이 아니라면 해당 공간을 BFS로 탐색한다.
                    
                    if(array[y_][x_] == 'v') wolf++;
                    if(array[y_][x_] == 'k') sheep++;
                    array[y_][x_] = '#'; //방문 지역은 벽으로 막는다

                    Queue<Node> q = new LinkedList<>(); //해당 지점을 중심으로 카운팅 후 값 대입
                    q.offer(new Node(x_,y_));
             

                    while(!q.isEmpty()) {
                        Node temp = q.poll();
                        int x = temp.getX();
                        int y = temp.getY();
                    
                        for(int d=0; d<4; d++){
                            if(x+dx[d] < 0 || x+dx[d] >= M || y+dy[d] <0 || y+dy[d] >=N || array[y+dy[d]][x+dx[d]] == '#')  continue;
                            
                            if(array[y+dy[d]][x+dx[d]] == 'v') wolf++;  //해당 지점 동물 카운팅
                            if(array[y+dy[d]][x+dx[d]] == 'k') sheep++; 

                            array[y+dy[d]][x+dx[d]] = '#'; //방문 지역은 벽으로 막는다
                            q.offer(new Node(x+dx[d], y+dy[d]));
                        }
                    }

                    if(wolf < sheep) wolf=0; //양이 많으면 늑대는 다 잡아먹힌다
                    else sheep = 0; //그렇지 않다면 양이 잡아먹힌다

                    wolfCount+= wolf;
                    sheepCount+=sheep;
                    
                }

            }
                
        }
            
       System.out.println(sheepCount+" "+wolfCount);
    }
 
}




