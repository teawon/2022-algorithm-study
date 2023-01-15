import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/11404
 * 
 * 472ms
 * 문제 접근 방법 & 사용 알고리즘 : 
 * - Integer.max값 사용시 오버플로우 연산주의
 * 
 */

public class P_11404 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine()); // 도시의 수(노드)
        int M = Integer.parseInt(br.readLine()); // 버스의 수(간선)
        int[][] distance = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) { // 자기 자신이라면 0, 그렇지 않다면 INF값 초기화
            for (int j = 1; j < N + 1; j++) {
                distance[i][j] = i == j ? 0 : 100000001;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            if (dis < distance[start][target]) {
                distance[start][target] = dis;
            }

        }

        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {

                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                sb.append((distance[i][j] == 100000001 ? 0 : distance[i][j]) + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }
}