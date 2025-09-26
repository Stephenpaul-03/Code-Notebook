import java.util.*;

public class Max_product {
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

                int maxProduct = arr[0];
                int minProduct = arr[0];
                int total = arr[0];

                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] == 0) {
                        maxProduct = 1;
                        minProduct = 1;
                        continue;
                    }

                    if (arr[i] < 0) {
                        int temp = maxProduct;
                        maxProduct = minProduct;
                        minProduct = temp;
                    }

                    maxProduct = Math.max(arr[i], maxProduct * arr[i]);
                    minProduct = Math.min(arr[i], minProduct * arr[i]);

                    total = Math.max(total, maxProduct);
                }

                System.out.println(total);
            }
        } 
    }
}
