public class Q24RotateMatrix {
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
        
        // Rotate matrix
        int[][] rotated = rotateMatrix90(matrix);
        
        // Print rotated matrix
        System.out.println("\nMatrix after 90° clockwise rotation:");
        printMatrix(rotated);
    }
    
    public static int[][] rotateMatrix90(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
            System.out.println("Matrix must be square for rotation");
            return null;
        }
        
        int n = matrix.length;
        int[][] rotated = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // For 90° clockwise rotation: rotated[j][n-1-i] = matrix[i][j]
                rotated[j][n-1-i] = matrix[i][j];
            }
        }
        
        return rotated;
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