public class Q22MaxMatrixElement {
    public static void main(String[] args) {
        // Example matrix
        int[][] matrix = {
            {1, 2, 3},
            {14, 5, 6},
            {7, 8, 9}
        };
        
        // Print original matrix
        System.out.println("Matrix:");
        printMatrix(matrix);
        
        // Find maximum element
        int max = findMaxElement(matrix);
        
        // Print result
        System.out.println("\nMaximum element: " + max);
    }
    
    public static int findMaxElement(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            System.out.println("Empty matrix");
            return Integer.MIN_VALUE;
        }
        
        int max = matrix[0][0];
        int maxRow = 0;
        int maxCol = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        
        System.out.println("Maximum element " + max + " found at position: (" + maxRow + "," + maxCol + ")");
        return max;
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