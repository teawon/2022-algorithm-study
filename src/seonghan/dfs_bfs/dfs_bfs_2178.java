package seonghan.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 문제 주소 :  https://www.acmicpc.net/problem/2178
 *
 * 문제 접근 방법 & 사용 알고리즘: BFS
 * dx, dy를 만들어 상하좌우로 direction을 바꿔주면서 풀이
 *
 */

public class dfs_bfs_2178 {
    static int N;
    static int M;
    static int[][] board;
    static int[] dx = { -1, 1, 0, 0 }; //x방향배열-상하
    static int[] dy = { 0, 0, -1, 1 }; //y방향배열-좌우
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        // N x M 배열
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            String[] tempArr = temp.split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(tempArr[j]);
            }
        }
        visited = new boolean[N][M];
        visited[0][0] = true;
        solution(0,0);
        System.out.println(board[N-1][M-1]);
    }


    public static void solution(int x, int y){
        Queue<int[] > q = new LinkedList<>();
        q.add(new int[] {x,y});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i=0;i<4;i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX>=N || nextY>=M){
                    continue;
                }
                if(visited[nextX][nextY]||board[nextX][nextY]==0){
                    continue;
                }

                q.add(new int[] {nextX,nextY});
                board[nextX][nextY] = board[curX][curY] + 1;
                visited[nextX][nextY] = true;
            }
        }



    }
}
