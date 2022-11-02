import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/2178
 * 
 * 문제 접근 방법 & 사용 알고리즘: 
 * BFS에서 방문노드 처리위치에 따라 메모리사용량이 다르다. 주의하기 
 * >> 큐에 넣기전에 해당값을 방문처리해야 중복해서 방문하지 않는다. 역순으로하면 중복으로 큐에 같은 노드가 들어감 (68번째 줄)
 */

public class P_2178_BFS {

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

        int[][] array = new int[100][100]; //미로 정보
        int[][] visited = new int[100][100]; //방문 여부 확인
    
        int[] dy = { -1 ,0, 1, 0 }; //위에부터 시계방향 검색
        int[] dx = {0, 1, 0, -1};

        int N = Integer.parseInt(st.nextToken()); // 행의 수
        int M = Integer.parseInt(st.nextToken()); // 열의 수

        
        for(int y=0; y<N; y++){
            String numbers = br.readLine();
            for(int x=0; x<M; x++){       
                array[y][x] = numbers.charAt(x)-'0';
        
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0));

        while(!q.isEmpty()) {
            Node node = q.poll();
            int y= node.getY();
            int x= node.getX();
            
            
            
            for(int d=0; d<4; d++){
                if(x+dx[d] < 0 || x+dx[d] >= M || y+dy[d] <0 || y+dy[d] >=N || array[y+dy[d]][x+dx[d]] == 0 || visited[y+dy[d]][x+dx[d]] == 1)  continue;
                array[y+dy[d]][x+dx[d]] = array[y][x]+1;
                visited[y+dy[d]][x+dx[d]] = 1;
                q.offer(new Node(x+dx[d],y+dy[d]));
            }

        }
        System.out.println(array[N-1][M-1]);
    }

}



