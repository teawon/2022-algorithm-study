// 문제 주소 :  https://www.acmicpc.net/problem/22945

// 시간 : 288ms

/* 문제 접근 방법 & 사용 알고리즘: 
 * 주석 참고
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class P_22945 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 개발자의 수 입력
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[N];

        // 2. 각 개발자의 능력치 입력
        for(int i = 0; i < N; i++)
            array[i] = Integer.parseInt(st.nextToken());

        // 3. 왼쪽 끝에서 시작할 인덱스를 가리키는 변수
        int start = 0;
        // 4. 오른쪽 끝에서 시작할 인덱스를 가리키는 변수
        int end = N - 1;
        // 5. 팀의 능력치 최댓값을 저장할 변수
        int max = 0;

        while(start <= end) {
            // 6. 주어진 공식 (개발자 A와 개발자 B 사이에 존재하는 다른 개발자 수) × min(개발자 A의 능력치, 개발자 B의 능력치)을 이용해서 초기값을 설정
            max = Math.max((end - start -1) * Math.min(array[start], array[end]), max);

            // 7. 배열의 왼쪽 값과 오른쪽 값을 비교해서 왼쪽이 더 작으면 왼쪽을 1 증가시키고
            if(array[start] < array[end])
                start++;
            // 8. 아니면 오른쪽을 1 감소시킨다.
            else
                end--;
        }

        System.out.println(max);
    }
}