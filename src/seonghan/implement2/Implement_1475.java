package seonghan.implement2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1475
 *
 * 문제 접근 방법 & 사용 알고리즘:
 * 크기가 10인 check배열을 만들어서 필요한 숫자 자리에 ++
 * 필요한 6의 값을 전부 9에 넣고 나누기 2 해서 최대값을 구함
 *
 *
 */
public class Implement_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        String[] sArr = n.split("");
        int[] arr = new int[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            arr[i] = Integer.parseInt(sArr[i]);
        }

        Solution(arr);

    }

    public static void Solution(int[] arr) {
        int[] check = new int[10];
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            check[arr[i]]++;
        }
        check[9] +=check[6];
        check[6]=0;
        if(check[9]%2==0){
            check[9]-=check[9]/2;
            check[6] = check[9];
        }else if(check[9]%2>0){
            int temp = check[9]/2;
            check[9]-=temp;
            check[6] +=temp;
        }
        max = findMax(check);
        System.out.println(max);


//        for(int i=0;i<arr.length;i++){
//            if(arr[i]==9&&check[9]==1){
//                if(check[6]==1){
//                    cnt++;
//                    check = makeZero(check);
//                    check[9]=1;
//                }else if(check[6]==0){
//                    check[6]=1;
//                }
//            }else if(arr[i]==9&&check[9]==0){
//                check[9]=1;
//            }else if(arr[i]==6&&check[6]==1){
//                if(check[9]==1){
//                    cnt++;
//                    check = makeZero(check);
//                    check[6]=1;
//                }else if(check[9]==0){
//                    check[9]=1;
//                }
//            }else if(arr[i]==6&&check[6]==0){
//                check[6]=1;
//            }else{
//                if(check[arr[i]]==1){
//                    cnt++;
//                    check=makeZero(check);
//                    check[arr[i]]=1;
//                }else if(check[arr[i]]==0){
//                    check[arr[i]]=1;
//                }
//            }
//        }


//        System.out.println(cnt+1);
    }
//
//    public static int[] makeZero(int[] check){
//        for(int i=0;i<check.length;i++){
//            check[i]=0;
//        }
//        return check;
//    }

    public static int findMax(int[] check) {
        int max = 0;
        for (int i = 0; i < check.length; i++) {
            if (max < check[i]) {
                max = check[i];
            }
        }
        return max;
    }
}