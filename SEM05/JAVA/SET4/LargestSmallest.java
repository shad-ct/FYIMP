import java.util.*;

class LargestSmallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] a = new int[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                a[i][j] = sc.nextInt();

        int max = a[0][0];
        int min = a[0][0];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                if (a[i][j] > max) max = a[i][j];
                if (a[i][j] < min) min = a[i][j];
            }

        System.out.println("Largest = " + max);
        System.out.println("Smallest = " + min);
    }
}
