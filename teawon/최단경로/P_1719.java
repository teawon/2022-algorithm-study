import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1719
 * 
 * 396ms
 * 문제 접근 방법 & 사용 알고리즘 : 플로이드 워셜 풀이방법
    path[a][b]란 a에서 b까지 가는데 가장 먼저 방문해야하는 노드값이라고 정의하자.
    초기에는 당연히 path[a][b]의 값은 입력받은 그래프 값  "path[start][target] = target" 을 넣게된다.

    이후 다음과 같이 1->2->5->6 경로를 거치는 path[1][6]을 구해야한다고 가정하자.

    플로이드 워셜 알고리즘에 의해 path[1][6] = "2를 경유함" // path[1][6] = "5를 경유함" 순서를 가지지만 최종적으로 path[1][6]에는 2값이 들어가야한다.

   이를 다음과 같은 점화식 "k를 경유함" -> "i에서 k까지 가는데 처음으로 가야하는 경로" => path[1][6] = path[1][k] 와 같이 나타낸다면

   중간에 어디를 경유하든 해당 경유지를 방문하기위해 처음으로 방문해야하는 값을 넣게되므로 정답이 나온다.
 * 
 */

public class P_1719 {

    static int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 간선의 수

        int[][] distance = new int[N + 1][N + 1];
        int[][] path = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                distance[i][j] = i == j ? 0 : INF;

            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            distance[start][target] = dis;
            distance[target][start] = dis;
            path[start][target] = target;
            path[target][start] = start;

        }

        for (int k = 1; k < N + 1; k++) {

            for (int i = 1; i < N + 1; i++) {
                if (k == i)
                    continue;
                for (int j = 1; j < N + 1; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        // System.out.println("k - " + k + "를 경유해서 " + i + "에서 " + j + "로 이동합니다.");
                        // System.out.println("이때 path[i][k]의 값은 : " + path[i][k]);
                        path[i][j] = path[i][k];

                    }
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {

                sb.append(path[i][j] == 0 ? "-" : path[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}