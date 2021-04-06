package array;

import java.util.Arrays;

/**
 * 격자판 최대합
 * <p>
 * 5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
 * 10 12 11 19 19
 * 13 39 25 27 13
 * 10 30 50 29 30
 * 12 23 53 37 13
 * 15 11 15 27 19
 * N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합 니다.
 * <p>
 * ▣ 입력설명
 * 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
 * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는 다.
 * <p>
 * ▣ 출력설명 최대합을 출력합니다.
 * <p>
 * ▣ 입력예제 1
 * 5
 * 10 13 10 12 15
 * 12 39 30 23 11
 * 11 25 50 53 15
 * 19 27 29 37 27
 * 19 13 30 13 19
 * <p>
 * ▣ 출력예제 1
 * 155
 */

public class Array09 {
    public int solution(int[][] arr) {
        int answer = 0;
        for (int i = 0; i < arr.length; i++) { // 가로, 세로 확인
            int a = 0;
            int b = 0;
            for (int j = 0; j < arr.length; j++) {
                a += arr[i][j];
                b += arr[j][i];
            }
            answer = Math.max(answer, Math.max(a, b));
        }

        int a = 0;
        int b = 0;
        for (int i = 0; i < arr.length; i++) {
            a += arr[i][i];
            b += arr[i][arr.length - 1 - i];
        }
        answer = Math.max(answer, Math.max(a, b));

        return answer;
    }

    public static void main(String[] args) {
        Array09 array = new Array09();
        int result = array.solution(new int[][]{
                {10, 13, 10, 12, 15},
                {12, 39, 30, 23, 11},
                {11, 25, 50, 53, 15},
                {19, 27, 29, 37, 27},
                {19, 13, 30, 13, 19}
        });
        System.out.println("result = " + result);
    }
}
