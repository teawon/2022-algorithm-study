// 문제 주소 :  https://www.acmicpc.net/problem/11652

// 시간 : 404ms

/* 문제 접근 방법 & 사용 알고리즘: 
 * 1. 카드의 개수 만큼 배열에 입력받은 후 정렬. ex) [1, 1, 1, 3, 5]
 * 2. 배열에 i번째 원소와 i+1번째 원소를 비교
 *      같으면 현재 정수의 카드수 증가. 다르면 0으로 초기화
 *      이후 가장 많이 가지고 있는 카드의 개수를 찾아서 정수를 출력한다.
 */ 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P_11652 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1. 카드의 개수가 1인 경우 바로 출력한 뒤 종료한다
        if (N == 1) {
            Long temp = Long.parseLong(br.readLine());
            System.out.print(temp);
            return;
        }

        Long[] inputArray = new Long[N];

        // 2. 입력
        for (int i = 0; i < N; i++)
            inputArray[i] = Long.parseLong(br.readLine());

        // 3. 정렬
        Arrays.sort(inputArray);

        // 4. 가장 많이 가지고 있는 정수 찾기
        Long maxCountNumber = 0L;
        int maxNumberCount = 0;
        int currentNumberCount = 0;

        for (int i = 0; i < N - 1; i++) {
            currentNumberCount++;
            
            if (inputArray[i].equals(inputArray[i+1])) {
                if (i != N-2)
                    continue;
                if (i == N-2)
                    currentNumberCount++; 
            }
            
            if (currentNumberCount > maxNumberCount) {
                maxNumberCount = currentNumberCount;
                maxCountNumber = inputArray[i];
            }

            currentNumberCount = 0;
        }
        
        // 5. 결과 출력
        System.out.print(maxCountNumber);
    }
}