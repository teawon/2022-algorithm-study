import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/13699
 *  14212KB | 128ms
 * 문제 접근 방법 & 사용 알고리즘: 다이나믹의 기본 개념문제
*/

public class P_13699 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 정수를 입력받는다

        long[] array = new long[36];
        array[0] = 1;

        for (int i = 1; i < 36; i++) {
            for (int j = 0; j < i; j++) {
                array[i] += (array[j] * array[i - j - 1]);
            }
        }

        System.out.println(array[N]);

    }

}
