public class Q18PrintMatrix {
    public static void main(String[] args) {
        // Example matrix (3x4)
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        
        // Print matrix dimensions
        System.out.println("Matrix dimensions: " + matrix.length + "x" + matrix[0].length);
        
        // Print the matrix
        System.out.println("Matrix elements row-wise:");
        printMatrixRowWise(matrix);
    }
    
    public static void printMatrixRowWise(int[][] matrix) {
        // Check if the matrix is empty
        if (matrix == null || matrix.length == 0) {
            System.out.println("Empty matrix");
            return;
        }
        
        // Get dimensions
        int m = matrix.length;    // Number of rows
        int n = matrix[0].length; // Number of columns
        
        // Iterate through each row
        for (int i = 0; i < m; i++) {
            // Iterate through each column in the current row
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            // Move to the next line after printing each row
            System.out.println();
        }
    }
}