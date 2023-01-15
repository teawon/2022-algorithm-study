package seonghan.dikstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
1288ms
bfs
 */
public class dijkstra_18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] distance = new int[300001];
        ArrayList<ArrayList<Integer>> linkList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            linkList.add(new ArrayList<Integer>());
            distance[i] = -1;
        }

        distance[x] = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            linkList.get(a).add(b);
        }


        Queue<Integer> q = new LinkedList<>();
        q.add(x);

        while (!q.isEmpty()) {
            int tmp = q.poll();

            for (int i = 0; i < linkList.get(tmp).size(); i++) {
                int next = linkList.get(tmp).get(i);

                if (distance[next] == -1) {
                    distance[next] = distance[tmp] + 1;
                    q.add(next);
                }
            }
        }

        boolean chk = false;
        for(int i=0;i<=n;i++){
            if(distance[i]==k){
                System.out.println(i);
                chk = true;
            }
        }

        if(!chk) System.out.println(-1);
    }
}
