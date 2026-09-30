import java.util.Scanner;

class ColumnSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] a = new int[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                a[i][j] = sc.nextInt();

        for (int j = 0; j < c; j++) {
            int sum = 0;
            for (int i = 0; i < r; i++)
                sum += a[i][j];
            System.out.println("Column " + (j + 1) + " = " + sum);
        }
    }
}
