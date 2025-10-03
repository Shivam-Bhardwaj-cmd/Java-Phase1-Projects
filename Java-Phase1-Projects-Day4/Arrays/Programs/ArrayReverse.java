package Arrays.Programs;
import java.util.Arrays;
public class ArrayReverse {
     public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int n = numbers.length;

        // Reverse using two-pointer approach
        for (int i = 0; i < n / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[n - 1 - i];
            numbers[n - 1 - i] = temp;
        }

        System.out.println("Reversed Array: " + Arrays.toString(numbers));
    }
}
