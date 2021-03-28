package string;

/*
문장 속 단어

한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요. 문장속의 각 단어는 공백으로 구분됩니다.

▣ 입력설명
첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성 되어 있습니다.

▣ 출력설명
첫 줄에 가장 긴 단어를 출력한다. 가장 긴 단어가 여러개일 경우 문장속에가 가장 앞쪽에 위 치한 단어를 답으로 합니다.

▣ 입력예제 1
it is time to study

▣ 출력예제 1 study
 */

public class String03 {
    public String solution(String str) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        String[] split = str.split(" ");
        for (String s : split) {
            if (s.length() > max) {
                max = s.length();
                answer = s;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String03 string = new String03();
        String answer = string.solution("it is time to study");
        System.out.println(answer);
    }
}
