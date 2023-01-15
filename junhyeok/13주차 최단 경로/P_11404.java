// 문제 주소 :  https://www.acmicpc.net/problem/11404

// 메모리 및 시간 : 43304KB || 448ms

// 문제 접근 방법 & 사용 알고리즘: 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_11404 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 000. Integer.MAX_VALUE, 100,001로 넣으면 틀림
        final int NUM_MAX = Integer.MAX_VALUE / 2 - 1;

        // 001. 도시의 개수 N 입력
        int N = Integer.parseInt(br.readLine());

        // 002. 인접행렬 
        int[][] maps = new int[N][N];

        // 003. 인접행렬 초기화
        for (int[] array : maps) 
            Arrays.fill(array, NUM_MAX);

        // 004. 버스의 개수 M 입력
        int M = Integer.parseInt(br.readLine());

        // 005. 버스의 정보 입력(시작 도시, 도착 도시, 비용)
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            maps[a][b] = Math.min(maps[a][b], c);
        }

        int[][] dp = maps.clone();

        // 006. 거쳐가는 노드 k
        for (int k = 0; k < N; k++)
            // 007. 출발노드 i
            for (int i = 0; i < N; i++)
                // 008. 도착노드 j
                for (int j = 0; j < N; j++)
                    if (dp[i][k] + dp[k][j] < dp[i][j])
                        dp[i][j] = dp[i][k] + dp[k][j];

        // 009. 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] == NUM_MAX || i == j)
                    sb.append(0 + " ");
                else
                    sb.append(dp[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
