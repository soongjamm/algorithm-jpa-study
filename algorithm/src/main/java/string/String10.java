package string;

/*
가장 짧은 문자거리

한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.

▣ 입력설명
첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다. 문자열의 길이는 100을 넘지 않는다.

▣ 출력설명
첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.

▣ 입력예제 1 teachermode e

▣ 출력예제 1 10121012210
 */

public class String10 {
    public int[] solution(String str, char t) {
        int[] answer = new int[str.length()];
        final int INIT_VALUE = 1000;// 주어진 문자열의 길이보다 크게 설정해야 함

        int p = INIT_VALUE;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == t) {
                p = 0;
            } else {
                p++;
            }
            answer[i] = p;
        }

        p = INIT_VALUE;
        for (int i = str.length()-1; i >= 0; i--) {
            if(str.charAt(i) == t) {
                p = 0;
            } else {
                p++;
            }
            answer[i] = Math.min(answer[i], p);
        }
        return answer;
    }

    public static void main(String[] args) {
        String10 string = new String10();
        int[] distances = string.solution("teachermode", 'e');
        StringBuilder sb = new StringBuilder();
        for (int i : distances) {
            sb.append(i);
        }
        String answer = sb.toString();
        System.out.println("answer = " + answer);
        System.out.println("10121012210".equals(answer));

    }
}
