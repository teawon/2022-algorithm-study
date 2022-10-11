import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/17276
 * 직접 그려보면서 이동하는 경로를 순서대로 코드화.
 * 단 그리다보면 마지막은 역순이므로 해당부분만 따로 복사해서 값을 옮긴다.
 */


public class P_17276 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 입력받을 테스트 케이스 수

        
        for(int tNum=0; tNum<T; tNum++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 배열의 크기
            int radius = Integer.parseInt(st.nextToken()); //각도

            int dataArr[][] = new int[N][N]; //배열의 데이터를 저장

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    dataArr[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            int[] tempSpace = new int[N]; //임시로 배열을 저장
            if(radius < 0){ // 음수라면 360을 더함
                radius += 360;
            }
            if(radius == 360){ //360이면 생략
                radius = 0;
            }
            
           

            for(int count=0; count<radius/45; count++){
                for(int i=0; i<N; i++){
                    tempSpace[i] = dataArr[N-i-1][N/2]; // y축 정보를 미리 복사
                }
                for(int i=0; i<N; i++){ //시계방향으로 돌린다.
                    dataArr[i][N/2] = dataArr[i][i]; //  대각선(왼->오) 
                    dataArr[i][i] = dataArr[N/2][i]; // x축
                    dataArr[N/2][i] = dataArr[N-1-i][i]; // 대각선(오->왼)
                    dataArr[N-i-1][i] = tempSpace[i]; // y축
                }
            }



            for(int i=0; i<N; i++){  //변경된 배열을 저장
                for(int j=0; j<N; j++){
                    sb.append(dataArr[i][j]+ " ");
                }
                sb.append("\n");
            }

        }
        System.out.println(sb); //저장된 문자열 출력

    }
    

}