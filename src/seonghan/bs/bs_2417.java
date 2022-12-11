package seonghan.bs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bs_2417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long start = 0;
        long end = n;
        long min = Long.MAX_VALUE;

        while(start<=end){
            long mid = (start + end)/2;

            //Math.pow(밑,지수)
            if(Math.pow(mid,2) >= n){
                min = mid;
                end = mid - 1;
            }else{
                start= mid + 1;
            }
        }

        System.out.println(min);

    }
}
