package seonghan.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
 * 문제 주소 :  https://www.acmicpc.net/problem/14916
 *
 * 문제 접근 방법 & 사용 알고리즘:
 *  그리디 알고리즘을 사용
 *  5원으로 n을 나누어서 나머지가 없을 때 까지 2원을 n에서 빼줌
 *  -1인 경우가 3,1 두가지 경우 일때 뿐 이라서 예외 처리
 */
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
