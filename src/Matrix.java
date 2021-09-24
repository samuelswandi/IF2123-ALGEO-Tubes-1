import java.util.Scanner;

import javax.rmi.ssl.SslRMIClientSocketFactory;

public class Matrix {
    int rows, columns;
    double[][] matrix;

    Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new double[rows][columns];
    }


    /* KELOMPOK KONSTRUKTOR */
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

    /*KELOMPOK OPERASI PRIMITIF TERHADAP MATRIX */

    double Determinan() {
        if (this.rows == 1) {
            return this.matrix[0][0];
        } else if (this.rows == 2) {
            return this.matrix[0][0] * this.matrix[1][1] - this.matrix[1][0] * this.matrix[0][1];
        } else {
            int i, j, k;
            double det = 0;
            for (i = 0; i < this.rows; i++) {
                Matrix newM = new Matrix(this.rows - 1, this.columns - 1);
                for (j = 1; j < this.rows; j++) {
                    int row = j - 1, col = 0;
                    for (k = 0; k < this.rows; k++) {
                        if (k != i) {
                            newM.matrix[row][col] = this.matrix[j][k];
                            col++;
                        }
                    }
                }
                if (i % 2 == 0) {
                    det += this.matrix[0][i] * newM.Determinan();
                } else {
                    det += (-1) * this.matrix[0][i] * newM.Determinan();
                }
            }
            return det;
        }
    }

    void Transpose() {
        int i, j;
        double temp;
        for (i = 0; i < this.rows; i++) {
            for (j = i; j < this.rows; j++) {
                temp = this.matrix[i][j];
                this.matrix[i][j] = this.matrix[j][i];
                this.matrix[j][i] = temp;
            }
        }
    }

    double[][] Multiply(double[][] mIn) {
        int i, j, k;
        double[][] mOut = new double[this.rows][mIn[0].length];
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < mIn[0].length; j++) {
                mOut[i][j] = 0;
                for (k = 0; k < this.columns; k++) {
                    mOut[i][j] += this.matrix[i][k] * mIn[k][j];
                }
            }
        }
        return mOut;
    }

    void MultiplyConst(double n) {
        int i, j;
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.columns; j++) {
                this.matrix[i][j] *= n;
            }

        }
    }


    /* KELOMPOK PENYELESAIAN SPL MATRIX */
    void SPLbalikan() {
        int i, j, row = 0;
        Matrix mOut = new Matrix(this.rows, this.columns - 1);
        Matrix temp = new Matrix(this.rows, 1);
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.columns; j++) {
                if (j == this.columns - 1) {
                    temp.matrix[row][0] = this.matrix[i][j];
                    row++;
                } else {
                    mOut.matrix[i][j] = this.matrix[i][j];
                }
            }
        }

        System.out.println("Hasil SPL :");
        mOut.Inverse();
        this.matrix = mOut.Multiply(temp.matrix);   /* Size matrix juga berubah ,  apa ga sekalian diubah?*/
        this.DisplayMatrix();
    }

    void SPLcramer(){
        double det = this.Determinan();
        Matrix result = new Matrix(this.rows,1);
        for(int i = 0 ; i < this.rows ; i++){
            // Temporary Matrix for Value Assigning
            Matrix temp = new Matrix(this.rows, this.columns - 1);
            for(int tempRow = 0 ; tempRow < this.rows ; tempRow++){
                for(int tempCol = 0 ; tempCol < this.columns - 1 ; tempCol++){
                    if (tempCol == i){
                        temp.matrix[tempRow][tempCol] = this.matrix[tempRow][this.columns - 1];
                    }
                    else{
                        temp.matrix[tempRow][tempCol] = this.matrix[tempRow][tempCol];
                    }
                }
            }
            //Assign Temporary Matrix Determinant for Variable's Resolver
            result.matrix[i][0] = temp.Determinan() / det;
        }
        System.out.println("Hasil SPL :");
        this.matrix = result.matrix;
        this.columns = 1;
        this.DisplayMatrix();
    }



    /* KELOMPOK PENYELESAIAN INVERSE MATRIX */
    void Inverse() {
        int i, j, a, b;
        double det = this.Determinan();
        Matrix cofactor = new Matrix(this.rows, this.columns);
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.columns; j++) {
                Matrix tempMatrix = new Matrix(this.rows - 1, this.columns - 1);
                int row = 0;
                for (a = 0; a < this.rows; a++) {
                    int col = 0;
                    for (b = 0; b < this.columns; b++) {
                        if (a != i && b != j) {
                            tempMatrix.matrix[row][col] = this.matrix[a][b];
                            col++;
                        }
                    }
                    if (a != i) {
                        row++;
                    }
                }
                if ((i + j) % 2 == 0) {
                    cofactor.matrix[i][j] = tempMatrix.Determinan();
                } else {
                    cofactor.matrix[i][j] = (-1) * tempMatrix.Determinan();
                }
            }
        }
        if (this.Determinan() == 0) {
            System.out.println("Matriks tidak memiliki invers!");
        } else {
            cofactor.Transpose();
            cofactor.MultiplyConst(1 / det);
            this.matrix = cofactor.matrix;
        }
    }
}
