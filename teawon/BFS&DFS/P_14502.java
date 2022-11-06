import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/14502
 * 
 * 문제 접근 방법 & 사용 알고리즘: 모든 경우의 수에 대해 벽을 두고 바이러스의 영역계산해보기 (지도의 최대크기는 많아도 8보다 이하이므로 비현실적이지 않을 듯
 * 
 *  - 특히 벽세우기 같은 경우 (모든 경우의 수 대입) DFS를 활용하는 방법 이해하기. 
 */

public class P_14502{

    public static int[][] array = new int[8][8]; //미로 정보
    public static int[][] copy = new int[8][8]; //copy
    public static int N;
    public static int M;
    public static int maxValue = -1;
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
        
    

         //바이러스 공간 정보 (0: 빈칸 , 1:벽 , 2:바이러스)
        for(int y=0; y<N; y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<M; x++){       
                array[y][x] = Integer.parseInt(st.nextToken());
            }
        }


        buildWall(0);
        System.out.println(maxValue);

    }


    public static void buildWall(int count){
   
        if(count == 3){
            for(int i=0; i<N; i++){
                copy[i] = array[i].clone();
            }
            spreadVirus();
            maxValue = Math.max(calCount(), maxValue);
            return;
        }

        for(int y=0; y<N; y++){
            for(int x=0; x<M; x++){
                if(array[y][x] == 0) {
                    array[y][x] = 1;
                    buildWall(count+1);
                    array[y][x] = 0;
                }
            }
        }
    }


    public static void spreadVirus(){
        for(int y_=0; y_<N; y_++){
            for(int x_=0; x_<M; x_++){   

                if(copy[y_][x_] == 2){ //바이러스라면 퍼뜨린다.
                    
                    Queue<Node> q = new LinkedList<>(); //해당 지점을 중심으로 카운팅 후 값 대입
                    q.offer(new Node(x_,y_));
             
                    while(!q.isEmpty()) {
                        Node temp = q.poll();
                        int x = temp.getX();
                        int y = temp.getY();
                    
                        for(int d=0; d<4; d++){
                            if(x+dx[d] < 0 || x+dx[d] >= M || y+dy[d] <0 || y+dy[d] >=N || copy[y+dy[d]][x+dx[d]] != 0)  continue;
                            copy[y+dy[d]][x+dx[d]] = 2; //방문 지역은 바이러스가 된다
                            q.offer(new Node(x+dx[d], y+dy[d]));
                        }
                    }
                }
            }
        }       
    }

    public static int calCount(){ //안전 공간을 계산한다.
        int count = 0;
        for(int y=0; y<N; y++){
            for(int x=0; x<M; x++){
                if(copy[y][x] == 0) count++;
            }
        }

        return count;
    }
}




