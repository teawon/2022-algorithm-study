import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/3109
 * 
 * 문제 접근 방법 & 사용 알고리즘: 
 * 일단 DFS를 통해 모든 경우의 수에 대한 경로는 탐색할 수 있다. 몇 개의 경로가 나오는지도 알 수 있고.. 각 경로에대해서는 걸린횟수나 위로간 횟수 등 특징을 모두 확인할 수 있다.
 * 근데 최대 몇 개인지는?? 다른 경로와 곂치지 않는다는 이야기는 다른 경로에 대한 정보도 필요한거같은데 DFS에서 이걸 알 수 있나?
 * 
 * //변경.. 각 열에 대해 갈수 있는 이전경로값을 계산한다
 */

public class P_3109 {
    

    public static char[][] map_array= new char[10002][502]; //미로 정보
    public static boolean[][] visited= new boolean[10002][502]; //미로 정보
    public static int R;
    public static int C;
    public static int[] dy = {-1,0,1}; //파이프 설치 가능 경로 3개 (x축은 +1씩 고정)
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); // 행의 수
        C = Integer.parseInt(st.nextToken()); // 열의 수

        int max = 9999999;
        for(int y=1; y<R+1; y++){
            String line = br.readLine();
            for(int x=0; x<C; x++){       
                map_array[y][x+1] = line.charAt(x);
        
            }
        }
       
        for(int y=1; y<R+1; y++){
             visited[y][1] = true;
        }

        for(int x=1; x<C; x++){
            int count = 0;
            for(int y=1; y<R+1; y++){       
                Boolean isblocked = true;
                if(visited[y][x] == true){ //지금 위치가능하면
                    for(int d=0; d<3; d++){
                        if(y+dy[d] > 0 && y+dy[d] < R+1 && map_array[y+dy[d]][x+1]== '.' && visited[y+dy[d]][x+1] == false){ //다음 경로중 갈수있는 위치에 대해 체크표시 및 카운팅
                            count++;
                            visited[y+dy[d]][x+1] = true;
                            isblocked = false;
                            
                        }
                    }
                    
                }
            }
            //System.out.println("x : "+ x + " count : " + count);
            if(count != 0){
                max = Math.min(max , count); //각 열을 돌며 갈수있는 경로수를 계산한다.
            }
            else{
                max = 0; break;
            }
           
        }
        // if(max == 9999999){
        //     System.out.println("0");
        // }
        
            System.out.println(max);
        
        
    }

}




