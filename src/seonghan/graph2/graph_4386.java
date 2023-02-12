package seonghan.graph2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class graph_4386 {

    static int n;
    static int[] parent, rank;
    static Pair[] pair;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i] = i;
        }

        rank = new int[n+1];
        pair = new Pair[n+1];
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            pair[i] = new Pair(i,x,y);
        }

        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                double x1 = pair[i].x;
                double x2 = pair[j].x;
                double y1 = pair[i].y;
                double y2 = pair[j].y;
                pq.add(new Edge(i,j,calc(x1,y1,x2,y2)));
            }
        }

        mst();
    }

    static double calc(double x1, double y1, double x2, double y2){
        double a = x2 - x1;
        double b = y2 - y1;
        return Math.sqrt((a*a) + (b*b));
    }

    static void union(int u, int v){
        u = find(u);
        v = find(v);

        if(u!=v){
            if(rank[u] < rank[v]){
                parent[u] = v;
            }else{
                parent[v] = u;
                if(rank[u] == rank[v]){
                    rank[u]++;
                }
            }
        }
    }

    static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void mst(){
        double ret = 0;
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int u = cur.s;
            int v = cur.e;
            if(find(u) == find(v)){
                continue;
            }
            union(u,v);

            ret = cur.cost;
        }

        System.out.println(ret);
    }

    static class Edge implements Comparable<Edge> {
        int s, e;
        double cost;

        public Edge(int s, int e, double cost) {
            this.e = e;
            this.s = s;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return (int) (this.cost - o.cost);
        }
    }

    static class Pair {
        int id;
        double x, y;

        public Pair(int id, double x, double y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }
    }
}
