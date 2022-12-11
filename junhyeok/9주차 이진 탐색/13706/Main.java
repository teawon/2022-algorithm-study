// 84220KB	844ms
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number = new String(br.readLine());
        BigInteger N = new BigInteger(number);

        // N의 범위는 0부터 800자리 수 ?

        BigInteger left = new BigInteger("0");
        BigInteger right = new BigInteger(number);

        // 같으면 0
        // 파라미터보다 작으면 -1
        // 크면 1
        while (left.compareTo(right) == -1 || left.compareTo(right) == 0 ) {
            BigInteger temp = left.add(right).divide(new BigInteger("2"));
            BigInteger middle = new BigInteger(temp.toString());

            int compare = middle.multiply(middle).compareTo(N);

            if (compare == -1 || compare == 0)
                left = middle.add(new BigInteger("1"));
            else
                right = middle.subtract(new BigInteger("1"));
        }

        System.out.println(left.subtract(new BigInteger("1")));

    }
    
}

// BigInteger A = BigInteger.valueOf(a); //int -> BigInteger