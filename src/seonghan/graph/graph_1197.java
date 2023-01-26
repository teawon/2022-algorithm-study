package seonghan.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
// 544ms
public class graph_1197 {
    static class Node implements Comparable<Node>{
        int from;
        int to;
        int cost;


        public Node(int from, int to,int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost-o.cost;
        }
    }


    static int V,E;
    static int[] parent;
    static ArrayList<Node> nodeList;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        nodeList = new ArrayList<>();


        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodeList.add(new Node(from,to,cost));

        }
        Collections.sort(nodeList);
        make();

        int sum = 0;
        int cnt = 0;

        for(Node n : nodeList){
            if(union(n.from,n.to)){
                sum+=n.cost;
                cnt++;

                if(cnt == E-1) break;
            }
        }

        System.out.println(sum);
    }

    private static boolean union(int from, int to){
        int fromRoot = find(from);
        int toRoot = find(to);


        if(fromRoot == toRoot) return false;
        else parent[toRoot] = fromRoot;
        return true;
    }

    private static int find(int v){
        if(parent[v] == v) return v;
        else return parent[v] = find(parent[v]);
    }

    private static void make(){
        for(int i=1;i<=V;i++){
            parent[i]=i;
        }
    }
}
