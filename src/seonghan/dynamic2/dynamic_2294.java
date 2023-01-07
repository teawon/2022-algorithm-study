package seonghan.dynamic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// 96ms
//dp[0] = 0 1원 동전으로 1원을 만들 수 있는 경우의 수는 0원을 만들 수 있는 경우의 수 + 1;

public class dynamic_2294  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];

        for(int i=0;i<n;i++){
            coin[i] = Integer.parseInt(br.readLine());

        }

        int dp[] = new int[k+1];
        Arrays.fill(dp,100001);
        dp[0] = 0;

        for(int i=0;i<n;i++){
            for(int j = coin[i]; j<=k;j++){
                dp[j] = Math.min(dp[j],dp[j-coin[i]]+1);
            }
        }


        System.out.println(dp[k] == 100001 ? -1 : dp[k]);
    }
}
