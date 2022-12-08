import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/11687
 *  
 *  124ms
 *  
 *  문제 접근 방법 & 사용 알고리즘: 
 * 1. 특정 N팩토리얼의 값을 계산하고 0의 개수를 카운팅하는 이진탐색 
 *  - N의 범위는? 값이 너무 커질 것 같다.
 *  - 0의 수만 계산하면 되는데 굳이 그렇게 많은 값이 필요할까? -> 30까지 팩토리얼 계산 결과 5의 배수마다 0의 개수가 1씩 증가하는 규칙발견
 *  - 사실 5의 배수마다 증가하는게 아니라, 5^n 꼴의 배수라면 해당 값만큼 더 추가된다는 특징이 있음. ex) 3: 15 / 4:20 / 5: 없음 / 6: 25 ... 
*/

public class P_11687 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 0의 개수가 N개인 최소 X!의 값 구하기.

        long start = 1;
        long end = 500000000; // n개의 0의 개수를 표현하는데 약 5n개가 필요하다.
        long mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;

            if (calculate(mid) < N) {// 최소값이므로 요구하는 0의 개수보다 값이 작다면 오른쪽 범위를 탐색해야함
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (calculate(start) == N) { // 임의의 정답 (a,a)에서 왼쪽으로 이동(a , a-1) , 여기서 정답은 a이므로 Start return
            System.out.println(start);
        } else {
            System.out.println("-1"); // 정답이 없는 경우 -1 Return
        }
    }

    public static int calculate(long number) { // number만큼 0을 가지는 N!의 N 값 계산
        int count = 0;
        for (int i = 5; i <= number; i *= 5) {
            count += (number / i);
        }
        return count;
    }
}
