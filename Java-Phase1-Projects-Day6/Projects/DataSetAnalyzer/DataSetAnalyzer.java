package Projects.DataSetAnalyzer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataSetAnalyzer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of data points: ");
        int n = sc.nextInt();

        double[] data = new double[n];
        System.out.println("Enter the data values:");
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextDouble();
        }

        Arrays.sort(data);

        double sum = 0;
        for (double d : data) sum += d;

        double mean = sum / n;
        double median = (n % 2 == 0) ? (data[n / 2 - 1] + data[n / 2]) / 2 : data[n / 2];
        double min = data[0];
        double max = data[n - 1];

        Map<Double, Integer> freqMap = new HashMap<>();
        for (double d : data)
            freqMap.put(d, freqMap.getOrDefault(d, 0) + 1);

        System.out.println("\n--- DataSet Summary ---");
        System.out.println("Sorted Data: " + Arrays.toString(data));
        System.out.println("Mean: " + mean);
        System.out.println("Median: " + median);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Frequency Distribution: " + freqMap);

        sc.close();
    }
}
