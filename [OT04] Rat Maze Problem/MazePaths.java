import java.util.*;

public class MazePaths {

    static String direction = "DLRU";
    static int[] DR = { 1, 0, 0, -1 };
    static int[] DC = { 0, -1, 1, 0 };

    static boolean check_validity(int row, int col, int n, int[][] maze) {
        return row >= 0 && col >= 0 && row < n && col < n && maze[row][col] == 1;
    }

    static void path_finder(int row, int col, int[][] maze, int n, ArrayList<String> ans, StringBuilder currentPath) {
        if (row == n - 1 && col == n - 1) {
            ans.add(currentPath.toString());
            return;
        }

        maze[row][col] = 0;

        for (int i = 0; i < 4; i++) {
            int nextrow = row + DR[i];
            int nextcol = col + DC[i];

            if (check_validity(nextrow, nextcol, n, maze)) {
                currentPath.append(direction.charAt(i));
                path_finder(nextrow, nextcol, maze, n, ans, currentPath);
                currentPath.deleteCharAt(currentPath.length() - 1);
            }
        }

        maze[row][col] = 1;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of test cases: ");
            int t = scanner.nextInt();
            scanner.nextLine(); 

            for (int testCase = 0; testCase < t; testCase++) {
                System.out.print("Enter the size of the maze (n): ");
                int n = scanner.nextInt();
                scanner.nextLine();

                int[][] maze = new int[n][n];
                System.out.println("Enter the maze rows:");

                for (int i = 0; i < n; i++) {
                    maze[i] = Arrays.stream(scanner.nextLine().split(" "))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();
                }

                ArrayList<String> res = new ArrayList<>();
                StringBuilder current_path = new StringBuilder();

                if (maze[0][0] != 0 && maze[n - 1][n - 1] != 0) {
                    path_finder(0, 0, maze, n, res, current_path);
                }

                if (res.isEmpty())
                    System.out.println(-1);
                else {
                    System.out.print("Paths for test case " + (testCase + 1) + ": ");
                    for (String path : res) {
                        System.out.print(path + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
