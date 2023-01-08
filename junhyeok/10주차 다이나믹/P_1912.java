// 문제 주소 :  https://www.acmicpc.net/problem/1912

// 메모리 및 시간 : 24216KB || 264ms

// 문제 접근 방법 & 사용 알고리즘: 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1912 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수열 저장
        int[] arr = new int[N];
        // 연속한 값 저장
        int[] dp = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
            
        dp[0] = arr[0];            
        max = arr[0];

        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
