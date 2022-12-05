// 문제 주소 :  https://www.acmicpc.net/problem/10816

// 메모리 및 시간 : 119368KB | 524ms

/* 문제 접근 방법 & 사용 알고리즘: 
 * . 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 나무의 수 N 입력
        int N = Integer.parseInt(st.nextToken());

        // 2. 집에 가져가려고하는 나무의 길이 M 입력
        int M = Integer.parseInt(st.nextToken());

        int[] height = new int[N];

        // 3. 이분탐색에서 사용할 변수
        int right = 0;
        int left = 0;

        // 3. 각각의 나무의 길이 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            height[i] = temp;
            // . Right를 길이의 최댓값으로 설정
            right = Math.max(right, temp);
        }

        // . 이분탐색 시작
        int middle = 0;
        while(left <= right) {
            long sum = 0;
            middle = (right + left) / 2;

            for (int i = 0; i < height.length; i++)
                if (height[i] - middle > 0)
                    sum += (height[i] - middle);

            if (sum >= M) 
                left = middle + 1;

            if (sum < M) 
                right = middle - 1;

            
        }

        System.out.println(left - 1);
    }
}