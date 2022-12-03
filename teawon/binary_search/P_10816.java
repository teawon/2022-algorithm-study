import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/10816
 *  195364KB | 1212ms
 * 문제 접근 방법 & 사용 알고리즘: 
 * 첫번째 접근 - 맵을 통해 특정 값(키)와 횟수를 저장
 * 
*/

public class P_10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine()); // 정수의 개수
        HashMap<Integer, Integer> map = new HashMap<>(); // 각 값과 정수를 저장할 hashmap생성

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            int count = map.getOrDefault(num, 0); // 값이 있다면 가져오고 없다면 0가져오기
            map.put(num, count + 1);
        }

        int M = Integer.parseInt(br.readLine()); // 계산할 수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (map.get(num) != null) {
                sb.append(map.get(num) + " ");
            } else {
                sb.append(0 + " ");
            }

        }
        System.out.println(sb.toString().trim());

    }
}
