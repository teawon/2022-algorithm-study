import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 246728	900

public class P_6497 {
    public static int[] parent;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 집의 수
            int M = Integer.parseInt(st.nextToken());

            // 길의 수
            int N = Integer.parseInt(st.nextToken());

            if (M == 0 && N == 0)
                break;

            parent = new int[M];
            for (int i = 0; i < M; i++)
                parent[i] = i;

            int[][] maps = new int[N][3];


            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                
                int V1 = Integer.parseInt(st.nextToken());
                int V2 = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                maps[i][0] = V1;
                maps[i][1] = V2;
                maps[i][2] = weight;
            }

            Arrays.sort(maps, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return a[2] - b[2];
                }
            });

            int result = 0;

            for (int i = 0; i < maps.length; i++) {
                int V1 = maps[i][0];
                int V2 = maps[i][1];

                if (find(V1) != find(V2)) {
                    union(V1, V2);
                }
                else {
                    result += maps[i][2];
                }
            }

            sb.append(result + "\n");
        }
        System.out.println(sb);
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
