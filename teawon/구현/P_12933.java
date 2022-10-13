import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/12933
 * 
 * 문제 접근 방법 & 사용 알고리즘: 
*    q -> u -> a -> c -> k 순으로 울음소리가 잘 나는지 카운팅 한다. 
     q가 시작하는 순간 카운팅 개수를 늘리고 k에서 한 마리가 울음을 다 마쳤으면 현재 카운팅에서 -1 처리를 한다. 
     특정 시점에서 울고있는 현재카운팅이 가장 높은 경우를 저장해서 출력
 */


public class P_12933 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] duck = br.readLine().split("");
        int[] counts = new int[5];
        
        int max_counts = 0; //최대 울고 있는 오리 수
        int cur_count = 0; //현재 울고있는 오리 수
        
        
        int flag=1;

        for(int i=0; i<duck.length; i++){ //각 울음소리의 순번에 맞게 횟수를 카운팅. 한 마리가 다 울고 다시 우는 경우도 있으므로 전부 울면 현재 카운트를 -1
           if(flag == 0) break;
            switch (duck[i]) {
                case "q" :  counts[0]++; cur_count++; if(max_counts<cur_count) max_counts=cur_count;
                            break;
                case "u" :  if(counts[0] > counts[1]) counts[1]++; else{ flag = 0;}
                            break;
                case "a" :  if(counts[1] > counts[2]) counts[2]++; else{ flag = 0;}
                             break;
                case "c" :  if(counts[2] > counts[3]) counts[3]++; else{ flag = 0;}
                            break;
                case "k" :  if(counts[3] > counts[4]) {counts[4]++; cur_count--;} else{ flag = 0;}
                            break;
            }
        }

    
        
        if(flag == 0 || counts[0]!=counts[4]){ //울음 소리 순서가 안맞거나, 울다 만 경우 예외처리
            System.out.println("-1");
        }
        else{
            System.out.println(max_counts);
        }
  
 

    }
  

}