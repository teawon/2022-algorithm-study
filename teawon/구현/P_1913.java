import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1913
 * 
 * 문제 접근 방법 & 사용 알고리즘: 
 * 일단은 직관적으로 N*N의 배열을 만들고 4가지 방향으로 값이 있거나, 범위를 이탈하면 방향을 바꿔가며 값을 채워나가기
 * 
 * -> 시간 초과 발생
 */





public class P_1913 {
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt(); //N*N의 달팽이 수열

        int P = sc.nextInt(); //찾고자 하는 좌표

        int[][] snail_arr = new int[N][N];

        int curNum = N * N;
        int x = 0;
        int y = 0;
        
        int [] dx = {0 , 1 , 0, -1}; // 4방향 정의
        int [] dy = {1, 0, -1, 0}; // 4방향 정의

        int direct = 0;

        while(curNum >= 1){


            snail_arr[y][x] = curNum;
       
            if (x+dx[direct] < 0 || x+dx[direct] >= N || y+dy[direct] < 0 || y+dy[direct] >=N || snail_arr[y+dy[direct]][x+dx[direct]]!=0){     
                //범위를 이탈하거나 0이라면 방향을 바꾼다.
                direct = (direct+1) % 4;
            }
            x += dx[direct];
            y += dy[direct];
            curNum --;

        }
        int P_x = 0 , P_y = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (P == snail_arr[i][j]) {
                    P_x = i;
                    P_y = j;
                }
                sb.append(snail_arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);

        System.out.println(++P_x + " " + ++P_y);
        

    
    }
    

}