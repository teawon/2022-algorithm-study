// 문제 주소 :  https://www.acmicpc.net/problem/11052

// 메모리 및 시간 : 14480KB || 148ms

// 문제 접근 방법 & 사용 알고리즘: 


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_11052 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 카드의 개수 
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 가격
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i < N + 1; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N + 1; i++)
            for (int j = 1; j <= i; j++)
                dp[i] = Math.max(dp[i], arr[j] + dp[i - j]);

        System.out.println(dp[N]);
    }
}
