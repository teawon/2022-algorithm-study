import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1699
 *  15604KB | 2516ms
 * 문제 접근 방법 & 사용 알고리즘: 
 * 1:1 / 2:2 / 3:3 / 4:2(2^2) / 5:3 (4+1) ...
 * 5라는 숫자는 4+1 / 3+2로 나타낼 수 있다.
 * 6은 5+1 / 4+2 / 3+3 .. 즉 n은 (n-1....1)의 숫자의 덧셈으로 쪼개짐
 * 
 * Q. 시간을 더 줄이는 방법?
 
*/

public class P_1699 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 입력받는 정수
        int dp[] = new int[N + 1];

        for (int i = 2; i * i < N + 1; i++) { // 하나의 제곱근으로 나누어지는 예외케이스에 대한 값 저장
            dp[i * i] = 1;
        }

        dp[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            if (dp[i] != 0)
                continue;
            dp[i] = i;
            for (int j = 1; j <= ((i + 1) / 2); j++) { // 10이라면 5까지만 11이라면 5까지만
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }

        }
        System.out.println(dp[N]);

    }

}