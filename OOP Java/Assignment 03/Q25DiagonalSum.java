public class Q25DiagonalSum {
    public static void main(String[] args) {
        // Example matrix
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        // Print original matrix
        System.out.println("Matrix:");
        printMatrix(matrix);
        
        // Calculate diagonal sums
        int[] diagonalSums = findDiagonalSum(matrix);
        
        // Print results
        System.out.println("\nPrimary diagonal (top-left to bottom-right): " + diagonalSums[0]);
        System.out.println("Secondary diagonal (top-right to bottom-left): " + diagonalSums[1]);
        System.out.println("Sum of both diagonals: " + (diagonalSums[0] + diagonalSums[1]));
    }
    
    public static int[] findDiagonalSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
            System.out.println("Matrix must be square for diagonal sum");
            return new int[]{0, 0};
        }
        
        int n = matrix.length;
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;
        
        for (int i = 0; i < n; i++) {
            // Primary diagonal: elements where row index equals column index
            primaryDiagonalSum += matrix[i][i];
            
            // Secondary diagonal: elements where row index + column index = n-1
            secondaryDiagonalSum += matrix[i][n-1-i];
        }
        
        return new int[]{primaryDiagonalSum, secondaryDiagonalSum};
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