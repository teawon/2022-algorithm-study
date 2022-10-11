package seonghan.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 주소 :  https://www.acmicpc.net/problem/20546
 *
 * 문제 접근 방법 & 사용 알고리즘:
 * 단순 구현 문제 , 주석을 써가면서 햇갈리지 않게 푸는게 좋은듯
 * 문제를 한문장 씩 읽으며 한글 조건을 코드로 만드는게 중요.
 *
 */

public class Implement_20546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cash = Integer.parseInt(br.readLine());
        int[] arr = new int[14];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(Solution(cash, arr));

    }

    public static String Solution(int cash, int[] arr) {
        String result = "";
        int jun = cash; //준현이 남은돈
        int junjusik = 0;
        //준현이는 현금 cash 만큼을 arr순서대로 다삼 가격 될때까지.
        for (int i = 0; i < 14; i++) {
            int jusik = 0; // 매매가능한 주식 수
            if (jun / arr[i] < 1) {
                continue; // 해당 반복문 탈출 후 다음 반복문 실행
            } else {
                jusik = jun / arr[i];
                junjusik += jusik;
                jun = jun - arr[i] * jusik;
            }
        }
        jun += junjusik * arr[13];

        int seong = cash; //준성이 남은 돈
        int seongJusik = 0; //준성이 가진 주식
        int rise = 0; // 주식 오름  카운트
        int decline = 0;  //주식 떨어짐  카운트
        for (int i = 0; i < 14; i++) {
            if (i == 0) { // 첫날은 패스
                continue;
            } else if (arr[i - 1] > arr[i]) { //주식이 전날 보다 떨어질 때
                rise = 0; // 주식 오름  카운트는 0
                decline++; // 주식 떨어짐  카운트 +1
                if (seong / arr[i] > 1 && decline >= 3) //주식 살때 떨어짐 카운트가 3개 이상일 때
                {
                    int jusik = seong / arr[i];
                    seongJusik += jusik;
                    seong = seong - jusik * arr[i];

                }
            } else if (arr[i - 1] < arr[i]) { // 주식이 전날 보다 오를 때
                rise++; // 주식 오름 카운트 +
                decline = 0; // 주식 떨어짐 카운트 = 0
                if(rise>=3&&seongJusik!=0) // 파는 경우
                {
                    seong += seongJusik * arr[i]; // 현금화
                    seongJusik = 0; // 주식 갯수 0개로
                }

            } else if (arr[i - 1] == arr[i]) // 두 주식이 같으면 두 카운트 모두 0
            {
                rise = 0;
                decline = 0;
            }
        }

        seong += seongJusik*arr[13];

        if(seong>jun)
        {
            return "TIMING";
        }else if(seong<jun)
        {
            return "BNP";
        }else
        {
            return "SAMESAME";
        }

    }
}
