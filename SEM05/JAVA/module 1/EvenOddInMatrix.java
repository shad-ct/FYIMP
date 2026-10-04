// Write a Java program to count the number of even and odd elements in a 3x3 matrix.
import java.util.Scanner;
public class EvenOddInMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[3][3];
        int even = 0;
        int odd = 0;
        System.out.println("Enter elements of 3x3 matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = sc.nextInt();
                if (matrix[i][j] % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
        }
        System.out.println("Even elements: " + even);
        System.out.println("Odd elements: " + odd);
        sc.close();
    }
}
