import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/10994
 * 
 * 문제 접근 방법 & 사용 알고리즘: 별찍기 문제는 항상 규칙을 찾아 for문으로 값을 출력했다. 하지만 이 경우는 내부의 사각형을 한번에 for문으로 그릴 수 없다.
 * 단순 출력은 힘들 것 같고 배열을 만들어서 자기 위치에 해당하는 사각형을 그리도록 함수를 구현
 * 
 * 숫자의 경우 1 , 5  ,9 , 13  즉 4*(number-1) + 1의 규칙을 가지고 있다.
 * 
 * 
 * Q. 배열을 전역변수로 선언하기 vs 내부 함수의 파라메터로 넣기 - 생각보다 성능차이가 나지 않았다. 가독성 차이?
 * Q. 배열 자체의 값을 사용하는게 아니라 array[a][b] == true 이면~~ 식으로 사용할 때는 boolean이 적합할까? int형도 크게 차이는 없는 것 같은데 취향차이?
 */


public class P_10994 {
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt(); //입력 정수
        boolean[][] star_arr = new boolean[4*(N-1)+1][4*(N-1)+1];

        draw(N, star_arr , 0);

        StringBuilder sb = new StringBuilder(); 
        for(int i=0; i<4*(N-1)+1; i++){ //출력
            for(int j=0; j<4*(N-1)+1; j++){
                if(star_arr[i][j] == true){
                    sb.append("*");
                }
                else{
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);    
    }

    public static void draw(int number, boolean[][] array, int start){ //number : 바깥에 위치한 n번째 사각형 , start : 그릴 좌표 (내부 사각형은 자기 위치모르니까)
        for(int i =0; i<4*(number-1)+1; i++){ //N번째 바깥 사각형 그리기
            array[start][start+i] = true;
            array[start+i][start] = true;
            array[start+4*(number-1)][start+i] = true;
            array[start+i][start+4*(number-1)] = true;
        }

        if(number == 1) return;
        draw(number-1, array, start+2);
    }
    
}