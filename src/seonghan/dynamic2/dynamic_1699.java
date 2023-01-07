package seonghan.dynamic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//116ms
public class dynamic_1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int dp[] = new int[n+1];

        for(int i=1;i<=n;i++){
            dp[i] = i;
            for(int j=1;j*j<=i;j++){
                if(dp[i]> dp[i-j*j]+1){
                    dp[i] = dp[i-j*j]+1;
                }
            }


        }


        System.out.println(dp[n]);

    }
}
