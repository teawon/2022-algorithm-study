    package seonghan.dfs_bfs2;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.LinkedList;
    import java.util.Queue;
    import java.util.StringTokenizer;

    /*
     * 문제 주소 :  https://www.acmicpc.net/problem/2573
     *
     * 문제 접근 방법 & 사용 알고리즘: BFS,DFS
     * 1초후에 움직일 수 있는 경우의 수가 3가지
     * -> 한칸 앞으로, 한칸 뒤로, 현재 위치 x 2 로 이동.
     * 이렇게 3가지를 bfs로 최단 거리?
     *
     *
     */
    public class dfs_bfs_1697 {
        static int N; //  수빈의 위치
        static int K; // 동생의 위치
        static int[] visited = new int[100001];

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            System.out.println(solution(N));

        }


        public static int solution(int startNode) {
            Queue<Integer> q = new LinkedList<>();
            q.add(startNode);
            int index = startNode;
            int n = 0;
            visited[index] = 1;
            while(q.isEmpty()==false){
                n = q.poll();

                if(n==K){
                    return visited[n]-1;
                }if(n-1>=0 && visited[n-1] == 0){
                    visited[n-1] = visited[n]+1;
                    q.add(n-1);
                }if(n+1<=100000 && visited[n+1]==0){
                    visited[n+1] = visited[n]+1;
                    q.add(n+1);
                }
                if(2*n<=100000 && visited[2*n]==0){
                    visited[2*n] = visited[n]+1;
                    q.add(2*n);
                }
            }
            return -1;
        }
    }
