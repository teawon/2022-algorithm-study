import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/2294
 *  14776KB | 220ms
 * 문제 접근 방법 & 사용 알고리즘: 
 * 1원 3원 7원이 있다고 가정
 * 2원 : 1+1 
 * 3원 : 1
 * 4원 : 3원+1원 (2)
 * 5원 : 4원+1원 (3)
 * 6원 : 3원+3원 (2)
 * 7원 : 7원 (1)
 * 
 * 
 
*/

public class P_2294 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 동전의 수
        int sum = Integer.parseInt(st.nextToken()); // 가치의 합
        int[] money = new int[N + 1];
        int[] dp = new int[sum + 1];

        for (int i = 1; i < N + 1; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(money);

        for (int i = 1; i < N + 1; i++) {
            int value = money[i];
            for (int j = value; j < sum + 1; j += value) {
                dp[j] = j / value;
            }

        }

        for (int i = 1; i < sum + 1; i++) {
            if (dp[i] == 0) {
                dp[i] = 100001;
            }
            for (int j = 1; j <= ((i + 1) / 2); j++) { // 10이라면 5까지만 11이라면 5까지만
                if (dp[j] != 0 && dp[i - j] != 0) {

                    dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                }

            }

        }

        if (dp[sum] == 100001) {
            System.out.println("-1");
        } else
            System.out.println(dp[sum]);

    }

}
