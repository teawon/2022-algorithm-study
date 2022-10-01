import java.util.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/11508
 * 
 * 문제 접근 방법 & 사용 알고리즘:
 * 결국 할인 받을 가격이 가장 커야한다. 3개씩 값을 묶었을 때 가장 싼 값이 할인되므로 그냥 단순하게 내림차순으로 정리해서 3개씩 묶으면 되지 않을까?
 *  
 */

public class P_11508 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); //유제품의 수
        int sum = 0;

        Integer[] productArr = new Integer[N];
        for(int i=0; i<N; i++){
            productArr[i] = sc.nextInt(); 
        
        }       
        
        Arrays.sort(productArr , Comparator.reverseOrder());


        for(int i=0; i<N; i++){
            if( (i+1) % 3 == 0) {
                continue;
            }
            sum += productArr[i];
        }

        System.out.println(sum);
       

    }
}