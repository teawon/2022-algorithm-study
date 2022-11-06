import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1260
 * 
 * 문제 접근 방법 & 사용 알고리즘: 
 * 이 문제는 애초에 DFS로 풀이하면 안된다. 
 * "모든 경로를 하나씩 다 순회하며 도착지에 도달"하게 되면 시간이 오래걸린다. 만약 특정 경로마다 가중치가있거나 복잡한 길을 찾는거라면 DFS가 맞지만
 * 이 문제에서 요구하는건 최단경로를 단순히 찾아야하므로 BFS로 풀어야함. 애초에 시간초과뜸ㅜ
 */

public class P_2178_DFS {

    public static int[][] array = new int[100][100]; //미로 정보
    public static int N;
    public static int M;
    public static int[] dy = { -1 ,0, 1, 0 }; //위에부터 시계방향 검색
    public static int[] dx = {0, 1, 0, -1};
    public static int min = 99999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 행의 수
        M = Integer.parseInt(st.nextToken()); // 열의 수

        
        for(int y=0; y<N; y++){
            String numbers = br.readLine();
            for(int x=0; x<M; x++){       
                array[y][x] = numbers.charAt(x)-'0';
        
            }
        }

        dfs(0,0,1);
        System.out.println(min);
    }
 

    public static void dfs(int x, int y, int count){
       

        if(y==N-1 && x==M-1) {
            min = Math.min(count , min); 
            return;
        }
        

        for(int d=0; d<4; d++){
            if(x+dx[d] < 0 || x+dx[d] >= M || y+dy[d] <0 || y+dy[d] >=N || array[y+dy[d]][x+dx[d]] == 0)  continue;
            array[y+dy[d]][x+dx[d]] = 0;
            dfs(x+dx[d] , y+dy[d], count+1);
            array[y+dy[d]][x+dx[d]] = 1; //다른 경우의 수에서 탐색이 가능하도록 방문흔적을 다시 풀어줘야한다.
            
        }
    }
}




