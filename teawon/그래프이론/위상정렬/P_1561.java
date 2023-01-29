import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1561
 * 
 * 268ms
 * 문제 접근 방법 & 사용 알고리즘 : 선행조건이 있는 간선의 경우 배열을 통해 우선순위 관계를 표현할 수 있다는 점이 위상정렬의 특징이다.
 * 따라서 A를 필요로하는 정보를 담은 후 A를 처리할때 관련된 정보들의 카운트를 낮추는 방향으로 구현하기
    
    
 */

public class P_1561 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine()); // 건물의 수
        int[] buildTime = new int[N + 1];
        int[] totalPreBuildTime = new int[N + 1]; // N번째 건물을 짓기전에 필요한 시간
        ArrayList<ArrayList<Integer>> connectInfo = new ArrayList<ArrayList<Integer>>();
        int[] preBuildCount = new int[N + 1]; // 특정 건물을 필요로하는 건물 번호들의 리스트

        for (int i = 0; i < N + 1; i++) {
            connectInfo.add(new ArrayList<Integer>()); // 초기화
        }

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            buildTime[i] = time;
            while (true) {
                int number = Integer.parseInt(st.nextToken());
                if (number == -1)
                    break;
                connectInfo.get(number).add(i);
                preBuildCount[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (preBuildCount[i] == 0) {
                q.offer(i);
            }

            // 선행 조건이 없는 건물정보를 큐에 넣는다.
        }

        while (!q.isEmpty()) {
            int buildNum = q.poll(); // 지을 수 있는 건물을 꺼낸다.
            buildTime[buildNum] += totalPreBuildTime[buildNum];
            // 해당 건물을 필요로하는 다른 건물들의 카운트를 하나씩 줄임
            for (int other : connectInfo.get(buildNum)) {
                totalPreBuildTime[other] = Math.max(totalPreBuildTime[other], buildTime[buildNum]);
                // n번 건물을 짓기전에 소모되는 총시간을 계산(선행 조건중 가장 큰 값)
                preBuildCount[other]--;
                if (preBuildCount[other] == 0) {
                    q.offer(other);
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            sb.append(buildTime[i]).append("\n");
        }

        System.out.print(sb);
    }

    }

    
    


