package seonghan.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
카드 i 개를 구매하는 방법:
 카드 1개가 들어있는 카드팩을 구매하고, 카드 i-1 개를 구입한다. 또는
 카드 2개가 들어있는 카드팩을 구매하고, 카드 i-2 개를 구압한다. 또는
 카드 3개가 들어있는 카드팩을 구매하고, 카드 i-3 개를 구입한다. ..........

 즉 , dp[i] = p[n] + dp[i-n]

 3번 문제
 100ms
* */
public class dynamic_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=i;j++){
                dp[i] = Math.max(dp[i],dp[i-j]+arr[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
