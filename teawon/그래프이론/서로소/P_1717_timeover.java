import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1717
 * 
 * 
 * 문제 접근 방법 & 사용 알고리즘 : 
 * - union , find의 개념을 사용해 서로소인지 판별하는 문제
 * - 시간초과가 발생한 코드
 * 
 */

public class P_1717_timeover {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 집합의 범위
        StringBuffer sb = new StringBuffer();
        parent = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            parent[i] = i; // 초기에는 자기 자신이 부모인 집합을 생성
        }

        int M = Integer.parseInt(st.nextToken()); // 연산 수행 횟수

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (type == 0) {
                union(x, y);
            }

            else {
                if (findParent(x) == findParent(y)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }

        }
        System.out.print(sb);

    }

    public static int findParent(int x) {
        if (parent[x] == x) {
            return x;
        }

        return findParent(parent[x]);
    }

    public static void union(int x, int y) {
        int p1 = findParent(x);
        int p2 = findParent(y);

        if (p1 != p2) {
            parent[p1] = p2;
        }
    }

}
