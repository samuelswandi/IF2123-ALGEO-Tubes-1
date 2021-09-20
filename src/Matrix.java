import java.util.Scanner;

public class Matrix {
    int rows;
    int columns;
    int[][] matrix;

    Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new int[rows][columns];
    }

    void CreateMatrix() {
        System.out.print("Masukkan ukuran matriks: ");
        Scanner in = new Scanner(System.in);
        this.rows = in.nextInt();
        this.columns = in.nextInt();

        System.out.println("Masukkan elemen matriks : ");
        this.matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.matrix[i][j] = in.nextInt();
            }
        }
    }

    void DisplayMatrix() {
            System.out.println("Matriks :");
            for (int[] row : this.matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

}
