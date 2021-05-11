package dfsbfs;

import java.util.Arrays;

/**
 * 합이 같은 부분집합(DFS : 아마존 인터뷰)
 * <p>
 * N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때 두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.
 * 둘로 나뉘는 두 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어 합니다.
 * 예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이 16으로 같은 경우가 존재하는 것을 알 수 있다.
 * <p>
 * ▣ 입력설명
 * 첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
 * 두 번째 줄에 집합의 원소 N개가 주어진다. 각 원소는 중복되지 않는다.
 * <p>
 * ▣ 출력설명
 * 첫 번째 줄에 “YES" 또는 ”NO"를 출력한다.
 * <p>
 * ▣ 입력예제 1
 * 6
 * 1 3 5 6 7 10
 * ▣ 출력예제 1
 * YES
 */
public class DFSBFS01 {
    private boolean[] visit;
    private int size;
    private String answer = "NO";
    private int[] arr;

    int total;

    public void dfs2(int depth, int sum) {
        if (answer.equals("YES")) {
            return;
        }
        if (sum > total / 2) {
            return;
        }
        if (depth == size) {
            if (sum == (total - sum)) {
                answer = "YES";
            }
        } else {
            dfs2(depth + 1, sum + arr[depth]);
            dfs2(depth + 1, sum);
        }

    }

    public void dfs(int depth) {
        if (answer.equals("YES")) {
            return;
        }

        if (depth == size) {
            check();
            return;
        }

        visit[depth] = true;
        dfs(depth + 1);
        visit[depth] = false;
        dfs(depth + 1);

    }

    private void check() {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < size; i++) {
            if (visit[i]) {
                sum1 += arr[i];
                continue;
            }
            sum2 += arr[i];
        }
        if (sum1 == sum2) {
            answer = "YES";
        }
    }

    private String solution(int[] input) {
        arr = input;
        size = input.length;
        visit = new boolean[size];
        dfs(0);

        total = Arrays.stream(input).sum();
        dfs2(0, 0);

        return answer;
    }

    public static void main(String[] args) {
        DFSBFS01 q = new DFSBFS01();
        String result = q.solution(new int[]{1, 3, 5, 6, 7, 10});
        System.out.println("result = " + result);
    }
}
