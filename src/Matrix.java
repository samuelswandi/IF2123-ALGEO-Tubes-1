import java.util.Scanner;

public class Matrix {
    int rows, columns;
    double[][] matrix;

    Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new double[rows][columns];
    }

    void CreateMatrix() {
        System.out.print("Masukkan ukuran matriks: ");
        Scanner in = new Scanner(System.in);
        this.rows = in.nextInt();
        this.columns = in.nextInt();

        System.out.println("Masukkan elemen matriks : ");
        this.matrix = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.matrix[i][j] = in.nextFloat();
            }
        }

    }

    void DisplayMatrix() {
        for (double[] row : this.matrix) {
            for (double col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    double Determinan(){
        if (this.rows  == 1){return this.matrix[0][0];}
        else if(this.rows == 2){return this.matrix[0][0]*this.matrix[1][1] - this.matrix[1][0]*this.matrix[0][1];}
        else{ 
            int i,j,k;
            double det = 0;
            for (i = 0 ; i < this.rows ; i++){
                Matrix newM = new Matrix(this.rows - 1, this.columns - 1);
                for (j = 1 ; j < this.rows ; j++){
                    int row = j-1 , col = 0;
                    for (k = 0 ; k < this.rows ; k++){
                        if (k != i){
                            newM.matrix[row][col] = this.matrix[j][k];
                            col++;
                        }
                    }
                }
                if (i % 2 == 0){
                    det += this.matrix[0][i] * newM.Determinan();
                }
                else{det += (-1)*this.matrix[0][i] * newM.Determinan();}
            }
            return det;
        }
    }

    void Transpose(){
        int i,j;
        double temp;
        for (i = 0 ; i < this.rows ; i++){
            for(j = i ; j < this.rows ; j++){
                temp = this.matrix[i][j];
                this.matrix[i][j] = this.matrix[j][i];
                this.matrix[j][i] = temp;
            }
        }
    }

}
