import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/18352
 * 
 * 272736KB | 1304ms
 * 문제 접근 방법 & 사용 알고리즘
 * 
 * 간선의 길이가 1이리면 다익스트라 알고리즘을 굳이 사용하지 않아도 된다. 오히려 빠름
 * 
 * 단, 그래프 문제에서 메모리가 부족하다면 인접리스트를 꼭 고려할 것
 * - 인접행렬 : 빠르다, 메모리가 많이든다 , 배열로 선언
 * - 인접 리스트 : 느리다 , 메모리가 적게 든다 , ArrayList로 선언
 */

public class P_18352 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        // 첫째 줄에 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X가 주어진다.
        int N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int K = Integer.parseInt(st.nextToken()); // 찾아야하는 최단 거리
        int X = Integer.parseInt(st.nextToken()); // 출발 도시

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1]; // 시작점에서 각 노드까지의 최단거리를 저장한다.

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
        }

        distance[X] = 0;
        visited[X] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(X);
        while (!q.isEmpty()) {
            int start = q.poll();

            for (int i = 0; i < graph.get(start).size(); i++) {
                int end = graph.get(start).get(i);
                if (visited[end])
                    continue;
                visited[end] = true;
                distance[end] = distance[start] + 1;
                q.offer(end);
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (distance[i] == K) {
                sb.append(i + "\n");
            }
        }

        if (sb.length() == 0) {
            System.out.println("-1");
        } else {
            System.out.print(sb);
        }

    }

}
