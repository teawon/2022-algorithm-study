import java.util.*;
import java.io.*;
import java.math.BigInteger;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/13706
 * 문제 접근 방법 & 사용 알고리즘: 앞서 푼 제곱근 문제와 동일. 단 BigInteger에 대한 연산 주의 할 것
 * 
 *  long의 경우  9,223,372,036,854,775,807 (2^63 -1) // Integer의 경우 2,147,483,647 (2^31-1)이므로 넘어간다면 BigInteger사용하기
 * 
 *  22096KB | 232ms
 * 
*/

public class P_13706 {
    static BigInteger N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = new BigInteger(br.readLine()); // 정수

        System.out.println(find(new BigInteger("0"), N));
    }

    public static BigInteger find(BigInteger start, BigInteger end) {
        BigInteger mid = (start.add(end)).divide(new BigInteger("2"));

        if (start.compareTo(end) == 1) {
            return start;
        }

        if ((mid.multiply(mid)).compareTo(N) == -1) {
            return find(mid.add(new BigInteger("1")), end);
        }
        return find(start, mid.subtract(new BigInteger("1")));

    }
}
