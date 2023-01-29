// 22480	308

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

        // 건물 개수
        int N = Integer.parseInt(br.readLine());

        int[] indegree = new int[N + 1];
        int[] time = new int[N + 1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<Integer>());

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            time[i] = Integer.parseInt(st.nextToken());
            int need = Integer.parseInt(st.nextToken());

            while(need != -1) {
                indegree[i]++;
                graph.get(need).add(i);
                need = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++)
            if (indegree[i] == 0) {
                q.add(i);
                dp[i] = time[i];
            }

        while (!q.isEmpty()) {
            int nodeNum = q.poll();

            ArrayList<Integer> list = graph.get(nodeNum);

            for (int i = 0; i < list.size(); i++) {
                int temp = list.get(i);

                indegree[temp]--;
                dp[temp] = Math.max(dp[temp], dp[nodeNum] + time[temp]);

                if (indegree[temp] == 0)
                    q.add(temp);
            }
        }

        for (int i = 1; i <= N; i++)
            System.out.println(dp[i]);
    }
}
