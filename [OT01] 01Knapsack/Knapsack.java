import java.util.*;

public class Knapsack {

    static int knapSack(int W, int[] wt, int[] val, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (wt[n - 1] > W) {
            return knapSack(W, wt, val, n - 1);
        } else {
            return Math.max(knapSack(W, wt, val, n - 1), val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1));
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of items: ");
            int n = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Enter the profits of items (space-separated): ");
            int[] profit = Arrays.stream(sc.nextLine().split(" "))
                                 .mapToInt(Integer::parseInt)
                                 .toArray();

            System.out.print("Enter the weights of items (space-separated): ");
            int[] weight = Arrays.stream(sc.nextLine().split(" "))
                                 .mapToInt(Integer::parseInt)
                                 .toArray();

            System.out.print("Enter the maximum capacity of the knapsack: ");
            int W = sc.nextInt();

            System.out.println("Maximum profit: " + knapSack(W, weight, profit, n));
        }
    }
}
