package seonghan.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

//union find, 76ms
public class graph_1043 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        boolean[] know = new boolean[n + 1];

        HashSet<Integer>[] party = new HashSet[m + 1];
        for (int i = 1; i <= m; i++) {
            party[i] = new HashSet<>();
        }

        inputs = br.readLine().split(" ");
        int knowNum = Integer.parseInt(inputs[0]);

        for (int i = 1; i <= knowNum; i++) {
            int temp = Integer.parseInt(inputs[i]);
            know[temp] = true;
        }


        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int p = 1; p <= m; p++) {
            inputs = br.readLine().split(" ");
            int partyNum = Integer.parseInt(inputs[0]);


            if (partyNum <= 1) {
                party[p].add(Integer.parseInt(inputs[1]));
                continue;
            }

            for (int j = 1; j < partyNum; j++) {
                int a = Integer.parseInt(inputs[j]);
                int b = Integer.parseInt(inputs[j + 1]);
                if (find(a) != find(b)) {
                    union(a, b);
                }

                party[p].add(a);
                party[p].add(b);

            }
        }


        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (know[i] && !visited[i]) {
                int root = find(i);
                for (int j = 1; j <= n; j++) {
                    if (find(j) == root) {
                        know[j] = true;
                        visited[j] = true;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= m; i++) {
            boolean flag = false;
            for (int person : party[i]) {
                if (know[person]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) result++;
        }

        System.out.println(result);
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public static void union(int a, int b) {
        int parent_b = find(b);
        parent[parent_b] = a;
    }

}
