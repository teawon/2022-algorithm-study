package seonghan.implement2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/14719
 *
 * 문제 접근 방법 & 사용 알고리즘:
 * 구현
 * 1차원 배열에 w 순서대로 h를 넣어줌
 * 양끝을 제외한 인덱스를 왼쪽 최대값, 오른쪽 최대값 중 더 작은거에서 빼주고 결과에 더해줌
 *
 */
public class Implement_14719 {
    static int h;
    static int w;
    static int[] block;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        block = new int[w];
        for (int i = 0; i < w; i++) {
            block[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }

    static public void solution() {
        res = 0;
        for (int i = 1; i < w - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;

            for (int j = 0; j < i; j++) {
                leftMax = Math.max(block[j], leftMax);
            }

            for (int j = i + 1; j < w; j++) {
                rightMax = Math.max(block[j], rightMax);
            }

            if (block[i] < leftMax && block[i] < rightMax) {
                res += Math.min(rightMax, leftMax) - block[i];
            }
        }
        System.out.println(res);
    }

}
