// 10.09.22
// 2812번 크게 만들기
// 문제주소 : https://www.acmicpc.net/problem/2812

// 단순히 정렬해서 작은 값부터 지우면 되는 줄 알았으나 아니었다.
// 스택을 이용해서 나중에 들어올 값이 먼저 들어와있는 값보다 작으면 그냥 push하고
// 크다면 앞에 들어와 있는 값을 pop 후 push한다.

// 마지막엔 결과를 출력하기 위해 모두 pop하는데 순서가 거꾸로 되어있기 때문에 reverse해준다.

import java.util.Scanner;
import java.util.Stack;

public class P_2812 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int units = scanner.nextInt();
        int remove = scanner.nextInt();
        int len = units - remove;

        String number = scanner.next();

        // 자바는 스택을 기본적으로 제공해준다
        // isEmpty, push, peek, search, pop, clear 등의 메소드가 있다.
        // <>의 의미? 제네릭이라고 하는데 <>안에 어떠한 타입을 선언해주어 ArrayList, List 등이 사용할 객체의 타입을 지정해준다는 뜻이다.
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < units; i++)
        {
            while(!stack.empty() && remove > 0 && stack.peek() < number.charAt(i))
            {
                stack.pop();
                remove --;
            }

            stack.push(number.charAt(i));
        }

        // 앞에서 remove 만큼 제거하지 못한 경우 pop
        while(true) {
            if(stack.size() == len)
                break;
            
            stack.pop();
        }

        StringBuffer result = new StringBuffer();
        
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        System.out.println(result.reverse());

        scanner.close();
    }
}
