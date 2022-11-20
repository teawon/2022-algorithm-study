// 문제 주소 : https://www.acmicpc.net/problem/17276

// 문제 접근 방법 & 사용 알고리즘: 

/* 구현
 * 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class P_17276 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        for (int i=0; i<T; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            int[][] array = new array[N][N];

            for (int j=0; j<N; j++)
                for (int k=0; k<N; k++) 
                {
                    st = new StringTokenizer(br.readLine(), " ");
                    array[j][k] = Integer.parseInt(st.nextToken());
                }

            int[][] duplicatedArray = new array[N][N];

            if (D > 0)
            {
                for (int j=0; j<N; j++)
                    for (int K=0; K<N; K++)
                    {
                        if (j == k)
                            duplicatedArray[j][N/2] = array[j][k]; // 주 대각선
                        if (k/2 == N)
                            duplicatedArray[][]
                    }
            }
        }

    }
}
