import java.util.Scanner;
import java.util.ArrayList;

public class MatrixAnalyzerEnhanced {

    // Method to input matrix
    public static int[][] inputMatrix(Scanner sc) {
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    // Display matrix
    public static void displayMatrix(int[][] matrix) {
        System.out.println("Matrix:");
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + "\t");
            }
            System.out.println();
        }
    }

    // Search for an element (returns list of positions)
    public static void searchElement(int[][] matrix, int target) {
        ArrayList<String> positions = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    positions.add("(" + i + "," + j + ")");
                }
            }
        }

        if (positions.isEmpty()) {
            System.out.println(target + " not found in the matrix.");
        } else {
            System.out.println(target + " found at positions: " + positions);
        }
    }

    // Find max and min
    public static void findMaxMin(int[][] matrix) {
        int max = matrix[0][0], min = matrix[0][0];
        for (int[] row : matrix) {
            for (int elem : row) {
                if (elem > max) max = elem;
                if (elem < min) min = elem;
            }
        }
        System.out.println("Maximum element: " + max);
        System.out.println("Minimum element: " + min);
    }

    // Compute sum and average
    public static void sumAndAverage(int[][] matrix) {
        int sum = 0, count = 0;
        for (int[] row : matrix) {
            for (int elem : row) {
                sum += elem;
                count++;
            }
        }
        double average = (double) sum / count;
        System.out.println("Sum of all elements: " + sum);
        System.out.println("Average of elements: " + average);
    }

    // Count even and odd elements
    public static void countEvenOdd(int[][] matrix) {
        int even = 0, odd = 0;
        for (int[] row : matrix) {
            for (int elem : row) {
                if (elem % 2 == 0) even++;
                else odd++;
            }
        }
        System.out.println("Even elements: " + even);
        System.out.println("Odd elements: " + odd);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = null;
        int choice;

        do {
            System.out.println("\n=== Matrix Analyzer Enhanced ===");
            System.out.println("1. Input Matrix");
            System.out.println("2. Display Matrix");
            System.out.println("3. Search Element");
            System.out.println("4. Find Max & Min");
            System.out.println("5. Sum & Average");
            System.out.println("6. Count Even & Odd");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    matrix = inputMatrix(sc);
                    break;
                case 2:
                    if (matrix != null) displayMatrix(matrix);
                    else System.out.println("Matrix not initialized.");
                    break;
                case 3:
                    if (matrix != null) {
                        System.out.print("Enter element to search: ");
                        int target = sc.nextInt();
                        searchElement(matrix, target);
                    } else System.out.println("Matrix not initialized.");
                    break;
                case 4:
                    if (matrix != null) findMaxMin(matrix);
                    else System.out.println("Matrix not initialized.");
                    break;
                case 5:
                    if (matrix != null) sumAndAverage(matrix);
                    else System.out.println("Matrix not initialized.");
                    break;
                case 6:
                    if (matrix != null) countEvenOdd(matrix);
                    else System.out.println("Matrix not initialized.");
                    break;
                case 0:
                    System.out.println("Exiting Matrix Analyzer Enhanced.");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}

