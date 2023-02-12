package seonghan.graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


// Kruskal 로 MST 생성한 다음에 가장 마지막에 추가되는 길을 제외하면 마을 두개로 분리하고 유지비가 최소가 된다.
//1400ms
public class graph_1647 {
    static int N;// 집의 개수
    static int M;// 길의 개수
    static int home[];
    static PriorityQueue<Edge> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        home = new int[N+1];

        for(int i= 1;i<=N;i++){
            home[i] = i;
        }

        pq = new PriorityQueue<Edge>();


        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Edge(a,b,cost));
        }


        int min = 0;
        int count = 0;
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            if(count == N-2){
                break;
            }

            int a = find(edge.from);
            int b = find(edge.to);

            if(a==b){
                continue;
            }

            home[b] = a;
            min += edge.cost;
            count++;

        }

        System.out.println(min);

    }

    public static int find(int a){
        if(home[a] == a){
            return a;
        }
        return home[a] = find(home[a]);
    }

    public static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }
}
