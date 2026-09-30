import java.util.Scanner;

class Sum2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] a = new int[r][c];
        int sum = 0;

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                a[i][j] = sc.nextInt();
                sum += a[i][j];
            }

        System.out.println("Sum = " + sum);
    }
}
