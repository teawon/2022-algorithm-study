package seonghan.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 160ms
public class graph_16562 {
    static int N, M, K;
    static int[] parent, friendFee;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        friendFee = new int[N + 1];
        parent = new int[N + 1];
        check = new boolean[N + 1];

        for (int i = 1; i < parent.length; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < friendFee.length; i++) friendFee[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        int friend = 0;
        int answer = 0;

        for (int i = 1; i < parent.length; i++) {
            int temp = find(i);
            if (check[temp]) {
                friend++;
                continue;
            }
            if(K-friendFee[i]>=0){
                friend++;
                answer+=friendFee[i];
                K-=friendFee[i];
                check[temp] = true;
            }
        }

        System.out.println(friend==N?answer:"Oh no");
    }

    public static void union(int a,int b){
        a = find(a);
        b = find(b);

        if(a<b) parent[b] = a;
        else parent[a] = b;

        if(friendFee[a]<friendFee[b]) friendFee[b]= friendFee[a];
        else friendFee[a] = friendFee[b];
    }

    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);

    }
}
