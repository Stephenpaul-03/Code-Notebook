import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryRightView {

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    public void RightView(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();

                if (i == levelSize - 1) {
                    System.out.print(node.data + " ");
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    public Node buildTree() {
        Node localRoot;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the root node value: ");
            int rootValue = scanner.nextInt();
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
        BinaryRightView tree = new BinaryRightView();
        tree.root = tree.buildTree();
        System.out.println("Right view of the binary tree:");
        tree.RightView(tree.root);
    }
}
