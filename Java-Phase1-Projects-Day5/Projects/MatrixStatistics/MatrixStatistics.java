package Projects.MatrixStatistics;

import java.util.Scanner;

public class MatrixStatistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        printMatrix(matrix);
        System.out.println("\n--- Matrix Statistics ---");

        int totalSum = 0, max = matrix[0][0], min = matrix[0][0];
        for (int[] row : matrix) {
            for (int val : row) {
                totalSum += val;
                if (val > max) max = val;
                if (val < min) min = val;
            }
        }

        System.out.println("Total Sum = " + totalSum);
        System.out.println("Maximum Value = " + max);
        System.out.println("Minimum Value = " + min);

        System.out.println("\nRow-wise Sum:");
        for (int i = 0; i < rows; i++) {
            int sum = 0;
            for (int j = 0; j < cols; j++) sum += matrix[i][j];
            System.out.println("Row " + (i + 1) + ": " + sum);
        }

        System.out.println("\nColumn-wise Sum:");
        for (int j = 0; j < cols; j++) {
            int sum = 0;
            for (int i = 0; i < rows; i++) sum += matrix[i][j];
            System.out.println("Column " + (j + 1) + ": " + sum);
        }

        if (rows == cols) {
            int mainDiag = 0, secDiag = 0;
            for (int i = 0; i < rows; i++) {
                mainDiag += matrix[i][i];
                secDiag += matrix[i][rows - 1 - i];
            }
            System.out.println("\nMain Diagonal Sum = " + mainDiag);
            System.out.println("Secondary Diagonal Sum = " + secDiag);
        }

        sc.close();
    }

    static void printMatrix(int[][] matrix) {
        System.out.println("\nMatrix:");
        for (int[] row : matrix) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }
}

