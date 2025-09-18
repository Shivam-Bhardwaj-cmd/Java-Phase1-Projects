import java.util.Scanner;

public class MatrixAnalyzer {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Matrix Analyzer!");
        int[][] matrix = null;
        int choice;

        do {
            System.out.println("\n--- Matrix Analyzer Menu ---");
            System.out.println("1. Input Matrix");
            System.out.println("2. Display Matrix");
            System.out.println("3. Sum of Each Row");
            System.out.println("4. Sum of Each Column");
            System.out.println("5. Find Maximum Element");
            System.out.println("6. Find Minimum Element");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    matrix = inputMatrix();
                    break;
                case 2:
                    displayMatrix(matrix);
                    break;
                case 3:
                    sumRows(matrix);
                    break;
                case 4:
                    sumColumns(matrix);
                    break;
                case 5:
                    findMax(matrix);
                    break;
                case 6:
                    findMin(matrix);
                    break;
                case 0:
                    System.out.println("Exiting Matrix Analyzer. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 0);
    }

    // Method to input a matrix
    public static int[][] inputMatrix() {
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Matrix input completed!");
        return matrix;
    }

    // Method to display the matrix
    public static void displayMatrix(int[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix not initialized. Please input matrix first.");
            return;
        }
        System.out.println("Matrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    // Method to sum rows
    public static void sumRows(int[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix not initialized. Please input matrix first.");
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int val : matrix[i]) {
                sum += val;
            }
            System.out.println("Sum of row " + i + ": " + sum);
        }
    }

    // Method to sum columns
    public static void sumColumns(int[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix not initialized. Please input matrix first.");
            return;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int j = 0; j < cols; j++) {
            int sum = 0;
            for (int i = 0; i < rows; i++) {
                sum += matrix[i][j];
            }
            System.out.println("Sum of column " + j + ": " + sum);
        }
    }

    // Method to find max element
    public static void findMax(int[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix not initialized. Please input matrix first.");
            return;
        }
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int val : row) {
                if (val > max) max = val;
            }
        }
        System.out.println("Maximum element in matrix: " + max);
    }

    // Method to find min element
    public static void findMin(int[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix not initialized. Please input matrix first.");
            return;
        }
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int val : row) {
                if (val < min) min = val;
            }
        }
        System.out.println("Minimum element in matrix: " + min);
    }
}

