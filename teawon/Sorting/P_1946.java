import java.util.*;
import java.io.*;
/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1946
 * 299204KB |872ms
 *  
 * 문제 접근 방법 & 사용 알고리즘: 
 * 1) 서류심사(1,2,3...등)부터 값을 비교하는데 자기보다 상위단계의 면접등수가 있으면 안된다. 
 * 즉 서류2등은 서류1등보다 면접등수가 높아야하고 , 서류3등은 서류2,1등보다 높아야하고.. 따라서 서류등수를 인덱스로가지는 배열을 순차탐색하며 카운팅한다. 
 **/

public class P_1946 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 횟수

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); // 지원자의 수
            int[] grade = new int[N + 1]; // 각 서류성적에 대한(인덱스) 면접 성적(value);
            int maxGrade = 100000000;
            int count = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                grade[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < N + 1; i++) {
                if (maxGrade > grade[i]) {
                    maxGrade = grade[i];
                    count++;
                }
            }
            sb.append(count + "\n");

        }
        System.out.print(sb);
    }
}