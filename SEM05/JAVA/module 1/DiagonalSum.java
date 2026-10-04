// Write a Java program to find the sum of the principal and secondary diagonal elements of a square matrix.
import java.util.Scanner;
public class DiagonalSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of square matrix: ");
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int principal = 0;
        int secondary = 0;
        for (int i = 0; i < n; i++) {
            principal = principal + matrix[i][i];
            secondary = secondary + matrix[i][n - 1 - i];
        }
        System.out.println("Sum of principal diagonal: " + principal);
        System.out.println("Sum of secondary diagonal: " + secondary);
        sc.close();
    }
}
