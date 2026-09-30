/*
 * Question:
 * Write a Java program to find the largest and smallest elements in a 2D array.
 */

import java.util.Scanner;

public class LargestSmallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] a = new int[2][2];

        System.out.println("Enter elements:");

        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                a[i][j]=sc.nextInt();
            }
        }

        int largest = a[0][0];
        int smallest = a[0][0];

        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){

                if(a[i][j]>largest)
                    largest=a[i][j];

                if(a[i][j]<smallest)
                    smallest=a[i][j];
            }
        }

        System.out.println("Largest = " + largest);
        System.out.println("Smallest = " + smallest);
    }
}
