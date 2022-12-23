import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1823
 *  30864KB | 180ms
 * 문제 접근 방법 & 사용 알고리즘: 
 * 값이 클 수록 나중에 베어야 한다. 그런데 만약 9 8 1 1 10 이라면? 큰 수인 10을 먼저배고 왼쪽부터 자르는 순서가 정답일 수도 있다.
 * -> 내부 데이터를 확인하기전에는 알 수 없다... -> 모든 경우의 수 탐색
 * -> 단순히 DFS를 수행하면 시간초과가 나온다. 
 * -> 왼쪽 오른쪽 왼쪽 오른쪽 // 오른쪽 왼쪽 오른쪽 왼쪽같은 경우 같은 내부의 재귀문이 돌아가는데 각각 연산이 실행되므로 이미 계산되었다면 재활용
*/

public class P_1823 {
    static int[] rice;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 벼의 개수
        rice = new int[N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            rice[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(dfs(0, N - 1, 1));

    }

    public static int dfs(int start, int end, int count) {

        if (start > end) {
            return 0;
        }

        if (dp[start][end] != 0) {
            return dp[start][end];
        }

        int left = (dfs(start + 1, end, count + 1) + (rice[start] * count));
        int right = (dfs(start, end - 1, count + 1) + (rice[end] * count));

        int result = Math.max(left, right);
        dp[start][end] = result;
        return dp[start][end];
        // 왼쪽선택
        // 오른쪽선택
        // 그중 큰 값을 return

    }

}