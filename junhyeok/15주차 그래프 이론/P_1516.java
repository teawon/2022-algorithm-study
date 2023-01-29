// 문제 주소 : https://www.acmicpc.net/problem/1516

// 메모리 및 응답시간 : 22480kb || 308ms

// 문제 접근 방법 & 사용 알고리즘: 
// 위상 정렬 알고리즘을 사용하고, dp를 사용하여 건물을 짓는데 걸리는 시간을 갱신해나감.
// 한 건물을 짓는데 건물1과 건물2가 필요하다면, 건물1과 건물2 중에 더 긴 시간을 선택해야함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_1516 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 001. 건물 개수 N 입력
        int N = Integer.parseInt(br.readLine());

        // 002. 각 노드(건물)의 진입차수 저장할 배열
        int[] indegree = new int[N + 1];
        
        // 003. 각 건물을 짓는데 걸리는 시간
        int[] time = new int[N + 1];

        // 004. 그래프를 리스트로 표현
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<Integer>());

        // 005. 각 건물을 짓는데 걸리는 시간과 먼저 지어져야 하는 건물의 번호 입력
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            time[i] = Integer.parseInt(st.nextToken());
            int need = Integer.parseInt(st.nextToken());

            // 006. -1이면 다음 건물 정보 입력
            while(need != -1) {
                indegree[i]++;
                graph.get(need).add(i);
                need = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        // 007. 건물을 짓는데 걸리는 시간을 갱신해주어야 함
        int[] dp = new int[N + 1];

        // 008. 진입 차수가 0인 노드(건물)들을 QUEUE에 추가
        for (int i = 1; i <= N; i++)
            if (indegree[i] == 0) {
                q.add(i);
                dp[i] = time[i];
            }

        // 009. QUEUE가 빌때까지 반복
        while (!q.isEmpty()) {
            // 010. 큐에서 노드를 하나 꺼냄
            int nodeNum = q.poll();

            // 011. 꺼낸 노드에서 연결되어 있는 노드들의 정보를 가져옴
            ArrayList<Integer> list = graph.get(nodeNum);

            // 012. 각 노드들을 순회하면서 시간을 갱신
            for (int i = 0; i < list.size(); i++) {
                int crnt = list.get(i);

                indegree[crnt]--;
                // 013. 필요한 건물 중 가장 긴 시간을 골라야 함
                dp[crnt] = Math.max(dp[crnt], dp[nodeNum] + time[crnt]);

                // 014. 진입 차수가 0이 되면 큐에 추가함
                if (indegree[crnt] == 0)
                    q.add(crnt);
            }
        }

        // 015. 결과출력
        for (int i = 1; i <= N; i++)
            System.out.println(dp[i]);
    }
}
