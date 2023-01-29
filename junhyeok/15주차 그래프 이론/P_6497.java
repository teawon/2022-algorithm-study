// 문제 주소 : https://www.acmicpc.net/problem/6497

// 메모리 및 응답시간 : 246728KB || 900ms

// 문제 접근 방법 & 사용 알고리즘: 
// 간선 정보 입력받고, 오름차순(가준치 기준)으로 정렬한 후 최소 스패닝 트리를 구함. 최소 비용을 구하는 것이 아니라
// 절약할 수 있는 최대 비용을 구하는 것이므로 부모가 같을 때 결과 값에 더함

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P_6497 {
    public static int[] parent;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 001. 테스트 케이스마다 반복. 0 0 입력시 종료
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 002. 집의 수 M 입력
            int M = Integer.parseInt(st.nextToken());

            // 003. 길의 수 N 입력
            int N = Integer.parseInt(st.nextToken());

            // 004. 0 0 입력시 종료
            if (M == 0 && N == 0)
                break;

            // 005. 부모 노드 저장할 배열 선언 후 자기 자신으로 초기화
            parent = new int[M];
            for (int i = 0; i < M; i++)
                parent[i] = i;

            // 006. 두 집을 연결하는 간선 정보를 저장할 배열
            int[][] maps = new int[N][3];

            // 007. 간선 정보 입력
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                
                int V1 = Integer.parseInt(st.nextToken());
                int V2 = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                maps[i][0] = V1;
                maps[i][1] = V2;
                maps[i][2] = weight;
            }

            // 008. 간선을 가중치 기준 오름차순으로 정렬
            Arrays.sort(maps, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return a[2] - b[2];
                }
            });

            int result = 0;

            // 009. UNION & FIND
            for (int i = 0; i < maps.length; i++) {
                int V1 = maps[i][0];
                int V2 = maps[i][1];

                if (find(V1) != find(V2)) {
                    union(V1, V2);
                }
                // 010. 절약할 수 있는 최대 비용을 출력해야 하므로 부모가 같을 때 결과값에 더함
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
