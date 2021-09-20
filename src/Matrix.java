package src;
import java.util.Scanner;
public class Matrix {
    public static void main(String[] args) {
        System.out.print("Enter Matrix size : ");
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int columns = in.nextInt();

        System.out.println("Enter Matrix elements : ");

        int matrix[][] = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        System.out.print("\nMatrix : \n");
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        in.close();
    }

}
