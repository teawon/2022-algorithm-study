package seonghan.dynamic;

// 음수를 만나면 음수 전 까지의 합을 음수와 비교해서
// 크면 계속 더해가고
// 작으면 음수 인덱스 까지 다 버리고 계산하는데 다 버릴때 음수 전까지의 합을 max 와 비교해서 저장한 후 에 진행
/* 2번
 * 문제 주소 :  https://www.acmicpc.net/problem/1912
 *
 * 문제 접근 방법 & 사용 알고리즘: 다이나믹
 * Math.max사용해서 N번 만큼 비교
 * dp 배열을 만들어서 계산되는 합을 저장 후 비교
 * 192ms
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dynamic_1912 {
    static int max;
    static int N;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        max = 0;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        max = arr[0];

        for(int i=1;i<N;i++){
            dp[i] = Math.max(dp[i-1]+arr[i],arr[i]);
            max = Math.max(max,dp[i]);
        }

        System.out.println(max);


    }
}
