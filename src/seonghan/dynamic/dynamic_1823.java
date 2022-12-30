package seonghan.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1823
 *
 * 132ms
 * start 와 end를 사용하여 index 체크
 * 5번
 *
 */
public class dynamic_1823 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[N+1][N+1];
        System.out.println(findDP(1,N));
    }
    static int N;
    static int[] arr;
    static int[][] dp;
    static int findDP(int start, int end){
        if(start > end){
            return 0;
        }
        if(dp[start][end] != 0){
            return dp[start][end];
        }
        int index = N-(end-start);

        dp[start][end] = Math.max(findDP(start+1,end)+ (arr[start]*index), findDP(start,end-1)+(arr[end]*index));

        return dp[start][end];
    }
}
