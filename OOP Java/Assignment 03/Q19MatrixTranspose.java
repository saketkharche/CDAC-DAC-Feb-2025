public class Q19MatrixTranspose {
    public static void main(String[] args) {
        // Example matrix
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        // Print original matrix
        System.out.println("Original Matrix:");
        printMatrix(matrix);
        
        // Get transpose of the matrix
        int[][] transpose = transposeMatrix(matrix);
        
        // Print transposed matrix
        System.out.println("\nTransposed Matrix:");
        printMatrix(transpose);
        
        // Example of a non-square matrix
        int[][] nonSquareMatrix = {
            {1, 2, 3},
            {4, 5, 6}
        };
        
        System.out.println("\nOriginal Non-square Matrix (2x3):");
        printMatrix(nonSquareMatrix);
        
        int[][] nonSquareTranspose = transposeMatrix(nonSquareMatrix);
        
        System.out.println("\nTransposed Non-square Matrix (3x2):");
        printMatrix(nonSquareTranspose);
    }
    
    public static int[][] transposeMatrix(int[][] matrix) {
        // Check if the matrix is empty
        if (matrix == null || matrix.length == 0) {
            return new int[0][0];
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Create a new matrix with swapped dimensions
        int[][] transpose = new int[cols][rows];
        
        // Fill the transposed matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        
        return transpose;
    }
    
    // Helper method to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}