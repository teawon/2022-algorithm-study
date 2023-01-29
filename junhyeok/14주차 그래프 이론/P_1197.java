import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 그래프가 주어졌을 때 그 그래프의 최소 스패닝 트리를 구하는 프로그램을 작성하시오

public class P_1197 {
    public static int graph[][];
    public static int[] parent;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 00. 정점의 개수 V
        int V = Integer.parseInt(st.nextToken());

        // 00. 간선의 개수 E
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        graph = new int[E][3];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

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
                total += graph[i][2];
                union(V1, V2);
                count++;
                if (count == V - 1)
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
