import java.util.*;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1931
 *  
 * 문제 접근 방법 & 사용 알고리즘: 
 * 첫번째 접근 - 회의가 끝나는 시간을 기준으로 정렬 후 값을 계속비교하며 차례차례 넣어보기
 * 
 * 
 * 개인메모
 * /**
 *     for(int i=0; i<N; i++){
            if(curEnd <= timeSchedule[i].getEndTime()) {
                if( curEnd <= timeSchedule[i].getStartTime()){
                    curEnd = timeSchedule[i].getEndTime();
                    sum++;
                }
            }
        }

     - 회의가 끝나는 시간을 if문으로 비교했다. 사실 이미 오름차순으로 정렬되어있기때문에 불필요한 코드였다.
     - 객체를 정렬하는 방법 "compareTo"

 */

 


class RoomTime implements Comparable<RoomTime> {
    private int startTime; //시작시간
    private int endTime;  //끝시간

    public RoomTime(int startTime , int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime(){
        return startTime;
    }

    public int getEndTime(){
        return endTime;
    }

    @Override
    public int compareTo(RoomTime target) { //회의 종료시간을 기준으로 오름차순 정렬 (같다면 회의 시작시간기준 오름차순)
        if(this.getEndTime() == target.getEndTime()) return this.getStartTime() - target.getStartTime();
        return this.getEndTime() - target.getEndTime();
    }
}


public class P_1931 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); //회의의 수


        RoomTime[] timeSchedule = new RoomTime[N]; 

        for(int i=0; i<N; i++){
            int startTime = sc.nextInt();
            int endTime = sc.nextInt();
            timeSchedule[i] = new RoomTime(startTime, endTime);
        }      
        
   
        Arrays.sort(timeSchedule);
        
        int sum = 0;
        int curEnd = 0;

        for(int i=0; i<N; i++){

            if( curEnd <= timeSchedule[i].getStartTime()){ //회의의 시작시간이 이전에 끝났던 회의시간보다 이후라면 값을 갱신한다.
                curEnd = timeSchedule[i].getEndTime();
                sum++;
            }
        }
        
       System.out.println(sum);
    }
}
