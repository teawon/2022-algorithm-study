import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1654
 *  119164KB | 180ms
 * 문제 접근 방법 & 사용 알고리즘: 
 * - 이진탐색 시 start, end범위 값 잡을 때 주의하기
 * - 등호 주의하기 (문제에서 크거나 같아도 괜찮다고 제시했는지 , 어떤 경우에 정답이 안되는지) 
*/

public class P_1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 랜선의 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 렌선의 개수

        int[] wire = new int[K];

        for (int i = 0; i < K; i++) {
            wire[i] = Integer.parseInt(br.readLine());
        }

        long start = 1;
        long end = Integer.MAX_VALUE; // 처음에 1000000으로 잡고 시간을 갈았다. 문제를 잘 보고 애매하면 그냥 배열의 최대값을 넣자.
        long mid = -1;

        while (start <= end) {

            mid = (start + end) / 2;
            if (calculate(wire, mid, N)) { // 개수가 부족하면 더 낮은 위치에서 잘라야한다
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end); // 정답이 되는 위치가 (a,a)라면 (a+1,a)로 이동후 끝. 따라서 end 가 정답

    }

    public static boolean calculate(int[] wire, long length, int goal) { // 특정 길이로 잘랐을 때 나오는 랜선의 개수가 목표치를 넘는지 확인
        long count = 0;
        for (int i = 0; i < wire.length; i++) {
            count = count + (wire[i] / length);

        }
        if (count >= goal) {
            return true;
        }
        return false;

    }

}
