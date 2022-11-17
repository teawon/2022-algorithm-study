package seonghan.dfs_bfs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * 문제 주소 :  https://www.acmicpc.net/problem/2644
 *
 * 문제 접근 방법 & 사용 알고리즘: DFS 사용이유? 코드가 짧을거 같아서? bfs써서 풀어도 될듯 최단거리이기 때문에
 * 부모 자식의 관계를 간선, 사람을 정점 으로 보고 양방향 간선, 정점 만들어서 dfs풀이
 *
 */

public class dfs_bfs_2644 {
    static int n; // 전체 사람의 수
    static int person1, person2; // 계산 해야하는 서로 다른 두사람
    static int m; // 부모 자식의 관계
    static int[][] relation;
    static int min = 100;
    static ArrayList<Integer>visited = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        person1 = Integer.parseInt(st.nextToken());
        person2 = Integer.parseInt(st.nextToken());
    

        m = Integer.parseInt(br.readLine());
        relation = new int[101][101];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            relation[x][y] = relation[y][x] = 1;
        }
        int result = person1 > person2 ? dfs(person2,0) : dfs(person1,0);
        if(result == -1&&min==100) min = result;
        System.out.println(min);
    }

    public static int dfs(int person,int length){
        int goalPerson = person1 > person2 ? person1:person2;
        if(goalPerson==person){
            if(min>length) min = length;
                return min;
        }
        visited.add(person);
        for(int i=1;i<n+1;i++){
            if(!visited.contains(i)&&i!=person&&relation[person][i]==1){
                dfs(i,length+1);
            }
            if(person==n&&i==n){
                return -1;
            }
        }

        return -1;

    }
}
