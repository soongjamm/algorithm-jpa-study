package stack;

import java.util.Stack;

/**
 * 괄호문자제거
 * <p>
 * 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
 * <p>
 * ▣ 입력설명
 * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 * <p>
 * ▣ 출력설명
 * 남은 문자만 출력한다.
 * <p>
 * ▣ 입력예제 1
 * (A(BC)D)EF(G(H)(IJ)K)LM(N)
 * <p>
 * ▣ 출력예제 1
 * EFLM
 */

public class Stack02 {
    public String solution(String input) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (c == ')') {
                while (stack.pop() != '(') ;
            } else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        return answer.reverse().toString();
    }

    public static void main(String[] args) {
        Stack02 stack = new Stack02();
        String result = stack.solution("(A(BC)D)EF(G(H)(IJ)K)LM(N)");
        System.out.println("result = " + result);
    }
}
