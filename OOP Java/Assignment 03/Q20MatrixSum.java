public class Q20MatrixSum {
    public static void main(String[] args) {
        // Example matrices
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        int[][] matrix2 = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };
        
        // Print original matrices
        System.out.println("Matrix 1:");
        printMatrix(matrix1);
        
        System.out.println("\nMatrix 2:");
        printMatrix(matrix2);
        
        // Calculate sum
        int[][] sumMatrix = matrixSum(matrix1, matrix2);
        
        // Print result
        System.out.println("\nSum of matrices:");
        printMatrix(sumMatrix);
    }
    
    public static int[][] matrixSum(int[][] matrix1, int[][] matrix2) {
        if (matrix1 == null || matrix2 == null || 
            matrix1.length != matrix2.length || 
            matrix1[0].length != matrix2[0].length) {
            System.out.println("Matrices must have the same dimensions");
            return null;
        }
        
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
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
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}