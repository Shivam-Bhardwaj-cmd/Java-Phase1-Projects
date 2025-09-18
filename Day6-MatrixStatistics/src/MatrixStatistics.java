import java.util.Scanner;

public class MatrixStatistics {

    // Scanner for input
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Matrix Analyzer: Statistics & Pattern Analysis ===");

        int[][] matrix = inputMatrix();
        boolean exit = false;

        while (!exit) {
            showMenu();
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> displayMatrix(matrix);
                case 2 -> rowWiseSum(matrix);
                case 3 -> columnWiseSum(matrix);
                case 4 -> rowWiseMax(matrix);
                case 5 -> columnWiseMax(matrix);
                case 6 -> countPrimes(matrix);
                case 7 -> checkDiagonalDominance(matrix);
                case 8 -> compareRowColumnSums(matrix);
                case 9 -> exit = true;
                default -> System.out.println("Invalid choice. Try again!");
            }
        }
        System.out.println("Exiting Matrix Analyzer. Goodbye!");
    }

    // Input matrix from user
    public static int[][] inputMatrix() {
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("Enter matrix elements (row by row):");
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = sc.nextInt();

        return matrix;
    }

    // Display the matrix
    public static void displayMatrix(int[][] matrix) {
        System.out.println("Matrix:");
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + "\t");
            System.out.println();
        }
    }

    // Row-wise sum
    public static void rowWiseSum(int[][] matrix) {
        System.out.println("Row-wise Sum:");
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int val : matrix[i]) sum += val;
            System.out.println("Row " + i + ": " + sum);
        }
    }

    // Column-wise sum
    public static void columnWiseSum(int[][] matrix) {
        System.out.println("Column-wise Sum:");
        int cols = matrix[0].length;
        for (int j = 0; j < cols; j++) {
            int sum = 0;
            for (int[] row : matrix) sum += row[j];
            System.out.println("Column " + j + ": " + sum);
        }
    }

    // Row-wise maximum
    public static void rowWiseMax(int[][] matrix) {
        System.out.println("Row-wise Maximum:");
        for (int i = 0; i < matrix.length; i++) {
            int max = matrix[i][0];
            for (int val : matrix[i])
                if (val > max) max = val;
            System.out.println("Row " + i + ": " + max);
        }
    }

    // Column-wise maximum
    public static void columnWiseMax(int[][] matrix) {
        System.out.println("Column-wise Maximum:");
        int cols = matrix[0].length;
        for (int j = 0; j < cols; j++) {
            int max = matrix[0][j];
            for (int i = 0; i < matrix.length; i++)
                if (matrix[i][j] > max) max = matrix[i][j];
            System.out.println("Column " + j + ": " + max);
        }
    }

    // Count prime numbers
    public static void countPrimes(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix)
            for (int val : row)
                if (isPrime(val)) count++;

        System.out.println("Total prime numbers in matrix: " + count);
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        int limit = (int)Math.sqrt(num);
        for (int i = 2; i <= limit; i++)
            if (num % i == 0) return false;
        return true;
    }

    // Diagonal dominance check
    public static void checkDiagonalDominance(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rows != cols) {
            System.out.println("Matrix is not square. Cannot check diagonal dominance.");
            return;
        }

        boolean dominant = true;
        for (int i = 0; i < rows; i++) {
            int diag = Math.abs(matrix[i][i]);
            int sum = 0;
            for (int j = 0; j < cols; j++) {
                if (i != j) sum += Math.abs(matrix[i][j]);
            }
            if (diag < sum) dominant = false;
        }

        System.out.println(dominant ? "Matrix is diagonally dominant." : "Matrix is NOT diagonally dominant.");
    }

    // Compare sum of rows vs sum of columns (total sums)
    public static void compareRowColumnSums(int[][] matrix) {
        int rowSum = 0, colSum = 0;

        for (int[] row : matrix)
            for (int val : row) rowSum += val;

        int cols = matrix[0].length;
        for (int j = 0; j < cols; j++)
            for (int[] row : matrix) colSum += row[j];

        System.out.println("Total row sum: " + rowSum);
        System.out.println("Total column sum: " + colSum);

        if (rowSum > colSum) System.out.println("Row sum > Column sum");
        else if (colSum > rowSum) System.out.println("Column sum > Row sum");
        else System.out.println("Row sum = Column sum");
    }

    // Display menu
    public static void showMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Display Matrix");
        System.out.println("2. Row-wise Sum");
        System.out.println("3. Column-wise Sum");
        System.out.println("4. Row-wise Maximum");
        System.out.println("5. Column-wise Maximum");
        System.out.println("6. Count Prime Numbers");
        System.out.println("7. Check Diagonal Dominance");
        System.out.println("8. Compare Row & Column Sums");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }
}
