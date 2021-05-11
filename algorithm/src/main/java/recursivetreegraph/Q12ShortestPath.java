package recursivetreegraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 그래프 최단거리(BFS)
 * <p>
 * 다음 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력하세요. (방향그래프)
 * 125
 * 346
 * <p>
 * ▣ 입력설명
 * 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연 결정보가 주어진다.
 * <p>
 * ▣ 출력설명
 * 1번 정점에서 각 정점으로 가는 최소 간선수를 2번 정점부터 차례대로 출력하세요.
 * <p>
 * ▣ 입력예제 1
 * 6 9
 * 1 3
 * 1 4
 * 2 1
 * 2 5
 * 3 4
 * 4 5
 * 4 6
 * 6 2
 * 6 5
 * <p>
 * ▣ 출력예제 1
 * 2:3
 * 3:1
 * 4:1
 * 5:2
 * 6:2
 */

public class Q12ShortestPath {

    ArrayList<ArrayList<Integer>> map;
    boolean[] visit;

    public void solution(int nodeCount, int[][] paths) {
        map = new ArrayList<>();

        // 지도 설정
        for (int i = 0; i < nodeCount; i++) {
            map.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            map.get(path[0] - 1).add(path[1] - 1);
        }

        for (int target = 1; target < nodeCount; target++) {
            visit = new boolean[nodeCount];
            bfs(target);
        }

    }

    public void bfs(int destination) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        int count = 0;
        visit[0] = true;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int tmp = q.poll();
                visit[tmp] = true;
                if(tmp == destination) {
                    System.out.println(destination + " : " + count);
                    return;
                }
                for (Integer j : map.get(tmp)) {
                    if (!visit[j]) {
                        q.add(j);
                    }
                }
            }
            count++;
        }

    }


    public static void main(String[] args) {
        Q12ShortestPath subset = new Q12ShortestPath();
        subset.solution(6, new int[][]{
                {1, 3},
                {1, 4},
                {2, 1},
                {2, 5},
                {3, 4},
                {4, 5},
                {4, 6},
                {6, 2},
                {6, 5}
        });

    }
}
