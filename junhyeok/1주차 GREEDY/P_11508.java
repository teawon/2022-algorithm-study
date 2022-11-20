// 10.03.22
// 11508번 2+1 세일
// 문제주소 : https://www.acmicpc.net/problem/11508

// 어떻게 접근할까? 잘 모르겠다.. 경우의 수를 모두 계산한다? 최댓값을 찾아서 최댓값끼리 묶는다?(내림차순 정렬)?  

// 내림차순으로 정렬하고 인덱스가 2, 5, ... 가 아닐때만 비용에 더했다.

// 자꾸 시간초과가 뜨길래, 2일동안 고민했는데 안풀려서 찾아보니 오름차순, 내림차순 정렬 메소드가 있었다..

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator; // 나중에 알아보기

public class P_11508 {
    public static void main (String args[]) {        
        Scanner scanner = new Scanner(System.in);

        int howMany = scanner.nextInt();
        // int[] array = new int[howMany];
        Integer[] array = new Integer[howMany]; // Integer int 차이?

        for (int i = 0; i < howMany; i++)
            array[i] = scanner.nextInt();

        // for (i = 0; i < howMany - 1; i++)
        //     for (int j = i + 1; j < howMany; j++)
        //         if (array[i] > array[j])
        //         {
        //             int temp = array[j];
        //             array[j] = array[i];
        //             array[i] = temp;
        //         }

        Arrays.sort(array, Comparator.reverseOrder()); // 내림차순 정렬
            
        int result = 0;

        for (int i = 0 ; i < howMany; i++) 
        {
            if (i % 3 == 2) // 인덱스가 2, 5, ... 이면 continue
                continue;

            result += array[i];
        }

        System.out.print(result);

        scanner.close();
    }
}


// 고민하는 과정에서 다른 풀이로도 접근해봤는데 시간초과가 뜬다. 결과가 나오기는 하는것같다.
// 배열에서 가장 큰 값을 찾아 더하고, 3, 6, 9 번째 값은 더하지 않도록 함.

// import java.util.Scanner;

// public class Main {
//     public static void main(String args[]) {
//         Scanner scanner = new Scanner(System.in);

//         int howMany = scanner.nextInt();

//         int[] array = new int[howMany];

//         for (int i = 0; i < howMany; i++)
//             array[i] = scanner.nextInt();

//         int max = 0;
//         int maxPosition = 0;
//         int result = 0;

//         int count = 1;
//         int repeat = 1;

//         while(true) 
//         {
//             for (int i = 0; i < howMany; i++)
//             {
//                 if (array[i] > max)
//                 {
//                     max = array[i];
//                     maxPosition = i;
//                 }
//             }

//             array[maxPosition] = 0;

//             if (count == 3)
//             {
//                 max = 0;
//                 if (repeat == howMany)
//                     break;
//                 count = 1;
//                 repeat ++;
//                 continue;
//             }

//             result += max;

//             count ++;
//             max = 0;
            
//             if (repeat == howMany)
//                 break;

//             repeat++;
//         }

//         System.out.print(result);
//         scanner.close();
//     }
// }
