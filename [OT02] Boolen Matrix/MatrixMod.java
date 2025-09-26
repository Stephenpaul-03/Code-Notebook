import java.util.Scanner;

public class MatrixMod {
    public static void Modify(int mat[][]) {
        boolean row_flag = false;
        boolean col_flag = false;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i == 0 && mat[i][j] == 1)
                    row_flag = true;

                if (j == 0 && mat[i][j] == 1)
                    col_flag = true;

                if (mat[i][j] == 1) {
                    mat[0][j] = 1;
                    mat[i][0] = 1;
                }
            }
        }

        for (int i = 1; i < mat.length; i++)
            for (int j = 1; j < mat[0].length; j++)
                if (mat[0][j] == 1 || mat[i][0] == 1)
                    mat[i][j] = 1;

        if (row_flag == true)
            for (int i = 0; i < mat[0].length; i++)
                mat[0][i] = 1;

        if (col_flag == true)
            for (int[] mat1 : mat) {
            mat1[0] = 1;
        }
    }

    public static void Print(int mat[][]) {
        for (int[] mat1 : mat) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat1[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
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

                int[][] mat = new int[n][m];

                for (int i = 0; i < n; i++) {
                    String[] values = rows[i].split(" ");
                    for (int j = 0; j < m; j++) {
                        mat[i][j] = Integer.parseInt(values[j]);
                    }
                }

                Modify(mat);
                Print(mat);
            }
        } 
    }
}
