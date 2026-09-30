import java.util.Scanner;

class DiagonalSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] a = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();

        int p = 0, s = 0;

        for (int i = 0; i < n; i++) {
            p += a[i][i];
            s += a[i][n - 1 - i];
        }

        System.out.println("Principal diagonal = " + p);
        System.out.println("Secondary diagonal = " + s);
        System.out.println("Total = " + (p + s));
    }
}
