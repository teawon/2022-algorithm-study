// 문제 주소 :  https://www.acmicpc.net/problem/1

// 문제 접근 방법 & 사용 알고리즘: 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class P_2644 {
    static int count = 0;
    static int[][] array;
    static boolean[] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        array = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            array[a-1][b-1] = 1;
            array[b-1][a-1] = 1;
        }

        int result = dfs(p, q);

        System.out.println(result);
    }

    public static int dfs(int p, int q) {
        if (p == q) {
            return count;
        }
        visited[p] = true;
        for (int j = 1; j < array.length; j++) {
            if (array[p][j] == 1 && !visited[j]) {
                count ++;
                dfs(j, q);
            }
        }

        return -1;
    }
}
