import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/11403
 * 
 * 188ms
 * 문제 접근 방법 & 사용 알고리즘 : 
 * - 노드 수가 적어 플로이드워셜을 사용 , 0이 들어왔다면 임의의 큰 값을 넣어 갈 수 없음을 나타낸다.
 * 
 */

public class P_11403 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine()); // 노드의 수
        int[][] distance = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j < N + 1; j++) {
                int dis = Integer.parseInt(st.nextToken());
                distance[i][j] = dis == 0 ? 10000000 : 1;
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
                if (distance[i][j] < 10000000) {
                    sb.append("1 ");
                } else {
                    sb.append("0 ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}