// 10.02.22
// 14916번 거스름돈
// 문제주소 : https://www.acmicpc.net/problem/14916

// 어떻게 접근할까? %연산자와 (정수) / (정수) = (정수) 인 것을 이용하면 될것같다

import java.util.Scanner;

public class P_14196 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int change = scanner.nextInt();
        int ohwon = 0;
        int eawon = 0;
        
        ohwon = change / 5;
        eawon = change % 5 / 2;

        if (ohwon * 5 + eawon * 2 != change)
        {
            ohwon = ohwon - 1;
            eawon = (change - ohwon * 5) / 2;
        }

        int total = ohwon + eawon;

        if (ohwon < 0)
            System.out.print("-1");
        else
            System.out.print(total);

        scanner.close();
    }
}

// 틀렸던 코드

// import java.util.Scanner;

// public class Main {
//     public static void main(String args[]) {
//         Scanner scanner = new Scanner(System.in);

//         int change = scanner.nextInt();
//         int ohwon = 0;
//         int eawon = 0;
        
//         if ((change % 5 / 2) % 2 == 0) 
//         {
//             ohwon = change / 5;
//             eawon = change % 5 / 2;
//         }
//         else
//         {
//             ohwon = change / 5 - 1 ;
//             eawon = (change - ohwon * 5) / 2;
//         }

//         int total = ohwon + eawon;

//         if (ohwon * 5 + eawon * 2 != change)
//             System.out.print("-1");
//         else
//             System.out.print(total);

//         scanner.close();
//     }
// }