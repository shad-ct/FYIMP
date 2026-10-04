// Write a Java program to count the number of digits in a given integer.
import java.util.Scanner;
public class CountDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();
        int count = 0;
        int temp = Math.abs(num);
        if (temp == 0) {
            count = 1;
        } else {
            while (temp != 0) {
                temp = temp / 10;
                count++;
            }
        }
        System.out.println("Number of digits: " + count);
        sc.close();
    }
}
