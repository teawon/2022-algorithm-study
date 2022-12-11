// 14168KB	124ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        int left = 1;
        int right = M * 5;
        boolean isExist = false;

        while (left <= right) {
            int middle = (left + right) / 2;

            int result = solve(middle);

            if (result > M)
                right = middle - 1;
            if (result == M) {
                right = middle - 1;
                isExist = true;
            }
            if (result < M)
                left = middle + 1;
        }

        if (isExist)
            System.out.println(left);
        else
            System.out.println(-1);
    }

    public static int solve(int middle) {
        int count = 0;

        for (int i = 5; i <= middle; i *= 5) 
            count += (middle / i); // 25 -> 5 10 15 20 25 -> 25는 5가 2개

        return count;
    }
}