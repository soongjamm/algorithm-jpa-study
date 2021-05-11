package recursivetreegraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 경로 탐색(인접행렬)
 * <p>
 * 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프 로그램을 작성하세요.
 * 아래 그래프에서 (방향있음)
 * 125
 * 34
 * <p>
 * 1번 정점에서 5번 정점으로 가는 가지 수는
 * 12345
 * 125
 * 13425
 * 1345
 * 1425
 * 145
 * 총 6 가지입니다.
 * <p>
 * ▣ 입력설명
 * 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연 결정보가 주어진다.
 * <p>
 * ▣ 출력설명
 * 총 가지수를 출력한다.
 * <p>
 * ▣ 입력예제 1
 * 5 9
 * 1 2
 * 1 3
 * 1 4
 * 2 1
 * 2 3
 * 2 5
 * 3 4
 * 4 2
 * 4 5
 * <p>
 * ▣ 출력예제 1
 * 6
 */

public class SearchPath10 {

    int[][] map;
    boolean[] visit;
    int destination;
    int answer = 0;

    public int solution(int destination, int[][] paths) {
        this.destination = destination;
        map = new int[destination + 1][destination + 1];
        visit = new boolean[destination + 1];

        // 지도 설정
        for (int[] path : paths) {
            int from = path[0];
            int to = path[1];
            map[from][to] = 1;
        }

        // 1 = 출발지
        visit[1] = true;
        for (int i = 1; i < visit.length; i++) {
            if (map[1][i] == 1) {
                dfs(i);
            }
        }

        return answer;
    }

    private void dfs(int to) {
        visit[to] = true;
        if (to == destination) {
            answer++;
        } else {
            for (int i = 1; i < visit.length; i++) {
                if (map[to][i] == 1 && !visit[i]) {
                    dfs(i);
                }
            }
        }
        visit[to] = false;
    }

    public static void main(String[] args) {
        SearchPath10 subset = new SearchPath10();
        int result = subset.solution(5, new int[][]{
                {1, 2},
                {1, 3},
                {1, 4},
                {2, 1},
                {2, 3},
                {2, 5},
                {3, 4},
                {4, 2},
                {4, 5}
        });
        System.out.println("result = " + result);

    }
}
