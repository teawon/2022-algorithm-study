import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/11561
 * 끝 지점에서 1칸 2칸 3칸.. N칸 까지 건너갔을 때 나올 수 있는 최대 개수. 즉 n(n+1)/2 등차수열의 값이 N값보다 작은 값을 계산해야한다.
 * 단순히 for문으로 1+2+3...을 할 수도 있지만 시간초과를 고려해야한다 (10^16까지의 값.) - 범위가 크면 시간초과를 먼저 의심하기
 * 
 * 
*/

public class P_11561 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < T; i++) {
            long N = Long.parseLong(br.readLine());

            long start = 1;
            long end = Integer.MAX_VALUE; // n^2 = 10^16 이므로 10^8이상의 값을 넣자

            while (start <= end) {
                long mid = (start + end) / 2;

                if ((mid * (mid + 1) / 2) <= N) { // 계산값이 더 작다면 오른쪽(큰 수) 탐색
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            sb.append(end + "\n");

        }

        System.out.print(sb);
    }

}
