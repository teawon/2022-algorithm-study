// 10.27.22 (MM:DD:YY)
// 문제 주소 :  https://www.acmicpc.net/problem/1475

// 문제 접근 방법 & 사용 알고리즘:

/* 정리
 * 다솜이는 자기 방 번호를 플라스틱 숫자로 문에 붙이려고 한다.
 * 한 세트에는 0부터 9까지 숫자가 들어있다.
 * 방 번호가 주어졌을때, 필요한 세트의 개수의 최솟값
 * 6 -> 9, 9 -> 6 사용 가능
 */

/*
 * 각 숫자의 개수를 배열에 저장하여 카운트
 * 배열을 순회
 * 배열에서 최댓값이 필요한 세트수가 됨
 * 6과 9는 서로 뒤집어서 대체가 가능하므로 6과 9일 경우에는
 * 6과 9의 개수를 더한후 2로 나눈것을 비교
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class P_1475 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String numberOfRoom = br.readLine();

        int[] array = new int[10];

        for (int i = 0; i < numberOfRoom.length(); i++) {
            array[numberOfRoom.charAt(i) - 48]++;
        }

        int count = 0;
        int numberOfSet = 0;

        for (int i = 0; i < array.length; i++) {
            if (i == 6 || i == 9) {
                count += array[i];

                int n = (count % 2 == 0) ? (count / 2) : ((count + 1) / 2);

                if (n > numberOfSet) {
                    numberOfSet = n;
                }
                continue;
            }
            if (array[i] > numberOfSet) {
                numberOfSet = array[i];
            }
        }

        System.out.print(numberOfSet);
    }
}