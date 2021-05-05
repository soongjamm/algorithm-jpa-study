package recursivetreegraph;

import java.util.Arrays;

/**
 * 피보나치 수열
 * <p>
 * 1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
 * 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
 * <p>
 * ▣ 입력설명
 * 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
 * <p>
 * ▣ 출력설명
 * 첫 줄에 피보나치 수열을 출력합니다.
 * <p>
 * ▣ 입력예제 1
 * 10
 * <p>
 * ▣ 출력예제 1
 * 1 1 2 3 5 8 13 21 34 55
 */

public class Fibonacci06 {

    static int[] mem;

    public int memoization(int n) {
        if (mem[n] != 0) {
            return mem[n];
        }
        return dfs(n - 1) + dfs(n - 2);
    }

    public int dfs(int n) {
        if (n <= 1) {
            return 1;
        }
        return dfs(n - 1) + dfs(n - 2);
    }

    public int[] solution(int n) {
        mem = new int[n];
        mem[0] = 1;
        mem[1] = 1;

        long s = System.nanoTime();
        for (int i = 0; i < n; i++) {
            dfs(i);
        }
        long e = System.nanoTime();
        System.out.println("took = " + (e - s));

        s = System.nanoTime();
        for (int i = 0; i < n; i++) {
            mem[i] = memoization(i);
        }
        e = System.nanoTime();
        System.out.println("took = " + (e - s)+ " nano");

        return mem;
    }


    public static void main(String[] args) {
        Fibonacci06 fibonacci = new Fibonacci06();
        int[] result = fibonacci.solution(25);
        System.out.println("result = " + Arrays.toString(result));
    }
}
