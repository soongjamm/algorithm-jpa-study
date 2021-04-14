package two_pointer;

/**
 * 연속된 자연수의 합
 * <p>
 * N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
 * 만약 N=15이면
 * 7+8=15
 * 4+5+6=15
 * 1+2+3+4+5=15
 * 와 같이 총 3가지의 경우가 존재한다.
 * <p>
 * ▣ 입력설명
 * 첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.
 * <p>
 * ▣ 출력설명
 * 첫 줄에 총 경우수를 출력합니다.
 * <p>
 * ▣ 입력예제 1
 * 15
 * <p>
 * ▣ 출력예제 1
 * 3
 */

public class TwoPointer05 {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;
        int lt = 0;
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }
        for (int rt = 0; rt < n / 2 + 1; rt++) { // n >= sum 이면 rt 이동
            sum += numbers[rt];
            while (n <= sum) { // n <= sum 일 때 lt를 이동.
                if (n == sum) {
                    answer++;
                }
                sum -= numbers[lt++];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        TwoPointer05 twoPointer = new TwoPointer05();

        int result = twoPointer.solution(15);
        System.out.println("result = " + result);
    }
}
