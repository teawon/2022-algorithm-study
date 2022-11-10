import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/3109
 * 
 * 문제 접근 방법 & 사용 알고리즘: 
 * 일단 DFS를 통해 모든 경우의 수에 대한 경로는 탐색할 수 있다. 몇 개의 경로가 나오는지도 알 수 있고.. 각 경로에대해서는 걸린횟수나 위로간 횟수 등 특징을 모두 확인할 수 있다.
 * 근데 최대 몇 개인지는?? 다른 경로와 곂치지 않는다는 이야기는 다른 경로에 대한 정보도 필요한거같은데 DFS에서 이걸 알 수 있나?
 * 
 * -- 답지보고 풂, 다시 풀어보기 --
 * 시작지점점에서 차례대로 파이프를 두는데 핵심은 가장 위쪽부터 파이프를 놓으며 최대한 당겨서 파이프를 설치힌다.
 * DFS를 통해 방문지역을 확인하며 파이프를 계속두고 "내 앞에 있는 경로"에 길이 있다면(true를 return받으면) 자기 자신도 true를 반환해서 "내 뒤에 있는 경로에게 알린다"
 * 내가 3가지 경로에 대해 다 0의 값을 return받았다면 내 앞의 어떤 경로로 가도 도착지에는 도달할 수 없음을 의미하게된다.
 * 결과적으로 각 출발지에서 최대한 위쪽으로 붙여 파이프를 만들어나가는데 전체 만들어진 파이프의 개수를 카운팅하여 최대 개수를 계산한다
 */

public class P_3109 {
    

    public static char[][] map_array= new char[10002][502]; //빵집 정보
    public static boolean[][] visited= new boolean[10002][502]; //빵집 정보
    public static int R;
    public static int C;
    public static int[] dy = {-1,0,1}; //파이프 설치 가능 경로 3개 (x축은 +1씩 고정)
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); // 행의 수
        C = Integer.parseInt(st.nextToken()); // 열의 수

        int max = 0;
        for(int y=1; y<R+1; y++){
            String line = br.readLine();
            for(int x=0; x<C; x++){       
                map_array[y][x+1] = line.charAt(x);
        
            }
        }
      
        for(int y=1; y<R+1; y++){

           if(dfs(y,1) ==  1){ 
               max++;
           }
          
        }
        
        System.out.println(max);
        
    }
    public static int dfs(int y, int x){

        map_array[y][x] = 'x';
        if(x == C) {
            return 1;
        }

        for(int d=0; d<3; d++){
            if(y+dy[d] > 0 && y+dy[d] < R+1 && map_array[y+dy[d]][x+1]== '.'){ 
                if(dfs(y+dy[d],x+1) == 1) {return  1;} //내 앞의 노드에서 1을 받았다면 파이프로 이어지는 경로가 있었다는 의미. 자기도 return하며 뒤의 노드에게 알린다
            }
        }
        return 0;
        
    }
}
