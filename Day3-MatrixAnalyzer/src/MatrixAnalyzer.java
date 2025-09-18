package Day3MatrixAnalyzer;

import java.util.Scanner;

public class MatrixAnalyzer {

    // Method to display the matrix
    static void displayMatrix(int[][] matrix) {
        System.out.println("Matrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    // Method to sum rows
    static void sumRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int val : matrix[i]) sum += val;
            System.out.println("Sum of row " + i + ": " + sum);
        }
    }

    // Method to sum columns
    static void sumColumns(int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < matrix.length; i++) sum += matrix[i][j];
            System.out.println("Sum of column " + j + ": " + sum);
        }
    }

    // Method to find max and min
    static void findMaxMin(int[][] matrix) {
        int max = matrix[0][0], min = matrix[0][0];
        for (int[] row : matrix) {
            for (int val : row) {
                if (val > max) max = val;
                if (val < min) min = val;
            }
        }
        System.out.println("Maximum element: " + max);
        System.out.println("Minimum element: " + min);
    }

    // New Feature 1: Transpose
    static void transposeMatrix(int[][] matrix) {
        System.out.println("Transpose of the matrix:");
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // New Feature 2: Sum of diagonal elements
    static void sumDiagonals(int[][] matrix) {
        int primary = 0, secondary = 0;
        int n = Math.min(matrix.length, matrix[0].length); // handle non-square
        for (int i = 0; i < n; i++) {
            primary += matrix[i][i];
            secondary += matrix[i][n - 1 - i];
        }
        System.out.println("Sum of primary diagonal: " + primary);
        System.out.println("Sum of secondary diagonal: " + secondary);
    }

    // New Feature 3: Check if square
    static void checkSquare(int[][] matrix) {
        if (matrix.length == matrix[0].length) {
            System.out.println("The matrix is square.");
        } else {
            System.out.println("The matrix is NOT square.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input matrix size
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        // Input matrix elements
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Matrix Analyzer Menu ===");
            System.out.println("1. Display Matrix");
            System.out.println("2. Sum of Rows");
            System.out.println("3. Sum of Columns");
            System.out.println("4. Find Max & Min");
            System.out.println("5. Transpose Matrix");
            System.out.println("6. Sum of Diagonals");
            System.out.println("7. Check if Square");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> displayMatrix(matrix);
                case 2 -> sumRows(matrix);
                case 3 -> sumColumns(matrix);
                case 4 -> findMaxMin(matrix);
                case 5 -> transposeMatrix(matrix);
                case 6 -> sumDiagonals(matrix);
                case 7 -> checkSquare(matrix);
                case 8 -> {
                    exit = true;
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }
}

