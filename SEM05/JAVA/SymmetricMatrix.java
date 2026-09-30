/*
 * Question:
 * Write a Java program to check whether a given matrix is a symmetric matrix.
 */

import java.util.Scanner;

public class SymmetricMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] a = new int[3][3];

        System.out.println("Enter elements:");

        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                a[i][j]=sc.nextInt();

        boolean symmetric = true;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){

                if(a[i][j]!=a[j][i]){
                    symmetric=false;
                }

            }
        }

        if(symmetric)
            System.out.println("Matrix is Symmetric");
        else
            System.out.println("Matrix is Not Symmetric");
    }
}
