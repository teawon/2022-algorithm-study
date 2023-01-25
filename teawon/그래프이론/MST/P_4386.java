import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/4386
 * 
 * 144ms
 * 문제 접근 방법 & 사용 알고리즘 : 
   문제에서 100이라는 작은숫자로 범위를 한정시켰음을 확인하자.
   최대 n개에 대해서 n!의 연산을 수행하므로 다른방법을 찾아야할것 같지만 범위가 적어서 직관적인 풀이로 접근해도 괜찮았다.
   근데 ArrayList를 사용하는 이유는무엇??
 */

public class P_4386 {

    static int[] parent;

    public static class Star {
        double x;
        double y;

        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Edge implements Comparable<Edge> {
        int start;
        int end;
        double cost;

        public Edge(int start, int end, double cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public int compareTo(Edge target) {
            return (int) this.cost - (int) target.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 별의 수

        Star[] star = new Star[N];
        parent = new int[N + 1];

        for (int i = 1; i < N + 1; i++) { // 부모는 자기자신을 가리키도록 초기화
            parent[i] = i;
        }

        ArrayList<Edge> edge = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            star[i] = new Star(x, y);
        }

        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                double cost = Math.sqrt(Math.pow(star[i].x - star[j].x, 2) + Math.pow(star[i].y - star[j].y, 2));

                edge.add(new Edge(i, j, cost));
            }
        }

        Collections.sort(edge);

        double totalCost = 0;
        for (int i = 0; i < edge.size(); i++) {
            Edge e = edge.get(i);
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
