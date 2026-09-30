import java.util.Scanner;

class RowSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] a = new int[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                a[i][j] = sc.nextInt();

        for (int i = 0; i < r; i++) {
            int sum = 0;
            for (int j = 0; j < c; j++)
                sum += a[i][j];
            System.out.println("Row " + (i + 1) + " = " + sum);
        }
    }
}
