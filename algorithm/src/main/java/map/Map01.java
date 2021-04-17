package map;

import java.util.HashMap;
import java.util.Map;

/**
 * 학급 회장(해쉬)
 *
 * 학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
 * 투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
 * 선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작 성하세요. 반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.
 *
 * ▣ 입력설명
 * 첫 줄에는 반 학생수 N(5<=N<=50)이 주어집니다.
 * 두 번째 줄에 N개의 투표용지에 쓰여져 있던 각 후보의 기호가 선생님이 발표한 순서대로 문자열로 입력됩니다.
 *
 * ▣ 출력설명
 * 학급 회장으로 선택된 기호를 출력합니다.
 *
 * ▣ 입력예제 1
 * 15
 * BACBACCACCBDEDE
 *
 * ▣ 출력예제 1
 * C
 */
public class Map01 {
    public char solution(String input) {
        char answer = ' ';
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) +1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (value > max) {
                answer = key;
                max = value;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Map01 map = new Map01();
        char result = map.solution("BACBACCACCBDEDE");
        System.out.println("result = " + result);
    }
}
