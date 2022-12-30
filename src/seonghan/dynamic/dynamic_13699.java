package seonghan.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 문제 주소 :  https://www.acmicpc.net/problem/13699
 * 1번 문제
 * 문제 접근 방법 & 사용 알고리즘: 다이나믹
 * 점화식 찾기가 중요
 * 76ms
 */
public class dynamic_13699 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        process(N);

    }

    public static void process(int N){
        long dx[] = new long[36];
        dx[0] = 1;
        dx[1] = 1;
        dx[2] = 2;
        dx[3] = 5;

        for(int i=4;i<=N;i++){
            for(int j=0;j<i;j++){
                dx[i] += dx[j] * dx[i-j-1];
            }
        }

        System.out.println(dx[N]);
    }

}
