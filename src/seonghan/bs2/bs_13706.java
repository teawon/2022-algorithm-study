package seonghan.bs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class bs_13706 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger N = new BigInteger(br.readLine());
        BigInteger lo = new BigInteger("1");
        BigInteger hi = N;
        BigInteger mid;
        while(true){
            mid = lo.add(hi);
            mid = mid.divide(new BigInteger("2"));

            int temp = (mid.multiply(mid)).compareTo(N);
            if(temp == 0){
                break;
            }else if(temp == 1){
                hi = mid.subtract(new BigInteger("1"));
            }else if(temp == -1){
                lo = mid.add(new BigInteger("1"));
            }
        }

        System.out.println(mid);

    }
}
