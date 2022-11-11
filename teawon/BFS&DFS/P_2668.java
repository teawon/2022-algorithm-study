import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/2668
 * 각 순서에 따른 정수를 따라가되 루프가 형성되면 해당 집합이 정답이라고 생각했다. 
 * 루프를 어떻게 확인해야할까?
 * // 일단 방문노드를 계속 따라간다. 그러다가 visited를 만났을 때 멈춘다
 * // 그러다가 visited를 만났을 때 시작지점과 끝 지점이 같은지 확인한다. 
 * // 값이 같다면 해당 큐에들어가있는 루프에 대해 다 확인표시를 넣는다.
 */

public class P_2668 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
  

        int N = Integer.parseInt(br.readLine()); //정수의 수
        int[] numArray = new int[N+1]; //숫자 카드의 정보
        boolean[] visited = new boolean[N+1]; //방문 여부
        boolean[] loop = new boolean[N+1]; //루프 형성 여부
        int count=0;

        for(int i=1; i<N+1; i++){
            numArray[i] = Integer.parseInt(br.readLine());
        }
   
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<N+1; i++){
            
            if(loop[i]==false){ //이미 루프가 형성된 노드가 아니라면 루프 여부를 확인
                Arrays.fill(visited, false); //방문 초기화 
                q.clear(); //큐 초기화

                int curNum = i; 
                visited[curNum] = true;
                q.offer(curNum);


                while(visited[numArray[curNum]] == false){ //방문한 지역이 나올때 까지 계속 탐색
                    q.offer(numArray[curNum]); //다음 노드값을 큐에 넣는다
                    visited[numArray[curNum]] = true; //방문 여부 체크
                    curNum = numArray[curNum]; //해당 값으로 계속 반복
                }
                if(numArray[curNum] == i) { //만약 처음지점과 끝 지점이 같다면 루프 - > 큐의 값을을 꺼내 다 루프임을 체크
                    while(!q.isEmpty()){ 
                        loop[q.poll()] = true;
                        count++;
                    }
                }
            }
        }

        sb.append(count+"\n");

        for(int i=1; i<N+1; i++){
           if(loop[i]==true){
                sb.append(i);
                if(count > 1){
                    sb.append("\n");
                    count--;
                }
           }
        }
        System.out.println(sb);
    }
}




