package recursivetreegraph;

import java.util.ArrayList;

/**
 * 경로 탐색(인접리스트)
 * <p>
 * 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프 로그램을 작성하세요.
 * 아래 그래프에서 (방향있음)
 * 125
 * 34
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

public class SearchPath11 {

    ArrayList<ArrayList<Integer>> map;
    boolean[] visit;
    int destination;
    int answer = 0;

    public int solution(int destination, int[][] paths) {
        this.destination = destination-1;
        map = new ArrayList<>();
        visit = new boolean[destination];

        // 지도 설정
        for (int i = 0; i < destination; i++) {
            map.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            map.get(path[0]-1).add(path[1]-1);
        }

        // 1 = 출발지
        visit[0] = true;
        for (Integer start : map.get(0)) {
            dfs(start);
        }

        return answer;
    }

    private void dfs(int to) {
        visit[to] = true;
        if (to == destination) {
            answer++;
        } else {
            for (Integer i : map.get(to)) {
                if (!visit[i]) {
                    dfs(i);
                }
            }
        }
        visit[to] = false;
    }

    public static void main(String[] args) {
        SearchPath11 subset = new SearchPath11();
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
