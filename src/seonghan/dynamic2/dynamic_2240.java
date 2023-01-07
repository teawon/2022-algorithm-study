package seonghan.dynamic2;

import java.io.*;
import java.util.*;
//80ms
public class dynamic_2240 {

    private static int T, W;
    private static int[] arr;
    private static int[][][] cache;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        cache = new int[3][T + 1][W + 2];

        for (int i = 1; i <= T; i++) {
            for (int j = 1; j <= W + 1; j++) {
                if (arr[i] == 1) {
                    cache[1][i][j] = Math.max(cache[1][i - 1][j], cache[2][i - 1][j - 1]) + 1;
                    cache[2][i][j] = Math.max(cache[2][i - 1][j], cache[1][i - 1][j - 1]);
                } else {
                    if (i == 1 && j == 1) continue;
                    cache[1][i][j] = Math.max(cache[1][i - 1][j], cache[2][i - 1][j - 1]);
                    cache[2][i][j] = Math.max(cache[2][i - 1][j], cache[1][i - 1][j - 1]) + 1;
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= W + 1; i++) {
            result = Math.max(result, Math.max(cache[1][T][i], cache[2][T][i]));
        }

        System.out.println(result);
    }
}