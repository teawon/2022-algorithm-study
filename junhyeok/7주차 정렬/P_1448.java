// 문제 주소 :  https://www.acmicpc.net/problem/1448

// 메모리 및 시간 : 115316KB | 1060ms

/* 문제 접근 방법 & 사용 알고리즘: 
 * 주석참고
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P_1448 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 빨대의 개수 N 입력
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        // 2. 빨대의 길이 입력
        for (int i = 0; i < N; i++)
            array[i] = Integer.parseInt(br.readLine());

        // 3. 빨대의 길이 오름차순으로 정렬
        Arrays.sort(array);

        // 4. 우선순위 큐 선언(빨대의 길이를 넣을 거임)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 5. 제일 짧은 빨대 2개를 넣음
        pq.add(array[0]);
        pq.add(array[1]);

        // 6. 최댓값 저장할 변수(삼각형을 만들 수 없으면 -1)
        int max = -1;

        for (int i = 2; i < N; i++) {
            // 7. 우선순위 큐에서 2개를 뽑음
            int temp = pq.poll();
            int temp2 = pq.poll();

            // 8. 2개를 더한 값이 현재 빨대의 길이보다 길면 삼각형이 만들어짐
            if (temp + temp2 > array[i]) 
                // 9. 최댓값 저장
                max = temp + temp2 + array[i];

            // 10. 큐에서 뽑았던 값 2개중 하나를 버리고, 현재 값과 나머지 하나를 다시 넣음
            pq.add(temp2);
            pq.add(array[i]);
        }

        System.out.println(max);
    }
}