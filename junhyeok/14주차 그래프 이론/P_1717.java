// 문제 주소 :  https://www.acmicpc.net/problem/1717

// 메모리 및 응답 시간 : 53112KB || 480ms

// 문제 접근 방법 & 사용 알고리즘: 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class P_1717 {
    public static int[] parent;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 001. N 입력 {0}, {1}, ..., {N} 이 각각 n + 1개의 집합을 이루고 있음.
        int N = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            // 002. 부모 노드를 자기 자신으로 초기화
            parent[i] = i;

        // 003. M 입력
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int job = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (job == 0) 
                // 004. 합집합 연산
                union(a, b);
            else {
                // 005. 부모 노드가 같으면 YES
                if (isSameParent(a, b)) sb.append("YES\n");
                // 006. 다르면 NO
                else sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

    public static int find(int x) {
        if (parent[x] == x)
            return x;
        else 
            return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
 
        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }

    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return true;
        else return false;
    }
}
