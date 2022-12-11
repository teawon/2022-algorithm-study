// 17048KB	184ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 처음에 변수를 long으로 잡지 않아서 틀림

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 이미 가지고 있는 랜선의 개수 (1 <= K <= 10000)
        int K = Integer.parseInt(st.nextToken());

        // 필요한 랜선의 개수 N (1 <= N <= 1,000,000)
        int N = Integer.parseInt(st.nextToken());

        // (랜선의 길이 <= 2^31 - 1)
        // int 범위 2^31 - 1 까지
        long[] cable = new long[K];
        
        // 랜선의 최대 길이중 최솟값
        long left = 1;
        // 랜선의 최대 길이중 최댓값
        long right = 0;

        for (int i = 0; i < K; i++) {
            cable[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, cable[i]);
        }

        // 랜선의 개수
        long count = 0;

        while (left <= right) {
            long middle = (left + right) / 2;

            for (int i = 0; i < K; i++)
                if (middle > 0)
                    count += (cable[i] / middle);

            if (count < N)
                right = middle - 1;
            else
                left = middle + 1;

            count = 0;
        }

        System.out.println(left - 1);
    }
}