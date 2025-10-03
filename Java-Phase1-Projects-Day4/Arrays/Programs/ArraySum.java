package Arrays.Programs;

public class ArraySum {
    public static void main(String[] args) {
        int[] numbers = {5, 10, 15, 20, 25}; // Example array
        int sum = 0;

        for (int num : numbers) {
            sum += num; // Add each element
        }

        System.out.println("Sum of array elements: " + sum);
    }
}
