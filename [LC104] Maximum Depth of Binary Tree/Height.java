import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Height {

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    public int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public Node buildTree() {
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
        Height tree = new Height();
        tree.root = tree.buildTree();

        System.out.println("Maximum depth of the tree: " + tree.maxDepth(tree.root));
    }
}
