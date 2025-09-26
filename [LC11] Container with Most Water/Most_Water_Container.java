import java.util.*;

public class Most_Water_Container {
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

                int left = 0;
                int right = arr.length - 1;
                int max_area = 0;

                while (left < right) {
                    int width = right - left;
                    int height = Math.min(arr[left], arr[right]);
                    int area = width * height;

                    max_area = Math.max(area, max_area);

                    if (arr[left] < arr[right]) {
                        left += 1;
                    } else {
                        right -= 1; 
                    }
                }

                System.out.println(max_area);
            }
        } 
    }
}
