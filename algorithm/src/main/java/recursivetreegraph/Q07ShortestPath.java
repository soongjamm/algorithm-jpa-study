package recursivetreegraph;

/**
 * Tree 말단 노드까지의 가장 짧은 경로
 *
 * 아래 그림과 같은 이진트리에서 루트 노드 1에서 말단노드까지의 길이 중 가장 짧은 길이를 구하는 프로그램을 작성하세요.
 * 각 경로의 길이는 루트노드에서 말단노드까지 가는데 이동하는 횟수를 즉 간선(에지)의 개수를 길이로 하겠습니다.
 * 1
 * 2    3
 * 4 5
 * 가장 짧은 길이는 3번 노느까지의 길이인 1이다.
 */

public class Q07ShortestPath {

    static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public int dfs(Node node, int depth) {
        if (node.left == null && node.right == null) {
            return depth;
        }
        return Math.min(dfs(node.left, depth + 1), dfs(node.right, depth + 1));
    }

    public int solution() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        return dfs(root, 0);
    }


    public static void main(String[] args) {
        Q07ShortestPath recursive = new Q07ShortestPath();
        int result = recursive.solution();
        System.out.println("result = " + result);
    }
}
