package teawon.programers.다트게임;

import java.util.*;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/17682 [1단계]
 * 풀이시간 : 약 1시간 이상
 * 
 * 실수한점 : 정수는 10까지 나올 수 있고 옵션또한 선택옵션이기때문에 확정적으로 다음 다트게임임을 나타내려면 S, D ,T가 나오는시점에 인덱스를 늘려야한다.
 * 처음애는 각 점수배열판을 두는게아니라 curScore, preScore형태를 사용했지만 [옵션]값이 선택이기때문에 넘어가는 지점을 확정지을 수 없었고 배열을 통해 각각 값을 변경해야했다.
 */

class Solution {
    public static int solution(String dartResult) {

        String strScore = "";
        int[] score = new int[4];
        int index = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            char value = dartResult.charAt(i);
            if (Character.isDigit(value)) {
                strScore += value;
            } else if (value == 'D' || value == 'S' || value == 'T') {

                score[++index] = Integer.parseInt(strScore);
                strScore = "";
                if (value == 'D') {
                    score[index] = (int) Math.pow(score[index], 2);
                }
                if (value == 'T') {
                    score[index] = (int) Math.pow(score[index], 3);
                }

            } else {
                if (value == '*') {
                    score[index - 1] *= 2;
                    score[index] *= 2;

                }
                if (value == '#') {
                    score[index] *= -1;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= 3; i++) {
            answer += score[i];
        }
        return answer;
    }
}