// 문제 주소 :  https://www.acmicpc.net/problem/1920

// 메모리 및 시간 : 45680KB | 1396ms

/* 문제 접근 방법 & 사용 알고리즘: 
 * 1. 주어진 정수 A[1], A[2], ..., A[N] 을 오름차순으로 정렬
 * 2. 존재하는지 확인할 정수 B[1], B[2], ..., B[M] 을 오름차순으로 정렬
 * 3. B[1]을 A[1]부터 비교하기 시작하는데
 *      예를들어 B[1]이 A[3]에 존재한다면 3을 저장하여
 *      B[2]를 비교할때 A[3]부터 비교하기 시작.
 *      모두 오름차순으로 정렬되어 있기 때문에 3 이전부터는 비교할 필요가 없음.
 *      B[1]과 B[2]는 같은 수가 될 수 있기 때문에 A[4]가 아닌 A[3]부터 비교해야함
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Number implements Comparable<Number> {
    private int num;
    private int index;

    public Number(int num, int index) {
        this.num = num;
        this.index = index;
    }

    public int getNum() { return num; }
    public int getIndex() { return index; }

    @Override
    public int compareTo(Number n) {
        return Integer.compare(this.getNum(), n.getNum());
    }
}

public class P_1920 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1. 정수의 개수 N 입력
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        
        // 2. 정수 A[1], A[2], ..., A[N] 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) 
            array[i] = Integer.parseInt(st.nextToken());

        // 3. 입력받은 정수 오름차순 정렬
        Arrays.sort(array);

        // 4. 확인할 수의 개수 M 입력
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // 5. 정렬하기 전 순서(index)와 값(B[M])을 저장할 객체
        Number[] numbers = new Number[M];

        // 6. 값 입력 후 객체 생성
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int index = i;
            
            numbers[i] = new Number(num, index);
        }

        // 7. 값(B[M)을 기준으로 오름차순 정렬
        Arrays.sort(numbers);

        int[] isExist = new int[M];
        int max = 0;

        // 8. 존재하는지 확인
        for (int i = 0; i < M; i++) {
            for (int j = max; j < N; j++) {
                if (numbers[i].getNum() == array[j]) {
                    isExist[numbers[i].getIndex()] = 1;
                    max = j;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            if (isExist[i] == 1)
                sb.append("1\n");
            else
                sb.append("0\n");
        }

        // 9. 결과 출력
        System.out.print(sb);
    }
}