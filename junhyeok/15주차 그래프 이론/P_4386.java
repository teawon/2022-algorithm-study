// 문제 주소 : https://www.acmicpc.net/problem/4386

// 메모리 및 응답시간 : 14788KB || 144ms

// 문제 접근 방법 & 사용 알고리즘: 
// 별의 개수와 각 별의 위치 정보를 입력 받은 후 거리를 계산하고 최소 스패닝 트리를 구함	

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

        // 001. 별의 개수 N 입력
        int N = Integer.parseInt(br.readLine());

        // 002. 부모노드 배열 선언 후 자기 자신으로 초기화
        parent = new int[N + 1];
        for (int i = 1 ; i <= N; i++)
            parent[i] = i;

        // 003. 별의 위치를 저장할 배열
        double[][] location = new double[N][2];

        // 004. 각 별의 위치 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            location[i][0] = x;
            location[i][1] = y;
        }

        // 005. 간선을 계산하고 저장할 리스트
        ArrayList<double[]> list = new ArrayList<double[]>();

        // 006. 거리 계산 후 리스트에 저장
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

        // 007. 리스트를 거리 기준 오름차순으로 정렬
        Collections.sort(list, new Comparator<double[]>() {
            @Override
            public int compare(double[] a, double[] b) {
                return (int)(a[2] - b[2]);
            }
        });

        double result = 0;
        int count = 0;

        // 008. UNION & FIND
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

        // 009. 소수점 둘째 자리까지 출력
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
