import java.util.*;

public class Kadane {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Test Case Count: ");
            int t = sc.nextInt();
            sc.nextLine();

            while (t-- > 0) {
                System.out.print("Enter Array Elements (space-separated): ");
                String input = sc.nextLine();
                int[] arr = Arrays.stream(input.split(" "))
                                  .mapToInt(Integer::parseInt)
                                  .toArray();

                int total = arr[0];
                int tempTotal = arr[0];

                for (int i = 1; i < arr.length; i++) {
                    tempTotal = Math.max(arr[i], tempTotal + arr[i]);
                    total = Math.max(total, tempTotal);
                }

                System.out.println(total);
            }
        }
    }
}
