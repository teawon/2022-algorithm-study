import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/16401
 *  114996KB | 584ms
 * 문제 접근 방법 & 사용 알고리즘: 
 * 패턴을 찾을수 없다고 생각했다. 1 1 9를 3명에게 나누어주면 3 3 3이고 , 1 7 9 를 3명에게 나누어주면 4 4 4... 
 * 접근 방법을 다르게 해서 1, 2, 3, ... 등 모든 경우의 수를 탐색해야한다고 결정 -> 이진탐색 
 * 
 * 
*/

public class P_16401 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 조카 수
        int M = Integer.parseInt(st.nextToken()); // 과자 수

        int[] snack = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 1000000000;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (is_Allow(snack, mid, N)) { // 특정 길이에서 성공했다면 더 큰 범위로 탐색을 시도
                start = mid + 1;
            } else {
                end = mid - 1; // 실패 했다면 길이를 낮추는 범위에서 재 탐색
            }
        }
        System.out.println(end);
        // 0 1 2 3 4 에서 정답이 2 ,
        // 여기서 2를 탐색했어. 가능? -> 그럼 더 높은 길이에 대해 탐색 반복 -> 근데 3에서 안된다. 그럼 2로간다. -> 이 시점에서
        // start > end , 최종적으로는 End가 정답.

    }

    public static boolean is_Allow(int[] snack, int height, int num) {
        int count = 0;
        if (height == 0)
            return true; // 0예외 처리
        for (int i = 0; i < snack.length; i++) { // height 과자를 num명에게 줄 수 있는지 확인
            count += ((snack[i] / height));
            if (count >= num) {
                return true;
            }
        }
        return false;
    }

}
