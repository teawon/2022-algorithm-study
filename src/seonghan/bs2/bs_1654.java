package seonghan.bs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//132ms
// 랜선의 길이를 0 부터 max 까지 잡고, mid를 설정, mid 로 배열에 길이 값 나누고 몫을 더 해준다. 몫을 저장 해주고 다음 계산 부터 몫을 비교
public class bs_1654 {
    static int K; // 가지고 있는 랜선의 갯수
    static int N; // 필요한 랜선의 갯수
    static long[] arr; // 랜선 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new long[K];

        for(int i=0;i<K;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        long lo = 1;
        long max = 0;

        for(int i=0;i<K;i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }

        max +=1;
        long mid = 0;

        while(lo<max){
            mid = (max+lo)/2;
            int lanCnt = 0;
            for(int i=0;i<K;i++){
                lanCnt += arr[i]/mid;
            }

            if(lanCnt < N){
                max = mid;
            }else{
                lo = mid + 1;
            }
        }


        System.out.println(lo-1);



    }
}
