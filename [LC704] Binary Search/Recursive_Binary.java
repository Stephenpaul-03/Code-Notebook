import java.util.*;

public class Recursive_Binary {

    public static int recursiveBinary(int[] arr, int low, int high, int key) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;

        if (arr[mid] == key) {
            return mid;
        }

        if (arr[low] <= arr[mid]) {
            if (arr[low] <= key && key < arr[mid]) {
                return recursiveBinary(arr, low, mid - 1, key);
            } else {
                return recursiveBinary(arr, mid + 1, high, key);
            }
        }
        else {
            if (arr[mid] < key && key <= arr[high]) {
                return recursiveBinary(arr, mid + 1, high, key);
            } else {
                return recursiveBinary(arr, low, mid - 1, key);
            }
        }
    }

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

                System.out.print("Enter Key: ");
                int key = sc.nextInt();
                sc.nextLine(); 

                int result = recursiveBinary(arr, 0, arr.length - 1, key);

                if (result != -1) {
                    System.out.println(result);
                } else {
                    System.out.println("-1");
                }
            }
        }
    }
}
