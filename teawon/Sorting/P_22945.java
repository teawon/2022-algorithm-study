import java.util.*;
import java.io.*;
/*
 * 문제 주소 :  https://www.acmicpc.net/problem/22945
 * 24452KB | 304ms
 *  
 * 문제 접근 방법 & 사용 알고리즘: 최대의 값을 가지려면 인원수가 많거나, 혹은 두 개발자의 능력치가 높아야한다.
 * 즉 정답이 되는게 양끝일수도 있고 중간에 위치할수도 있기때문에 모든 값을 탐색해야함
 * - 일단 양 끝부터 값을 계산하는데 양 끝에서 하나씩 범위를 좁혀간다. 좁혀갈때는 왼쪽과 오른쪽중 값이 작은정수를 이동시킨다.
 * 
 *
 **/

public class P_22945 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;
        int maxScore = 0;

        while (right - left > 1) {
            maxScore = Math.max(maxScore, ((right - left - 1) * Math.min(array[left], array[right])));
            if (array[right] > array[left])
                left++;
            else
                right--;
        }

        System.out.println(maxScore);

    }
}