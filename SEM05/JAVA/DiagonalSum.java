/*
 * Question:
 * Write a Java program to find the sum of the principal and secondary diagonal elements of a
 */

import java.util.Scanner;

public class DiagonalSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] a = new int[3][3];

        System.out.println("Enter elements:");

        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                a[i][j]=sc.nextInt();

        int p=0,s=0;

        for(int i=0;i<3;i++){
            p += a[i][i];
            s += a[i][2-i];
        }

        System.out.println("Principal Diagonal Sum = " + p);
        System.out.println("Secondary Diagonal Sum = " + s);
    }
}
