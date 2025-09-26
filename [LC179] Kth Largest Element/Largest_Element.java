import java.util.*;

public class Largest_Element {

    public static int elementFinder(int[] arr, int n) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(); // Min heap

        for (int num : arr) {
            heap.offer(num);
            if (heap.size() > n) {
                heap.poll();
            }
        }

        return heap.peek(); // nth largest element
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int _ = 0; _ < t; _++) {
            String[] parts = sc.nextLine().split(" ");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
            int n = Integer.parseInt(sc.nextLine().trim());

            System.out.println(elementFinder(arr, n));
        }

        sc.close();
    }
}
