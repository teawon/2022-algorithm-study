// 14788	144

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P_4386 {
    public static int[] parent;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 00. 별의 개수 N 입력
        int N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1 ; i <= N; i++)
            parent[i] = i;

        double[][] location = new double[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            location[i][0] = x;
            location[i][1] = y;
        }

        ArrayList<double[]> list = new ArrayList<double[]>();

        for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				double sX = Math.pow(location[j][0] - location[i][0], 2);
                double sY = Math.pow(location[j][1] - location[i][1], 2);

                double weight = Math.sqrt(sX + sY);

				double[] temp = new double[3];

                temp[0] = i;
                temp[1] = j;
                temp[2] = weight;

                list.add(temp);
			}
		}

        Collections.sort(list, new Comparator<double[]>() {
            @Override
            public int compare(double[] a, double[] b) {
                return (int)(a[2] - b[2]);
            }
        });

        double result = 0;
        int count = 0;

        for (int i = 0; i < list.size(); i++) {
            double[] temp = list.get(i);

            if (find((int)temp[0]) != find((int)temp[1])) {
                count++;
                result += temp[2];
                union((int)temp[0], (int)temp[1]);
                if (count == N - 1)
                    break;
            }
        }

        System.out.printf("%.2f", result);
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
