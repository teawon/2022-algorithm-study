import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1563
 * 128ms
 * 문제 접근 방법 & 사용 알고리즘:
 * 1. 수학적 접근 : 3^N  - (지각 2번이상 u 3번연속 결석) - (지각2번이상 n 3번연속결석) ->3^1000은 무한에 수렴 -> X
 * 2. DFS로 경우의 수 계산 (현재 값, 날짜에 대한 경우의 수를 다이나믹으로 저장)
 * 
 * 
 
*/

public class P_1563 {

    static int[][][][] dp; // 현재 날짜, 현재 출결사항 , 지각, 결석정보에 대한 DP
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 전체 학기 수

        dp = new int[3][N + 1][2][3];

        System.out.println(dfs(0, 0, 0, 0));

    }

    public static int dfs(int status, int day, int lateCount, int contiAbsences) {

        if (day > N || lateCount >= 2 || contiAbsences >= 3) {
            return 0;
        }

        if (day == N) {
            return 1;
        }

        if (dp[status][day][lateCount][contiAbsences] != 0) {
            return dp[status][day][lateCount][contiAbsences];
        }

        dp[status][day][lateCount][contiAbsences] = (dfs(0, day + 1, lateCount, 0) + dfs(1, day + 1, lateCount + 1, 0)
                + dfs(2, day + 1, lateCount, contiAbsences + 1)) % 1000000;
        // 출석, 지각, 결석에 대한 값 계산
        return dp[status][day][lateCount][contiAbsences];

    }
}