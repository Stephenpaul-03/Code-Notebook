import java.util.Scanner;

public class MaxOne {

    public static int maxOne(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int maxRow = -1;
        int currentRow = 0;
        int currentCol = col - 1;

        if (row == 0) return -1;
        if (col == 0) return -1;

        while (currentRow < row && currentCol >= 0) {
            if (arr[currentRow][currentCol] == 0) {
                currentRow++;
            } else {
                maxRow = currentRow;
                currentCol--;
            }
        }

        return maxRow;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt(); 
            while (t-- > 0) {
                int n = scanner.nextInt();
                int m = scanner.nextInt(); 
                int[][] arr = new int[n][m]; 

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        arr[i][j] = scanner.nextInt();
                    }
                }

                int result = maxOne(arr);
                System.out.println(result);
            }
        }
    }
}
