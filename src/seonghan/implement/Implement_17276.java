package seonghan.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/17276
 *
 * 문제 접근 방법 & 사용 알고리즘:
 * 단순 구현 문제 , 주석을 써가면서 햇갈리지 않게 푸는게 좋은듯
 * 일단 45도만 돌리면 나머지 조건은 쉽게 구현 가능
 * 단계마다 돌려야하는 숫자가 n 개 이므로 크기가 n인 배열을 만들어서 조건에 맞게 돌려주면됨.
 */

// 일단 조건대로 45도만 돌려보자
public class Implement_17276 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }

            }
            Solution(n,d,arr);



        }

    }

    public static void Solution(int n,int d, int arr[][]){


        //----------------------1번 작업 주 대각선을 가운데 열로 옮겨야함---------------------------------
        if(d>=0) {
            int[] temp = new int[n]; // 넣을 숫자들
            int[] temp2 = new int[n]; // 바껴짐 당하는 숫자들
            int ch = n-1; //리버스 용도
            for (int a = 0; a < d / 45; a++) {
                for (int i = 0; i < n; i++) {
                    temp[i] = arr[i][i]; // 그럼 일단 주 대각선을 temp 배열에 넣어야 하고, 주 대각선은 0,0/  1,1 / 2,2/ 이런식
                    temp2[i] = arr[i][n / 2]; // 그리고 temp2에 바껴짐 당하는 숫자들을 넣어야함 첫번째 작업에서는 가운데 열 (n+1)/2 열들 즉, arr[i][(n+1)/2] 이놈들을 바꿔야함
                    //여기 안에서 바꿔도 되지만 뭔가  반대로 돌릴 때를 생각하면 빠져 있는게 편할듯?
                }

                for (int i = 0; i < n; i++) { // 이제 주 대각선들을 가운데 열 놈들이랑 바꿔줌
                    arr[i][n / 2] = temp[i];
                }
                //--------------------1 번 작업 끝/ 2번 작업 가운데 열을 부 대각선으로--------------------------------------------
                for (int i = 0; i < n; i++) {
                    temp[i] = temp2[i]; // 넣을 숫자 배열로 이동
                    temp2[i] = arr[i][n - 1 - i]; // 부 대각선 놈들은 이렇게 되있음
                }

                for (int i = 0; i < n; i++) { // 이제 가운데 열을 부 대각선으로 바꿔줌.
                    arr[i][n - 1 - i] = temp[i];
                }
                //--------------------2번 작업 끝 / 3번 작업 부 대각선 놈들을 가운데 행으로 바꿔줌 -----------------------------------
                for (int i = 0; i < n; i++) {

                    temp[i] = temp2[i];
                    temp2[i] = arr[n / 2][i];
                }
                for (int i = 0; i < n; i++) {
                    arr[n / 2][i] = temp[ch];
                    ch--;
                }
                ch = n - 1;
                //---------------------3번 작업 끝/ 4번 작업 가운데 행놈들을 주 대각선으로 이동
                for (int i = 0; i < n; i++) {
                    temp[i] = temp2[i];
                }
                for (int i = 0; i < n; i++) {
                    arr[i][i] = temp[i];
                }
                //-------------4번 작업 끝-----------------
            }
        }


        if(d<0) // 시계 반대 방향 일 떄
        {
            int[] temp = new int[n]; // 넣을 숫자들
            int[] temp2 = new int[n]; // 바껴짐 당하는 숫자들
            int ch = n-1; //리버스 용도
            d = d*(-1);
            for (int a = 0; a < d / 45; a++) {
                for (int i = 0; i < n; i++) {
                    temp[i] = arr[i][i]; // 그럼 일단 주 대각선을 temp 배열에 넣어야 하고, 주 대각선은 0,0/  1,1 / 2,2/ 이런식
                    temp2[i] = arr[n/2][i]; // 그리고 temp2에 바껴짐 당하는 숫자들을 넣어야함 첫번째 작업에서는 가운데 열 (n+1)/2 열들 즉, arr[i][(n+1)/2] 이놈들을 바꿔야함
                    //여기 안에서 바꿔도 되지만 뭔가  반대로 돌릴 때를 생각하면 빠져 있는게 편할듯?
                }

                for (int i = 0; i < n; i++) { // 이제 주 대각선들을 가운데 열 놈들이랑 바꿔줌
                    arr[n/2][i] = temp[i];
                }
                //--------------------1 번 작업 끝/ 2번 작업 가운데 열을 부 대각선으로--------------------------------------------
                for (int i = 0; i < n; i++) {
                    temp[i] = temp2[i]; // 넣을 숫자 배열로 이동
                    temp2[i] = arr[i][n - 1 - i];
                }

                for (int i = 0; i < n; i++) {
                    arr[i][n - 1 - i] = temp[ch];
                    ch--;
                }
                ch = n-1;
//                //--------------------2번 작업 끝 / 3번 작업 부 대각선 놈들을 가운데 행으로 바꿔줌 -----------------------------------
                for (int i = 0; i < n; i++) {

                    temp[i] = temp2[i];
                    temp2[i] = arr[i][n/2];
                }
                for (int i = 0; i < n; i++) {
                    arr[i][n/2] = temp[i];
                }
                //---------------------3번 작업 끝/ 4번 작업 가운데 행놈들을 주 대각선으로 이동
                for (int i = 0; i < n; i++) {
                    temp[i] = temp2[i];
                }
                for (int i = 0; i < n; i++) {
                    arr[i][i] = temp[i];
                }
               // -------------4번 작업 끝-----------------
            }
        }

        //출력
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
//                System.out.print(arr[i][j]+" ("+i+","+j+")");
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }


}
