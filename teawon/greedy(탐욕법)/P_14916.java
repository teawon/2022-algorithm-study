import java.util.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/14916
 * 
 * 문제 접근 방법 & 사용 알고리즘:
 *  최대한 5원의 거스름돈 개수가 많아야 하기때문에 5로 먼저 나눈 후 나머지 값에 대해 2로 나머지 연산을 수행. 
 *  숫자 2가 있었기 때문에 짝수/홀수 개념으로 접근할 수 있었지만 다른 숫자였다면 다른방법을 사용해야한다.
 *  
 */

public class P_14916 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int numOf5 = 0;
        int numOf2 = 0;

        if ( (N % 5) % 2 == 0 ) { //5로 나눈 나머지가 2의 배수인지 확인
            numOf5 = N / 5;
            numOf2 = (N % 5) / 2;
        } 
        else{                     //2의 배수가 아니라면 5원의 거스름돈 개수를 하나 낮추면 항상 짝수가되므로 나머지를 계산한다.
    
            numOf5 = N / 5 - 1;
            numOf2 = ((N % 5) + 5) / 2;
        }

        if(numOf5 < 0){          //5의 값이 음수라면 (나누어지지 않는다는 의미) -1 출력
            System.out.println("-1");
        }
        else{
            System.out.println(numOf5+numOf2);
        }

    }
}