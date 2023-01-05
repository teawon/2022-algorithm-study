import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/11265
 * 
 * 448ms
 * 문제 접근 방법 & 사용 알고리즘 : 
    파티장의 크기가 500까지이므로 (=노드의 개수가 작기때문에) O(n^3)을 가지는 플로이드워셜 사용가능
 * 
 */
public class P_11265 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 파티장 수
        int M = Integer.parseInt(st.nextToken()); // 손님 수 (테스트 케이스 수)
        int[][] distance = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                distance[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {

                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            if (distance[start][end] <= time) {
                sb.append("Enjoy other party\n");
            } else {
                sb.append("Stay here\n");
            }
        }
        System.out.print(sb);
    }
}