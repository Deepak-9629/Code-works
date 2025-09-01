package firstweektask;

import java.util.Scanner;

public class Task3 {
    public static void processInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            
            System.out.print("Enter a number: ");
            double number = scanner.nextDouble();
            if (number == 0) {
                throw new ArithmeticException("Reciprocal of zero is undefined.");
            }
            double reciprocal = 1 / number;
            System.out.println("Reciprocal: " + reciprocal);

        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a numeric value.");
        } finally {
            scanner.close(); 
        }
    }

    public static void main(String[] args) {
        processInput();
    }
}
