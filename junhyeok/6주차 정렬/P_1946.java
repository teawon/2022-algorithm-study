// 문제 주소 :  https://www.acmicpc.net/problem/1946

// 시간 : 1280ms

/* 문제 접근 방법 & 사용 알고리즘: 
 * 주석참고
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Ranking {
    int testA;
    int testB;

    public Ranking(int testA, int testB) {
        this.testA = testA;
        this.testB = testB;
    }
}

public class P_1946 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        // 1. 테스트 케이스의 개수 입력
        int T = Integer.parseInt(br.readLine());

        // 2. 테스트 케이스의 개수만큼 반복
        for (int j = 0; j < T; j++) {
            HashMap<Integer, Ranking> map = new HashMap<Integer, Ranking>();
        
            // 3. 지원자의 숫자 입력
            int N = Integer.parseInt(br.readLine());
            Ranking[] rankings = new Ranking[N];

            // 4. 서류심사, 면접 성적 입력받아서 객체 초기화후 서류심사 순위를 Key값으로 사용하여 매핑
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int testA = Integer.parseInt(st.nextToken());
                int testB = Integer.parseInt(st.nextToken());
                rankings[i] = new Ranking(testA, testB);
                map.put(testA, rankings[i]);
            }

            // 5. 서류 1위의 면접 성적을 가져옴
            int topOfA = map.get(1).testB;

            //6. 서류 1위는 무조건 통과이므로 1로 초기화
            int passed = 1;

            for (int i = 1; i < N; i++) {
                // 7. 서류 2, 3, 4, .. n 위의 면접 성적을 가져옴
                int temp =  map.get(i+1).testB;

                // 8. 면접 성적을 비교. 순위가 더 낮다면 면접 성적을 갱신한 후 통과한 사람의 수 증가
                if (temp < topOfA) {
                    topOfA = temp;
                    passed++;
                }
            }
            
            sb.append(passed);
            sb.append("\n");
        }
        // 9. 출력
        System.out.print(sb);
    }
}

/*
 * 처음엔 해시맵 2개를 만들어서 각각 서류 순위, 면접 순위를 키 값으로 매핑한 후 
 * 서류 순위 1위, 면접 순위 1위를 기준으로 아래와 같이 두번 비교해서 결과를 도출했는데
    * 첫번째 비교
        3 6	    탈락
        7 3     
        4 2	    
        1 4	    기준(면접 순위가 4위보다 낮은 사람은 탈락한다)
        5 7	    탈락
        2 5	    탈락
        6 1	
    * 두번째 비교
        3 6	    
        7 3     탈락
        4 2	    
        1 4	    
        5 7	    
        2 5	    
        6 1     기준(서류 순위가 6위보다 낮은 사람은 탈락한다)
    * 결과
        3 6	    
        7 3     
        4 2	    통과
        1 4	    통과
        5 7	    
        2 5	    
        6 1     통과
 * 위와 같은 알고리즘을 사용할 경우. 아래 테스트 케이스에서 (5, 3)이 (4, 2)보다 서류, 면접 순위가 모두 낮기 때문에
 * 떨어져야 하는데 떨어지지 않는다는 것을 발견 후 알고리즘을 변경하였다.
 *      1 4
 *      3 6
 *      2 5
 *      5 3
 *      6 1
 *      4 2
 */