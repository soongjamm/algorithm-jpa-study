package string;

/*
회문 문자열

앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력 하는 프로그램을 작성하세요.
단 회문을 검사할 때 대소문자를 구분하지 않습니다.

▣ 입력설명
첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.

▣ 출력설명
첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.

▣ 입력예제 1 gooG

▣ 출력예제 1 YES
 */

public class String07 {
    public String solution(String str) {
        String answer = "YES";
        str = str.toUpperCase();

        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != str.charAt(length - i -1) ) {
                answer = "NO";
                return answer;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String07 string = new String07();
        String answer = string.solution("gooG");
        System.out.println("answer = " + answer);
        System.out.println("YES".equals(answer));

    }
}
