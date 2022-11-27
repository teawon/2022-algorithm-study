// 문제 주소 :  https://www.acmicpc.net/problem/1838

// 메모리 및 시간 : 115244KB | 1084ms

/* 문제 접근 방법 & 사용 알고리즘: 
 * 1. 입력받은 정수를 배열에 입력
 * 2. 배열을 복사
 * 3. 배열을 복사후 정렬
 * 4. 원래 배열 ---->   30 10 44 27 49
 * 5. 정렬된 배열 -->   10 27 30 44 49
 * 6. (원래 배열의 인덱스) - (정렬된 배열의 인덱스)의 최댓값을 구함
 * 7. 정렬된 배열의 원소를 키 값으로 사용하여 원래 배열의 인덱스를 구하기 위해 해시맵 사용
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P_1838 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 정수의 개수 N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 2. 원래 배열
        int[] original = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 3. 키 : 원래 배열의 원소, 값 : 인덱스
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            original[i] = temp;
            // 4. 서로 다른 정수가 입력됨 -> 키값이 겹치지 않음
            map.put(temp, i);
        }

        // 5. 정렬된 배열
        int[] sorted = original.clone();
        Arrays.sort(sorted);

        // 6. 출력할 값
        int max = 0;

        for (int i = 0; i < N; i++) {
            // 7. 절대값으로 해야하나 생각했는데, 하나가 -2 만큼 이동했다고 하면 어차피 다른 하나도 2만큼 이동하기 때문에 절대값을 할 필요가 없음
            max = Math.max(map.get(sorted[i]) - i, max);
        }

        System.out.println(max);
    }
}