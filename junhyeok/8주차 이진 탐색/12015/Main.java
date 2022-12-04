// 문제 주소 :  https://www.acmicpc.net/problem/10816

// 메모리 및 시간 : 115592KB | 1260ms

/* 문제 접근 방법 & 사용 알고리즘: 
 * . 
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());

            if (temp > stack.peek()) {
                stack.push(temp);
            }
            else {
                int left = 0;
                int right = stack.size() - 2;

                while (left <= right) {
                    int middle = (left + right) / 2;

                    if(stack.get(middle) >= temp)
                        right = middle - 1;
                    if(stack.get(middle) < temp)
                        left = middle + 1;
                }

                stack.set(left, temp);
            }
        }

        int count = 0;
        
        while(!stack.empty()) {
            stack.pop();
            count++;
        }
        
        System.out.println(count - 1);
    }
}