// 10.09.22
// 1931번 회의실 배정
// 문제주소 : https://www.acmicpc.net/problem/1931

// 오랫동안 고민해봐도 어떻게 접근할지 모르겠어서 살짝 찾아봤는데.. 
// "서로 겹치지 않는 활동에 대해 종료시간이 빠르면 더 많은 회의를 할 수 있다" 라는 것을 알게되었다!!

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Meeting {
    int start;
    int finish;

    public Meeting(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

public class P_1931 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int howMany = scanner.nextInt();

        Meeting[] meeting = new Meeting[howMany];

        for (int i = 0; i < howMany; i++)
            meeting[i] = new Meeting(scanner.nextInt(), scanner.nextInt());

        // 객체 정렬하는 메소드가 있나 찾아보았는데 잘 이해가 안감. 나중에 더 알아보기
        Arrays.sort(meeting, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting m1, Meeting m2) {
                if (m1.finish == m2.finish)
                    return m1.start - m2.start; // finish가 같은 경우 start 기준 정렬

                return Integer.compare(m1.finish, m2.finish); 
                // compare() 인자1 > 인자2 인 경우 1 리턴
                // 인자1 < 인자2 인 경우 -1 리턴
                // 인자1 == 인자2 인 경우 0 리턴
            }
        });

        // for (int i = 0; i < howMany; i++)
        //     System.out.println(Integer.toString(meeting[i].start) + Integer.toString(meeting[i].finish));
        
        int count = 0;
        int time = 0;

        for (int i = 0; i < howMany; i++)
            if (time <= meeting[i].start)
            {
                time = meeting[i].finish;
                count ++;
            }
        System.out.print(count);

        scanner.close();
    }
}