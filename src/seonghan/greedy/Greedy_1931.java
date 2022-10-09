package seonghan.greedy;

/*
 * 문제 주소 :  https://www.acmicpc.net/problem/1931
 *
 * 문제 접근 방법 & 사용 알고리즘:
 *  그리디 알고리즘을 사용
 *  회의가 많을려면, 가장 시간이 짧은 회의 부터 넣어주면 되지 않을까? => 종료 시간이 빠르고, 직전 회의의 종료 시간보다 시작 시간이 느린것만 넣어주면 됨
 *  회의 시간 짧은 순으로 Comparator 사용해서 정렬하면 되지 않을까?
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Greedy_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        time[] times = new time[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = new time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        System.out.println(solution(times));
    }

    public static int solution(time[] times) {
        int result = 0;
        int pre = 0;
        Arrays.sort(times, new Comparator<time>() {
            @Override
            public int compare(time o1, time o2) {
                if (o1.endTime == o2.endTime) {
                    return o1.startTime - o2.startTime;
                }
                return o1.endTime - o2.endTime;
            }
        });

        for (int i = 0; i < times.length; i++) {
            if (pre <= times[i].startTime) {
                result++;
                pre = times[i].endTime;
            }
        }


        return result;
    }


    //    public static boolean Check(int[] arr, int startTime, int endTime) {
    //        int sum = 0;
    //        for (int i = startTime; i <= endTime; i++) {
    //            sum += arr[i];
    //        }
    //        if (sum == 0 || sum == 1) {
    //            return true;
    //        } else if (startTime == endTime) {
    //            return true;
    //        } else {
    //            return false;
    //        }
    //
    //    }

    //    public static int findMaxEndTime(time[] times) {
    //        int max = 0;
    //        for (int i = 0; i < times.length; i++) {
    //            if (max < times[i].endTime) {
    //                max = times[i].endTime;
    //            }
    //        }
    //        return max;
    //    }

    //    public static int findMinStartTime(time[] times) {
    //        int min = 0;
    //        for (int i = 0; i < times.length; i++) {
    //            if (min > times[i].startTime) {
    //                min = times[i].startTime;
    //            }
    //        }
    //        return min;
    //    }

    public static class time {
        public int startTime;
        public int endTime;

        public time(int StartTime, int endTime) {
            this.startTime = StartTime;
            this.endTime = endTime;
        }

    }

}
