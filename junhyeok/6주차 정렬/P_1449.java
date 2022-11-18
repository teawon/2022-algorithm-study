// 문제 주소 :  https://www.acmicpc.net/problem/1449

// 시간 : 128ms

/* 문제 접근 방법 & 사용 알고리즘: 
 * 값을 배열에 입력받고 정렬한뒤 테이프가 붙어있는 범위와 물이 새는 곳의 위치를 비교하면서, 테이프의 개수를 센다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_1449 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 1. 물이 새는 곳의 개수 입력
        int N = Integer.parseInt(st.nextToken());
        // 2. 테이프의 길이 입력
        int L = Integer.parseInt(st.nextToken());

        int[] position = new int[N];

        // 3. 물이 새는 곳의 위치 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            position[i] = Integer.parseInt(st.nextToken());

        // 4. 물이 새는 곳의 위치 배열 정렬
        Arrays.sort(position);

        // 5. 필요한 테이프의 개수 카운트
        double tapePosition = position[0] + L - 0.5; 
        int count = 1;

        for (int i = 1; i < N; i++) {
            if (tapePosition < position[i] + 0.5) { 
                count++;
                tapePosition = position[i] + L - 0.5;
            }
        }

        System.out.print(count);
    }
}