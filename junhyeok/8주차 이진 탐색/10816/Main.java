// 문제 주소 :  https://www.acmicpc.net/problem/10816

// 메모리 및 시간 : 168640KB | 1060ms

/* 문제 접근 방법 & 사용 알고리즘: 
 * . 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); // 키 : 정수, 값 : 인덱스(개수)

        int[] count = new int[500000]; // 4byte * 500,000 = 1.907MB
        int index = 0;

        // 1. 숫자 카드의 개수 N 입력
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (map.get(temp) == null) {
                map.put(temp, index);
                index++;
            }
            else {
                count[map.get(temp)]++;
                // System.out.println("i : " + i + "count[map.get(temp)] : " + count[map.get(temp)]);
            }
        }

        // 2. 비교할 정수의 개수 M 입력
        int M = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int temp = Integer.parseInt(st.nextToken());

            if (map.get(temp) == null) {
                sb.append(0);
                sb.append(" ");
            }
            else {
                sb.append(count[map.get(temp)] + 1);
                sb.append(" ");
            }
        }

        System.out.println(sb);
    }
}