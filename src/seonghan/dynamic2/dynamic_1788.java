package seonghan.dynamic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
//F(1) = F(0) + F(-1) = 0 + 1  > F(-1) = 1
//
//F(0) = F(-1) + F(-2) = 1 + (-2)  > F(-2) = -2
//
//F(-1) = F(-2) + F(-3) = (-2) + 3  > F(-3) = 3
//
//F(-2) = F(-3) + F(-4) = 3 + (-5)  > F(-4) = -5
//264ms
//1번 문제
public class dynamic_1788 {
    static int[] dp;
    static final int mod = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n > 0) {
            System.out.println(1);
        } else if (n < 0) {
            n = -n;
            if (n % 2 == 0) {
                System.out.println(-1);
            } else {
                System.out.println(1);
            }
        } else {
            System.out.println(0);
        }

        dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fibo(n));

    }

    static int fibo(int x){
        if(x==0) return 0;
        if(x==1||x==2) return 1;
        if(dp[x]!=-1) return dp[x];
        return dp[x] = (fibo(x-1)%mod + fibo(x-2)%mod)%mod;
    }
}
