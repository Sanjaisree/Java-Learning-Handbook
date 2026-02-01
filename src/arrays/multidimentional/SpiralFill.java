package arrays.multidimentional;

import java.util.Scanner;
public class SpiralFill {
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int N = sc.nextInt();

        int[][] matrix = new int[N][N];

        int top = 0, bottom = N - 1;
        int left = 0, right = N - 1;
        int num = 1;

        while (num <= N * N) {

            for (int j = left; j <= right && num <= N * N; j++) {
                matrix[top][j] = num++;
            }
            top++;

            for (int i = top; i <= bottom && num <= N * N; i++) {
                matrix[i][right] = num++;
            }
            right--;

            for (int j = right; j >= left && num <= N * N; j--) {
                matrix[bottom][j] = num++;
            }
            bottom--;

            for (int i = bottom; i >= top && num <= N * N; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }

        System.out.println("Spiral Matrix:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }

        sc.close();
    }


}
