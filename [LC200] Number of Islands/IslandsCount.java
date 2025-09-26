import java.util.Scanner;

public class IslandsCount {

    static void dfs(int[][] grid, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;

        // Directions including diagonals
        dfs(grid, i + 1, j, n, m);     // Down
        dfs(grid, i - 1, j, n, m);     // Up
        dfs(grid, i, j + 1, n, m);     // Right
        dfs(grid, i, j - 1, n, m);     // Left
        dfs(grid, i + 1, j + 1, n, m); // Bottom-Right
        dfs(grid, i - 1, j - 1, n, m); // Top-Left
        dfs(grid, i + 1, j - 1, n, m); // Bottom-Left
        dfs(grid, i - 1, j + 1, n, m); // Top-Right
    }

    static int countIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    dfs(grid, i, j, n, m);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();

        for (int _ = 0; _ < t; _++) {
            System.out.print("Enter dimensions of the grid (rows and columns): ");
            int n = sc.nextInt();
            int m = sc.nextInt();

            System.out.println("Enter the grid (0s and 1s):");
            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            System.out.println("Number of islands: " + countIslands(grid));
        }
        sc.close();
    }
}
