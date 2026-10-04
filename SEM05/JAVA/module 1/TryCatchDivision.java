// Write a Java program to accept two integers from the user and perform division. Use try-catch to handle the ArithmeticException that occurs when the denominator is zero.
import java.util.Scanner;
public class TryCatchDivision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter numerator: ");
        int a = sc.nextInt();
        System.out.print("Enter denominator: ");
        int b = sc.nextInt();
        try {
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero is not allowed.");
        }
        sc.close();
    }
}
