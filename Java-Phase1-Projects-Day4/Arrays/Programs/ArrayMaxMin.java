package Arrays.Programs;

public class ArrayMaxMin {
      public static void main(String[] args) {
        int[] numbers = {7, 3, 15, 2, 18, 10};

        int max = numbers[0];
        int min = numbers[0];

        for (int num : numbers) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
    }
}
