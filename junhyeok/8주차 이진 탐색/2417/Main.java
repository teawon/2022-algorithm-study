// 문제 주소 :  https://www.acmicpc.net/problem/10816

// 메모리 및 시간 : 14252KB | 128ms

/* 문제 접근 방법 & 사용 알고리즘: 
 * . 
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        long left = 0L;
        long right = n;
        long middle = 0L;

        while(left <= right) {
            middle = (left + right) / 2;
            
            // middle * middle로 쓰면 long범위까지 짤리기 때문에 안됨
            long result = (long)Math.pow(middle, 2);

            if (result >= n)
                right = middle - 1;
            
            if (result < n)
                left = middle + 1;
        }

        System.out.println(left);
    }
}