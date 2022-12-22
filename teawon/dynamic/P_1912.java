import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1912
 *  22576KB | 272ms
 * 문제 접근 방법 & 사용 알고리즘: 
 * 연속되는 수를 더해가는데 음수가 나오더라도 큰 수가 뒤에 존재한다면 앞의 값을 다 더하는게 맞다.? 10 -1 -2 -3 99999
 * 즉 값을 계속 더하는데 만약 음수가 나오면 앞의 수를 빼는게 이득이므로 초기화를 진행하고 계속 합산결과를 더해나감
 * 
*/

public class P_1912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 정수의 수
        int[] array = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int max = array[0];
        int curSum = 0;
        for (int i = 0; i < N; i++) {
            curSum += array[i];
            max = Math.max(curSum, max);
            if (curSum < 0) {
                curSum = 0;
            }

        }

        System.out.println(max);

    }

}
