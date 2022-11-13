import java.util.*;
import java.io.*;
/*
 * 문제 주소 :  https://www.acmicpc.net/problem/11652
 * 34120KB | 376ms
 *  
 * 문제 접근 방법 & 사용 알고리즘: 
 * 1) 카운팅정렬  - 사용하기엔 값의 범위가 너무크다.
 * 2) 값이 나온 횟수를 키로, 값을 Value로 2차원 배열로 구현하려했으나 범위가 너무큼 -> HashMap을 사용하자 (hashmap이란? : https://coding-factory.tistory.com/556)
 * +) Int의 값 범위 : -2^31 ~ 2^31-1 // long의 값 범위 : -2^63 ~ 2^63-1
 **/

public class P_11652 {
    static int maxCount = 0;
    static long minValue = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 숫자 카드의 개수

        HashMap<Long, Integer> map = new HashMap<>(); // 각 값과 정수를 저장할 hashmap생성

        for (int i = 0; i < N; i++) {
            long number = Long.parseLong(br.readLine());
            int count = map.getOrDefault(number, 0); // 값이 있다면 가져오고 없다면 0가져오기
            map.put(number, count + 1);
        }

        map.forEach((value, count) -> {
            if (maxCount == count) {
                minValue = Math.min(minValue, value);
            } else if (maxCount < count) {
                maxCount = count;
                minValue = value;
            }
        });

        System.out.println(minValue);
    }

}
