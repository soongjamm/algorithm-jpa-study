package sort;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 좌표 정렬
 * <p>
 * N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요. 정렬기준은 먼저 x값에 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.
 * <p>
 * ▣ 입력설명
 * 첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
 * 두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.
 * <p>
 * ▣ 출력설명
 * N개의 좌표를 정렬하여 출력하세요.
 * <p>
 * ▣ 입력예제 1
 * 5
 * 2 7
 * 1 3
 * 1 2
 * 2 5
 * 3 6
 * <p>
 * ▣ 출력예제 1
 * 1 2
 * 1 3
 * 2 5
 * 2 7
 * 3 6
 */

public class Sort07 {

    static class Point implements Comparable {

        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(@NotNull Object o) {
            Point other = (Point) o;
            if (this.x == other.x) {
                return this.y - other.y;
            }
            return this.x - other.x;
        }

        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private List<Point> solution(int[][] input) {
        List<Point> list = new ArrayList<>();
        for (int[] ints : input) {
            list.add(new Point(ints[0], ints[1]));
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        Sort07 sort = new Sort07();
        List<Point> result = sort.solution(new int[][]{
                {2, 7},
                {1, 3},
                {1, 2},
                {2, 5},
                {3, 6}
        });
        System.out.println("result = " + result);
    }
}
