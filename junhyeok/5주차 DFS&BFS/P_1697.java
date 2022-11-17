// 문제 주소 :  https://www.acmicpc.net/problem/1697

/* 정리
 * 첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다.
 * 수빈이의 위치가 X일때 걷는다면 1초 후에 X - 1또는 X + 1로 이동하게 된다. 
 * 순간이동을 하는 경우에는 1초 후에 2 * X의 위치로 이동하게 된다.
 * 동생을 찾는 가장 빠른 시간 출력
*/

/* 문제 접근 방법 & 사용 알고리즘:
 * BFS를 사용하였다. 
 * 수빈은 X - 1, X + 1, X * 2의 위치로 이동할 수 있기 때문에, 3가지 경우의 수를 고려하여 처리한다.
 * visited 배열을 만들어서 해당 위치까지 이동하는데 걸리는 시간을 저장하며, 배열의 초기값이 0이기 때문에 0초를 1로 저장하여 처리하였다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class P_1697 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] visited = new int[100001];
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int time = bfs(N, visited, K);
        System.out.print(time);
    }

    public static int bfs(int node, int[] visited, int K) {
        Queue<Integer> queue = new LinkedList<Integer>();

        // 수빈의 현재 위치를 큐에 추가
        queue.add(node);
        // 시작 위치를 방문 처리
        visited[node] = 1; 

        // 현재 위치를 저장할 변수
        int n = 0;

        while (!queue.isEmpty()) {
            n = queue.remove();

            // 수빈은 X - 1, X + 1, X * 2 의 위치로 이동가능

            // n이 동생의 위치이면
            if (n == K) return visited[n] - 1;
            // n - 1이 방문된 적이 없고 0보다 크거나 같다면 (위치 >= 0 && 위치 <= 100000 임)
            // 조건식에서 (visited[n-1])이 (n-1>=0) 보다 앞에 오게 된다면 ArrayIndexOutOfBounds 에러가 발생 
            if (n - 1 >= 0 && visited[n - 1] == 0) {
                visited[n - 1] = visited[n] + 1;
                queue.add(n - 1);
            }
            // n + 1이 방문된 적이 없고 100000보다 작거나 같다면 
            if (n + 1 <= 100000 && visited[n + 1] == 0) {
                visited[n + 1] = visited[n] + 1;
                queue.add(n + 1);
            }
            // n * 2가 방문된 적이 없고 100000보다 작거나 같다면
            if (n * 2 <= 100000 && visited[n * 2] == 0) {
                visited[n * 2] = visited[n] + 1;
                queue.add(n * 2);
            }
        }
        return 9999;
    }
}