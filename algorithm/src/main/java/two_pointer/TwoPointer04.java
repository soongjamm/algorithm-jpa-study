package two_pointer;

/**
 * 연속 부분수열
 * <p>
 * N개의 수로 이루어진 수열이 주어집니다.
 * 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
 * 만약 N=8, M=6이고 수열이 다음과 같다면
 * 1 2 1 3 1 1 1 2
 * 합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.
 * <p>
 * ▣ 입력설명
 * 첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다. 수열의 원소값은 1,000을 넘지 않는 자연수이다.
 * <p>
 * ▣ 출력설명
 * 첫째 줄에 경우의 수를 출력한다.
 * <p>
 * ▣ 입력예제 1
 * 8 6
 * 1 2 1 3 1 1 1 2
 * <p>
 * ▣ 출력예제 1
 * 3
 */

// 슬라이딩 윈도우
public class TwoPointer04 {
    public int solution(int target, int[] arr) {
        int answer = 0;
        int sum = arr[0];
        int lt = 0;
        int rt = 1;
        while (lt < arr.length && rt < arr.length) {
            if (sum < target) {
                sum += arr[rt++];
            } else if (sum > target) {
                sum -= arr[lt++];
            } else {
                sum -= arr[lt++];
                answer++;
            }
        }
        return answer;
    }

    public int solution2(int target, int[] arr) {
        int answer = 0;
        int sum = 0;
        int lt = 0;
        for (int rt = 0; rt < arr.length; rt++) {
            sum += arr[rt];
            if (sum == target) {
                answer++;
            }
            while (sum >= target) {
                sum -= arr[lt++];
                if (sum == target) {
                    answer++;
                }
            }

        }
        return answer;
    }


    public static void main(String[] args) {
        TwoPointer04 twoPointer = new TwoPointer04();
        int result = twoPointer.solution(
                6,
                new int[]{1, 2, 1, 3, 1, 1, 1, 2}
        );
        System.out.println("result = " + result);

        result = twoPointer.solution2(
                6,
                new int[]{1, 2, 1, 3, 1, 1, 1, 2}
        );
        System.out.println("result = " + result);
    }
}