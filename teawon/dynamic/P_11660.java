import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/11660
 *  126972KB | 1416ms
 * 문제 접근 방법 & 사용 알고리즘: 
 * 특정 행에 대해 5~7번째 행의 값은 7번째까지 더한 값 - 5번째까지 더한 값으로 나타냘 수 있다. 즉 n번째까지 더한 값을 변수에 저장한다면 재활용해서 연산가능
 * 
*/

public class P_11660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(st.nextToken()); // N*N의 표의 크기
        int M = Integer.parseInt(st.nextToken()); // 계산 횟수
        int[][] board = new int[N + 1][N + 1];
        int[][] sumRow = new int[N + 1][N + 1];

        for (int y = 1; y < N + 1; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x < N + 1; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
                sumRow[y][x] = sumRow[y][x - 1] + board[y][x];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int sum = 0;

            for (int y = y1; y < y2 + 1; y++) {
                sum += (sumRow[y][x2] - sumRow[y][x1 - 1]);
            }
            sb.append(sum + "\n");

        }

        System.out.print(sb);

    }

}
