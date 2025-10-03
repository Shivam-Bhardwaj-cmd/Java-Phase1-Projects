package Projects.ArrayStats;

import java.util.Scanner;

public class ArrayStats {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] numbers = new int[n];

        // Step 2: Take array input
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        // Step 3: Calculate sum, max, min
        int sum = 0, max = numbers[0], min = numbers[0];

        for (int num : numbers) {
            sum += num;
            if (num > max) max = num;
            if (num < min) min = num;
        }

        double average = (double) sum / n;

        // Step 4: Print results
        System.out.println("\nArray Statistics:");
        System.out.println("Sum = " + sum);
        System.out.println("Max = " + max);
        System.out.println("Min = " + min);
        System.out.println("Average = " + average);

        sc.close();
    }
}
