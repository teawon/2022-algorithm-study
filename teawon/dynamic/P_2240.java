import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/2240
 * 120ms
 * 문제 접근 방법 & 사용 알고리즘: 
 * 만약 한번 움직일수 있다면? - 1에서 받아먹다가 2가 오는순간 고민한다. 이동할것인가?
 * 이동하지 않는다면 2가 나오는 개수만큼 손해를 볼것이고 , 이동한다면 먼 훗날에 1이 나오는 개수만큼 손해를 본다.
 * -> DFS를 통해 모든경우를 계산하고 , 특정 좌표와 남은 개수, 현재 위치에 대한 DP를 저장하기
 * 
 * 
 
*/

public class P_2240 {

    static int[] peach;
    static int[][][] dp; // 남은개수 + 현재 위치에 대한 DP
    static int T;
    static int W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken()); // 자두가 떨어지는 수
        W = Integer.parseInt(st.nextToken()); // 이동 최대 횟수
        peach = new int[T + 1];
        dp = new int[W + 1][T + 1][3];

        for (int i = 1; i < T + 1; i++) {
            peach[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(dfs(W, 0, 1));

    }

    public static int dfs(int moveCount, int time, int isLeft) {

        if (moveCount < 0 || time > T) {
            return 0;
        }

        if (dp[moveCount][time][isLeft] != 0) {
        return dp[moveCount][time][isLeft];
        }

        int value = 0;
        int curTime = time;
        int curValue = peach[time];

    
        while (time <= T && peach[time] == curValue) { //값이 바뀔때 까지 자두가 떨어진다. 현재 위치와 떨어지는 자두의 위치가 같다면 추가로 value를 더해간다.
            if (peach[time] == isLeft) {
                value++;
            }
            time++;
                
        }

        int move = dfs(moveCount - 1, time, isLeft == 1? 2 : 1) + value; //움직였을 때, 움직이지 않았을때에 대한 경우를 계산
        int notMove = dfs(moveCount, time, isLeft) + value;

        dp[moveCount][curTime][isLeft] = Math.max(dp[moveCount][curTime][isLeft], Math.max(move, notMove));
        //현재 움직인 휫수, 시간, 위치에 대한 정보를 저장
        return dp[moveCount][curTime][isLeft];
    }

}
