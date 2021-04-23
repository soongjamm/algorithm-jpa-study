package sort;

import java.util.Arrays;

/**
 * 중복확인
 * <p>
 * 현수네 반에는 N명의 학생들이 있습니다.
 * 선생님은 반 학생들에게 1부터 10,000,000까지의 자연수 중에서 각자가 좋아하는 숫자 하나 적어 내라고 했습니다.
 * 만약 N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D(duplication)를 출력하고, N 명이 모두 각자 다른 숫자를 적어냈다면 U(unique)를 출력하는 프로그램을 작성하세요.
 * <p>
 * ▣ 입력설명
 * 첫 번째 줄에 자연수 N(5<=N<=100,000)이 주어진다.
 * 두 번째 줄에 학생들이 적어 낸 N개의 자연수가 입력된다.
 * <p>
 * ▣ 출력설명
 * 첫 번째 줄에 D 또는 U를 출력한다.
 * <p>
 * ▣ 입력예제 1
 * 8
 * 20 25 52 30 39 33 43 33
 * <p>
 * ▣ 출력예제 1
 * D
 */

public class Sort05 {
    private String solution(int[] input) {
        Arrays.sort(input);
        for (int i = 0; i < input.length; i++) {
            if (input[i] == input[i+1]) {
                return "D";
            }
        }
        return "U";
    }

    public static void main(String[] args) {
        Sort05 sort = new Sort05();
        String result = sort.solution(new int[]{20, 25, 52, 30, 39, 33, 43, 33});
        System.out.println("result = " + result);
    }
}
