import java.util.Scanner;

class SymmetricMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] a = new int[n][n];
        boolean symmetric = true;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (a[i][j] != a[j][i])
                    symmetric = false;

        if (symmetric)
            System.out.println("Symmetric Matrix");
        else
            System.out.println("Not a Symmetric Matrix");
    }
}
