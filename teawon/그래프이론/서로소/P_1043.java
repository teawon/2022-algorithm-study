import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1043
 * 
 * 128ms
 * 문제 접근 방법 & 사용 알고리즘 : 
 * 
 * - 우선 주어진 파티에서 거짓말을 할 수 있는지 바로는 알 수 없다. 인원중 한명이 미래에 진실을 듣게될 수도 있기때문  -> 각 파티정보를 List로 저장해야할 필요가 있음
 * - 파티 내에 진실을 알고있는 사람이 있다면 해당 집합은 모두 진실을 듣게된다 -> 집합의 관계로 파티참석 인원을 표현
 */

public class P_1043 {

    static boolean[] know_truth;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람의 수
        int M = Integer.parseInt(st.nextToken()); // 파티의 수
        know_truth = new boolean[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i < N + 1; i++) { // 부모는 자기자신을 가리키도록 초기화
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());

        int truthCount = Integer.parseInt(st.nextToken());

        for (int i = 0; i < truthCount; i++) {
            know_truth[Integer.parseInt(st.nextToken())] = true; // 진실을 알고있는 사람들을 저장
        }

        ArrayList<ArrayList<Integer>> partyInfo = new ArrayList<ArrayList<Integer>>(); // 각 파티의 정보를 저장하는 리스트

        for (int i = 0; i < M; i++) {
            partyInfo.add(new ArrayList<Integer>()); // 초기화
            st = new StringTokenizer(br.readLine());
            int peopleCount = Integer.parseInt(st.nextToken());

            int people = Integer.parseInt(st.nextToken());
            partyInfo.get(i).add(people);
            for (int j = 1; j < peopleCount; j++) { // 한 파티에 참석한 사람들을 하나의 집합으로 묶는다
                int prePeople = people;
                people = Integer.parseInt(st.nextToken());
                union(prePeople, people);
                partyInfo.get(i).add(people);
            }

        }
        int count = 0;
        boolean flag;
        for (int i = 0; i < M; i++) {
            flag = true;
            for (int people : partyInfo.get(i)) { // 파티에 참여한 사람들의 집합에서 진실을 알고있는 사람이 있는지 확인
                if (know_truth[findParent(people)]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static int findParent(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = findParent(parent[x]);
    }

    public static void union(int x, int y) {
        int p1 = findParent(x);
        int p2 = findParent(y);

        if (p1 != p2) {
            if (know_truth[p1]) { // 진실을 알고있는 사람을 우선적으로 부모로 할당
                parent[p2] = p1;
            } else {
                parent[p1] = p2;
            }
        }
    }
}
