import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1753
 * 
 * 772ms
 * 문제 접근 방법 & 사용 알고리즘 : 노드의 수가 많기때문에 플로이드워셜알고리즘은 사용할 수 없다.
 * +) 초기에는 visited여부를 두고 방문했다면 다시 확인하지 않았는데 다익스트라에서는 특정 노드의 방문값보다 작은 값이 갱신되면 또 돌아갈 수 있으므로 visited여부를 판별할필요가없다.
 * (실수하지 말기)

 * 
 */

public class P_1753 {

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int V = Integer.parseInt(st.nextToken()); // 정점의 수
        int E = Integer.parseInt(st.nextToken()); // 간선의 수
        int startVertex = Integer.parseInt(br.readLine()); // 시작 정점의 위치

        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<Node>()); // 초기화
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(target, weight));
        }

        int[] distance = new int[V + 1]; // 시작정점에서 임의의 정점까지의 최단거리
        Arrays.fill(distance, Integer.MAX_VALUE);

        boolean[] visited = new bo

        
        PriorityQueue<Node> q = new PriorityQueue<Node>();
        q.offer(new Node(startVertex, 0));

        while (!q.isEmpty()) {
            Node curNode = q.poll(); // 간선의 거리가 가장 짧은 큐를 꺼낸다.

            if (curNode.getCost() > distance[curNode.getIndex()]) // 이미 더 작은 경로가있다면 스킵
                continue;

            for (int i = 0; i < graph.get(curNode.index).size(); i++) {

                Node targetNode = graph.get(curNode.index).get(i);
                if (visited[targetNode.getIndex()])
                    continue;

                if (distance[targetNode.getIndex()] > curNode.getCost() + targetNode.getCost()) {
                    distance[targetNode.getIndex()] = curNode.getCost() + targetNode.getCost();
                    visited[targetNode.getIndex()] = true;
                    q.offer(new Node(targetNode.getIndex(), distance[targetNode.getIndex()]));
                }
            }
        }

        for (int i = 1; i < V + 1; i++) {
            sb.append((distance[i] == Integer.MAX_VALUE) ? "INF" : distance[i]).append("\n");

        }
        System.out.print(sb);
    }
}