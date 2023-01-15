// 문제 주소 :  https://www.acmicpc.net/problem/11403

// 메모리 및 시간 : 17956KB || 376ms

// 문제 접근 방법 & 사용 알고리즘: 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_11403 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 001. 정점의 개수 N 입력
        int N = Integer.parseInt(br.readLine());

        // 002. 인접행렬
        int[][] maps = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                maps[i][j] = temp;
            }
        }

        // 003. 배열 복사(가리키는 대상이 다름)
        int[][] dp = maps.clone();

        // 004. 거쳐가는 노드 k
        for (int k = 0; k < N; k++)
            // 005. 출발노드 i
            for (int i = 0; i < N; i++)
                // 006. 도착노드 j
                for (int j = 0; j < N; j++)
                    if (dp[i][j] == 0)
                        if (dp[i][k] == 1 && dp[k][j] == 1)
                            dp[i][j] = 1;

        // 007. 결과 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(maps[i][j] + " ");
            }
            System.out.println();
        }
    }
}
