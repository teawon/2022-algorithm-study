import java.util.*;

import java.io.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/21608
 * 
 * 문제 접근 방법 & 사용 알고리즘: 
       //1. 일단 좋아하는 학생의 자리가 있는지 확인해야한다.

        // 1.1) 있다면? 모든 배열값을 순회하며 옆 자리의 좌표값을 1씩 더하고 최종적으로 가장 높은 좌표값에 (좋아하는 학생이 근처에 있음) 넣기

        // 1.2) 없다면? 모든 배열값을 순회하며 좌표별 빈 자리의 개수를 계산하고 가장 적은 곳에 넣는다.

        // 근데 이걸 나눠서 하면 n*n배열을 여러번 검사해야한다. 차라리 한번 순회하며 각 좌표별 가중치값을 계산하는게 좋을 거 같음
        // 각 좌표별로 가중치값을 계산하는데 빈배열이 있다면 +1씩 , 좋아하는 학생수가 있다면 +5씩 (어처피 최대 4까지 값이 있으니까) 더해서 가중치 값을 계산한다.
        // 그리고 가장 가중치가 큰 좌표에 해당 학생을 넣는다. (같으면 행,열이 낮은곳에 들어가므로 행 - 열 순서로 0부터 탐색해서 같은값이면 갱신안하게 하기)



        -> 로직 자체는 잘 접근했는데 자잘한 오류와 실수로 2시간이상 걸렸다.
        -> 특히 변수 자체가 많아지니 햇갈렸고 x,y와 같은 직관적인 변수를 사용하는 연습을 가지기
        -> 코드가 길어지니 위에서부터 오류를 잡아갔는데 로직이 나뉜다면 (학생 자리 배치 , 학생 애정도 구하기) 중간에 끊어서 값이 잘 들어가는 지 확인해보기
        -> System.out.println(x+","+y+"학생 :"  + room[y][i])와 같이 하나하나 디버그하는 것보다 출력문으로 확인하는게 더 빠르고 후반에는 좋았던거 같음


 */





public class P_21608 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());// 교실의 크기 (N*N)

        int[][] student = new int[N*N][4]; // 각 학생별 좋아하는 학생의 정보를 담은 배열
        int[][] room = new int[N][N]; //학생들이 앉을 수 있는 좌표
        int[] order = new int[N*N]; //순번을 정할 학생의 순서
        
        for(int i=0; i<N*N; i++){ // n번째 학생이 좋아하는 학생들과 순번에 데이터 넣기
            st = new StringTokenizer(br.readLine(), " ");
            int student_num = Integer.parseInt(st.nextToken());
            order[i] = student_num;

            for(int j=0; j<4; j++){
           
                student[student_num-1][j]=  Integer.parseInt(st.nextToken());  
            } 
        }

  

        int[] dx = {0, 1, 0, -1}; // 시계방향으로 검사
        int[] dy = {-1, 0, 1, 0}; 

        for(int count=0; count<N*N; count++){
            int select_x = -1; //가중치가 가장 높은 x좌표
            int select_y = -1; //가중치가 가장 낮은 y좌표
            int maxScore = -1; //가장 높은 자리의 가중치 값
            for(int y=0; y<N; y++){
                for(int x=0; x<N; x++){
                    //각 좌표의 위 아래 왼쪽 오른쪽이 비어있는지, 좋아하는 학생이 있는지 계산 후 해당 점수를 계산한다.

                    if(room[y][x]==0) {
                        int  curScore = 0;
                        for(int direct=0; direct<4; direct++){

                            if(x+dx[direct]<0 ||x+dx[direct] >= N || y+dy[direct] < 0 || y+dy[direct] >= N ) continue; //범위 이탈 계산
                            
                            if(room[y+dy[direct]][x+dx[direct]] == 0) curScore++; //비어있다면 가중치 1 증가

                            for(int p=0; p<4; p++){
                                if(room[y+dy[direct]][x+dx[direct]] == student[order[count]-1][p]) curScore+=5; //해당 자리에 좋아하는 학생이 있으면 +5
                            }
                            
                        }
                        if(maxScore < curScore){ //만약 위, 아래, 왼쪽, 오른쪽을 살펴본 가중치가 제일 크다면 (넣어야 하는 위치라면) 현재 x, y값을 갱신한다.
                            maxScore = curScore;
                            select_y = y;
                            select_x = x;
                        }
                    
                    }

                }
            }

            room[select_y][select_x] = order[count]; //가장 높은 가중치의 좌표에 해당 학생을 넣는다.
            


        }
        //학생의 좌표선정 끝

        int sum = 0;

        for(int y=0; y<N; y++){  //y축
            for(int x=0; x<N; x++){ //xㅜZ
                //호감도를 계산한다.
                int count = 0;
                for(int direct=0; direct<4; direct++){

                    if(x+dx[direct]<0 || x+dx[direct] >= N || y+dy[direct] < 0 || y+dy[direct] >= N) continue; //범위 이탈 계산
                    

                    for(int p=0; p<4; p++){
                        if(room[y+dy[direct]][x+dx[direct]] == student[room[y][x]-1][p]) count++;
                    }
                     
                }
                if(count == 1){
                    sum+=1;
                }
                else if(count == 2){
                    sum+=10;
                }
                else if(count == 3){
                    sum+=100;
                }
                else if(count ==4){
                    sum+=1000;
                }
            }
        }

       System.out.println(sum);

    }
}

