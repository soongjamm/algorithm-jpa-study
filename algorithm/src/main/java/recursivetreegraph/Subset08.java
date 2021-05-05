package recursivetreegraph;

/**
 * 부분집합 구하기(DFS)
 *
 * 자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램 을 작성하세요.
 *
 * ▣ 입력설명
 * 첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
 *
 * ▣ 출력설명
 * 첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래와 출력예제와 같은 순서로 출력한다. 단 공집합은 출력하지 않습니다.
 *
 * ▣ 입력예제 1
 * 3
 *
 * ▣ 출력예제 1
 * 1 2 3
 * 1 2
 * 1 3
 * 1 2
 * 3
 * 2
 * 3
 */

public class Subset08 {

    boolean[] possible;
    StringBuilder str;
    int n;

    // n = 3 일때
    // 각 depth가 활성화 됬을때, 안됬을때로 나누어서 분기(dfs)
    public void dfs(int depth) {
        if (depth > n) {
            for (int i = 1; i < possible.length; i++) {
                if (possible[i]) {
                    str.append(i + " ");
                }
            }
            if (str.toString().length() > 0) {
                System.out.println(str);
            }
            str.delete(0, str.length());
            return;
        }

        possible[depth] = true;
        dfs(depth+1);
        possible[depth] = false;
        dfs(depth+1);

    }

    // n = 부분집합 최대 원소 개수
    public void solution(int n) {
        this.n = n;
        possible = new boolean[n+1];
        str = new StringBuilder();
        dfs(1);
    }


    public static void main(String[] args) {
        Subset08 subset = new Subset08();
        subset.solution(3);
    }
}
