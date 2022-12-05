// 문제 주소 :  https://www.acmicpc.net/problem/10816

// 메모리 및 시간 : 115196KB | 592ms

/* 문제 접근 방법 & 사용 알고리즘: 
 * . 
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 조카의 수 M 입력
        int M = Integer.parseInt(st.nextToken());

        // 과자의 수 N 입력
        int N = Integer.parseInt(st.nextToken());
        
        int[] snack = new int[N];

        int right = 0;
        int left = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, snack[i]);
        }

        while(left <= right) {
            int middle = (left + right) / 2;
            long num = 0;

            for (int i = 0; i < N; i++)
                if (middle != 0)
                    num += (snack[i] / middle);

            // 과자의 개수가 조카의 수보다 크거나 같으면
            if (num >= M)
                left = middle + 1;
            else
                right = middle - 1;
        }

        if (right == -1)
            System.out.println(0);
        else
            System.out.println(left - 1);
    }
}