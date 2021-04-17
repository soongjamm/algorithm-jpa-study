package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 모든 아나그램 찾기(해쉬, 투포인터, 슬라이딩 윈도우)
 * <p>
 * S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하 세요.
 * 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
 * <p>
 * ▣ 입력설명
 * 첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
 * S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
 * <p>
 * ▣ 출력설명
 * S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
 * <p>
 * ▣ 입력예제 1
 * bacaAacba
 * abc
 * <p>
 * ▣ 출력예제 1
 * 3
 * 출력설명: {bac}, {acb}, {cba} 3개의 부분문자열이 "abc"문자열과 아나그램입니다.
 * <p>
 * ▣ 입력예제 2
 * bacaAacbaa
 * abca
 * <p>
 * ▣ 출력예제 2
 * 3
 */
public class Map04 {
    public int solution(String full, String partial) {
        int answer = 0;
        Map<Character, Integer> mapPartial = new HashMap<>();
        Map<Character, Integer> mapFull = new HashMap<>();
        for (char c : partial.toCharArray()) {
            mapPartial.put(c, mapPartial.getOrDefault(c, 0) + 1);
        }

        int pLen = partial.length() - 1;
        for (int i = 0; i < pLen; i++) {
            char key = full.charAt(i);
            mapFull.put(key, mapFull.getOrDefault(key, 0) + 1);
        }

        int lt = 0;
        for (int rt = pLen; rt < full.length(); rt++) {
            char add = full.charAt(rt);
            mapFull.put(add, mapFull.getOrDefault(add, 0) + 1);
            if (mapFull.equals(mapPartial)) {
                answer += 1;
            }

            char remove = full.charAt(lt);
            mapFull.put(remove, mapFull.get(remove) - 1);
            if (mapFull.get(remove) == 0) {
                mapFull.remove(remove);
            }
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Map04 map = new Map04();

        int result = map.solution("bacaAacba", "abc");
        System.out.println("result = " + result);

        int result2 = map.solution("bacaAacbaa", "abca");
        System.out.println("result2 = " + result2);
    }
}
