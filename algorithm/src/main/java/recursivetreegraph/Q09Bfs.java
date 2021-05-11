package recursivetreegraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 송아지 찾기(BFS : 상태트리탐색)
 * <p>
 * 현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
 * 현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음 과 같은 방법으로 이동한다.
 * 송아지는 움직이지 않고 제자리에 있다.
 * 현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
 * 최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성 하세요.
 * <p>
 * ▣ 입력설명
 * 첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000 까지이다.
 * <p>
 * ▣ 출력설명
 * 점프의 최소횟수를 구한다. 답은 1이상입니다.
 * <p>
 * ▣ 입력예제 1
 * 5 14
 * <p>
 * ▣ 출력예제 1
 * 3
 * <p>
 * ▣ 입력예제 2
 * 8 3
 * <p>
 * ▣ 출력예제 2
 * 5
 */

public class Q09Bfs {
    static class Pos {
        private int pos;
        private int count;

        public Pos(int pos, int count) {
            this.pos = pos;
            this.count = count;
        }

        public int getPos() {
            return pos;
        }

        public int getCount() {
            return count;
        }
    }

    public int solution(int hyunsoo, int calf) {
        int[] move = {1, -1, 5};
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(hyunsoo, 0));

        while (!q.isEmpty()) {
            Pos pos = q.poll();
            if (pos.getPos() == calf) {
                return pos.getCount();
            }
            for (int i = 0; i < move.length; i++) {
                int tmp = pos.getPos() + move[i];
                q.add(new Pos(tmp, pos.getCount() + 1));
            }
        }

        return -1;
    }

    public int solution2(int hyunsoo, int calf) {
        int[] move = {1, -1, 5};
        Queue<Integer> q = new LinkedList<>();
        q.add(hyunsoo);

        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int l = 0; l < size; l++) {
                int pos = q.poll();
                if (pos == calf) {
                    return count;
                }
                for (int i = 0; i < move.length; i++) {
                    int tmp = pos + move[i];
                    q.add(tmp);
                }
            }
            count++;
        }

        return -1;
    }


    public static void main(String[] args) {
        Q09Bfs subset = new Q09Bfs();
        int result = subset.solution2(5, 14);
        System.out.println("result = " + result);

        result = subset.solution2(8, 3);
        System.out.println("result = " + result);
    }
}
