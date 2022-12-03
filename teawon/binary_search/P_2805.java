import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/2805
 *  119164KB | 556ms
 * 문제 접근 방법 & 사용 알고리즘: 
 * 모든 값을 탐색해야 한다고 생각했고 그 방법으로 이진탐색을 사용했다.
 * 
 * 여기서 실수한점 
 * [[정답이 0이고, 현재 start: 0 , end :1이라고 가정]]
 * 1) mid값을 반환하기 
 * - (start + end) : 특정 값이 정답이라면 문제에서는 "최대 높이"를 구하라고 했기때문에 0의 값을 탐색하면 값이 크거나 같으므로 start를 이동해서 start:1 , end:1로 이동
 * - 그리고 1을 다시 탐색하면 당연히 구해야하는 값보다 작으니까 왼쪽으로 탐색을 시도한다. 즉 start: 1 , end : 0 
 * - 따라서 마지막에는 end값을 return해야한다.
 * 
 * -> 암기하려 하지말고, 이진탐색을 할 때 구하고자 하는 값이 최대값이라면 정답을 탐색하고도 다른 방향으로 탐색을 계속 이어갈 수 있음을 잊지말기
 * 
 * 
*/

public class P_2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정수
        int totalWood = Integer.parseInt(st.nextToken());

        int[] wood = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            wood[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 1000000000;
        int mid = -1;
        // mid(높이)값이 작아질수록 잘리는 높이는 커진다.
        while (start <= end) {

            mid = (start + end) / 2;
            if (totalWood <= calculate(wood, mid)) { // 더 낮게 잘라야 한다. (탐색하려는 값의 범위가 아래에 있음)
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);

    }

    public static Long calculate(int[] wood, int height) {
        long sum = 0;
        for (int i = 0; i < wood.length; i++) {
            if (wood[i] > height)
                sum += wood[i] - height;
        }

        return sum;
    }

}
