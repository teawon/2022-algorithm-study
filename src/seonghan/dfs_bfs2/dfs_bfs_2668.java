package seonghan.dfs_bfs2;

import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/2688
 *
 * 문제 접근 방법 & 사용 알고리즘: DFS
 * 인덱스와 값을 비교하는 DFS
 */

public class dfs_bfs_2668 {
    static int N,index;
    static int []arr;
    public static boolean[] visited;
    public static List<Integer> answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        visited = new boolean[N+1];
        answer = new ArrayList<Integer>();

        for(int i=1;i<N+1;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=N;++i){
            visited[i] = true;
            index = i;
            dfs(i);
            visited[i] = false;
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder("");
        sb.append(answer.size()).append("\n");

        for(int n:answer){
            sb.append(n).append("\n");
        }
        System.out.println(sb);

    }
    public static void dfs(int i) {
        if (arr[i] == index) {
            answer.add(i);
        }

        if (!visited[arr[i]]) {
            visited[arr[i]] = true;
            dfs(arr[i]);
            visited[arr[i]] = false;
        }
    }
}
