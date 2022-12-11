package seonghan.bs;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;



public class bs_10816 {

    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 상근이가 가진 카드의 수
        StringTokenizer st = new StringTokenizer(br.readLine());

        int []card = new int[N]; // 상근이가 가진 카드의 배열


        for(int i=0;i<N;i++)
        {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);
        int M = Integer.parseInt(br.readLine()); // 비교대상 카드의 수
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int []tarCard = new int[M]; // 비교대상 카드의 배열
        for(int i=0;i<M;i++)
        {
            tarCard[i]=Integer.parseInt(st2.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++)
        {
            sb.append(UpperBound(card,tarCard[i])-LowerBound(card,tarCard[i])).append(' ');
        }

        System.out.print(sb);



    }

    public static int UpperBound(int []arr, int target)
    {
        int lo =0;
        int up = arr.length;


        while(up>lo)
        {
            int mid = 0;
            mid = (lo+up)/2;
            if(target<arr[mid])
            {
                up = mid;
            }
            else
            {
                lo = mid + 1;
            }
        }
        return lo;

    }
    public static int LowerBound(int []arr, int target)
    {
        int lo =0;
        int up = arr.length;


        while(up>lo)
        {
            int mid = 0;
            mid = (lo+up)/2;
            if(target<=arr[mid])
            {
                up = mid;
            }
            else
            {
                lo = mid + 1;
            }
        }
        return lo;

    }


}
