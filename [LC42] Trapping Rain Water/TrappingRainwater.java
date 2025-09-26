import java.util.*;

public class TrappingRainwater {

    public static int trap(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        int n = arr.length;
        int left = 0, right = n - 1;
        int left_max = 0, right_max = 0;
        int waterTrapped = 0;

        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= left_max) {
                    left_max = arr[left];
                } else {
                    waterTrapped += left_max - arr[left];
                }
                left++;
            } else {
                if (arr[right] >= right_max) {
                    right_max = arr[right];
                } else {
                    waterTrapped += right_max - arr[right];
                }
                right--;
            }
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt(); 
            scanner.nextLine(); 

            for (int i = 0; i < t; i++) {
                String input = scanner.nextLine();  
                int[] arr = Arrays.stream(input.split(" "))
                                  .mapToInt(Integer::parseInt)  
                                  .toArray(); 
                System.out.println(trap(arr));
            }
        }
    }
}
