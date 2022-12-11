// 17256KB	208ms

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T > 0) {
            long N = Long.parseLong(br.readLine());

            long left = 1;
            long right = Integer.MAX_VALUE;

            while(left <= right) {
                long middle = (left + right) / 2;

                long result = (middle * (middle + 1)) / 2;

                if (result > N) {
                    right = middle - 1;
                }
                else
                    left = middle + 1;
            }


            sb.append(left - 1);
            sb.append("\n");
            T--;
        }

        System.out.print(sb);
    }
}