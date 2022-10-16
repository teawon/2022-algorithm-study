// 문제 주소 :  https://www.acmicpc.net/problem/12933

// 문제 접근 방법 & 사용 알고리즘: 

/* 정리
 * 올바른 오리의 울음소리 : "quack", "quackquackquack" 등
 * 한 문자는 한 오리가 낸 소리이다. 오리의 울음 소리는 연속될 필요는 없지만, 순서는 quack 이어야 한다.
 * "quqacukqauackck"과 같은 경우는 두 오리가 울었다고 볼 수 있다.
 * 
 * 영선이가 녹음한 소리가 주어졌을때, 방에 있을 수 있는 오리의 최소 개수를 구하는 프로그램
 * 5 <= 소리의 길이 <= 2500
 */

/*
 * 먼저 문자열을 입력 받고
 * for문으로 순회하면서 q u a c k 순서대로 개수를 셈
 * 배열을 만들어 q u a c k의 개수를 세는데
 * 순회하는 과정에서 배열의 원소의 값을 모두 더한 것이 오리의 최솟값
 * quack이 만들어지지 않을 경우 -1 출력
 * 예를들어 현재 문자가 u인데 q의 개수가 0이면 만들어지지 않는다.
 * 또 for문이 종료되었을때 q u a c 의 개수가 0이 아니면 quack가 만들어지지 않았다는 것
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class P_12933 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        sb.append(br.readLine());
        int[] count = new int[5];
        int index = 0;
        int duck = 0;

        for (int i = 0; i < sb.length(); i++)
        {
            if (sb.charAt(i) == 'q')
                index = 0;
            if (sb.charAt(i) == 'u')
                index = 1;
            if (sb.charAt(i) == 'a')
                index = 2;
            if (sb.charAt(i) == 'c')
                index = 3;
            if (sb.charAt(i) == 'k')
                index = 4;

            if (index > 0 && count[index-1] == 0)
            {
                System.out.print("-1");
                System.exit(0);
            }
            
            if (index > 0)
            {
                count[index]++;
                count[index-1]--;
            }
            if (index == 0)
                count[index]++;

            int temp = 0;
            for (int j = 0; j < 4; j++)
                temp += count[j];
            duck = (duck > temp) ? duck : temp;
        }

        for (int i = 0; i < 4; i++) 
            if (count[i] > 0)
            {
                System.out.print("-1");
                System.exit(0);
            }

        System.out.println(duck);
    }
}