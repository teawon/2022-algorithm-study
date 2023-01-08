// 문제 주소 :  https://www.acmicpc.net/problem/13699

// 메모리 및 시간 : 14240KB || 124ms

// 문제 접근 방법 & 사용 알고리즘: 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_13699 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] value = new long[36];
        value[0] = 1;

        for (int i = 1; i < 36; i++) 
            for (int j = 0; j < i; j++) 
                value[i] += (value[j] * value[i-j-1]);
        
        System.out.println(value[n]);
    }
}