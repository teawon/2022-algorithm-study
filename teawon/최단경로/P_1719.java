import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1719
 * 
 * 396ms
 * 문제 접근 방법 & 사용 알고리즘 : 플로이드 워셜 풀이방법

 * 
 */

public class P_1719 {

    static int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 간선의 수

        int[][] distance = new int[N + 1][N + 1];
        int[][] path = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                distance[i][j] = i == j ? 0 : INF;

            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            distance[start][target] = dis;
            distance[target][start] = dis;
            path[start][target] = start;
            path[target][start] = target;

        }

        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        // System.out.println("k - " + k + "를 경유해서 " + i + "에서 " + j + "로 이동합니다.");

                        path[i][j] = path[k][j];

                    }
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {

                sb.append(path[j][i] == 0 ? "-" : path[j][i]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}