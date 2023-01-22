import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/16562
 * 
 * 232ms
 * 문제 접근 방법 & 사용 알고리즘 : 
 * - 일단 각 친구관계를 정의하는데 이때 친구비가 가장 작은 키값을 부모로 정한다.
 * - 각 친구를 순회하며 계산 수행
 * 
 */

public class P_16562 {

    static int[] parent;
    static int[] friend_fee;

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

        friend_fee = new int[N + 1];
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

        int sum_fee = 0;
        for (int i = 1; i < N + 1; i++) {
            if (parent[i] == i) {
                sum_fee += friend_fee[i];
            }
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
            if(friend_fee[p1] > friend_fee[p2]){ 
                //x의 비용과 y의 비용을 처음에 계산했는데 p1,p2로 수행하는게 맞다. (실수한점) 어처피 가장 작은 값을 부모로 가지고 있는게 전제되어있기 때문
                parent[p1] = p2;
            }
            else{
                parent[p2] = p1;
            }
        }
    }
}
