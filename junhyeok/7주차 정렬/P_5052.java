// 문제 주소 :  https://www.acmicpc.net/problem/5052

// 메모리 및 시간 : 33016KB | 556ms

/* 문제 접근 방법 & 사용 알고리즘: 
 * 1. 전화번호를 오름차순으로 정렬
 * 2. 예를들어 123, 2, 314, 3, 12 가 입력되면 [12, 123, 2, 3, 314] 로 정렬됨
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P_5052 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 테스트 케이스의 수 T 입력
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T > 0) {
            // 2. 전화번호의 수 N 입력
            int N = Integer.parseInt(br.readLine());
            String[] tels = new String[N];

            // 3. 각 전화번호 입력
            for (int i = 0; i < N; i++)
                tels[i] = br.readLine();

            // 4. 전화번호를 오름차순으로 정렬
            Arrays.sort(tels);

            boolean pass = true;

            // 5. 일관성 체크
            for (int i = 0; i < N - 1; i++) {
                if (tels[i+1].startsWith(tels[i])) {
                    sb.append("NO\n");
                    pass = false;
                    break;
                }
            }

            if (pass == true)
                sb.append("YES\n");

            T--;
        }
        System.out.println(sb);
    }
}