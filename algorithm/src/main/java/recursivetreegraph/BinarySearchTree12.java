package recursivetreegraph;

/**
 * 이진검색트리(BST : Binary Search Tree)
 * 아래와 같은 이진검색트리에서 특정 숫자를 검색하는 프로그램을 작성해보세요.
 * 이진검색트리에서 특정숫자를 찾는데 몇 번의 비교를 했는지 출력해보세요.
 * 만약 아래와 같은 이진트리에서 24를 찾는다면 2번의 비교를 통해 찾을 수 있고, 15를 찾는다면 4번의 비교를 해야 합니다.
 * <p>
 * 23
 * 12               24
 * 7        17
 * 15 20
 */

public class BinarySearchTree12 {

    private int target;

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

    }

    public void solution(int target) {
        this.target = target;
        Node root = new Node(23);
        root.left = new Node(12);
        root.right = new Node(24);
        root.left.left = new Node(7);
        root.left.right = new Node(17);
        root.left.right.left = new Node(15);
        root.left.right.right = new Node(20);

        dfs(root, 1);
    }

    private void dfs(Node node, int depth) {
        if (node == null) {
            System.out.println("not found");
            return;
        }
        if (node.value == target) {
            System.out.println(depth);
            return;
        }
        if (target < node.value) {
            dfs(node.left, depth+1);
        }
        if (target > node.value) {
            dfs(node.right, depth+1);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree12 subset = new BinarySearchTree12();
        subset.solution(24);
        subset.solution(15);
    }
}
