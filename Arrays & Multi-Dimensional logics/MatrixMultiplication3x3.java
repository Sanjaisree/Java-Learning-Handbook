public class MatrixMultiplication3x3 {

    static int[][] multiply(int[][] A, int[][] B) {
        int[][] C = new int[3][3];

        for (int i = 0; i < 3; i++) {          
            for (int j = 0; j < 3; j++) {      
                C[i][j] = 0;
                for (int k = 0; k < 3; k++) {  
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    
    static void printMatrix(int[][] M) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] A = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] B = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        int[][] C = multiply(A, B);

        System.out.println("Result Matrix:");
        printMatrix(C);
    }
}

