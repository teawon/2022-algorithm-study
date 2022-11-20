import java.io.InputStreamReader;

// 문제 주소 : https://www.acmicpc.net/problem/1913

// 문제 접근 방법 & 사용 알고리즘: 

/* 정리
 * 홀수인 자연수 N이 주어지면 1 ~ N까지의 자연수를 달팽이 모양으로 N * N의 표에 채움
 */

/* 구현
 * 미리 0으로 채워넣고
 * (0, 0)부터 달팽이 모양으로 채워넣는다.
 * 꼭짓점에서 방향을 꺾는다.
 * x또는 y가 증가하는 방향으로만 이동한다
 * 현재 좌표가 중심이면 종료
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class P_1913 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int find = Integer.parseInt(br.readLine());

        int[][] array = new int[N][N];

        for (int[] row : array)
            Arrays.fill(row, 0); //0으로 채움

        int currentX = 0;
        int currentY = 0;
        
        int number = N * N;

        while(true)
        {
            while(currentX < N - 1 && array[currentX + 1][currentY] == 0) // 아래쪽 방향
            {
                array[currentX][currentY] = number;
                currentX ++;
                number --;
            }
            
            if (currentX == N/2 && currentY == N/2)
            {
                array[currentX][currentY] = number;
                break;
            }

            while(currentY < N - 1 && array[currentX][currentY + 1] == 0) // 오른쪽 방향
            {
                array[currentX][currentY] = number;
                currentY ++;
                number --;
            }
            while(currentX > 0 && array[currentX - 1][currentY] == 0) // 위쪽 방향
            {
                array[currentX][currentY] = number;
                currentX --;
                number --;
            }
            while(currentY > 0 && array[currentX][currentY - 1] == 0) // 왼쪽 방향
            {
                array[currentX][currentY] = number;
                currentY --;
                number --;
            }
        }

        int indexX = 0;
        int indexY = 0;

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<array.length; i++) 
        {
            for (int j=0; j<array[i].length; j++) 
            {
                if (find == array[i][j]) 
                {
                    indexX = i;
                    indexY = j;
                }
                sb.append(array[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        System.out.println((indexX+1) + " " + (indexY+1));
    }
}