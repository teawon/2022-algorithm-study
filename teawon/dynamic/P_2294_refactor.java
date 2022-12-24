import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/2294
 *  14272KB | 136ms
 * 문제 접근 방법 & 사용 알고리즘: 
 * N원이 있다면 (1,N-1),(2,N-2),(3,N-3)...모든 경우의 수를 계산해최소의 값을 넣었지만
 * 사실 특정 동전을 하나 더하는 연산을 수행하는게 더 효과적이다 ex) 3원 , 5원이 있다면 N = (N-3원 + 1) or (N-5원 +1)
 * 
 * 
 
*/

public class P_2294_refactor {

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

        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for (int i = 1; i < sum + 1; i++) {

            for (int j = 1; j < N + 1; j++) { // 10이라면 5까지만 11이라면 5까지만
                if (i - money[j] < 0)
                    continue;
                dp[i] = Math.min(dp[i], dp[i - money[j]] + 1);
            }

        }

        if (dp[sum] == 100001) {
            System.out.println("-1");
        } else
            System.out.println(dp[sum]);

    }

}
