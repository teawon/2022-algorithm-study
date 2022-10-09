package seonghan.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Greedy_2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String num = br.readLine();
        solution(N,k,num);
    }

    public static void solution(int n,int k, String num)
    {
        char[] arr = num.toCharArray();
        int[] number = new int[arr.length];

        for(int i=0;i<arr.length;i++){
            number[i] = arr[i]-'0';
        }
        Stack<Integer> s = new Stack<Integer>();

        for(int i=0;i<number.length;i++){
            while(k>0&&!s.empty()&&s.peek()<number[i])
            {
                s.pop();
                k--;
            }
            s.add(number[i]);
        }
        for(int i=0;i<k;i++){
            s.pop();
        }
        StringBuilder sb = new StringBuilder();
        int size=s.size();
        for(int i=0;i<size;i++) sb.append(s.pop());
        System.out.println(sb.reverse().toString());

    }

}
