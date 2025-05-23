public class Q23MatrixMultiplication {
    public static void main(String[] args) {
        // Example matrices
        int[][] matrixA = {
            {1, 2, 3},
            {4, 5, 6}
        };
        
        int[][] matrixB = {
            {7, 8},
            {9, 10},
            {11, 12}
        };
        
        // Print original matrices
        System.out.println("Matrix A (2x3):");
        printMatrix(matrixA);
        
        System.out.println("\nMatrix B (3x2):");
        printMatrix(matrixB);
        
        // Multiply matrices
        int[][] result = matrixMultiplication(matrixA, matrixB);
        
        // Print result
        System.out.println("\nResult of A × B:");
        printMatrix(result);
    }
    
    public static int[][] matrixMultiplication(int[][] A, int[][] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            System.out.println("Empty matrices");
            return null;
        }
        
        if (A[0].length != B.length) {
            System.out.println("Cannot multiply: Number of columns in first matrix must equal number of rows in second matrix");
            return null;
        }
        
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;
        
        int[][] result = new int[rowsA][colsB];
        
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        
        return result;
    }
    
    // Helper method to print a matrix
    public static void printMatrix(int[][] matrix) {
        if (matrix == null) {
            System.out.println("Null matrix");
            return;
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}