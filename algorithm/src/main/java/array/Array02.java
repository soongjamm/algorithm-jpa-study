package array;

import java.util.ArrayList;

/**
 * 큰 수 출력하기
 *
 * N(1<=N<=100)개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작 성하세요.(첫 번째 수는 무조건 출력한다)
 *
 * ▣ 입력설명
 * 첫 줄에 자연수 N이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
 *
 * ▣ 출력설명
 * 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
 *
 * ▣ 입력예제 1
 * 6
 * 7 3 9 5 6 12
 *
 * ▣ 출력예제 1
 * 7 9 6 12
 */

public class Array02 {
    public int solution(int[] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Array02 array = new Array02();
        int result = array.solution(new int[]{130, 135, 148, 140, 145, 150, 150, 153});
        System.out.println("result = " + result);
    }
}
