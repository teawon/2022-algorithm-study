import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/2252
 * 
 * 516ms
 * 문제 접근 방법 & 사용 알고리즘 : "자신의 앞에 학생이 서있지 않다면 세운다"는 관점으로 접근하면 위상정렬의 알고리즘으로 풀이할 수 있다.
    
    
 */

public class P_2252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(st.nextToken()); // 학생의 수
        int M = Integer.parseInt(st.nextToken()); // 키를 비교하는 횟수

        int[] frontPeopleCount = new int[N + 1];
        ArrayList<ArrayList<Integer>> connectInfo = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < N + 1; i++) {
            connectInfo.add(new ArrayList<Integer>()); // 초기화
        }
        frontPeopleCount[0] = -1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());

            connectInfo.get(front).add(back);
            frontPeopleCount[back]++;
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 1; i < N + 1; i++) {
            if (frontPeopleCount[i] == 0) {
                q.offer(i);
                sb.append(i + " ");
            }

            // 내 앞에 아무도 없다면 줄에 세운다.
        }

        while (!q.isEmpty()) {
            int people = q.poll();

            for (int backPeople : connectInfo.get(people)) {
                // 줄에 세웠다면 자신의 뒤에서있던 사람들의 카운트를 줄인다.
                frontPeopleCount[backPeople]--;
                if (frontPeopleCount[backPeople] == 0) {
                    q.offer(backPeople);
                    sb.append(backPeople + " ");
                }
            }
        }

        System.out.println(sb);

    }
}
