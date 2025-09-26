import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class Palindrome_list {
    boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int left = 0;
        int right = list.size() - 1;
        while (left < right && list.get(left).equals(list.get(right))) {
            left++;
            right--;
        }
        return left >= right;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < t; i++) {
                int[] values = Arrays.stream(sc.nextLine().split(" "))
                                     .mapToInt(Integer::parseInt)
                                     .toArray();

                ListNode head = constructLinkedList(values);

                Palindrome_list solution = new Palindrome_list();
                boolean result = solution.isPalindrome(head);

                System.out.println(result ? "Palindrome" : "Not Palindrome");
            }
        }
    }

    private static ListNode constructLinkedList(int[] values) {
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }
}
