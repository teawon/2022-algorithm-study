// 문제 주소 : https://www.acmicpc.net/problem/1647

// 메모리 및 응답시간 : 341964KB ||	2396ms

// 문제 접근 방법 & 사용 알고리즘: 
// 최소 스패닝 트리를 구해서 가장 비싼 길(간선) 1개를 제거함 -> 트리가 2개로 나뉨 -> 즉 마을이 2개

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P_1647 {
    public static int[] parent;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 001. 집의 개수 N 입력
        int N = Integer.parseInt(st.nextToken());

        // 002. 길의 개수 M 입력
        int M = Integer.parseInt(st.nextToken());

        // 003. 간선 정보 저장할 배열 선언
        int[][] graph = new int[M][3];

        // 004. 부모노드 배열 선언 후 자기자신으로 초기화
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) 
            parent[i] = i;

        // 005. 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int V1 = Integer.parseInt(st.nextToken());
            int V2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[i][0] = V1;
            graph[i][1] = V2;
            graph[i][2] = weight;
        }

        // 006. 간선을 가중치 기준 오름차순으로 정렬
        Arrays.sort(graph, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });

        // 007. 선택한 간선 개수
        int count = 0;
        // 008. 결과값
        int result = 0;

        // 009. UNION & FIND
        for (int i = 0; i < graph.length; i++) {
            int a = find(graph[i][0]);
            int b = find(graph[i][1]); 

            if (find(a) != find(b)) {
                count++;
                result += graph[i][2];
                union(a, b);
                
                // 010. 최소 스패닝 트리의 간선의 개수가 N - 1인데, 길 하나를 제거하므로
                //      N - 2가 되면 종료
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