package seonghan.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class dfs_bfs_1260 {
    static int N; //정점의 갯수
    static int M; //간선의 갯수
    static int startNode; //시작 노드
    static int[][] check;
    static ArrayList<Integer> visitedDFS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(st.nextToken());
        check = new int[1001][1001];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            check[f][s] = check[s][f] = 1;
        }

        visitedDFS = new ArrayList();
        dfs(startNode);
        System.out.println();
        bfs(startNode);


    }

    public static void bfs(int startNode) {
        ArrayList<Integer> visited = new ArrayList<>();
        ArrayList<Integer> needVisit = new ArrayList<>();

        needVisit.add(startNode);
        while(!needVisit.isEmpty()){
            int node = needVisit.remove(0);
            if(!visited.contains(node)) visited.add(node);
            for(int i=1;i<=N;i++){
                if(check[node][i]==1&&!visited.contains(i)){
                    needVisit.add(i);
                }
            }
        }
        for(int i=0;i<visited.size();i++){
            System.out.print(visited.get(i)+" ");
        }

    }

    public static void dfs(int i){

        visitedDFS.add(i);
        System.out.print(i+" ");
        for(int j=1;j<=N;j++){
            if(!visitedDFS.contains(j)&&check[i][j]==1){
                dfs(j);
            }
        }
    }
}
