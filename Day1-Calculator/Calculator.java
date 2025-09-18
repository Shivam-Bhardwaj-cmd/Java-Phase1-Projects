import java.util.Scanner;

public class Calculator {

    // Method to add numbers
    public static double add(double a, double b) {
        return a + b;
    }

    // Method to subtract numbers
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Method to multiply numbers
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Method to divide numbers
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero!");
            return 0;
        }
        return a / b;
    }

    // Method for modulus
    public static int modulus(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Modulus by zero!");
            return 0;
        }
        return a % b;
    }

    // Method for factorial
    public static long factorial(int n) {
        if (n < 0) {
            System.out.println("Error: Factorial of negative number!");
            return -1;
        }
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Method to check prime number
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Method for power
    public static double power(double base, double exp) {
        return Math.pow(base, exp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Calculator Menu ===");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Modulus");
            System.out.println("6. Factorial");
            System.out.println("7. Prime Check");
            System.out.println("8. Power");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter two numbers: ");
                    System.out.println("Result: " + add(sc.nextDouble(), sc.nextDouble()));
                    break;
                case 2:
                    System.out.print("Enter two numbers: ");
                    System.out.println("Result: " + subtract(sc.nextDouble(), sc.nextDouble()));
                    break;
                case 3:
                    System.out.print("Enter two numbers: ");
                    System.out.println("Result: " + multiply(sc.nextDouble(), sc.nextDouble()));
                    break;
                case 4:
                    System.out.print("Enter two numbers: ");
                    System.out.println("Result: " + divide(sc.nextDouble(), sc.nextDouble()));
                    break;
                case 5:
                    System.out.print("Enter two integers: ");
                    System.out.println("Result: " + modulus(sc.nextInt(), sc.nextInt()));
                    break;
                case 6:
                    System.out.print("Enter an integer: ");
                    System.out.println("Factorial: " + factorial(sc.nextInt()));
                    break;
                case 7:
                    System.out.print("Enter an integer: ");
                    int n = sc.nextInt();
                    System.out.println(n + (isPrime(n) ? " is Prime" : " is Not Prime"));
                    break;
                case 8:
                    System.out.print("Enter base and exponent: ");
                    System.out.println("Result: " + power(sc.nextDouble(), sc.nextDouble()));
                    break;
                case 9:
                    System.out.println("Exiting Calculator...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 9);

        sc.close();
    }
}

