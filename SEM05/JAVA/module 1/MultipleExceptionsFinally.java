// Write a Java program that accepts an array index and performs an operation on an array. Use try-catch to handle ArrayIndexOutOfBoundsException and another appropriate exception. Use a finally block to display a message indicating that exception handling has been completed.
import java.util.Scanner;
public class MultipleExceptionsFinally {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {10, 20, 30, 40, 50};
        System.out.print("Enter index (0-4): ");
        try {
            int index = sc.nextInt();
            System.out.println("Element at index " + index + ": " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index.");
        } catch (Exception e) {
            System.out.println("Invalid input.");
        } finally {
            System.out.println("Exception handling completed.");
        }
        sc.close();
    }
}
