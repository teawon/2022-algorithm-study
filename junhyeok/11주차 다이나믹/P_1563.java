// 문제 주소 :  https://www.acmicpc.net/problem/1563

// 메모리 및 시간 : 14272KB	|| 128ms

// 문제 접근 방법 & 사용 알고리즘: 

//

import java.util.*;
import java.io.*;

public class P_1563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        final int D = 1000000;
        int[][][] dp = new int[N+1][2][3];
        dp[1][0][0] = dp[1][1][0] = dp[1][0][1] = 1;

        for(int i = 2; i <=N; i++) {
            dp[i][0][0] = (dp[i-1][0][0] + dp[i-1][0][1] + dp[i-1][0][2]) % D;
            dp[i][0][1] = dp[i-1][0][0] % D;
            dp[i][0][2] = dp[i-1][0][1] % D;
            dp[i][1][0] = (dp[i-1][0][0] + dp[i-1][0][1] + dp[i-1][0][2]
                           + dp[i-1][1][0] + dp[i-1][1][1] + dp[i-1][1][2]) % D;
            dp[i][1][1] = dp[i-1][1][0];
            dp[i][1][2] = dp[i-1][1][1];
        }
        int ans = 0;
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 3; j++) {
                ans += dp[N][i][j];
            }
        }
        System.out.println(ans % D);
    }
}
