// Write a Java program to find the largest of two numbers using an if-else statement.
import java.util.Scanner;
public class LargestOfTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        if (a > b) {
            System.out.println(a + " is the largest.");
        } else if (b > a) {
            System.out.println(b + " is the largest.");
        } else {
            System.out.println("Both numbers are equal.");
        }
        sc.close();
    }
}
