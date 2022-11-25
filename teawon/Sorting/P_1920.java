import java.util.*;
import java.io.*;
/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1920
 * 48420KB | 704ms
 *  
 * 문제 접근 방법 & 사용 알고리즘: 
 * 전형적인 이진탐색문제라고 생각했다.
 **/

public class P_1920 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine()); // N개의 정수
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine()); // M개의 정수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(binary_search(target, 0, N - 1) + "\n");

        }

        System.out.print(sb);

    }

    public static int binary_search(int target, int start, int end) {

        if (start > end) {
            return 0;
        }

        int mid = (start + end) / 2;

        if (arr[mid] < target) {
            return binary_search(target, mid + 1, end);
        } else if (arr[mid] > target) {
            return binary_search(target, start, mid - 1);
        } else {
            return 1;
        }

    }
}