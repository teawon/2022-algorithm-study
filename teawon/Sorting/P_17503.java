
import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/17503
 * 82092KB | 1232ms
 * 
 * 문제 접근 방법 & 사용 알고리즘: 
 * 문제에서 요구하는건 "최소 레벨"이다.
 * 따라서 비교해야 하는 값 (선호도 , 레벨)중 레벨을 기준으로 오름차순으로 정렬한다. (기준이 되는건 최소 레벨)
 * 그리고 정렬된 값을 탐색해가며 선호도를 만족할 때 까지 계속 비교해나간다. 
 * 
 * etc )) 술을 꼭 N개 먹어야한다. 문제를 꼼꼼히 읽는 습관 가지기
 *
*/
class Bear implements Comparable<Bear> {

    private int score; // 선호도
    private int level; // 레벨

    public Bear(int score, int level) {
        this.score = score;
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public int compareTo(Bear target) {
        if (this.getLevel() == target.getLevel()) {
            return this.getScore() - target.getScore();
        }
        return this.getLevel() - target.getLevel();
    }

}

public class P_17503 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 축제 기간 (선택 맥주 수)
        int M = Integer.parseInt(st.nextToken()); // 선호도
        int K = Integer.parseInt(st.nextToken()); // 맥주의 수

        Bear[] arr = new Bear[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int score = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            arr[i] = new Bear(score, level);
        }
        Arrays.sort(arr);
        int sum = 0;
        int minLevel = 0;
        int index = 0;
        PriorityQueue<Integer> pQue = new PriorityQueue<>(); // 호감도 정보를 오름차순으로 정렬 (작은거 부터 뺄거임)

        while (index < K) {
            pQue.offer(arr[index].getScore());
            if (pQue.size() <= N) {
                sum += arr[index].getScore();
            } else {
                sum = sum - pQue.poll() + arr[index].getScore();
            }
            // System.out.println(arr[index].getScore() + "값을 넣었습니다. index:" + index);

            if (sum >= M && ) {
                break;
            }
            index++;
        }

        if (index >= K) {
            minLevel = -1;
        } else {
            minLevel = arr[index].getLevel();
        }
        System.out.println(minLevel);

    }

}
