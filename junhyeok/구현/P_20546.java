// 문제 주소 : https://www.acmicpc.net/problem/20546

// 문제 접근 방법 & 사용 알고리즘: 

/* 정리
 * 준현이는 주식을 살 수 있으면 최대한 많이 산다.
 * 성민이는 3일 연속 가격이 상승하면 전량 매도, 3일 연속 가격이 하락하면 전량 매수
 *
 * 첫번째 줄에 동일한 현금이 주어진다.
 * 두번째 줄에 1월 1일 ~ 1월 14일까지의 주가가 공백을 두고 차례대로 주어진다.
*/

/* 구현
 * 1. 준현이와 성민이가 가지고 있는 돈·주식 수 멤버 변수를 가진 클래스를 선언
 * 2. 현금을 입력받아서 준현이와 성민 객체를 초기화 시키고
 * 3. 주가를 입력받는다.
 * 4. 준현이는 될 수 있는 만큼 매매하고
 * 5. 성민이는 for문을 돌면서 3일 연속 하락의 패턴이 나타나면 매매한 후 3일 연속 상승이 나타나면 매도한다.
 * 6. 14일에 계산하여 출력
 */

// 고려하지 못했던 것 : 3일연속 상승 또는 하락이 나타나면 거래를 하는데 4일째에도 반복되면 거래한다는 것

import java.io.BufferedReader;
//import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

class Stock {
    int currentMoney;
    int numberOfStock;

    public Stock(int m) {
        this.currentMoney = m;
        this.numberOfStock = 0;
    }
}

public class P_20546 {
    public static void main(String args[]) throws IOException {
        int[] priceOfStock = new int[14];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int money = Integer.parseInt(br.readLine());

        Stock junhyeon = new Stock(money);
        Stock sungmin = new Stock(money);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<14; i++)
            priceOfStock[i] = Integer.parseInt(st.nextToken());


        for (int i=0; i<14; i++) // 준현
            if (priceOfStock[i] <= junhyeon.currentMoney)
            {
                // System.out.println("준현 매수 " + i);
                junhyeon.numberOfStock = junhyeon.currentMoney / priceOfStock[i];
                junhyeon.currentMoney = junhyeon.currentMoney % priceOfStock[i];
            }

        int increaseCount = 0;
        int decreaseCount = 0;

        for (int i=1; i<14; i++) // 성민
        {
            if (priceOfStock[i] > priceOfStock[i - 1] )
                increaseCount ++;
            else
                increaseCount = 0;

            if (priceOfStock[i] < priceOfStock[i - 1])
            {
                decreaseCount ++;
            }
            else
                decreaseCount = 0;
            
            if (decreaseCount >= 3 && (sungmin.currentMoney >= priceOfStock[i]))
            {
                // System.out.println("성민 매수 " + i);
                sungmin.numberOfStock = sungmin.currentMoney / priceOfStock[i];
                sungmin.currentMoney %= priceOfStock[i]; 
            }
            if (increaseCount >= 3 && (sungmin.numberOfStock > 0))
            {
                // System.out.println("성민 매도 " + i);
                sungmin.currentMoney += (sungmin.numberOfStock * priceOfStock[i]); 
                sungmin.numberOfStock = 0;
            }

        }

        // 결과

        if ((junhyeon.currentMoney + junhyeon.numberOfStock * priceOfStock[13]) > (sungmin.currentMoney + 
        sungmin.numberOfStock * priceOfStock[13]))
            System.out.print("BNP");
        else if ((junhyeon.currentMoney + junhyeon.numberOfStock * priceOfStock[13]) == (sungmin.currentMoney + 
        sungmin.numberOfStock * priceOfStock[13]))
            System.out.print("SAMESAME");
        else
            System.out.print("TIMING");
    }
 }