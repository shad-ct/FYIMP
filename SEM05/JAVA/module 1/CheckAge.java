// Write a Java program to create a method checkAge(int age) that throws an exception using the throw keyword when the age is less than 18. Declare the exception using throws and handle it in the calling method.
import java.util.Scanner;
public class CheckAge {
    static void checkAge(int age) throws Exception {
        if (age < 18) {
            throw new Exception("Age must be 18 or above.");
        } else {
            System.out.println("Access granted.");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        try {
            checkAge(age);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}
