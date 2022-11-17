package seonghan.dfs_bfs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dfs_bfs_3109 {
    public static int R,C,width,answer;
    public static char[][] map;
    public static int[] dir = {-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for(int i=0;i<R;i++){
            String s = br.readLine();
            for(int j=0;j<C;j++){
                map[i][j] = s.charAt(j);
            }
        }

        width = C;
        answer = 0;

        for(int i=0;i<R;i++){
            dfs(i,0);
        }
        System.out.println(answer);
    }
    public static boolean dfs(int x, int y){
        if(y==width-1){
            answer++;
            return true;
        }

        for(int i=0;i<3;i++){
            int nx = x + dir[i];
            int ny = y+1;

            if(nx < 0 || ny<0||nx ==R||ny ==C) continue;

            if(map[nx][ny]=='x')continue;

            map[nx][ny] = 'x';

            if(dfs(nx,ny)) return true;
        }
        return false;
    }
}
