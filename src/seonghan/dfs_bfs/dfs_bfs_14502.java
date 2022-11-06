package seonghan.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 문제 주소 :  https://www.acmicpc.net/problem/14502
 *
 * 문제 접근 방법 & 사용 알고리즘: bfs dfs
 * dfs를 활용하여 벽을 세우는 모든 경우의 수에 대한 bfs(바이러스 퍼트리기) -> 안전영역 값들 구해서 그중 최대값
 *
 */
public class dfs_bfs_14502 {
    static int N; // 행
    static int M; // 열
    static int[][] board;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int maxSafeZone = Integer.MIN_VALUE;

    // 0 -> 빈칸  , 1 -> 벽 , 2 -> 바이러스
    // 벽은 3개 세워야함.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(maxSafeZone);

    }

    static void dfs(int wallCnt){
        if(wallCnt == 3){
            bfs();
            return;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j] == 0){
                    board[i][j] = 1;
                    dfs(wallCnt+1);
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j]==2){
                    q.add(new Node(i,j));
                }
            }
        }

        int copyMap[][] = new int[N][M];

        for(int i=0;i<N;i++){
            copyMap[i] = board[i].clone();
        }

        while(!q.isEmpty()){
            Node now = q.poll();
            int x = now.x;
            int y = now.y;

            for(int k=0;k<4;k++){
                int nx = x +dx[k];
                int ny = y + dy[k];

                if(0<=nx && nx<N && 0<=ny && ny<M){
                    if(copyMap[nx][ny] == 0){
                        q.add(new Node(nx,ny));
                        copyMap[nx][ny] = 2;
                    }
                }
            }
        }

        funcSafeZone(copyMap);

    }
    public static void funcSafeZone(int[][] copyMap){
        int safeZone = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(copyMap[i][j]==0){
                    safeZone++;
                }
            }
        }

        if(maxSafeZone< safeZone){
            maxSafeZone = safeZone;
        }
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y){
          this.x = x;
          this.y = y;
        }
    }
}
