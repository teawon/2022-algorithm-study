import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/11657
 * 
 *  356ms
 * 문제 접근 방법 & 사용 알고리즘 
 * 간선의 값이 음수가 나올 수 있기때문에 벨만포드 알고리즘을 사용해야 한다
 * 
 * - 큐를 사용하는게 아니다. 갱신이 될때마다 큐에 넣는다면 무한루프가 발생한다. 그렇기 때문에 다익스트라를 쓸 수 없는것
 * - 음수 싸이클의 경우 계속해서 값이 연산될 수 있기때문에 오버플로우를 신경써야한다 (long타입)
 * - 갈 수 없는 경로가 있다면 continue를 통해 스킵해야한다. 음수 싸이클이 있는 지역의 길이 끊겨있다고 생각해보기
 * 

 */

public class P_11657 {

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

        // 첫째 줄에 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X가 주어진다.
        int N = Integer.parseInt(st.nextToken()); // 도시의 개수 (노드)
        int M = Integer.parseInt(st.nextToken()); // 버스 노선의 개수 (간선)
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

        // 각 노드의 방문여부를 확인하면서.. 하나의 노드를 꺼내고 인접노드 거리 다 계산, 그리고 또 계산,, 이를 반복한다.
        // 즉 큐에서 값과 무게에 대한 정보를 꺼내야하ㄴ,ㅡㄴ데 그럼 노드를 저장해야함
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<Node>());
        }

        long[] distance = new long[N + 1]; // 시작점에서 각 노드까지의 최단거리를 저장한다.

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(index, dis));
        }

        Arrays.fill(distance, 1000000000);
        distance[1] = 0;

        for (int k = 1; k < N; k++) { // (전체 노드 수 - 1) 만큼 반복 (k개의 노드를 거쳐갔을 때 도달가능한 최단경로값을 계산)
            for (int i = 1; i < N + 1; i++) { // 각 노드에 연결된 모든 간선을 확인하며 가중치값을 갱신한다.
                for (int j = 0; j < graph.get(i).size(); j++) {
                    Node node = graph.get(i).get(j);

                    if (distance[i] == 1000000000) { // 이 부분 주의, 길이 끊겨 갈 일이 없는 임의의 경로에 음수싸이클이 있다면 이건 신경쓰면 안된다.
                        break;
                    }

                    if (distance[node.getIndex()] > distance[i] + node.getCost()) {
                        distance[node.getIndex()] = distance[i] + node.getCost();
                    }
                }
            }
        }

        boolean isInfLoop = false;
        for (int i = 1; i < N + 1; i++) { // 각 노드에 연결된 모든 간선을 확인하며 가중치값을 갱신한다.
            for (int j = 0; j < graph.get(i).size(); j++) {
                Node node = graph.get(i).get(j);

                if (distance[i] == 1000000000) {
                    break;
                }

                if (distance[node.getIndex()] > distance[i] + node.getCost()) {
                    isInfLoop = true;
                    break;
                }
            }
        }

        if (isInfLoop) {
            sb.append("-1\n");
        } else {
            for (int i = 2; i < N + 1; i++) {
                sb.append(distance[i] == 1000000000 ? "-1" : distance[i]).append("\n");
            }
        }
        System.out.print(sb);
    }

}
