import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class CheckBST {

    static int maxValue(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(node.data, Math.max(maxValue(node.left), maxValue(node.right)));
    }

    static int minValue(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(node.data, Math.min(minValue(node.left), minValue(node.right)));
    }

    static boolean checker(Node node) {
        if (node == null) {
            return true;
        }

        if (node.left != null && maxValue(node.left) >= node.data) {
            return false;
        }

        if (node.right != null && minValue(node.right) <= node.data) {
            return false;
        }

        return checker(node.left) && checker(node.right);
    }

    static Node build(String[] values) {
        if (values.length == 0 || values[0].equals("N")) {
            return null;
        }

        Node root = new Node(Integer.parseInt(values[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;

        while (index < values.length) {
            Node current = queue.poll();

            if (index < values.length && !values[index].equals("N")) {
                current.left = new Node(Integer.parseInt(values[index]));
                queue.offer(current.left);
            }
            index++;

            if (index >= values.length) break;

            if (!values[index].equals("N")) {
                current.right = new Node(Integer.parseInt(values[index]));
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of test cases: ");
        int t = Integer.parseInt(sc.nextLine().trim());

        for (int test = 1; test <= t; test++) {
            System.out.println("\nTest case " + test + ":");
            System.out.print("Enter level-order traversal (use 'N' for null nodes): ");
            String[] levelOrder = sc.nextLine().trim().split("\\s+");

            Node treeRoot = build(levelOrder);

            if (checker(treeRoot)) {
                System.out.println("This tree satisfies the Binary Search Tree (BST) property.");
            } else {
                System.out.println("This tree does NOT satisfy the BST property.");
            }
        }

        sc.close();
    }
}
