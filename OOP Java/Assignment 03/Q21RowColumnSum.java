public class Q21RowColumnSum {
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
        
        // Find row and column sums
        System.out.println("\nRow and Column Sums:");
        findRowAndColumnSum(matrix);
    }
    
    public static void findRowAndColumnSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            System.out.println("Empty matrix");
            return;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Calculate row sums
        System.out.println("Row sums:");
        for (int i = 0; i < rows; i++) {
            int rowSum = 0;
            for (int j = 0; j < cols; j++) {
                rowSum += matrix[i][j];
            }
            System.out.println("Row " + (i+1) + ": " + rowSum);
        }
        
        // Calculate column sums
        System.out.println("\nColumn sums:");
        for (int j = 0; j < cols; j++) {
            int colSum = 0;
            for (int i = 0; i < rows; i++) {
                colSum += matrix[i][j];
            }
            System.out.println("Column " + (j+1) + ": " + colSum);
        }
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