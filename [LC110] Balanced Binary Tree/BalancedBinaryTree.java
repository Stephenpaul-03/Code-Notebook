import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BalancedBinaryTree {

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    public boolean balanced(Node node) {
        int left, right;
        if (node == null)
            return true;
        left = height(node.left);
        right = height(node.right);
        return Math.abs(left - right) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public int height(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public Node TreeBuild() {
        Node localRoot;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the root node value: ");
            int rootValue = scanner.nextInt();
            if (rootValue == -1) return null;
            localRoot = new Node(rootValue);
            Queue<Node> queue = new LinkedList<>();
            queue.add(localRoot);

            while (!queue.isEmpty()) {
                Node current = queue.poll();

                System.out.print("Enter left child of " + current.data + " (or -1 if no left child): ");
                int leftValue = scanner.nextInt();
                if (leftValue != -1) {
                    current.left = new Node(leftValue);
                    queue.add(current.left);
                }

                System.out.print("Enter right child of " + current.data + " (or -1 if no right child): ");
                int rightValue = scanner.nextInt();
                if (rightValue != -1) {
                    current.right = new Node(rightValue);
                    queue.add(current.right);
                }
            }
        }
        return localRoot;
    }

    public static void main(String[] args) {
        BalancedTree tree = new BalancedTree();
        tree.root = tree.TreeBuild();

        if (tree.balanced(tree.root)) {
            System.out.println("Tree is balanced");
        } else {
            System.out.println("Tree is not balanced");
        }
    }
}
