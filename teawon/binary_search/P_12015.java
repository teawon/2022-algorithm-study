import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/12015
 *  536ms
 * -> 정답을 보고 풂, 다시 풀어볼것 (다이나믹 개념 + 이진탐색을 통한 속도개선 모두 사용해야 풀 수 있다.)
 * 
*/

public class P_12015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수열의 수

        int[] array = new int[N];
        int[] anser = new int[N];
        int anserIndex = 0;

       
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        anser[0] = array[0];

        for (int i = 1; i < N; i++) {

            if (anser[anserIndex] < array[i]) { // 10 20 .. 다음 수가 더 크다면 결과배열에 데이터를 추가
                anser[++anserIndex] = array[i];

            } else {  // 즉 카운팅을 해 나아가는데 작은 수가 나오면 해당값을 바꾼다, 그리고 큰 수를 계속 넣음. 
                anser[findIndex(0, anserIndex, array[i], anser)] = array[i];
            }
            //Ex) 10 20 30 1 2 3  -> 10 | 10 20 | 10 20 30 | 1 20 30 | 1 2 30 | 1 2 3| ( 값을 바꿈으로써 증가하는 값에 들어올 수 있는 범위를 유동적으로 조절한다.)
        }

        System.out.println(anserIndex + 1);

    }

    public static int findIndex(int start, int end, int target, int[] array) {

        if (start > end) { //a <= 찾는 위치 <= b 이므로,   a<= target인 최대 정수a값을 찾아 마지막에 1을 더한다. 
                           // ex) 1 3  , target: 2라면 a값은 1
            return end + 1;
        }

        int mid = (start + end) / 2;

        if (array[mid] >= target) { // 현재 위치값이 target 보다 작다면 더 높은 값에서 자리 탐색
            return findIndex(start, mid - 1, target, array);
        } else {
            return findIndex(mid + 1, end, target, array);

        }
    }
}
