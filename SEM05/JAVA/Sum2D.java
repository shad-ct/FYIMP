/*
 * Question:
 * Write a Java program to find the sum of all elements in a 2D array.
 */

import java.util.Scanner;

public class Sum2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] a = new int[2][2];
        int sum = 0;

        System.out.println("Enter 4 elements:");

        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                a[i][j]=sc.nextInt();
                sum += a[i][j];
            }
        }

        System.out.println("Sum = " + sum);
    }
}
