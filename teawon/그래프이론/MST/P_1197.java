import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1197
 * 
 * 672ms
 * 문제 접근 방법 & 사용 알고리즘 : 
    다익스트라 알고리즘과 다른점이 무엇인가?
    우선 크루스칼알고리즘은 "노드"가 아니라 "간선"을 기준으로 자료구조를 정해야한다
    
    - 다익스트라 : A에서 B까지 가는 경로를 자기 자신의 cost + 연결된 값 =   distance[i][j] = distance[i][k] + distance[k][j]; 형태로 값을 기억해야했다.
    따라서 Node (index, cost)를 가지는 자료구조를 선언하고 각 노드에 대해 연결된 간선정보를 모두 확인하기 위해 2차원의 ArrayList<ArrayList<Node>> 값을 사용
    
    - 크루스칼 : Edge(start, end, cost)값을 가지고 값을 계산하기만 하면된다. 이미 포함되어있는 간선인지 확인하기 위해 같은 집합인지 확인이 필요하다.
    따라서 가중치를 기준으로 오름차순 정렬 후 하나의 ArrayList<Edge>를 선언 해 모든 간선을 둘러본다. 
    
 */

public class P_1197 {

    static int[] parent;

    public static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        public int compareTo(Edge target) {
            return this.cost - target.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점의 수
        int E = Integer.parseInt(st.nextToken()); // 간선의 수
        
        nt = new int[V + 1];
        (int i = 1; i < V + 1; i++) { // 부모는 자기자신을 가

        
    

    

        st = new Strin   i
    nt start =Itge.par
    e
        int end = Integer
        int cost = Integer.parseInt(st.nextToken());
            
        e
        
        
        ys.sort(edge);
        
    i

        Edge e = edge[i];
            if (findParent(e.start) == findParent(e.end)) {
                continue;
            }
            union(e.start, e.end);
            totalCost += e.cost;
        }

        System.out.println(totalCost);

    }

    public static int findParent(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = findParent(parent[x]);
    }

    public static void union(int x, int y) {
        int p1 = findParent(x);
        int p2 = findParent(y);

        if (p1 != p2) {

            parent[p1] = p2;
            }
        
    }
}
