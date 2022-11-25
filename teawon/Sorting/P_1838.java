
import java.util.*;
import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1838
 *  118340KB | 1148ms
 * 
 * 문제 접근 방법 & 사용 알고리즘: 
 *  1 2 3 4 5 ..에서 만약 2 3 4 5 1이 있다면? 즉 앞에서부터 비교하므로 가장 뒤에있는 작은수의 index값이 처음으로
        // 이동하는데 n만큼의 시간이 걸린다.
        // 만약 .. 1 4 5 6 7 2 3 이라면, 3은 자기 자리까지 가는데 n만큼 걸리고, 2는 자기자리까지 가는데 n...이렇게 n의 값을 비교한다.
        
    
        -> 특정 인덱스에 해당하는 값이 n번째임을 나타내기 위해 map을 사용했는데 그 때문인지 메모리사용량이 높은 것 같음.
*/

public class P_1838 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 정수의 개수
        int[] array = new int[N];
        int[] copy = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            array[i] = number;
            copy[i] = number;
        }
        Arrays.sort(copy);
        Map<Integer, Integer> orderMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            orderMap.put(copy[i], i);
        }
        int max_index = 0;
        for (int i = 0; i < N; i++) {
            max_index = Math.max(i - orderMap.get(array[i]), max_index);

        }

        System.out.println(max_index);

    }

}
