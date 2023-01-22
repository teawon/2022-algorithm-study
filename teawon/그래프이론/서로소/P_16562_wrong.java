import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/16562
 * 
 *
 * 문제 접근 방법 & 사용 알고리즘 : 
 * - 일단 각 친구관계를 정의하자. ex) 1 1 3 3 2 2 2 
 *  각 친구의 부모값을 순회하며 새로운 집합이 나오면 해당 집합의 값 = 최소금액으로 저장하고 마지막에 총 계산된 최소값을 출력하기 
 *  -> 틀린 답이 나온다. 이유는 모르겠음
 */

public class P_16562_wrong {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 친구 관계 수
        int K = Integer.parseInt(st.nextToken()); // 가지고 있는 돈

        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) { // 부모는 자기자신을 가리키도록 초기화
            parent[i] = i;
        }

        int[] friend_fee = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            friend_fee[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int friend_1 = Integer.parseInt(st.nextToken());
            int friend_2 = Integer.parseInt(st.nextToken());
            union(friend_1, friend_2);
        }

        HashMap<Integer, Integer> map = new HashMap<>(); // 특정 집합 - 최소 비용을 저장하는 맵 선언
        for (int i = 1; i < N + 1; i++) {
            int set_key = parent[i]; // 특정 친구가 속하고있는 집합
            if (map.containsKey(set_key)) {
                map.put(set_key, Math.min(map.get(set_key), friend_fee[i]));
            } else {
                map.put(set_key, friend_fee[i]);
            }
        }

        int sum_fee = 0;
        for (int fee : map.values()) {
            sum_fee += fee;
        }

        System.out.println(sum_fee > K ? "Oh no" : sum_fee);

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

            parent[p1] = p2;

        }
    }
}
