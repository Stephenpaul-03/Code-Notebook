import java.util.Scanner;

public class Stock2 {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] prices = new int[n];
            for (int j = 0; j < n; j++) {
                prices[j] = sc.nextInt();
            }
            System.out.println(maxProfit(prices));
        }

        sc.close();
    }
}
