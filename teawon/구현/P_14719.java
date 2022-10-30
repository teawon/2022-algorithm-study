import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/14719
 * 
 * 문제 접근 방법 & 사용 알고리즘: 두 벽 사이에 갇혀있는 빗물을 계산한다. 
 * 단 계산은 한쪽 벽의 크기가 기준값이 되는 벽보다 크거나 같을 때 계산해야한다. 
 * 
 * 초기에는 한쪽 방향만 계산했으나 마지막 벽의 값이 작다면 집계되지 않았고 이를 그냥 역방향으로 다시 탐색해서 해결하였다.
 */

public class P_14719 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] rainArr = new int[W];

        int sum = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<W; i++){
            rainArr[i] = Integer.parseInt(st.nextToken());
        }

        int left = W; //0이 아닌 첫번째 왼쪽 변수를 찾는다.
        for(int i=0; i<W; i++){
            if( rainArr[i]!=0) {
                left = i;
                break;
            }
        }

        for(int i=left+1; i<W; i++){  //왼쪽->오른쪽 방향으로 빗물을 계산한다
            if(rainArr[i]>=rainArr[left]){ //현재 왼쪽벽보다 크거나 같은 오른쪽 벽이 있다면 갇혀있는 빗물을 계산 후 왼쪽 벽도 갱신
                for(int j=left+1; j<i; j++){
                    sum += rainArr[left]-rainArr[j];
                }
                left = i;
            }
        }

        int right = 0;
        for(int i=W-1; i>-1; i--) {
            if( rainArr[i]!=0) {
                right = i;
                break;
            }
        }

        for(int i=right-1; i>-1; i--){ //오른쪽 -> 왼쪽 방향으로 빗물을 계산한다
            if(rainArr[i]>rainArr[right]){  //왼쪽 -> 오른쪽을 계산할 때 >=를 표현했으므로 중복계산이 되지않도록 등호 제거
                for(int j=right-1; j>i; j--){
                    sum += rainArr[right]-rainArr[j];
                }
                right = i;
            }
        }

        System.out.println(sum);
    }   
}