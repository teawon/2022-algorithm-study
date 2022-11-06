package seonghan.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
/*
 * 문제 주소 :  https://www.acmicpc.net/problem/3187
 *
 * 문제 접근 방법 & 사용 알고리즘:
 * BFS로 양과 늑대 카운트 후 비교
 *
 */
public class dfs_bfs_3187 {
    static char[][] board;
    static int v = 0; // 늑대
    static int k = 0; // 양
    static int R;
    static int C;
    static boolean visited[][];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt(); // 세로
        C = sc.nextInt(); // 가로
        board = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String temp = sc.next();
            for (int j = 0; j < C; j++) {
                board[i][j] = temp.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j]!='#' && !visited[i][j]) {
                    bfs(new Point(i, j));
                }
            }
        }
        System.out.println(k + " " + v);
    }

    public static void bfs(Point point) {
        Queue<Point> q = new LinkedList<>();
        q.offer(point);
        visited[point.r][point.c] = true;
        int wolfCnt = 0;
        int sheepCnt = 0;
        while (!q.isEmpty()) {
            Point point1 = q.poll();
            int r = point1.r;
            int c = point1.c;
            if (board[r][c]=='k') {
                sheepCnt++;
            } else if (board[r][c]=='v') {
                wolfCnt++;
            }

            for (int i = 0; i < 4; i++) {
                int r2 = point1.r + dx[i];
                int c2 = point1.c + dy[i];
                if ((r2 > 0 && r2 < R && c2 > 0 && c2 < C)&& !visited[r2][c2]&&board[r2][c2]!='#'){
                    visited[r2][c2] = true;
                    q.offer(new Point(r2,c2));
                }
            }
        }

        if(sheepCnt>wolfCnt){
            k += sheepCnt;
        }else{
            v += wolfCnt;
        }


    }

    static class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
