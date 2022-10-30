import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/2615
 * 
 * 문제 접근 방법 & 사용 알고리즘: 
 * 2. 각 값을 순회하며 4방향에 대해 카운팅을 한다. 
 * 단 출력되는 좌표값은 x값이 가장 낮은 좌표이므로 방향을 선정할 때 x값이 증가하는 4방향만 선택한다. (역순은 어처피 중복)
 * (초기에는 8방향으로 선택했으나 어처피 for문에서 왼쪽에서 오른쪽으로 값을 순회하므로 반대는 고려하지 않아도 된다.)
 * (6목 예외처리 주의 [o][o][o][o][o][o]의 경우 처음에는 6이 카운팅되지만 for문으로 한칸 이동하면 5가 카운팅된다.)
 */


public class P_2615_2 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] dx = {1, 1, 1, 0 }; // ↗  ⇨ ↘ ⇩ 순으로 검사(8방향 중 한쪽 방향에 대해서만 검사하면된다. 단 x가 증가하는 방향으로 잡아야 x값이 최소가되는 위치를 찾을 수 있다.)
        int[] dy = {-1, 0 , 1 , 1}; 
        int[][] data = new int[19][19]; //오목판 데이터

        for(int i=0; i<19; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<19; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int winner = 0;
        int y_place = -1;
        int x_place = -1;

        for(int i=0; i<19; i++){
            for(int j=0; j<19; j++){

                int value = data[i][j]; //검사할 값
              
                if(value==0) continue;
                
                for(int d=0; d<4; d++){ //검사할 값의 4방향에 대해 카운트를 센다
                    int count = 1;
                    int y=i;
                    int x=j;
                    if(y-dy[d] >= 0 && y-dy[d] <= 18 && x-dx[d] >= 0 &&  x-dx[d] <= 18 && data[y-dy[d]][x-dx[d]] == value) continue;
                    //이전값이 같으면 패스 (어처피 값을 순회하면서 다음Value에서 확인된다. 6목의 경우 이전값을 빼고 5가 되면 안되므로 예외처리)
                        
                    for(; count<6; count++){
                        if(y+dy[d] < 0 || y+dy[d] > 18 || x+dx[d] < 0 ||  x+dx[d] > 18 || data[y+dy[d]][x+dx[d]] != value) break;
                        y+=dy[d];
                        x+=dx[d];
                    }
                    
                    if(count == 5){ //정확히 5개일때 값을 저장
                        winner=value;
                        x_place=j;
                        y_place=i;
                    }
                } 
            }
        }

        System.out.println(winner);
        if(winner!=0){
            System.out.println((y_place+1)+" "+(x_place+1));
        }   
    }   
}