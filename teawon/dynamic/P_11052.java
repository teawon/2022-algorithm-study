import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/11052
 *  14512KB | 152ms
 * 문제 접근 방법 & 사용 알고리즘: 
 * 6일때 1+1+1+1+1+1 , 2+2+2 , 3+3, 4+2, 5+1 , 6일 수 있다. 즉 모든 경우의 수가 가능
 * 확실한것은 어떤 수의 합은 작은 수들의 합으로 이루어진다. 
 * -> 다이나믹으로 이를 표현하기
*/

//2원은 2원 or 1+1 
//3원은 3 or 2+1 
//4원은 4 or 3+1 or 2+2 
//5원은 5 or 4+1 or 3+2
public class P_11052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 정수의 수
        int[] card = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            sum[i] = card[i];
            for (int j = 1; j <= (i + 1) / 2; j++) {
                sum[i] = Math.max(sum[i], sum[j] + sum[i - j]);
            }
        }
        System.out.println(sum[N]);
    }

}
