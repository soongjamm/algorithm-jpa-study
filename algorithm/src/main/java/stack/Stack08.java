package stack;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 응급실
 * <p>
 * 메디컬 병원 응급실에는 의사가 한 명밖에 없습니다.
 * 응급실은 환자가 도착한 순서대로 진료를 합니다. 하지만 위험도가 높은 환자는 빨리 응급조치를 의사가 해야 합니다.
 * 이런 문제를 보완하기 위해 응급실은 다음과 같은 방법으로 환자의 진료순서를 정합니다.
 * • 환자가 접수한 순서대로의 목록에서 제일 앞에 있는 환자목록을 꺼냅니다.
 * • 나머지 대기 목록에서 꺼낸 환자 보다 위험도가 높은 환자가 존재하면 대기목록 제일 뒤로 다시 넣습니다.
 * 그렇지 않으면 진료를 받습니다.
 * 즉 대기목록에 자기 보다 위험도가 높은 환자가 없을 때 자신이 진료를 받는 구조입니다.
 * 현재 N명의 환자가 대기목록에 있습니다.
 * N명의 대기목록 순서의 환자 위험도가 주어지면, 대기목록상의 M번째 환자는 몇 번째로 진료 를 받는지 출력하는 프로그램을 작성하세요.
 * 대기목록상의 M번째는 대기목록의 제일 처음 환자를 0번째로 간주하여 표현한 것입니다.
 * <p>
 * ▣ 입력설명
 * 첫 줄에 자연수 N(5<=N<=100)과 M(0<=M<N) 주어집니다.
 * 두 번째 줄에 접수한 순서대로 환자의 위험도(50<=위험도<=100)가 주어집니다.
 * 위험도는 값이 높을 수록 더 위험하다는 뜻입니다. 같은 값의 위험도가 존재할 수 있습니다.
 * <p>
 * ▣ 출력설명
 * M번째 환자의 몇 번째로 진료받는지 출력하세요.
 * <p>
 * ▣ 입력예제 1
 * 5 2
 * 60 50 70 80 90
 * <p>
 * ▣ 출력예제 1
 * 3
 * <p>
 * ▣ 입력예제 2
 * 6 3
 * 70 60 90 60 60 60
 * <p>
 * ▣ 출력예제 2
 * 4
 */

public class Stack08 {

    static class Person implements Comparable {
        private int order;
        private int urgency;

        public Person(int order, int urgency) {
            this.order = order;
            this.urgency = urgency;
        }

        public int getOrder() {
            return order;
        }

        public int getUrgency() {
            return urgency;
        }

        @Override
        public int compareTo(@NotNull Object o) {
            Person other = (Person) o;
            if (this.urgency > other.urgency) {
                return -1;
            } else if (this.urgency == other.urgency) {
                if (this.order < other.getOrder()) {
                    return -1;
                }
                return 1;
            }
            return 1;
        }
    }

    public int solutionTreeSet(int order, int[] input) {
        int answer = 1;
        TreeSet<Person> q = new TreeSet<>();
        for (int i = 0; i < input.length; i++) {
            q.add(new Person(i, input[i]));
        }

        for (Person person : q) {
            if (person.getOrder() == order) {
                return answer;
            }
            answer++;
        }
        return answer;
    }

    public int solutionQueue(int order, int[] input) {
        int answer = 0;
        Queue<Person> q = new LinkedList<>();
        for (int i = 0; i < input.length; i++) {
            q.add(new Person(i, input[i]));
        }

        while (!q.isEmpty()) {
            Person poll = q.poll();
            for (Person person : q) {
                if (poll.urgency < person.getUrgency()) {
                    q.offer(poll);
                    poll = null;
                    break;
                }
            }
            if (poll != null) {
                answer++;
                if (poll.getOrder() == order) {
                    return answer;
                }
            }
        }
        return answer;
    }

    public int solution(int order, int[] input) {
        int treeSet = solutionTreeSet(order, input);
        int queue = solutionQueue(order, input);
        if (treeSet == queue) {
            return treeSet;
        }

        System.out.println("wrong");
        return queue;
    }

    public static void main(String[] args) {
        Stack08 stack = new Stack08();
        int result = stack.solution(2, new int[]{60, 50, 70, 80, 90});
        System.out.println("result = " + result);

        result = stack.solution(3, new int[]{70, 60, 90, 60, 60, 60});
        System.out.println("result = " + result);

        stack.solution(1, new int[]{19, 2359, 25, 23, 4, 53});
        stack.solution(5, new int[]{19, 213, 22, 115, 4, 123});
        stack.solution(6, new int[]{1125, 123, 123, 211, 5, 125, 2, 326, 2, 164, 16, 463, 345});
        stack.solution(10, new int[]{112, 1, 2, 3, 232, 12, 17, 6, 59, 125, 123, 123, 211, 5, 125, 2, 326, 2, 164, 16, 463, 345});
        stack.solution(0, new int[]{50,50});
        stack.solution(1, new int[]{50,50});

    }
}
