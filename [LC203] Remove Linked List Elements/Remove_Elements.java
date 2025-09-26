import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

public class DeleteInLinkedList {

    public static Node delete(Node head, int key) {
        Node curr = head, prev = null;

        while (curr != null) {
            if (curr.data == key) {
                if (prev == null) {
                    head = curr.next;
                } else {
                    prev.next = curr.next;
                }
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    public static Node build(int[] values) {
        if (values.length == 0)
            return null;
        Node head = new Node(values[0]);
        Node current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }
        return head;
    }

    public static void printList(Node head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null)
                System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        for (int test = 1; test <= t; test++) {
            System.out.println("\nTest case " + test + ":");
            String[] parts = sc.nextLine().trim().split("\\s+");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
            Node head = build(arr);

            int key = Integer.parseInt(sc.nextLine().trim());
            head = delete(head, key);
            printList(head);
        }
        sc.close();
    }
}
