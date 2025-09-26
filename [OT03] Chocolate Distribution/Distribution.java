import java.util.*;

public class Distribution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            scanner.nextLine(); 
            
            while(t-- > 0){
                // Read the array
                int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                                  .mapToInt(Integer::parseInt)
                                  .toArray();

                int m = scanner.nextInt();
                scanner.nextLine();

                if (m > arr.length) {
                    System.out.println("-1");
                } else {
                    Arrays.sort(arr);
                    int min_diff = Integer.MAX_VALUE;

                    for (int i = 0; i <= arr.length - m; i++) {
                        int diff = arr[i + m - 1] - arr[i];
                        min_diff = Math.min(min_diff, diff);
                    }

                    System.out.println(min_diff);
                }
            }
        }
    }
}
