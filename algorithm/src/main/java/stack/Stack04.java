package stack;

import java.util.Stack;

/**
 * 후위식 연산(postfix)
 * <p>
 * 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
 * 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
 * <p>
 * ▣ 입력설명
 * 첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다. 식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.
 * <p>
 * ▣ 출력설명
 * 연산한 결과를 출력합니다.
 * <p>
 * ▣ 입력예제 1
 * 352+*9-
 * <p>
 * ▣ 출력예제 1
 * 12
 */

public class Stack04 {
    public int solution(String exp) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (char c : exp.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
                continue;
            }
            int value1 = stack.pop();
            int value2 = stack.pop();
            int res = 0;
            if (c == '+') {
                stack.push(value2 + value1);
            }
            if (c == '-') {
                stack.push(value2 - value1);
            }
            if (c == '*') {
                stack.push(value2 * value1);
            }
            if (c == '/') {
                stack.push(value2 / value1);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Stack04 stack = new Stack04();
        int result = stack.solution("352+*9-");
        System.out.println("result = " + result);
    }
}
