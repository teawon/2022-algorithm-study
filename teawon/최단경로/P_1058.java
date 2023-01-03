import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1058
 * 
 * 140ms
 * 문제 접근 방법 & 사용 알고리즘 : 
 * - 결국 특정 친구로부터 거리가 2이내에 갈 수 있는 경로의 수를 계산하는 문제
 * - 노드수가 많지 않아 플로이드워셜을 사용해도 된다.
 * 
 * 
 */

public class P_1058 {
    static int N;
    static int[][] graph;

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

        N = Integer.parseInt(br.readLine()); // 사람의 수
        graph = new int[N][N];
        int[] countOfFriend = new int[N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < N; j++) {
                graph[i][j] = line.charAt(j) == 'Y' ? 1 : 0;
            }
        }

        int max = dst(0);
        for (int i = 1; i < N; i++) {
            max = Math.max(max, dst(i));
        }

        System.out.println(max);
    }

    public static int dst(int start) {
        boolean[] visited = new boolean[N]; // 방문 여부 확인
        int[] distance = new int[N]; // start에서 임의의 노드까지의 최단거리
        Arrays.fill(distance, 51);

        distance[start] = 0;
        visited[start] = true;

        PriorityQueue<Node> q = new PriorityQueue<Node>();
        q.offer(new Node(start, 0));

        while (!q.isEmpty()) {
            Node curNode = q.poll(); // 간선의 거리가 가장 짧은 큐를 꺼낸다.

            if (curNode.getCost() > distance[curNode.getIndex()]) // 이미 더 작은 경로가있다면 스킵
                continue;

            for (int i = 0; i < N; i++) {
                if (visited[i] || graph[curNode.getIndex()][i] == 0)
                    continue;

                if (distance[i] > (curNode.getCost() + graph[curNode.getIndex()][i])) {
                    distance[i] = curNode.getCost() + graph[curNode.getIndex()][i];
                    visited[i] = true;
                    q.offer(new Node(i, distance[i]));
                }
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (distance[i] <= 2 && distance[i] != 0) {
                count++;
            }
        }
        return count;
    }

}
