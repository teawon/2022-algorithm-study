import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1202
 * 
 * 문제 접근 방법 & 사용 알고리즘: 가장 가볍고 비싼 보석을 구매해야한다. 
 * 1. - 가격순서대로 정렬 후 각 값이 가방에 들어갈 수 있는 지 하나하나 비교하기. 이미들어갔으면 무게를 최대무게이상의 값으로 바꿈  -> 시간초과 발생
 * 
 * 1.2 - 시간이 걸리는 이유를 값을 하나하나 비교(N번)하는데 있다고 생각했다. 1억개중 가방에 넣을 수 있는게 마지막 1번째라면 1억번을 다비교하니까
 * -> N번 비교는 줄일 수 없지만 가방에 보석을 넣으면 다시 처음부터 탐색하는게 문제가 있다고 생각했다. 가방의 크기도 아에 정렬을 하고 
 * 보석을 넣은 시점부터 다시 탐색하자.
 * 
 * (반례 -
 *  가방크기가 100 90 이야 그리고 가장 비싼게 10원인데 무게가 89고 두번째로 비싼게 5원인데 무게가 100  
    그러면 .. 이 알고리즘에 의하면 첫번째 가방에 89짜리 무게를 넣겠지.
    그리고 두번째 가방에 5원을 넣어야하는데 넣을 수 없으니 아에 틀린 답이 나온다.
    
 *  
 *  2. 결국 핵심은 무게이다. 가격에 대해 정렬하고 넣는게 아니라, 직관적으로 무게에 대해 정렬하고 해당 무게의 값을 전부 순회해야한다.
 *  특정 무게에 도달할 때 까지 모든 값을 저장하고 이를 우선순위 큐에넣어 항상 정렬된 상태를 유지하자.
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
    public int compareTo(Jewel target){ //무게 기준 오름차순 정렬
        return this.getWeight() - target.getWeight();
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
        Arrays.sort(packSize);  //가방의 크기도 오름차순 정렬
   
       
        long sum=0;

        PriorityQueue<Integer> pQue = new PriorityQueue<>(Comparator.reverseOrder()); //가격에 대해 내림차순 정렬
        int curIndex = 0;
        for(int i=0; i<K; i++){ //가방에 비싼 가격의 보석 순서대로 넣는다.
            while(curIndex < N && jewelArr[curIndex].getWeight() <= packSize[i]){
              //특정 가방에 들어갈 수 있는 모든 보석을 큐에 넣어 가격순으로 정렬한다.
             pQue.offer(jewelArr[i].getPrice()); 
             curIndex++;
            }

            if(!pQue.isEmpty()){
                sum+=pQue.poll();
            }
        }

        System.out.println(sum);
    }
}

