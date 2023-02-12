package teawon.programers.k진수소수구하기;

import java.util.*;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/92335w [2단계]
 * 풀이시간 : 45분
 * 
 * 실수한점 : 런타임에러가 일부 테스트케이스에서 발생했다면 항상 오버플로우를 고려하자. (제일 큰수 or 제일 작은 수 or 자리수 이탈 가능성 고려)
 */

class Solution {
    public static int solution(int n, int k) {

        String parsedNum = Integer.toString(n, k);
        int answer = 0;
        ArrayList<Long> numList = new ArrayList<>();
        String number = "";
        for (int i = 0; i < parsedNum.length(); i++) {
            char val = parsedNum.charAt(i);
            if (val != '0') {
                number += val;
            } else {
                if (number != "") {
                    numList.add(Long.parseLong(number, 10));
                    number = "";
                }
            }
        }
        if (number != "") {
            numList.add(Long.parseLong(number, 10));
        }

        for (int i = 0; i < numList.size(); i++) {
            if (isPrime(numList.get(i))) {
                answer++;
            }
            System.out.println(numList.get(i));
        }

        return answer;
    }

    public static boolean isPrime(long n) {
        if (n < 2)
            return false;
        else if (n == 2)
            return true;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }
}