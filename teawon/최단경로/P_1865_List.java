import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1865
 * 
 * 636ms
 * 문제 접근 방법 & 사용 알고리즘 : 
 * - 벨만포드 사용
 * - 인접 리스트 방법을 사용 (메모리 51300 -> 47608 || 시간 1836ms -> 636ms) 
 * 
 */

public class P_1865_List {

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

    static ArrayList<ArrayList<Node>> graph;
    static long[] distance;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {

            // 지점의 수 N(1 ≤ N ≤ 500), 도로의 개수 M(1 ≤ M ≤ 2500), 웜홀의 개수 W(1 ≤ W ≤ 200)이 주어진다.
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 지점의 수 (노드)
            int M = Integer.parseInt(st.nextToken()); // 도로의 수 (간선)
            int W = Integer.parseInt(st.nextToken()); // 웜홀의 수 (간선)

            graph = new ArrayList<ArrayList<Node>>();
            for (int i = 0; i < N + 1; i++) {
                graph.add(new ArrayList<Node>()); // 초기화
            }

            for (int m = 0; m < M; m++) { // 각 도로에 대한 정보를 받는다.
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int target = Integer.parseInt(st.nextToken());
                int dis = Integer.parseInt(st.nextToken());

                graph.get(start).add(new Node(target, dis));
                graph.get(target).add(new Node(start, dis));
            }

            for (int w = 0; w < W; w++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int target = Integer.parseInt(st.nextToken());
                int dis = Integer.parseInt(st.nextToken());
                graph.get(start).add(new Node(target, -dis));
            }

            distance = new long[N + 1];
            Arrays.fill(distance, 1000000000);
            distance[1] = 0;
            sb.append(ballman() ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);

    }

    static public boolean ballman() {

        for (int k = 1; k < N; k++) {

            for (int i = 1; i < N + 1; i++) {

                for (Node node : graph.get(i)) {
                    if (distance[node.getIndex()] > node.getCost() + distance[i]) {
                        distance[node.getIndex()] = node.getCost() + distance[i];
                    }
                }

            }

        }

        boolean isLoop = false;
        for (int i = 1; i < N + 1; i++) {

            for (Node node : graph.get(i)) {
                if (distance[node.getIndex()] > node.getCost() + distance[i]) {
                    isLoop = true;
                }
            }

        }
        return isLoop;
    }
}