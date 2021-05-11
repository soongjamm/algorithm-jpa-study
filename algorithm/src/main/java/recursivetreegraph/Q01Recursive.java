package recursivetreegraph;

/**
 * 재귀함수
 * <p>
 * 자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하세요.
 * <p>
 * ▣ 입력설명
 * 첫 번째 줄은 정수 N(3<=N<=10)이 입력된다.
 * <p>
 * ▣ 출력설명
 * 첫째 줄에 출력한다.
 * <p>
 * ▣ 입력예제 1
 * 3
 * <p>
 * ▣ 출력예제 1
 * 1 2 3
 */

public class Q01Recursive {
    public void solution(int n) {
        dfs(n);
        System.out.println();
    }

    public void dfs(int n) {
        if (n <= 0) {
            return;
        }
        dfs(n-1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        Q01Recursive recursive = new Q01Recursive();
        recursive.solution(3);
    }
}
