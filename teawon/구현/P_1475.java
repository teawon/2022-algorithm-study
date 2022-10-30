import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1475
 * 
 * 문제 접근 방법 & 사용 알고리즘: 가장 많은 숫자의 개수를 출력하면 된다. 단 6과 9의 경우 두 수를 합친 후 2로 나눠서 비교해야한다.
 * 
 * 처음에는 정수로 받아서 %10을 하며 값을 비교했는데 긴 문자열이 왔을 때 예외가 발생
 * -> 문자열로 값을 받아 파싱하자
 
 */


public class P_1475 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String N = br.readLine(); // 방번호

       
        int[] number = new int[10]; //1~9까지 번호를 사용하겠다.

        for(int i=0; i<N.length(); i++){
            number[N.charAt(i)-'0']++;
        }

        int max = -1;

        for(int i=0; i<10; i++){  //6과 9를 뺀 나머지 값들의 최대값을 찾는다
            if(i == 6 || i == 9 ) continue;
            if(max < number[i]){
                max = number[i];
            }
        }

        if( max < (number[6]+number[9]+1)/2){ //6과 9의경우 서로 호환이 가능하므로 더해서 2로 나눈다 (0.5는 올림하기 위해 1을 추가로 더함)
            max = (number[6]+number[9]+1)/2;
        }

        System.out.println(max);
    }
    
}