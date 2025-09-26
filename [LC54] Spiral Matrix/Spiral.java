import java.util.*;

class Spiral {
    public static void Print(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            sc.nextLine();

            while (t-- > 0) {
                StringBuilder matrixInput = new StringBuilder();
                while (sc.hasNextLine()) {
                    String line = sc.nextLine().trim();
                    if (line.isEmpty()) break;
                    matrixInput.append(line).append("\n");
                }

                String[] rows = matrixInput.toString().split("\n");

                int n = rows.length;
                int m = rows[0].split(" ").length;

                int[][] matrix = new int[n][m];

                int i = 0;
                for (String row : rows) {
                    String[] values = row.split(" ");
                    int j = 0;
                    for (String value : values) {
                        matrix[i][j++] = Integer.parseInt(value);
                    }
                    i++;
                }

                Print(matrix);
            }
        }
    }
}
