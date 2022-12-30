import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1788
 *  22128KB | 144ms
 * 문제 접근 방법 & 사용 알고리즘: 
 * f(-1) = f(1) - f(0) 
 * f(-2) = f(0) - f(-1) 
 * 즉 음수라면 f(n) = f(n+2) - f(n+1)
*/

public class P_1788 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 입력받는 정수
        long[] fib = new long[1000001];

        fib[0] = 0;
        fib[1] = 1;

        if (N < 0) {
            for (int i = 2; i < Math.abs(N) + 1; i++) {
                fib[i] = (fib[i - 2] - fib[i - 1]) % 1000000000;
            }
        } else {
            for (int i = 2; i < Math.abs(N) + 1; i++) {
                fib[i] = (fib[i - 2] + fib[i - 1]) % 1000000000;
            }
        }

        long result = fib[Math.abs(N)];
        if (result < 0) {
            System.out.println("-1");
            System.out.println(Math.abs(result));
        } else if (result > 0) {
            System.out.println("1");
            System.out.println(Math.abs(result));
        } else {
            System.out.println("0");
            System.out.println(Math.abs(result));
        }
    }

}