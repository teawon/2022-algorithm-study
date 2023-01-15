// 문제 주소 :  https://www.acmicpc.net/problem/11657

// 메모리 및 시간 : 19584KB || 352ms

// 문제 접근 방법 & 사용 알고리즘:
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    // 001. 도착노드
    int dest;
    // 002. 이동하는데 걸리는 시간
    int time;

    public Node(int dest, int time) {
        this.dest = dest;
        this.time = time;
    }
}

public class P_11657 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int INF = 6000000;

        // 001. 도시의 개수 입력
        int N = Integer.parseInt(st.nextToken());

        // 002. 버스 노선의 개수 입력
        int M = Integer.parseInt(st.nextToken());

        // 003. 인접리스트
        ArrayList<Node>[] list = new ArrayList[N + 1];
        long[] distance = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            distance[i] = INF;
        }

        // 004. 인접리스트 초기화
        for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
            // 005. 노드 a에서 b로 출발하는 버스, 그리고 시간 c
			list[a].add(new Node(b, c));
		}

        // 006. 시작노드 0으로 초기화
        distance[1] = 0;

        // 007. i == 최대 방문할 수 있는 노드의 개수 
        for (int i = 0; i < N - 1; i++)
            // 008. j점 주변에 있는 노드를 갱신할 수 있는지 확인
            for (int j = 1; j <= N; j++)
                // 009. j점에서 출발할 수 있는 버스 노선
                for (int k = 0; k < list[j].size(); k++) {
                    Node temp = list[j].get(k);

                    long before = distance[temp.dest];
                    long after = distance[j] + temp.time;

                    if (before > after && distance[j] != INF)
                        distance[temp.dest] = after;
                }

        // 010. 한번더 갱신이 일어난다면 마이너스 사이클 존재
        boolean hasMinusCycle = false;
        for (int j = 1; j <= N; j++) {
            if (hasMinusCycle == true) break;

            for (int k = 0; k < list[j].size(); k++) {
                Node temp = list[j].get(k);

                long before = distance[temp.dest];
                long after = distance[j] + temp.time;

                if(after < before && distance[j] != INF) {
					hasMinusCycle = true;
                    break;
				}
            }
        }

        // 011. 마이너스 사이클이 존재하면 -1 출력
        if (hasMinusCycle == true) System.out.println(-1);
        
        // 012. 아니면 값을 출력하는데, INF이면 경로가 없다는 의미이므로 -1 출력
        else
            for (int i = 2; i <= N; i++) {
                if (distance[i] == INF) 
                    System.out.println(-1);
                else
                    System.out.println(distance[i]);
            }
    }
}