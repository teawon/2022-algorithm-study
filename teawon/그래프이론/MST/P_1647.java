import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1647
 * 
 * 2820ms
 * 문제 접근 방법 & 사용 알고리즘 : 
    최소신장트리를 구한 후 가장큰 경로값을 지운다.
 */

public class P_1647 {

    static int[] parent;

    public static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public int compareTo(Edge target) {
            return this.cost - target.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 집의 수
        int M = Integer.parseInt(st.nextToken()); // 길의 수

        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) { // 부모는 자기자신을 가리키도록 초기화
            parent[i] = i;
        }

        Edge[] edge = new Edge[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edge[i] = new Edge(start, end, cost);
        }

        Arrays.sort(edge);

        int totalCost = 0;
        int maxCost = -1;
        for (int i = 0; i < M; i++) {
            Edge e = edge[i];
            if (findParent(e.start) == findParent(e.end)) {
                continue;
            }
            union(e.start, e.end);
            totalCost += e.cost;
            maxCost = Math.max(maxCost, e.cost);
        }

        System.out.println(totalCost - maxCost);

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
