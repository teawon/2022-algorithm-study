import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

// Created on iPad.

// 가장 적은 비용으로 모든 사람과 친구가 되는 방법을 구하라

public class P_16562 {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 00. 학생 수 N 입력
        int N = Integer.parseInt(st.nextToken());
        // 00. 친구 관계 수 M 입력
        int M = Integer.parseInt(st.nextToken());
        // 00. 가지고 있는 돈 K 입력
        int K = Integer.parseInt(st.nextToken());

        // 00. 각각의 학생이 원하는 친구비
        int[] fee = new int[N + 1];

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            // 00. 친구비 입력
            fee[i] = Integer.parseInt(st.nextToken());
        }

        //boolean[] isFriend = new boolean[N + 1];

        // 00. 친구관계 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a != b)
                union(a, b);
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < parent.length; i++) {
            // 00. parent가 최종 부모를 가리키고 있지 않기 때문에 한번더해줌. 
            int dump = find(i);
            int toSearch = parent[i];
            // 00. 리스트에 포함되어 있지 않으면
            if (!list.contains(toSearch))
                list.add(toSearch);
        }

        int total = 0;

        for (int i = 0; i < list.size(); i++) {
            int parentNum = list.get(i);
            int min = Integer.MAX_VALUE;
            for (int j = 1; j < fee.length; j++) {
                if (parent[j] == parentNum)
                    min = Math.min(min, fee[j]);
            }
            total += min;
        }

        if (total <= K)
            System.out.println(total);
        else
            System.out.println("Oh no");
    }

    public static int find(int x) {
        if (parent[x] == x)
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