package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 매출액의 종류
 * <p>
 * 현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를 각 구간별로 구하라고 했습니다.
 * 만약 N=7이고 7일 간의 매출기록이 아래오 같고, 이때 K=4이면
 * 20 12 20 10 23 17 10
 * 각 연속 4일간의 구간의 매출종류
 * 첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
 * 두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
 * 세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
 * 네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
 * N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별 매출액의 종류를 출력하는 프로그램을 작성하세요.
 * <p>
 * ▣ 입력설명
 * 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
 * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
 * <p>
 * ▣ 출력설명
 * 첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.
 * <p>
 * ▣ 입력예제 1
 * 7 4
 * 20 12 20 10 23 17 10
 * <p>
 * ▣ 출력예제 1
 * 3443
 */
public class Map03 {
    public ArrayList<Integer> solution(int period, int[] profit) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < period-1; i++) {
            int target = profit[i];
            map.put(target, map.getOrDefault(target, 0) + 1);
        }

        int lt = 0;
        for (int rt = period-1; rt < profit.length; rt++) {
            int add = profit[rt];
            int remove = profit[lt];
            map.put(add, map.getOrDefault(add, 0) + 1);
            answer.add(map.size());
            map.put(remove, map.get(remove) - 1);
            if (map.get(remove) == 0) {
                map.remove(remove);
            }
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Map03 map = new Map03();
        ArrayList<Integer> result = map.solution(4, new int[]{20, 12, 20, 10, 23, 17, 10});
        System.out.println("result = " + result);
    }
}
