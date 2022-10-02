package seonghan.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Greedy_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 거스름돈 액수
        System.out.println(solution(n));

    }

    static int solution(int n) {
        int totalCoin = 0;
        if (n == 1 || n == 3) {
            return -1;
        }

        while (n != 0) {
            if (n % 5 == 0) {
                totalCoin += n / 5;
                n -= (n / 5) * 5;
            } else {
                n -= 2;
                totalCoin++;
            }
        }

        return totalCoin;

    }
}
