import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/2644
 * BFS문제 - 주어진 두 지점의 미로에서 최단거리를 찾는 문제와 같다고 생각했다. DFS로도
 */

public class P_2644 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //사람의 수
        st = new StringTokenizer(br.readLine());
        int target1 = Integer.parseInt(st.nextToken())-1; //찾으려는 두 사람
        int target2 = Integer.parseInt(st.nextToken())-1; //찾으려는 두 사람

        int M = Integer.parseInt(br.readLine()); //관계의  수

        int[][] array = new int[N][N]; //관계를 나타내는 그래프
        int[] distance = new int[100]; //방문 여부 확인

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken())-1; 
            int right = Integer.parseInt(st.nextToken())-1; 
            array[left][right] = 1; //양방향이므로 둘 다 1
            array[right][left] = 1;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<N; i++){
            if(array[target1][i] == 1){ //시작지점으로부터 연결된 모든 노드를 큐에 넣고 거리1로 지정
                distance[i] = 1;
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int curNode = q.poll();
            
            for(int i=0; i<N; i++){
                if((array[curNode][i] == 1) && distance[i] == 0){
                    q.offer(i);
                    distance[i] = distance[curNode]+1; //그 다음부터는 방문노드마다 현재거리 + 1의 값을 넣는다.
                }
                
            }
        }

        if(distance[target2]==0){
            System.out.println("-1");
        }
        else{
            System.out.println(distance[target2]);
        }

    }
}




