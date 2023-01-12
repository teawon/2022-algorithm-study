import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1865
 * 
 * 1836s
 * 문제 접근 방법 & 사용 알고리즘 : 
 * - 벨만포드 사용
 * - 타임머신 문제와 반대로 무한 값에 대해 체크를 하고 건너뛰면 반대로 떨어져있는 음의 싸이클을 감지하지 못한다. 
 * 
 */

public class P_1865 {

    static int[][] graph;
    static long[] distance;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {

            // 지점의 수 N(1 ≤ N ≤ 500), 도로의 개수 M(1 ≤ M ≤ 2500), 웜홀의 개수 W(1 ≤ W ≤ 200)이 주어진다.
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 지점의 수 (노드)
            int M = Integer.parseInt(st.nextToken()); // 도로의 수 (간선)
            int W = Integer.parseInt(st.nextToken()); // 웜홀의 수 (간선)

            graph = new int[N + 1][N + 1];

            for (int i = 1; i < N + 1; i++) { // 그래프 초기화
                for (int j = 1; j < N + 1; j++) {
                    graph[i][j] = i == j ? 0 : 1000000000;
                }
            }

            for (int m = 0; m < M; m++) { // 각 도로에 대한 정보를 받는다.
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int target = Integer.parseInt(st.nextToken());
                int dis = Integer.parseInt(st.nextToken());
                if (graph[start][target] > dis) {
                    graph[start][target] = dis;
                    graph[target][start] = dis;
                }

            }

            for (int w = 0; w < W; w++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int target = Integer.parseInt(st.nextToken());
                int dis = Integer.parseInt(st.nextToken());
                if (graph[start][target] > -dis) {
                    graph[start][target] = -dis;
                }
            }

            distance = new long[N + 1];
            Arrays.fill(distance, 1000000000);
            distance[1] = 0;
            sb.append(ballman() ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);

    }

    static public boolean ballman() {

        for (int k = 0; k < N; k++) {

            for (int i = 1; i < N + 1; i++) {

                for (int j = 1; j < N + 1; j++) {
                    if (distance[j] > distance[i] + graph[i][j]) {
                        distance[j] = distance[i] + graph[i][j];

                    }
                }

            }

        }

        boolean isLoop = false;
        for (int i = 1; i < N + 1; i++) {

            for (int j = 1; j < N + 1; j++) {
                if (distance[j] > distance[i] + graph[i][j]) {
                    isLoop = true;
                    break;
                }
            }

        }
        return isLoop;
    }
}