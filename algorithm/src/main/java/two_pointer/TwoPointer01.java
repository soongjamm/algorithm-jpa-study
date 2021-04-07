package two_pointer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 두 배열 합치기
 * <p>
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램 을 작성하세요.
 * <p>
 * ▣ 입력설명
 * 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다. 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
 * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다. 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
 * 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
 * <p>
 * ▣ 출력설명
 * 오름차순으로 정렬된 배열을 출력합니다.
 * <p>
 * ▣ 입력예제 1
 * 3
 * 1 3 5
 * 5
 * 2 3 6 7 9
 * <p>
 * ▣ 출력예제 1 12335679
 */

public class TwoPointer01 {
    public ArrayList<Integer> solution(int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        int pa = 0;
        int pb = 0;

        while (pa < a.length && pb < b.length) {
            if (a[pa] < b[pb]) {
                answer.add(a[pa++]);
            } else {
                answer.add(b[pb++]);
            }
        }
        while (pa < a.length) {
            answer.add(a[pa++]);
        }
        while (pb < b.length) {
            answer.add(b[pb++]);
        }

        return answer;
    }

    public static void main(String[] args) {
        TwoPointer01 twoPointer = new TwoPointer01();
        ArrayList<Integer> result = twoPointer.solution(
                new int[]{1, 3, 5},
                new int[]{2, 3, 6, 7, 9}
        );
        System.out.println("result = " + result);
    }
}
