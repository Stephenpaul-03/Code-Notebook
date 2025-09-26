import java.util.Scanner;

public class Jump2 {

    public static int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;
        if (arr[0] == 0) return -1;

        int jumps = 1;
        int maxReach = arr[0];
        int steps = arr[0];

        for (int i = 1; i < n; i++) {
            if (i == n - 1) return jumps;

            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;

            if (steps == 0) {
                jumps++;
                if (i >= maxReach) return -1;
                steps = maxReach - i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            System.out.print("Enter array elements: ");
            sc.nextLine();  // consume newline
            String[] parts = sc.nextLine().split(" ");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }

            int result = minJumps(arr);
            if (result == -1) {
                System.out.println("Cannot reach the end of the array.");
            } else {
                System.out.println("Minimum number of jumps: " + result);
            }
        }

        sc.close();
    }
}
