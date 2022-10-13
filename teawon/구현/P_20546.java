import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/20546
 * 
 * 문제 접근 방법 & 사용 알고리즘: 
 
  // 준현이는 그냥 돈되는대로 다 사고 절대 팔지 않는다.
  // 성민이는 자기가 가진 주식이 3일연속 상승하면 판다. 반대로 3일 연속 하강하면 산다.

  말 그대로 코드로 구현해서 총 가격을 비교한다.

 */





public class P_20546 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int money = Integer.parseInt(st.nextToken());//주어진 현금

        int A_money = money;
        int A_count = 0;
        int B_money = money;
        int B_count = 0;

        st = new StringTokenizer(br.readLine(), " ");

        int[] price_arr = new int[14];
        
        for(int i=0; i<14; i++){ //14일간의 주가 변화를 확인한다.
            price_arr[i] =  Integer.parseInt(st.nextToken());  
        }

        if(price_arr[0] < A_money){ //1일차의 주식거래
            A_count =  A_money / price_arr[0];
            A_money =  A_money % price_arr[0];
        }

        int flow = 0; //주식의 상승, 하강의 흐름을 나타내는 변수

        for(int i=1; i<14; i++){ //2일차 ~ 14일차 간의 주식거래
            
            if(price_arr[i] <= A_money){       //준현이의 주식거래
                A_count = A_count + A_money /price_arr[i] ;
                A_money = A_money % price_arr[i];
            }



            if(price_arr[i] == price_arr[i-1]){  //주식 가격이 증가하는지, 감소하는지 체크
                flow = 0;
            }
            else if(price_arr[i] < price_arr[i-1]){
                if(flow <= 0)  flow--;
                else flow = -1;
            }
            else{
                if(flow >= 0)  flow++;
                else flow = 1;
            }

            if(flow <= -3 ){  //3일 이상 떡락하면 올매수
                B_count = B_count + B_money / price_arr[i];
                B_money = B_money % price_arr[i];
            }
            if(flow >=3){ //3일 이상 오르면 올 매도
                B_money = B_money + price_arr[i] *  B_count;
                B_count = 0;
            }


        }

        A_money = A_money + A_count * price_arr[13];
        B_money = B_money + B_count * price_arr[13];

        if(A_money == B_money) System.out.println("SAMESAME");
        else if(A_money>B_money) System.out.println("BNP");
        else System.out.println("TIMING");
        
        
    }
}

