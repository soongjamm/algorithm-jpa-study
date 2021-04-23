package sort;

import java.util.Arrays;

/**
 * 삽입 정렬
 * <p>
 * N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요. 정렬하는 방법은 삽입정렬입니다.
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
 * 11 7 5 6 10 9
 * <p>
 * ▣ 출력예제 1
 * 5 6 7 9 10 11
 */

public class Sort03 {
    // 삽입정렬 - 시간복잡도 O(n^2)
    // 정렬된 부분 집합에서 한 원소씩 적절한 위치에 삽입한다.
    // 부분집합의 크기가 1에서 n까지 늘어난다.
    private int[] solution(int[] input) {
        for (int i = 1; i < input.length; i++) {
            int target = input[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (target < input[j]) { // 삽입될 지점을 찾을때 까지 한칸씩 민다.
                    input[j + 1] = input[j];
                    continue;
                }
                break;
            }
            // input[j]는 target 보다 작은 상태
            input[j + 1] = target;
        }

        return input;
    }

    public static void main(String[] args) {
        Sort03 sort = new Sort03();
        int[] result = sort.solution(new int[]{11, 7, 5, 6, 10, 9});
        System.out.println("result = " + Arrays.toString(result));
        result = sort.solution(new int[]{5, 13, 11, 7, 23, 15});
        System.out.println("result = " + Arrays.toString(result));
    }
}
