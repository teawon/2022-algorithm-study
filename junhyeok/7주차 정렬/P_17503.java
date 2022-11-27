// 문제 주소 :  https://www.acmicpc.net/problem/17503

// 메모리 및 시간 : 77468KB | 1284ms

/* 문제 접근 방법 & 사용 알고리즘: 
 * 1. 선호도와 도수를 멤버변수로 가지는 객체에 맥주 정보를 저장하고, 객체를 도수 기준으로 오름차순 정렬함.
 * 2. 우선순위 큐를 사용하는데, 선호도가 낮은 맥주가 우선순위가 높아서 poll하면 선호도가 낮은 맥주가 먼저 나옴.
 * 3. 이후는 주석참고
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Beer implements Comparable<Beer> {
    private int perference;
    private int degree;

    public Beer(int perference, int degree) {
        this.perference = perference;
        this.degree = degree;
    }

    public int getPf() { return perference; }
    public int getDgr() { return degree; }

    @Override
    public int compareTo(Beer b) {
        if (this.getPf() == b.getPf())
            return this.getDgr() - b.getDgr();

        return this.getPf() - b.getPf();
    }
}

public class P_17503 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 축제가 열리는 기간 N 입력
        int N = Integer.parseInt(st.nextToken());

        // 2. 채워야 하는 선호도의 합 M 입력
        int M = Integer.parseInt(st.nextToken());

        // 3. 맥주 종류의 수 K 입력
        int K = Integer.parseInt(st.nextToken());
        Beer[] beers = new Beer[K];

        // 4. 맥주의 선호도와 도수 레벨이 공백을 사이에 두고 주어짐
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int pf = Integer.parseInt(st.nextToken());
            int dgr = Integer.parseInt(st.nextToken());

            beers[i] = new Beer(pf, dgr);
        }

        // 5. 맥주를 도수 기준 오름차순으로 정렬
        Comparator<Beer> comparator = new Comparator<Beer>() {
            @Override
            public int compare(Beer a, Beer b) {
                if (a.getDgr() == b.getDgr())
                    return a.getPf() - b.getPf();
                return a.getDgr() - b.getDgr();
            }
        };
        Arrays.sort(beers, comparator);

        // 6. 우선순위 큐 선언(맥주를 넣을 거임. 맥주의 선호도가 낮은 것부터 뽑음)
        PriorityQueue<Beer> pq = new PriorityQueue<>();

        // 7. 선호도의 총합을 저장할 변수
        int preference = 0;
        
        // 8. 출력할 간 레벨을 저장할 변수(아무리 레벨을 올려도 조건을 만족시킬 수 없으면 -1)
        int max = -1;

        for (int i = 0; i < K; i++) { 
            // 9. 우선순위 큐에 add. 동시에 선호도의 총합에 더해줌. beers는 도수 기준 오름차순으로 정렬되어 있기 때문에, 도수가 낮은 것부터 들어감
            pq.add(beers[i]);
            preference += beers[i].getPf();

            // 10. 우선순위 큐에 저장된 맥주가 N보다 크면 뽑음. 동시에 선호도의 총합에서 빼줌. 선호도가 낮은 것이 우선순위가 높기 때문에, 선호도가 낮은 맥주부터 뽑음
            if (pq.size() > N) {
                preference -= pq.poll().getPf();
            }

            // 11. 우선순위 큐에 저장된 맥주의 개수가 N과 같고, 선호도의 총합이 M보다 크다면 조건이 만족됐기 때문에 맥주를 큐에서 모두 뽑으면서 간 레벨의 최댓값을 구함.
            if (pq.size() == N && preference >= M) {
                while(!pq.isEmpty()) {
                    int p = pq.poll().getDgr();
                    max = Math.max(p, max);
                }
                break;
            }
        }

        // 12. 출력
        System.out.println(max);
    }
}