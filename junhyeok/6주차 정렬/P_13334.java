// 문제 주소 :  https://www.acmicpc.net/problem/13334

// 메모리 및 시간 : 48068KB | 704ms

/* 문제 접근 방법 & 사용 알고리즘: 
 * 주석 참고
 */

// 참고 블로그 : https://chanhuiseok.github.io/posts/baek-28/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Arrays;

public class P_13334 {
    static class Railroad implements Comparable<Railroad> {
        private int start;
        private int end;

        public Railroad(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() { return start; }

        public int getEnd() { return end; }

        @Override
        public int compareTo(Railroad r) {
            // 1. 끝점이 같을 경우 시작점을 기준으로 오름차순 정렬
            if (this.getEnd() == r.getEnd())
                return this.getStart() - r.getStart();
            // 2. 끝점을 기준으로 오름차순 정렬    
            return this.getEnd() - r.getEnd();
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1. 사람 수 N 입력 ( 1 <= N <= 100,000 )
        int N = Integer.parseInt(br.readLine());

        Railroad[] railroad = new Railroad[N];

        // 2. 정수쌍 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            

            // 3. 정수쌍은 서로 다른 정수이며, 끝점이 시작점보다 작을 수가 있음. 따라서 끝점이 시작점보다 항상 크게 객체생성
            if (start < end) railroad[i] = new Railroad(start, end);
            if (start > end) railroad[i] = new Railroad(end, start);
        }

        // 4. 정렬
        Arrays.sort(railroad);

        // 5. 철로의 길이 D 입력
        int D = Integer.parseInt(br.readLine());

        // 6. 낮은 숫자가 우선순위인 큐 선언
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = 0;

        for (int i = 0; i < N; i++) {
            int start = railroad[i].getStart();
            int end = railroad[i].getEnd();

            if (end - start <= D)
                pq.add(start);
            else
                continue;

            while(!pq.isEmpty()) {
                // 7. pq에서 값 하나를 추출(peek)
                int temp = pq.peek();

                // 8. 추출 후 현재 사람의 끝 값과의 거리를 계산. d보다 큰 거리면 후보에서 제거.
                if (end - temp <= D) 
                    break;
                else
                    pq.poll();
            }
            // 9. 최댓값 구하기
            max = Math.max(max, pq.size());
        }

        // 10. 출력
        System.out.print(max);
    }
}