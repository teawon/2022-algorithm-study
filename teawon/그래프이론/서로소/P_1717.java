import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1717
 * 
 * 620ms
 * 문제 접근 방법 & 사용 알고리즘 : 
 * 
 * 문제에서 제공되는 예제를 돌렸을 때 각 노드가 가지는 부모값
 * 1) 시간 초과 코드 : 1:6 2:2 3:6 4:2 5:5 6:6 7:6 
 * 2) 개선 코드 :     1:3 2:2 3:6 4:2 5:5 6:6 7:6 
 * 
 * -> (1)코드의 경우 1의 부모를 찾기위해서는 1->3->6 .. 즉 부모의 부모를 계속 찾아가야하므로 불필요한 연산이 수행된다.
 * -> (2)코드의 경우 1의 부모는 결국 최종값인 6으로 바로 찾을 수 있다.
 * 
 * 즉 부모의 부모의 부모..값은 결국 최종 부모값을 확인하면 되기때문에 findParent()코드에서 찾으려는 부모의값을 갱신하는 코드를 왜 넣었는지 이해하기
 */

public class P_1717 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 집합의 범위
        StringBuffer sb = new StringBuffer();
        parent = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            parent[i] = i; // 초기에는 자기 자신이 부모인 집합을 생성
        }

        int M = Integer.parseInt(st.nextToken()); // 연산 수행 횟수

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (type == 0) {
                union(x, y);
            }

            else {
                if (findParent(x) == findParent(y)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }

            for (int i1 = 1; i1 < N + 1; i1++) {

                System.out.print(i1 + ":" + parent[i1] + " ");
            }
            System.out.println("");

        }
        System.out.print(sb);

    }

    public static int findParent(int x) {
        if (parent[x] == x) {
            return x;
        }

        return findParent(parent[x]);
    }

    public static void union(int x, int y) {
        int p1 = findParent(x);
        int p2 = findParent(y);

        if (p1 != p2) {
            parent[p1] = p2;
        }
    }

}