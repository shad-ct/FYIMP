/*
 * Question:
 * Write a Java program to add two matrices.
 */

import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] a = new int[2][2];
        int[][] b = new int[2][2];

        System.out.println("Enter first matrix:");

        for(int i=0;i<2;i++)
            for(int j=0;j<2;j++)
                a[i][j]=sc.nextInt();

        System.out.println("Enter second matrix:");

        for(int i=0;i<2;i++)
            for(int j=0;j<2;j++)
                b[i][j]=sc.nextInt();

        System.out.println("Sum Matrix:");

        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                System.out.print((a[i][j]+b[i][j]) + " ");
            }
            System.out.println();
        }
    }
}
