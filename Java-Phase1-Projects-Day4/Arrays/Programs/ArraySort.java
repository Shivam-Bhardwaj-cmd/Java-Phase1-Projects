package Arrays.Programs;
import java.util.Arrays;
public class ArraySort {
    public static void main(String[] args) {
        int[] numbers = {12, 5, 8, 1, 20};

        Arrays.sort(numbers); // Built-in sort method

        System.out.println("Sorted Array: " + Arrays.toString(numbers));
    }
    
}
