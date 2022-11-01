import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1260
 * 
 * 문제 접근 방법 & 사용 알고리즘: BFS, DFS기초 연습 
 */

public class P_1260 {

    public static int[][] array = new int[1001][1001]; //간선의 정보
    public static boolean[] visited = new boolean[1001]; //방문 여부 확인
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //정점의 수
        int M = Integer.parseInt(st.nextToken()); //간선의 수
        int V = Integer.parseInt(st.nextToken()); //시작 정점의 위치
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()); 
            int right = Integer.parseInt(st.nextToken()); 
            array[left][right] = 1;
        }

        dfs(V);
        Arrays.fill(visited, false); //방문 기록 초기화
        System.out.println("");
        bfs(V);
        System.out.println("");
    }
    public static void bfs(int edge){
    
        Queue<Integer> q = new LinkedList<>();
        q.offer(edge);
        
        while(!q.isEmpty()) {
            edge = q.poll();
            System.out.print(edge+" ");
            visited[edge] = true;

            for(int i=1; i<=N; i++){
                if((array[edge][i] == 1 || array[i][edge] == 1) && visited[i] == false){
                    q.offer(i);
                    visited[i] = true;
                }
                
            }

        }

    }   

    public static void dfs(int edge){
        System.out.print(edge+" ");
        visited[edge]=true;
        
        for(int i=1; i<=N; i++){
            if((array[edge][i] == 1 || array[i][edge] == 1)&& visited[i] == false){ //양방향이므로 각 방향을 확인
                dfs(i);
            }
        }
    }
}




