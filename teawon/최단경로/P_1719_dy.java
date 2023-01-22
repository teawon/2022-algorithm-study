import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1917
 * 
 * 512ms
 * 문제 접근 방법 & 사용 알고리즘 : 다익스트라를 이용한 풀이방법
 * 
 *  findPath함수로 어느 경로로 가야하는지 저장한다  
     * 만약 1->2->5->6을 통해 값을 갱신한다고 가정하자. , 1번 노드에서 시작했다면
     * [1][2] = 1 
     * [1][5] = 2
     * [1][6] = 5
     * 
     * 즉 내가 "목적지"에 도착했을 때 어떤 "출발지"에서 시작했는 지 path에 기록한다.
     * 이후 출발지를 찾아서 처음에 어떤 목적지로 이동했는지 계산해나간다. 
     *

 */

public class P_1719_dy {

    static int[][] path;

    public static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        public int getIndex() {
            return index;
        }

        public int getCost() {
            return cost;
        }

        @Override
        public int compareTo(Node target) {

            return this.getCost() - target.getCost();
        }
    }

    static int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 간선의 수

        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<Node>()); // 초기화
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(target, dis));
            graph.get(target).add(new Node(start, dis));

        }

        int[][] distance = new int[N + 1][N + 1];
        path = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0;
            PriorityQueue<Node> q = new PriorityQueue<Node>();
            q.offer(new Node(i, 0));

            while (!q.isEmpty()) {
                Node node = q.poll();

                if (node.getCost() > distance[i][node.getIndex()])
                    continue;

                for (Node targetnode : graph.get(node.getIndex())) {

                    if (distance[i][targetnode.getIndex()] > distance[i][node.getIndex()] + targetnode.getCost()) {

                        distance[i][targetnode.getIndex()] = distance[i][node.getIndex()] + targetnode.getCost();
                        path[i][targetnode.getIndex()] = node.getIndex();
                        q.offer(new Node(targetnode.getIndex(), distance[i][targetnode.getIndex()]));

                    }
                }
            }

        }
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {

                sb.append(path[i][j] == 0 ? "-" : findPath(i, j)).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static int findPath(int start, int end) {
        int preNode = path[start][end];
        if (preNode == start) {
            return end;
        }

        return findPath(start, preNode);
    }
}