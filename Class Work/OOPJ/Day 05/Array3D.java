
import java.util.Scanner;

public class Array3D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[][]=new int[3][3];
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.println("Enter element");
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println("---------------");

        for(int ar[] : arr) {
            for(int x : ar) {
                System.out.print(" "+x);

                
            }
            System.out.println();
            
        }
    }
}
