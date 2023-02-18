package teawon.programers.압축;

import java.util.*;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/17684 [2단계]
 * 풀이시간 : 1시간 이상
 * 
 * 실수한점 : 중간중간 System.out.println을 통해 값이 잘 나오는지 확인하기. 
 */

class Solution {
    public static int[] solution(String msg) {

        ArrayList<String> dic = new ArrayList<>();
        ArrayList<Integer> press = new ArrayList<>();
        int count = 0;
        // A부터 Z까지 사전 초기화하기
        for (char i = 'A'; i <= 'Z'; i++) {
            dic.add(Character.toString(i));
        }

        for (int i = 0; i < msg.length(); i++) {
            String target = Character.toString(msg.charAt(i));
            target = target.toUpperCase();
            int index = 0;

            if (i == msg.length() - 1) {
                press.add(dic.indexOf(target) + 1);
            }

            else if (dic.contains(target)) {
                while (true) {

                    // 만약 마지막 글자라면? 다음글자를 포함할 필요도 없고 멈춰야한다.
                    // 다음글자를 포함해서 있는지 확인 "없을때까지"
                    if (i == msg.length() - 1 && dic.contains(target)) { // 만약 마지막 글자라면? 마지막 위치값에 등록 후 해당 인덱스를 바로
                                                                         // 저장해야한다.
                        index = dic.indexOf(target);
                        i++;
                        break;
                    }

                    if (!dic.contains(target)) {
                        i--;
                        break;
                    }
                    index = dic.indexOf(target);
                    i++;
                    target += Character.toString(msg.charAt(i)).toUpperCase();

                }
                press.add(index + 1);
                dic.add(target);

            }

        }

        int[] answer = new int[press.size()];
        for (int i = 0; i < press.size(); i++) {
            answer[i] = press.get(i);
        }
        return answer;
    }
}
