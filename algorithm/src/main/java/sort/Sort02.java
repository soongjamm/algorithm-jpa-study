package sort;

import java.util.Arrays;

/**
 * 버블 정렬
 * <p>
 * N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요. 정렬하는 방법은 버블정렬입니다.
 * <p>
 * ▣ 입력설명
 * 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
 * 두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.
 * <p>
 * ▣ 출력설명
 * 오름차순으로 정렬된 수열을 출력합니다.
 * <p>
 * ▣ 입력예제 1
 * 6
 * 13 5 11 7 23 15
 * <p>
 * ▣ 출력예제 1
 * 5 7 11 13 15 23
 */

public class Sort02 {
    // 버블정렬 - 시간복잡도 O(n^2)
    // 인접한 두 인자를 비교해 큰 값을 뒤로 보내기를 반복한다.
    // 바깥쪽 반복문을 돌때마다 가장 오른쪽의 수가 결정된다.  (안쪽이 j < n-i-1인 이유)
    // 바깥 반복문의 탈출조건은 반복해야하는 횟수
    private int[] solution(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] > input[j + 1]) {
                    int tmp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = tmp;
                }
            }
        }

        return input;
    }

    public static void main(String[] args) {
        Sort02 sort = new Sort02();
        int[] result = sort.solution(new int[]{13, 5, 11, 7, 23, 15});
        System.out.println("result = " + Arrays.toString(result));
    }
}
