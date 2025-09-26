import java.util.*;

class Change {
    static int count(int coins[], int n, int sum) {
        if (sum == 0)
            return 1;
        if (sum < 0)
            return 0;
        if (n <= 0)
            return 0;

        return count(coins, n - 1, sum) + count(coins, n, sum - coins[n - 1]);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            sc.nextLine();
            
            for (int i = 0; i < t; i++) {
                int[] arr = Arrays.stream(sc.nextLine().split(" "))
                                   .mapToInt(Integer::parseInt)
                                   .toArray();
                int sum = sc.nextInt();
                sc.nextLine();
                int n = arr.length;
                System.out.println(count(arr, n, sum));
                
            }
        }
    }
}
