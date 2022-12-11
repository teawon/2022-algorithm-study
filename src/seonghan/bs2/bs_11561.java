package seonghan.bs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/11561
 *
 *  1부터 N 까지의 합의 N보다 작은 최대값 n(n+1)/2
 * 340ms
 *
 */

public class bs_11561 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            long N = Long.parseLong(br.readLine());
            long min = 1;
            long max = Integer.MAX_VALUE;
            long answer = 1;

            while(min <= max){
                long mid = (min + max )/2;
                long temp = mid * (mid+1)/2;

                if(temp > N) max = mid-1;
                else {
                    answer = Math.max(mid,answer);
                    min = mid + 1;
                }
            }
            System.out.println(answer);
        }


    }
}
