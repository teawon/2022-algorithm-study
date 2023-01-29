// 문제 주소 : https://www.acmicpc.net/problem/2252

// 메모리 및 응답시간 : 47876KB || 576ms

// 문제 접근 방법 & 사용 알고리즘: 
// 학생 키 비교 정보를 입력받음. 
// A B 입력받으면 A에서 B로 진입하는 간선이 있는 것으로 생각하여 그래프를 위상 정렬

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_2252 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 001. 학생 수 N 입력
        int N = Integer.parseInt(st.nextToken());
        // 002. 비교 수 M 입력
        int M = Integer.parseInt(st.nextToken());

        // 003. 진입 차수 저장할 배열
        int[] indegree = new int[N + 1];

        // 004. 학생 키 비교 정보를 저장할 리스트
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<Integer>());

        // 005. 비교 정보 입력, 진입 차수 설정
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            indegree[B]++;
            graph.get(A).add(B);
        }

        Queue<Integer> q = new LinkedList<Integer>();

        // 006. 진입 차수가 0이라면 큐에 추가
        for (int i = 1; i <= N; i++)
            if (indegree[i] == 0) 
                q.add(i);

        // 007. 결과 출력을 위한
        StringBuilder sb = new StringBuilder();

        // 008. 큐가 빌때까지 반복
        while (!q.isEmpty()) {
            // 009. 큐에서 노드를 하나 꺼냄
            int nodeNum = q.poll();

            // 010. 꺼낸 노드번호(학생 번호) 결과에 저장
            sb.append(nodeNum + " ");

            // 011. 꺼낸 노드의 인접한 노드들 찾기
            ArrayList<Integer> list = graph.get(nodeNum);

            // 012. 인접한 노드의 개수만큼 반복문 실행
            for (int i = 0; i < list.size(); i++) {
                // 013. 인접한 노드의 진입차수 갱신
                indegree[list.get(i)]--;

                // 014. 갱신된 노드의 진입차수가 0이면 큐에 노드 넣기
                if (indegree[list.get(i)] == 0)
                    q.offer(list.get(i));
            }
        }
        // 015. 결과출력
        System.out.println(sb);
    }
}
