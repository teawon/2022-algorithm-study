import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 341964	2396

// 최소 스패닝 트리를 구해서 가장 비싼 길 1개를 제거함 -> 트리가 2개로 나뉨 -> 즉 마을이 2개

public class P_1647 {
    public static int[] parent;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 00. 집의 개수 N 입력
        int N = Integer.parseInt(st.nextToken());

        // 00. 길의 개수 M 입력
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[M][3];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) 
            parent[i] = i;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[i][0] = V1;
            graph[i][1] = V2;
            graph[i][2] = weight;
        }

        Arrays.sort(graph, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });

        // for (int[] temp : graph)
        //     System.out.println(Arrays.toString(temp));

        int count = 0;
        int result = 0;

        for (int i = 0; i < graph.length; i++) {
            int a = find(graph[i][0]);
            int b = find(graph[i][1]); 

            if (find(a) != find(b)) {
                count++;
                result += graph[i][2];
                union(a, b);
                if (count == N - 2)
                    break;
            }
        }

        System.out.println(result);
    }
    public static int find(int x) {
        if (x == parent[x])
            return x;
        else
            return parent[x] = find(parent[x]);
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
}