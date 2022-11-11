import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/16236
 * 문제 접근 방법 & 사용 알고리즘: 상어가 먹을 수 있는 물고기들을 우선 탐색한다. 특정 지점의 물고기를 먹는데 걸리는 거리를 BFS로 각각 찾은 후
 * 탐색된 물고기 중 하나를 먹으며 이를 반복한다.
 * 
 * - 초기에는 물고기를 발견하면 바로 먹어버렸는데 같은 거리라도 우선순위가 있기때문에 값을 전부 순회한 후 확인할 필요가 있었다.
 * 

 */

public class P_16236 {
    public static int[] dy = { -1, 0, 0, 1 }; // 위 왼쪽 오른쪽 아래 순
    public static int[] dx = { 0, -1, 1, 0 };

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // n*n 공간 생성

        int[][] array = new int[N][N]; // 공간 정보
        int[][] distance = new int[N][N]; // 거리정보
        int size = 2;
        int exp = 0;
        int totalMove = 0;
        Queue<Node> q = new LinkedList<>();

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                array[y][x] = Integer.parseInt(st.nextToken());
                if (array[y][x] == 9) { // 처음 상어가 있던 자리부터 탐색을 시작한다. 주의점은 9라는 숫자를 0으로 초기화
                    q.offer(new Node(x, y));
                    distance[y][x] = 1;
                    array[y][x] = 0;
                }
            }
        }

        while (true) {
            boolean isEnd = true;
            int eat_x = -1; // 각 n번째 탐색마다 먹게될 목표물
            int eat_y = -1;

            while (!q.isEmpty()) {
                Node node = q.poll();
                int y = node.getY();
                int x = node.getX();

                if (array[y][x] != 0 && array[y][x] < size) { // 사이즈가 작으면 일단 다 먹을 타겟으로 지정
                    if (isEnd) { // 처음이라면 일단 갱신
                        eat_x = x;
                        eat_y = y;
                        isEnd = false;
                    } else {
                        if (distance[eat_y][eat_x] > distance[y][x]) { // 최소 거리라면 갱신
                            eat_x = x;
                            eat_y = y;

                        } else if (distance[eat_y][eat_x] == distance[y][x]) { // 거리가 같다면
                            if ((eat_y > y || (eat_y == y && eat_x > x))) { // 위에있거나 , 혹은 같을 때 왼쪽에 있다면 갱신
                                eat_x = x;
                                eat_y = y;
                            }
                        }
                    }

                }

                for (int d = 0; d < 4; d++) { // 4방향에 대해 최단거리를 각각 갱신하며 경로 탐색
                    if (x + dx[d] < 0 || x + dx[d] >= N || y + dy[d] < 0 || y + dy[d] >= N
                            || array[y + dy[d]][x + dx[d]] > size || distance[y + dy[d]][x + dx[d]] != 0)
                        continue;
                    distance[y + dy[d]][x + dx[d]] = distance[y][x] + 1;
                    q.offer(new Node(x + dx[d], y + dy[d]));
                }
            }
            if (isEnd)
                break; // 만약 먹을게 없다면 종료

            array[eat_y][eat_x] = 0;
            totalMove += (distance[eat_y][eat_x] - 1); // 이 위치까지 이동한 거리 더하고

            exp++;
            if (exp == size) {
                size++;
                exp = 0;
            }

            for (int i = 0; i < N; i++) {
                Arrays.fill(distance[i], 0);
            }
            q.offer(new Node(eat_x, eat_y)); // 다시 탐색을 반복한다.
            distance[eat_y][eat_x] = 1;
            // System.out.println(totalMove + "레벨 : " + size + "경험치 : " + exp + "위치 : "+ "("
        }
        System.out.println(totalMove);
    }

}
