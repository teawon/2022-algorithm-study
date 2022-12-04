package seonghan.bs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bs_16401 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int []tree = new int[N];
        long max = 0;
        for(int i=0;i<N;i++)
        {
            tree[i]=Integer.parseInt(st1.nextToken());
            if(max<tree[i]) max = tree[i];

        }

        System.out.println(UpperBound(tree,K,max));


    }



    public static long UpperBound(int[]arr, int target,long max)
    {
        long high = max;
        long lo = 0;
        long mid =0;
        long count = 0;

        while(lo<high)
        {
            count = 0;
            mid = (lo + high)/2;
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i]-mid>0)
                {
                    count += arr[i]-mid;
                }
            }

            if(count<target)
            {
                high = mid;

            }else
            {
                lo = mid + 1;
            }

        }

        return lo-1;

    }

}
