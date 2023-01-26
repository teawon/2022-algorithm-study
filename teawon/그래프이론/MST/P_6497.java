import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/6497
 * 
 * 880ms
 * 
 */

public class P_6497 {

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
        StringBuffer sb = new StringBuffer();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 집의 수
            int M = Integer.parseInt(st.nextToken()); // 길의 수

            if (N == 0 && M == 0) {
                System.out.print(sb);
                break;
            }
            parent = new int[N + 1];
            Edge[] edge = new Edge[M];
            for (int i = 1; i < N + 1; i++) { // 부모는 자기자신을 가리키도록 초기화
                parent[i] = i;
            }

            int totalValue = 0;
            int deleteValue = 0;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                totalValue += cost;
                edge[i] = new Edge(start, end, cost);
            }

            Arrays.sort(edge);

            for (int i = 0; i < M; i++) {
                Edge e = edge[i];
                if (findParent(e.start) == findParent(e.end)) {
                    continue;
                }
                union(e.start, e.end);
                deleteValue += e.cost;
            }

            sb.append(totalValue - deleteValue).append("\n");
        }

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
