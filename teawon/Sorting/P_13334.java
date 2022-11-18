import java.util.*;
import java.io.*;
/*
 * 문제 주소 :  https://www.acmicpc.net/problem/13334
 * 48960KB | 788ms
 *  
 * 문제 접근 방법 & 사용 알고리즘: 
 * 1. 정렬후 모든 인덱스에 대해 포함하는 값을 찾는 방법 -> 시간초과
 * 2. 우선순위 큐 이용  -> 왜 도착지점을 중심으로 정렬을 해야하는가?
 *  
 * 만약 아래 그림이 있다고 가정   
 *             --                                 [---------]
 *             --                                     --
 *             --                                     --
 *        [-------]                                   --
 *      -------                                 --------
 *   ----                                      ----
 * ---                                      ---
 * --                                       --
 *
 * 
 *     [ ------ ] 부분을 잘 보면 시작지점으로 정렬하게되면(왼쪽) 시작지점의 값이 바뀌면 철도를 이동시키는데
 *      이동시키기 전에 카운팅할 수 있는 부분을 나중에 카운팅하게된다. 따라서 끝 지점을 중심으로 정렬해서 특정 철도에 대해 포할할 수 있는 모든 경로를 카운팅해야한다.
 **/

public class P_13334 {

    static class Node implements Comparable<Node> {
        private int start;
        private int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int compareTo(Node target) {
            if (this.getEnd() == target.getEnd()) { // 오름차순으로 정렬
                return this.getStart() - target.getStart();
            }
            return this.getEnd() - target.getEnd();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Node[] road = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (start < end) {
                road[i] = new Node(start, end);

            } else {
                road[i] = new Node(end, start);
            }

        }

        Arrays.sort(road);

        int length = Integer.parseInt(br.readLine()); // 철로의 길이 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 철로의 end 오름차순으로 정렬하는 큐 생성

        int maxCount = 0;
        for (int i = 0; i < N; i++) {
            int start = road[i].getStart();
            int end = road[i].getEnd();

            if (start - end > length)
                continue;

            pq.add(start);
            while (!pq.isEmpty() && pq.peek() < (end - length)) { // 이동하며 철로밖으로 이탈된 값들을 다 뺀다.
                pq.poll();

            }

            // System.out.println("현재 start 위치 :" + start + "현재 선로 개수 :" + pq.size());
            maxCount = Math.max(maxCount, pq.size());

        }
        System.out.println(maxCount);

    }
}
