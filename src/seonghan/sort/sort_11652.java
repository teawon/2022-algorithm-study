package seonghan.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
/*
 * 문제 주소 :  https://www.acmicpc.net/problem/11652
 *
 * Hash 를 사용하여 풀 수 있었다.
 * sort 문제로 구분되어 있긴한데  딱히 sorting 한 부분은 없다.
 * hash 로 입력을 받고 키를 저장 한다. ⇒ 저장한 키를 하나씩 꺼내 max값을 구하고 max값이 여러개일때 처리만 해준다.
 * 시간 : 328ms
 *
 */
public class sort_11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> hash = new HashMap<Long, Integer>(); // hash 는 key, value 구조로 데이터를 넣는데, 이 문제에서는 key를 입력값으로 value를 count로 사용하면된다.
        Long[] key = new Long[N]; //키를 저장해둠
        for (int i = 0; i < N; i++) {
            key[i] = Long.parseLong(br.readLine());
            if (hash.containsKey(key[i])) {  // 해당 키를 가지고 있을 때와 그렇지 않을 때로 나누 어서 가지고 있으면 value + 1; 그렇지 않으면 1을 넣어준다.
                int value = hash.get(key[i]);
                hash.put(key[i], value + 1);
            } else {
                hash.put(key[i], 0);
            }
        }
        int max = 0;
        Long maxKey = key[0];
        for (int i = 1; i < N; i++) {
            int value = hash.get(key[i]);             // value 즉 count 된값을 비교하는데 count 된 값이 같은 두가지의 key(입력값) 가 있을 경우 작은것을 출력해야하기 때문에 삼항 연산자로 비교해서 key값이 작은것을 max로 지정한다.
            if (value > max) {
                max = value;
                maxKey = key[i];
            } else if (value == max) {
                max = (maxKey > key[i]) ? hash.get(key[i]) : hash.get(maxKey);
                maxKey = (maxKey > key[i]) ? key[i] : maxKey;
            }
        }
        System.out.println(maxKey);
    }
}
