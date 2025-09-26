import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Test Case Count: ");
            int t = sc.nextInt();
            sc.nextLine();
            
            while (t-- > 0) {
                int[] arr = Arrays.stream(sc.nextLine().split(" "))
                                  .mapToInt(Integer::parseInt)
                                  .toArray();

                int s = sc.nextInt();
                sc.nextLine();
                int n = arr.length;
                Arrays.sort(arr);
                boolean flag = false;
                for (int i = 0; i < n - 2; i++) {
                    int left = i + 1;
                    int right = n - 1;

                    while (left < right) {
                        int sum = arr[i] + arr[left] + arr[right];
                        if (sum == s) {
                            System.out.println(arr[i] + " " + arr[left] + " " + arr[right]);
                            flag = true;
                            break;
                        } else if (sum < s) {
                            left += 1;
                        } else {
                            right -= 1;
                        }
                    }

                    if (flag) {
                        break;  
                    }
                }

                if (!flag) {
                    System.out.println("false");
                }
            }
        }
    }
}
