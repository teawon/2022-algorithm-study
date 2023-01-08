// 문제 주소 :  https://www.acmicpc.net/problem/1699

// 메모리 및 시간 : 14816KB || 172ms

// 문제 접근 방법 & 사용 알고리즘: 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int d[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            d[i] = i;
            for (int j = 1; j * j <= i; j++) {
                if (d[i] > d[i - j * j] + 1) {
                    d[i] = d[i - j * j] + 1;
                }
            }
        }
        System.out.println(d[n]);
    }
}
