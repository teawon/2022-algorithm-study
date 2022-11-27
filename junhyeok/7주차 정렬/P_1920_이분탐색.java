// 문제 주소 :  https://www.acmicpc.net/problem/1920

// 메모리 및 시간 : 43780KB | 596ms

/* 문제 접근 방법 & 사용 알고리즘: 
 * 정수 A[1], A[2], ..., A[M] 을 오름차순 정렬 후 이분탐색
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_1920_이분탐색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1. 정수의 개수 N 입력
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        // 2. 정수 A[1], A[2], ..., A[N] 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 오름차순 정렬
        Arrays.sort(numbers);

        // 4. 존재하는지 확인할 정수의 개수 M 입력
        int M = Integer.parseInt(br.readLine());
        int[] exists = new int[M];

        // 5. 정수 B[1], B[2], ..., B[M] 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            exists[i] = Integer.parseInt(st.nextToken());
        }

        // 6. 이분탐색 시작
        for (int i = 0; i < M; i++) {
            int key = exists[i];
            int bottom = 0;
            int top = N - 1;
            while (true) {
                int middle = (top + bottom) / 2;
                if (key == numbers[middle]) {
                    sb.append(1 + "\n");
                    break;
                } else if (bottom >= top) {
                    sb.append(0 + "\n");
                    break;
                } else if (key > numbers[middle]) {
                    bottom = middle + 1;
                } else if (key < numbers[middle]) {
                    top = middle - 1;
                }

            }
        }
        System.out.println(sb);
    }
}
