package recursivetreegraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 이진트리 순회(넓이우선탐색 : 레벨탐색)
 * <p>
 * 아래 그림과 같은 이진트리를 레벨탐색 연습하세요.
 * 1
 * 23
 * 4567
 * 레벨 탐색 순회 출력 : 1 2 3 4 5 6 7
 */

public class Q04RecursiveTree {

    static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public void solution() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                Node poll = q.poll();
                System.out.print(poll.data + " ");
                if (poll.left != null) {
                    q.add(poll.left);
                }
                if (poll.left != null) {
                    q.add(poll.right);
                }
            }
        }
    }


    public static void main(String[] args) {
        Q04RecursiveTree recursive = new Q04RecursiveTree();
        recursive.solution();
    }
}
