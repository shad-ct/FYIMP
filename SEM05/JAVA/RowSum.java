/*
 * Question:
 * Write a Java program to calculate the sum of each row in a matrix.
 */

import java.util.Scanner;

public class RowSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] a = new int[2][3];

        System.out.println("Enter elements:");

        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                a[i][j]=sc.nextInt();
            }
        }

        for(int i=0;i<2;i++){

            int sum=0;

            for(int j=0;j<3;j++){
                sum += a[i][j];
            }

            System.out.println("Row " + (i+1) + " Sum = " + sum);
        }
    }
}
