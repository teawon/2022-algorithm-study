import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/2417
 *  14368KB | 128ms
 * 문제 접근 방법 & 사용 알고리즘: 
 * -  Math.sqrt()함수를 통해 제곱근 계산하기 (명확한 이유는 모르겠지만 부동소수점 64비트를 사용한 제곱근계산(?)은 값이 다르게 나오는 케이스가 있는 것 같다)
 *  [https://www.acmicpc.net/board/view/84475]
 * - 모든 값을 탐색하는 방법 -> 이진탐색을 사용하기
 * 
*/

public class P_2417 {
    static Long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine()); // 정수

        System.out.println(find((long) 0, N));
    }

    public static Long find(Long start, Long end) {
        Long mid = (start + end) / 2;

        if (start >= end) {
            return start;
        }

        if (Math.pow(mid, 2) < N) {
            return find(mid + 1, end);
        }
        return find(start, mid);

    }
}
