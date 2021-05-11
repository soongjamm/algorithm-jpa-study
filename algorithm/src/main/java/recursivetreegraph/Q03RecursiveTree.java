package recursivetreegraph;

/**
 * Recursive02이진트리 순회(깊이우선탐색)
 * 아래 그림과 같은 이진트리를 전위순회와 후위순회를 연습해보세요.
 * 1
 * 2       3
 * 4 5     6 7
 * 전위순회 출력 : 1 2 4 5 3 6 7
 * 중위순회 출력 : 4 2 5 1 6 3 7
 * 후위순회 출력 : 4 5 2 6 7 3 1
 */

public class Q03RecursiveTree {

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

        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
    }

    private void print(Node node) {
        System.out.print(node.data + " ");
    }

    public void preorder(Node node) {
        if(node == null) {
            return;
        }
        print(node);
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder(Node node) {
        if(node == null) {
            return;
        }
        inorder(node.left);
        print(node);
        inorder(node.right);
    }

    public void postorder(Node node) {
        if(node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        print(node);
    }

    public static void main(String[] args) {
        Q03RecursiveTree recursive = new Q03RecursiveTree();
        recursive.solution();
    }
}
