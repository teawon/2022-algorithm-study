import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1202
 * 
 * 문제 접근 방법 & 사용 알고리즘: 가장 가볍고 비싼 보석을 구매해야한다. 
 * 1.1 - 가격순서대로 정렬 후 각 값이 가방에 들어갈 수 있는 지 하나하나 비교하기. 이미들어갔으면 무게를 최대무게이상의 값으로 바꿈  -> 시간초과 발생
 * 
 * 1.2 - 시간이 걸리는 이유를 값을 하나하나 비교(N번)하는데 있다고 생각했다. 1억개중 가방에 넣을 수 있는게 마지막 1번째라면 1억번을 다비교하니까
 * -> N번 비교는 줄일 수 없지만 가방에 보석을 넣으면 다시 처음부터 탐색하는게 문제가 있다고 생각했다. 가방의 크기도 아에 정렬을 하고 
 * 보석을 넣은 시점부터 다시 탐색하자.
 * 
 */




class Jewel implements Comparable<Jewel> {
 
    
    private int weight; //무게
    private int price;  //가격

    public Jewel(int weight , int price){
        this.weight = weight;
        this.price = price;
    }

    public int getWeight(){
        return weight;
    }

    public int getPrice(){
        return price;
    }



    @Override
    public int compareTo(Jewel target){ //가격 기준 내림차순 정렬 
        return target.getPrice() - this.getPrice();
    }


    
}

public class P_1202 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //보석의 개수
        int K =  Integer.parseInt(st.nextToken()); //가방의 개수
        
        Jewel[] jewelArr = new Jewel[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(st.nextToken()); 
            int price =  Integer.parseInt(st.nextToken()); 
            jewelArr[i] = new Jewel(weight, price);
        }

        Integer[] packSize = new Integer[K];
        for(int i=0; i<K; i++){
            packSize[i] = Integer.parseInt(br.readLine()); 
        }

        Arrays.sort(jewelArr);
        Arrays.sort(packSize , Comparator.reverseOrder());  //가방의 크기도 내림차순 정렬
   
       
        long sum=0;
        int curIndex = 0;

        for(int i=0; i<K; i++){ //가방에 비싼 가격의 보석 순서대로 넣는다.
            for(int j=curIndex; j<N; j++){
                if(jewelArr[j].getWeight() <= packSize[i]) {
                    sum += jewelArr[j].getPrice();
                    curIndex = j+1;
                    break;
                }
            }
        }

        System.out.println(sum);
    }
}

