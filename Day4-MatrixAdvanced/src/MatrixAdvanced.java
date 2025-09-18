import java.util.Scanner;

public class MatrixAdvanced {

    // 1️⃣ Print the matrix
    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    // 2️⃣ Rotate matrix 90° clockwise
    static int[][] rotate90Clockwise(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] rotated = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][n - 1 - i] = matrix[i][j];
            }
        }
        return rotated;
    }

    // 3️⃣ Print matrix in spiral order
    static void printSpiral(int[][] matrix) {
        int top = 0, left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        System.out.println("Spiral Order:");
        while (top <= bottom && left <= right) {
            // Top row
            for (int i = left; i <= right; i++) System.out.print(matrix[top][i] + " ");
            top++;

            // Right column
            for (int i = top; i <= bottom; i++) System.out.print(matrix[i][right] + " ");
            right--;

            // Bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) System.out.print(matrix[bottom][i] + " ");
                bottom--;
            }

            // Left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) System.out.print(matrix[i][left] + " ");
                left++;
            }
        }
        System.out.println();
    }

    // 4️⃣ Sum of all submatrices of given size
    static void sumOfSubmatrices(int[][] matrix, int subRows, int subCols) {
        int totalSum = 0;
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i <= n - subRows; i++) {
            for (int j = 0; j <= m - subCols; j++) {
                int subSum = 0;
                for (int r = i; r < i + subRows; r++) {
                    for (int c = j; c < j + subCols; c++) {
                        subSum += matrix[r][c];
                    }
                }
                totalSum += subSum;
            }
        }
        System.out.println("Sum of all " + subRows + "x" + subCols + " submatrices: " + totalSum);
    }

    // 5️⃣ Input matrix from user
    static int[][] inputMatrix(Scanner sc) {
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = inputMatrix(sc);

        while (true) {
            System.out.println("\n--- Matrix Advanced Menu ---");
            System.out.println("1. Display Matrix");
            System.out.println("2. Rotate 90° Clockwise");
            System.out.println("3. Print Spiral Order");
            System.out.println("4. Sum of Submatrices");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> printMatrix(matrix);
                case 2 -> {
                    matrix = rotate90Clockwise(matrix);
                    System.out.println("Matrix rotated 90° clockwise.");
                    printMatrix(matrix);
                }
                case 3 -> printSpiral(matrix);
                case 4 -> {
                    System.out.print("Enter submatrix rows: ");
                    int subRows = sc.nextInt();
                    System.out.print("Enter submatrix columns: ");
                    int subCols = sc.nextInt();
                    sumOfSubmatrices(matrix, subRows, subCols);
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid option. Try again!");
            }
        }
    }
}

