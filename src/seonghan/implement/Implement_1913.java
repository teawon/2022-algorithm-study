package seonghan.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Implement_1913 {
    /*
     * 문제 주소 :  https://www.acmicpc.net/problem/1913
     *
     * 문제 접근 방법 & 사용 알고리즘:
     * 규칙 찾기
     * N 이 3일때 3x3의 표
     * N 이 5일때 5x5의 표
     * N 이 7일때 7x7의 표
     * 1이 들어가는 좌표는 (2/n, 2/n) 이를 이용하면 바깥쪽으로 돌면서 움직이는 칸의 횟수가 1,1,2,2,3,3,,,,n씩 이동
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine()); // 찾을 수
        Solution(n, t);
    }

    public static void Solution(int n, int t) {
        int[][] map = new int[n][n];
        int value =1;

        int x = n/2, y=n/2;

        int limit =1;
        while(true) {
            for(int i=0; i<limit; i++) {
                map[y--][x] = value++;
            }
            if(value-1 == n*n) break;
            for(int i=0; i<limit; i++) {
                map[y][x++] = value++;
            }

            limit++;
            for(int i=0; i<limit; i++) {
                map[y++][x] = value++;
            }

            for(int i=0; i<limit; i++) {
                map[y][x--] = value++;
            }
            limit++;
        }

        StringBuilder sb = new StringBuilder();
        int tx=0, ty=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(t==map[i][j]) {
                    ty=i+1;
                    tx=j+1;
                }
                sb.append(map[i][j] +" ");
            }
            sb.append("\n");
        }
        sb.append(ty+" "+tx);
        System.out.println(sb.toString());

    }


}
