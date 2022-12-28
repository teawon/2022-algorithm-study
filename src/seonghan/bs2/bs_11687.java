package seonghan.bs2;


/*
 * 문제 주소 :  https://www.acmicpc.net/problem/11687
 *
 * 0 은 2*5일 때 만들어짐 / 2의 배수가 더 많기 때문에 5의 갯수가 홀수 있때 만들어짐
 *
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bs_11687 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());

        int left = 1;
        int right = m*5;

        boolean check = false;
        while(left <=right){
            int mid = (left + right)/2;
            if(check5(mid)>m){
                right=mid-1;
            }else if(check5(mid)==m){
                right=mid-1;
                check=true;
            }
            else{
                left = mid + 1;
        }

        }

        if(check){
            System.out.println(left);
        }else{
            System.out.println(-1);
        }


    }

    public static int check5(int mid){
        int count = 0;
        for(int i=5;i<=mid; i*=5){
            count +=(mid/i);
        }
        return count;
    }
}
