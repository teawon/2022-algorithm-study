import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/13424
 * 
 * 472ms
 * 문제 접근 방법 & 사용 알고리즘 : 각 노드의 개수가 100이므로 플로이드워셜을 사용
 *  -  실수했던점 : 두 그래프 사이에 무한의 값을 너무 큰 값을 넣게되면 이 문제와 같이 연산이 필요할때 오버플로우가 발생한다.
 *  -  반대로 너무 작은 값을 넣었다면 초기 최소값을 적절히 설정해야하는데 그렇지 않으면 지나갈 수 있는 경로로 인식한다.
 */
public class P_13424 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 노드의 수
            int M = Integer.parseInt(st.nextToken()); // 간선의 수

            int[][] distance = new int[N + 1][N + 1];
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    distance[i][j] = i == j ? 0 : 10000000;
                }
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int target = Integer.parseInt(st.nextToken());
                int dis = Integer.parseInt(st.nextToken());
                distance[start][target] = dis;
                distance[target][start] = dis;
            }

            int K = Integer.parseInt(br.readLine()); // 친구의 수
            int[] friend = new int[K]; // 친구가 위치하고있는 장소의 정보를 저장

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                friend[i] = Integer.parseInt(st.nextToken());
            }

            for (int k = 1; k < N + 1; k++) {
                for (int i = 1; i < N + 1; i++) {
                    for (int j = 1; j < N + 1; j++) {
                        if (distance[i][j] > distance[i][k] + distance[k][j]) {
                            distance[i][j] = distance[i][k] + distance[k][j];
                        }
                    }
                }
            }
            int minDistance = 10000000;
            int minRoomindex = -1;
            for (int i = 1; i < N + 1; i++) {
                int curValue = 0;
                for (int k = 0; k < K; k++) { // 각 친구의 위치에서 특정 장소(i)까지의 거리를 다 더해본다.
                    curValue += distance[friend[k]][i];

                }
                if (minDistance > curValue) {
                    minDistance = curValue;
                    minRoomindex = i;
                }
            }
            sb.append(minRoomindex + "\n");
        }
        System.out.print(sb);
    }
}