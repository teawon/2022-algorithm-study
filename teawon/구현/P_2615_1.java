import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/2615
 * 
 * 문제 접근 방법 & 사용 알고리즘: 
 * 
 * 
 * 1. x축 , y축 , 대각선 2방향을 각각 for문으로 순회하는데 연속되는 값이 나오면 카운트를 늘리는 방법으로 접근 (실패한 첫번째 방법)
 * 
 * Q. 이렇게 접근한 이유 : 값을 하나하나 검사하면서 4방향을 카운팅하면 한칸 이동할때도 같은 구간을 반복해서 검사하니까 비효율적이라고 생각했다. 
 *  차라리 4방향에 대해 한번에 검사를하면서 연속되는 개수를 계산하는게 더 좋은 알고리즘일 것 같다고 생각
 * 
 *  -> 코드가 너무 길어지고 대각선의 경우 한 방향을 나타낼 때 2가지 경우의 수로 나누어진다.
 *  
 *  -> 대각선 검사는 불가피하게 while로 돌리는데 코드의 일관성이 없고 함수로 묶기도 힘듦
 * 
 *  -> 차라리 하나씩 값을 검사하면서 개수를 체크하는게 좋을 듯
 * 

 
 */


public class P_2615_1 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int[][] data = new int[19][19]; //오목판 데이터

        int[] count = new int[2]; //연속된 개수 카운팅
        count[0]=1;
        count[1]=1;

        int winner = 0; // 이긴 바둑돌
 
        int x_place=0; //이긴 바둑돌의 위치
        int y_place=0; 
        
        for(int i=0; i<19; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<19; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int y=0; y<19; y++){ //x축 검사
            for(int x=1; x<19; x++){
                if(data[y][x-1] == data[y][x] && data[y][x]!=0 ){ //연속된 값이 있으면 +1
                    count[data[y][x]-1]++;

                    if(count[data[y][x]-1]==5){
                        winner = data[y][x];
                        y_place = y;
                        x_place = x-4;
                    }
                    if(count[data[y][x]-1]==6){
                        winner = 0;
                    }
                }
                else{
                    count[0]=1;
                    count[1]=1;
                }
            }
        }
        
        if(winner==0){
            count[0]=1;
            count[1]=1;
            for(int x=0; x<19; x++){ //y축 검사
                for(int y=1; y<19; y++){
                    if(data[y-1][x] == data[y][x]  && data[y][x]!=0){ //연속된 값이 있으면 +1
                        count[data[y][x]-1]++;
    
                        if(count[data[y][x]-1]==5){
                            winner = data[y][x];
                            y_place = y-4;
                            x_place = x;
                        }
                        if(count[data[y][x]-1]==6){
                            winner = 0;
                        }
                    }
                    else{
                        count[0]=1;
                        count[1]=1;
                    }
                }
            }
        }
        
        if(winner==0){ // 왼쪽->오른쪽으로 가는 대각선 검사 (1)
            count[0]=1;
            count[1]=1;
            for(int i=0; i<19; i++){
                int x=i;
                int y=0;
                while(true){
                    if(++y >=19 || ++x >=19) break;
    
                    if(data[y][x] == data[y-1][x-1]  && data[y][x]!=0 ){ //연속된 값이 있으면 +1
                        count[data[y][x]-1]++;
    
                        if(count[data[y][x]-1]==5){
                            winner = data[y][x];
                            y_place = y-4;
                            x_place = x-4;
                     
                        }
                        if(count[data[y][x]-1]==6){
                            winner = 0;
                        }
                    }
                    else{
                        count[0]=1;
                        count[1]=1;
                    }
                }
            }

        }

        if(winner==0){ // 왼쪽->오른쪽으로 가는 대각선 검사 (2)
            count[0]=1;
            count[1]=1;
            for(int i=0; i<19; i++){
                int x=0;
                int y=i;
                while(true){
                    if(++y >=19 || ++x >=19) break;
    

                    if(data[y][x] == data[y-1][x-1] && data[y][x]!=0){ //연속된 값이 있으면 +1
                        count[data[y][x]-1]++;
    
                        if(count[data[y][x]-1]==5){
                            winner = data[y][x];
                            y_place = y-4;
                            x_place = x-4;  
                        }
                        if(count[data[y][x]-1]==6){
                            winner = 0;
                           
                        }
                    }
                    else{
                        count[0]=1;
                        count[1]=1;
                    }
                }
            }
        }   


        if(winner==0){  // 오른쪽->왼쪽으로 가는 대각선 검사 (1)
            count[0]=1;
            count[1]=1;
            for(int i=0; i<19; i++){
                int x=i;
                int y=0;
                while(true){
                    if(++y >=19 || --x<0) break;
    
    
    
                    if(data[y][x] == data[y-1][x+1] && data[y][x]!=0){ //연속된 값이 있으면 +1
                        count[data[y][x]-1]++;
    
                        if(count[data[y][x]-1]==5){
                            winner = data[y][x];
                            y_place = y;
                            x_place = x;
            
                        }
                        if(count[data[y][x]-1]==6){
                            winner = 0;
                        }
                    }
                    else{
                        count[0]=1;
                        count[1]=1;
                    }
                }
            }
        }

      
        if(winner==0){  // 오른쪽->왼쪽으로 가는 대각선 검사 (2)
            count[0]=1;
            count[1]=1;
            for(int i=0; i<19; i++){
                int x=18;
                int y=i;
                while(true){
                    if(++y >=19 || --x<0) break;
        
                    if(data[y][x] == data[y-1][x+1]  && data[y][x]!=0){ //연속된 값이 있으면 +1
                        count[data[y][x]-1]++;
    
                        if(count[data[y][x]-1]==5){
                            winner = data[y][x];
                            y_place = y;
                            x_place = x;
                  
                        }
                        if(count[data[y][x]-1]==6){
                            winner = 0;
                        }
                    }
                    else{
                        count[0]=1;
                        count[1]=1;
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