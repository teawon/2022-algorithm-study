package seonghan.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
/*
 * 문제 주소 :  https://www.acmicpc.net/problem/11508
 *
 * 문제 접근 방법 & 사용 알고리즘:
 *  그리디 알고리즘을 사용
 *  가장 큰 값 3가지를 하나의 꾸러미로 계산하는 것이 최소 값을 구할 수 있는 방법
 *
 */

public class Greedy_11508 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 친구들과 같이 먹을 유제품의 수
        ArrayList list = new ArrayList();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine())); // 유제품의 가격
        }
        System.out.println(solution(list));
    }

    public static int solution(ArrayList<Integer> list) {
        int result = 0;
        int cnt = 0;
        Collections.sort(list,Collections.reverseOrder());
        for (int i = 0; i < list.size(); i++) {
             if(cnt==2)
             {
                 cnt = 0;
             }else
             {
                 result+=list.get(i);
                 cnt++;
             }
        }

        return result;
    }


}
