import java.util.Scanner;

public class MinSumPath {

    static int helper(int i, int j, int[][] matrix, int[][] dp) {
        if (i == 0 && j == 0)
            return matrix[0][0];
        if (i < 0 || j < 0)
            return Integer.MAX_VALUE;

        if (dp[i][j] != -1)
            return dp[i][j];

        int up = helper(i - 1, j, matrix, dp);
        int left = helper(i, j - 1, matrix, dp);

        dp[i][j] = matrix[i][j] + Math.min(up, left);
        return dp[i][j];
    }

    static int minSumPath(int n, int m, int[][] matrix) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                dp[i][j] = -1;

        return helper(n - 1, m - 1, matrix, dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int _ = 0; _ < t; _++) {
            System.out.print("Enter the number of rows in the matrix: ");
            int n = sc.nextInt();
            System.out.print("Enter the number of columns in the matrix: ");
            int m = sc.nextInt();

            int[][] matrix = new int[n][m];
            System.out.println("Enter the matrix row by row:");
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    matrix[i][j] = sc.nextInt();

            System.out.println("The minimum sum path is: " + minSumPath(n, m, matrix));
        }
        sc.close();
    }
}
