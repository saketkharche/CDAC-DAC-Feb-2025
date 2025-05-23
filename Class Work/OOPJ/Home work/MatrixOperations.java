import java.util.Scanner;

public class MatrixOperations {

    // Method to read a matrix
    public static int[][] readMatrix(int rows, int cols, Scanner sc) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    // Method to display a matrix
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + "\t");
            }
            System.out.println();
        }
    }

    // Method for matrix addition
    public static int[][] addMatrices(int[][] mat1, int[][] mat2) {
        int rows = mat1.length;
        int cols = mat1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        return result;
    }

    // Method for matrix subtraction
    public static int[][] subtractMatrices(int[][] mat1, int[][] mat2) {
        int rows = mat1.length;
        int cols = mat1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = mat1[i][j] - mat2[i][j];
            }
        }
        return result;
    }

    // Method for matrix multiplication
    public static int[][] multiplyMatrices(int[][] mat1, int[][] mat2) {
        int rows1 = mat1.length;
        int cols1 = mat1[0].length;
        int cols2 = mat2[0].length;
        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read dimensions for matrices
        System.out.print("Enter number of rows and columns for matrices: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        // Read matrix A
        System.out.println("\nMatrix A:");
        int[][] matrixA = readMatrix(rows, cols, sc);

        // Read matrix B
        System.out.println("\nMatrix B:");
        int[][] matrixB = readMatrix(rows, cols, sc);

        // Addition
        System.out.println("\nMatrix Addition:");
        int[][] sum = addMatrices(matrixA, matrixB);
        displayMatrix(sum);

        // Subtraction
        System.out.println("\nMatrix Subtraction:");
        int[][] difference = subtractMatrices(matrixA, matrixB);
        displayMatrix(difference);

        // Multiplication
        if (matrixA[0].length == matrixB.length) {
            System.out.println("\nMatrix Multiplication:");
            int[][] product = multiplyMatrices(matrixA, matrixB);
            displayMatrix(product);
        } else {
            System.out.println("\nMatrix Multiplication not possible (column of A ≠ row of B).");
        }

        sc.close();
    }
}
