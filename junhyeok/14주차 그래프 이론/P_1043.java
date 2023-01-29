import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P_1043 {
    public static int[] parent;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 00. 사람의 수 N
        int N = Integer.parseInt(st.nextToken());
        // 00. 파티의 수 M
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;

        // 00. <----- 두번째 줄 입력 시작 ----->
        st = new StringTokenizer(br.readLine());

        // 00. 진실을 아는 사람의 수
        int numOfKnow = Integer.parseInt(st.nextToken());
        boolean[] know = new boolean[51];

        for (int i = 0; i < numOfKnow; i++) {
            int personNum = Integer.parseInt(st.nextToken());
            know[personNum] = true;
        }

        // 00. <----- 세번째 줄 입력 시작 ----->

        // 00. 파티 참여자 저장할 list
        ArrayList<Integer>[] list = new ArrayList[M];

        for (int i = 0; i < M; i++)
            list[i] = new ArrayList<Integer>();

        int preNum = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int personNum = Integer.parseInt(st.nextToken());
            
            preNum = Integer.parseInt(st.nextToken());
            list[i].add(preNum);

            for (int j = 0; j < personNum - 1; j++) {
                int temp = Integer.parseInt(st.nextToken());
                list[i].add(temp);
                union(preNum, temp);
                preNum = temp;
            }
        }

        // 00. 처리
        for (int i = 1; i < know.length; i++) {
            if(know[i])
                know[find(i)] = true;
        }

        int count = 0;

        for (int i = 0; i < M; i++) {
            int top = find(list[i].get(0));
            if (!know[top]) count++;
        }

        System.out.println(count);
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
            if(y > x)
                parent[y] = x;
            else
                parent[x] = y;
        }
    }
}
