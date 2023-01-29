import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P_1922 {
    public static int[] parent;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 00. 컴퓨터의 수 N
        int N = Integer.parseInt(br.readLine());

        // 00. 연결할 수 있는 선의 수 M
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;

        int[][] graph = new int[M][3];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[i][0] = V1;
            graph[i][1] = V2;
            graph[i][2] = weight;
        }

        Arrays.sort(graph, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });

        int total = 0;
        int count = 0;

        for (int i = 0; i < graph.length; i++) {
            int V1 = graph[i][0];
            int V2 = graph[i][1];

            if (find(V1) != find(V2)) {
                count ++;
                total += graph[i][2];
                union(V1, V2);
                if (count == N - 1) 
                    break;
            }
        }

        System.out.println(total);
    }
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (y > x)
                parent[y] = x;
            else
                parent[x] = y;
        }
    }

    public static int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }

}
