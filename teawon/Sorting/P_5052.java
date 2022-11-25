import java.util.*;
import java.io.*;
import org.apache.commons.lang.StringUtils;
/*
 * 문제 주소 :  https://www.acmicpc.net/problem/5052
 * 33232KB |600ms
 *  
 * 문제 접근 방법 & 사용 알고리즘: 모든 문자열을 하나로 다 더한다. (문자열 사이사이에 식별넣어서) , 그리고 각 문자마다 2개이상 포함된다면 체크
 * -> 시간초과 발생 
 * 
 * 문제에서는 각 문자당 최대 1만개, 그리고 10개 , 테스트 케이스는 5개까지 이므로 이론상 50만개의 문자열을 비교하며 값을 계산해야한다.
 * 이것도 문제를 잘못 접근했는데 1234와 123456는 Yes지만 1234 , 561234는 No이다.
 * 시작되는 지점을 가지고 비교를 해야하고 모든 경우를 찾지 않도록 정렬을 이용해야했다. 
 * 
 * 
 **/

public class P_5052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 횟수

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); // 전화번호 개수
            StringBuffer total = new StringBuffer();
            String[] number = new String[N];

            for (int i = 0; i < N; i++) {
                number[i] = br.readLine();
            }
            Arrays.sort(number);
            boolean flag = true;

            for (int i = 0; i < N - 1; i++) {
                if (number[i + 1].startsWith(number[i])) {
                    sb.append("NO\n");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append("YES\n");
            }
        }
        System.out.print(sb);
    }

}
