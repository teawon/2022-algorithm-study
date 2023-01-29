// 	47876	576

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_2252 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 학생 수 N
        int N = Integer.parseInt(st.nextToken());
        // 비교 수 M
        int M = Integer.parseInt(st.nextToken());

        int[] indegree = new int[N + 1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<Integer>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            indegree[B]++;
            graph.get(A).add(B);
        }

        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 1; i <= N; i++)
            if (indegree[i] == 0) 
                q.add(i);

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            int nodeNum = q.poll();

            sb.append(nodeNum + " ");

            ArrayList<Integer> list = graph.get(nodeNum);

            for (int i = 0; i < list.size(); i++) {
                indegree[list.get(i)]--;

                if (indegree[list.get(i)] == 0)
                    q.offer(list.get(i));
            }
        }

        System.out.println(sb);
    }
}
