import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/2110
 *  29948KB | 336ms
 * 문제 접근 방법 & 사용 알고리즘: 
 *
        // 2개라면 양 끝과 끝. 3개라면? 양 끝과 중간 4개라면 각 간격을 4등분.. 즉 집의 좌표값을 N등분하는데 문제는 집의 좌표가 랜덤이다.
        // 관점을 바꿔서 1 , 2 , 3 .. 4.. N까지의 간격을 가질 수 있는지 이진탐색으로 접근
 * 
*/

public class P_2110 {
    static Long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 집의 개수
        int C = Integer.parseInt(st.nextToken()); // 공유기의 개수

        long[] homeDistance = new long[N];
   
        for (int i = 0; i < N; i++) {
            homeDistance[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(homeDistance);
        long start = 1;
        long end = 1000000000;
        long mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            if (find(homeDistance, mid) >= C) { // 특정 mid에 대한 간격값이 공유기 개수보다 같거나 많으면 오른쪽 search (더 간격을 벌려 탐색 진행)
                start = mid + 1;
            } else {
                end = mid - 1; // (a,a)좌표에서 정답탐색 후 (a+1,a) , a return
            }
        }
        System.out.println(end);

    }

    public static long find(long[] array, long target) {
        long count = 1;
        long base = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] - base >= target) {
                base = array[i];
                count++;
            }
            // target 이상의 간격을 가질 수 있다면 카운트 증가후 해당 값 갱신
        }
        return count;

    }
}

