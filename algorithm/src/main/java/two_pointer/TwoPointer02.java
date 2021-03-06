package two_pointer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 공통원소 구하기
 * <p>
 * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로 그램을 작성하세요.
 * <p>
 * ▣ 입력설명
 * 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
 * 두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다. 세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
 * 네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다. 각 집합의 원소는 1,000,000,000이하의 자연수입니다.
 * <p>
 * ▣ 출력설명
 * 두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
 * <p>
 * ▣ 입력예제 1
 * 5
 * 1 3 9 5 2
 * 5
 * 3 2 5 7 8
 * <p>
 * ▣ 출력예제 1
 * 2 3 5
 */

public class TwoPointer02 {
    public ArrayList<Integer> solution(int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        int pa = 0;
        int pb = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        while (pa < a.length && pb < b.length) {
            if (a[pa] == b[pb]) {
                answer.add(a[pa++]);
                pb++;
            } else if (a[pa] < b[pb]) {
                pa++;
            } else {
                pb++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        TwoPointer02 twoPointer = new TwoPointer02();
        ArrayList<Integer> result = twoPointer.solution(
                new int[]{1, 3, 9, 5, 2},
                new int[]{3, 2, 5, 7, 8}
        );
        System.out.println("result = " + result);
    }
}
