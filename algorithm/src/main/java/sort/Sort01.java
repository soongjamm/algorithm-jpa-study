package sort;

import java.util.Arrays;

/**
 * 선택 정렬
 * <p>
 * N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요. 정렬하는 방법은 선택정렬입니다.
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

public class Sort01 {
    // 선택정렬 - 시간복잡도 O(n^2)
    // 전체중 최소값을 선택해서 맨 앞 인덱스의 값과 교환한다.
    // 맨 앞의 인덱스를 한칸 이동한다. (반복)
    private int[] solution(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            int target = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[target]) {
                    target = j;
                }
            }
            int tmp = input[i];
            input[i] = input[target];
            input[target] = tmp;
        }

        return input;
    }

    public static void main(String[] args) {
        Sort01 sort = new Sort01();
        int[] result = sort.solution(new int[]{13, 5, 11, 7, 23, 15});
        System.out.println("result = " + Arrays.toString(result));
    }
}
