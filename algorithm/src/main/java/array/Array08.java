package array;

import java.util.Arrays;

/**
 * 등수구하기
 * <p>
 * N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
 * 같은 점수가 입력될 경우 높은 등수로 동일 처리한다. 즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
 * <p>
 * ▣ 입력설명
 * 첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력 된다.
 * <p>
 * ▣ 출력설명
 * 입력된 순서대로 등수를 출력한다.
 * <p>
 * ▣ 입력예제 1
 * 5
 * 87 89 92 100 76
 * <p>
 * ▣ 출력예제 1
 * 4 3 2 1 5
 */

public class Array08 {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length];
        int count;
        for (int i = 0; i < answer.length; i++) {
            count = 1;
            for (int j = 0; j < answer.length; j++) {
                if (arr[i] < arr[j]) {
                    count++;
                }
            }
            answer[i] = count;
        }


        return answer;
    }

    public static void main(String[] args) {
        Array08 array = new Array08();
        int[] result = array.solution(new int[]{87, 89, 92, 100, 76});
//        int[] result = array.solution(new int[]{1, 1, 1, 1, 1});
        System.out.println("result = " + Arrays.toString(result));
    }
}
