import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1697
 *  //단순히 2배하면 안된다. 값을 줄이고 2배하는게 빠를 수도 있으니까.
    // 두개를 줄이고 2배하는경우도 있나? - 있다. 예를들어 5 10 9 8 16이 정답이라면 .. 5 10 20 19 18 17 16 // 5 10 9 8 16 -> 가능
    // 다이나믹 프로그래밍으로 접근하면? 값을 계산해나가는데 이전값 * 2 , 이전값-1 *2 , 이전값 -2 * 2...등 앞에 있는 정수가 완벽하다는 전제를 사용해도 뒤에 값은 알 수 없으므로 힘들 것 같음
 */

public class P_1697 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //수빈이 위치
        int K = Integer.parseInt(st.nextToken()); //동생 위치
    
        int start = N;
        int[] distance = new int[100001];

        distance[start] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        
        while(!q.isEmpty()) {
            int curNode = q.poll();
            if(curNode == K) break;
            
            if(curNode+1<=100000 && distance[curNode+1]==0) {
                distance[curNode+1] = distance[curNode]+1;
                q.offer(curNode+1);
            }
            if(curNode-1>=0 &&distance[curNode-1]==0) {
                distance[curNode-1] = distance[curNode]+1;
                q.offer(curNode-1);
            }
            
            if(curNode*2<=100000 && distance[curNode*2]==0) {
                distance[curNode*2] = distance[curNode]+1;
                q.offer(curNode*2);
            }
            
        }
     
        System.out.println(distance[K]-1);
   
    }
}




