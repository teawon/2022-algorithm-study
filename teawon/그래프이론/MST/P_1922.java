import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1922
 * 
 * 604ms
 * 문제 접근 방법 & 사용 알고리즘 : 
    1917문제의 최소신장트리문제와 유사
 */

public class P_1922 {

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
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine()); // 정점의 수
        int E = Integer.parseInt(br.readLine()); // 간선의 수

        parent = new int[V + 1];
        for (int i = 1; i < V + 1; i++) { // 부모는 자기자신을 가리키도록 초기화
            parent[i] = i;
        }

        Edge[] edge = new Edge[E];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edge[i] = new Edge(start, end, cost);
        }

        Arrays.sort(edge);

        int totalCost = 0;
        for (int i = 0; i < E; i++) {
            Edge e = edge[i];
            if (findParent(e.start) == findParent(e.end)) {
                continue;
            }
            union(e.start, e.end);
            totalCost += e.cost;
        }

        System.out.println(totalCost);

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
