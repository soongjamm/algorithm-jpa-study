package array;

import java.util.ArrayList;

/**
 * 뒤집은 소수
 * <p>
 * N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하 는 프로그램을 작성하세요. 예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출 력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다. 첫 자리부터의 연속된 0은 무시한다.
 * <p>
 * ▣ 입력설명
 * 첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다. 각 자연수의 크기는 100,000를 넘지 않는다.
 * <p>
 * ▣ 출력설명
 * 첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
 * <p>
 * ▣ 입력예제 1
 * 9
 * 32 55 62 20 250 370 200 30 100
 * <p>
 * ▣ 출력예제 1
 * 23 2 73 2 3
 */

public class Array06 {
    public ArrayList<Integer> solution(int[] n) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int num : n) {
            int sum = 0;
            while (num > 0) {
                int t = num % 10;
                sum = sum * 10 + t;
                num /= 10;
            }
            if (isPrime(sum)) {
                answer.add(sum);
            }
        }

        return answer;
    }

    // '에라토스테네스 체'는 여러 개의 값이 있을 때 각각이 소수인지 검사할 때 사용하고
    // 지금은 하나의 숫자만 소수인지 판별하면 됌
    private boolean isPrime(int sum) {
        if (sum <= 1) {
            return false;
        }
        for (int i = 2; i < sum; i++) {
            if (sum % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Array06 array = new Array06();
        ArrayList<Integer> result = array.solution(new int[]{32, 55, 62, 20, 250, 370, 200, 30, 100});
        System.out.println("result = " + result.toString());
    }
}
