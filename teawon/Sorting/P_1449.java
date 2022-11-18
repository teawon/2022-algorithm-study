
import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1449
 * 14228KB | 136ms
 * 
 * 문제 접근 방법 & 사용 알고리즘: 
 * 1000까지만 범위를 가지므로 각 인덱스를 물이 세는 위치로 하는 배열을 만들어 물이샌다면 해당인덱스부터 길이만큼 파이프를 둔다.
 * 단 범위가 커지면 이 방법은 메모리사용량이 높아 다른 방법을 찾아봐야함
*/

public class P_1449 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물이 새는 개수
        int L = Integer.parseInt(st.nextToken()); // 테이프의 길이

        boolean[] leak_place = new boolean[1002];

        int count = 0; // 테이프의 개수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int index = Integer.parseInt(st.nextToken());
            leak_place[index] = true;
        }

        for (int i = 1; i < 1002; i++) {
            if (leak_place[i]) { // 물이 샌다면 해당 지점 막는다.
                count++;
                for (int l = 0; l < L; l++) {
                    if (i + l < 1002)
                        leak_place[i + l] = false;
                }
            }
        }

        System.out.println(count);

    }

}
