
import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1448
 * 98556KB | 1796ms
 * 
 * 문제 접근 방법 & 사용 알고리즘: 
 * 삼각형의 조건 - 가장 긴 변의 길이 < 나머지 변의 합  ( 15 14 13이 있을때 15보다 14+13이 커야한다. 즉 오름차순정렬로 3개를 선택해서 조건이 맞는지 보기)
*/

public class P_1448 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 빨대의 개수

        Integer[] length = new Integer[N];

        for (int i = 0; i < N; i++) {
            length[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(length, Collections.reverseOrder());

        int max = -1;
        for (int i = 0; i < N - 2; i++) {
            if (length[i] < length[i + 1] + length[i + 2]) {
                max = length[i] + length[i + 1] + length[i + 2];
                break;
            }
        }

        System.out.println(max);

    }

}
