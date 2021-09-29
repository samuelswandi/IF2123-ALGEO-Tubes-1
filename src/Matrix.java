import java.io.*;
import java.util.Scanner;
import java.lang.Math;

public class Matrix {
    int rows, columns;
    double[][] matrix;

    Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new double[rows][columns];
    }

    void CreateMatrix() {
        /* Membaca dan membentuk matrix dari class Matrix */
        /* I.S. = - */
        /* F.S. = Terbentuk Matrix sesuai dengan inputan pengguna */
        Scanner in = new Scanner(System.in);
        System.out.print("Pilihan masukkan (1 : Manual Keyboard, 2 : Masukkan nama file) : ");
        int choice = in.nextInt();
        if (choice == 1) {
            System.out.print("Masukkan ukuran matriks (m x n): ");
            this.rows = in.nextInt();
            this.columns = in.nextInt();

            System.out.println("Masukkan elemen matriks: ");
            this.matrix = new double[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    this.matrix[i][j] = in.nextFloat();
                }
            }
        } else if (choice == 2) {
            try {
                System.out.print("Silahkan masukkan nama file: ");
                Scanner scnr = new Scanner(System.in);
                File text = new File(scnr.nextLine());
                scnr = new Scanner(text);

                System.out.print("Masukkan ukuran matriks (m x n): ");
                this.rows = in.nextInt();
                this.columns = in.nextInt();
                this.matrix = new double[rows][columns];

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        this.matrix[i][j] = scnr.nextDouble();
                    }
                }
                scnr.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else {
            System.out.println("Pilihan yang anda masukkan salah");
        }

    }

    void CreateMatrix2() { // Untuk kasus determinan dan matriks balikan, yang input matriks hanya n, dan
                           // ukuran matriks harus nxn
        /* Membaca dan membentuk matrix dari class Matrix */
        /* I.S. = - */
        /* F.S. = Terbentuk Matrix sesuai dengan inputan pengguna */
        Scanner in = new Scanner(System.in);
        System.out.print("Pilihan masukkan (1 : Manual Keyboard, 2 : Masukkan nama file): ");
        int choice = in.nextInt();
        if (choice == 1) {
            System.out.print("Masukkan ukuran matriks (n x n): ");
            int n = in.nextInt();
            this.rows = n;
            this.columns = n;

            System.out.println("Masukkan elemen matriks: ");
            this.matrix = new double[n][n];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    this.matrix[i][j] = in.nextFloat();
                }
            }
        } else if (choice == 2) {
            try {
                System.out.print("Silahkan masukkan nama file: ");
                Scanner scnr = new Scanner(System.in);
                File text = new File(scnr.nextLine());
                scnr = new Scanner(text);

                System.out.print("Masukkan ukuran matriks (n x n): ");
                int n = in.nextInt();
                this.rows = n;
                this.columns = n;
                this.matrix = new double[n][n];

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        this.matrix[i][j] = scnr.nextDouble();
                    }
                }
                scnr.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else {
            System.out.println("Pilihan yang anda masukkan salah");
        }

    }

    void DisplayMatrix() {
        /* Mencetak matrix ke layar */
        /* I.S. = Matrix bebas terdefinisi */
        /*
         * F.S. = Tercetak elemen-elemen Matrix ke layar sesuai dengan format penulisan
         * matriks contoh : 1 0 0 0 1 0 0 0 1
         */
        for (double[] row : this.matrix) {
            for (double col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    /***** KELOMPOK OPERASI PRIMITIF TERHADAP MATRIX *****/

    void Transpose() {
        /* Menghasilkan matrix transpose */
        /* I.S. = Matrix persegi terdefinisi (Matriks berukuran N x N) */
        /*
         * F.S. = Terbentuk matriks transpose dengan definisi dari matriks transpose
         * adalah newMatrix[i][j] = oldMatrix[j][i]
         */
        int i, j;
        double temp;

        if (this.rows == this.columns) {
            for (i = 0; i < this.rows; i++) {
                for (j = i; j < this.rows; j++) {
                    temp = this.matrix[i][j];
                    this.matrix[i][j] = this.matrix[j][i];
                    this.matrix[j][i] = temp;
                }
            }
        } else {
            Matrix mOut = new Matrix(this.columns, this.rows);
            for (i = 0; i < this.columns; i++) {
                for (j = 0; j < this.rows; j++) {
                    mOut.matrix[i][j] = this.matrix[j][i];
                }
            }
            this.matrix = mOut.matrix;
            this.rows = mOut.rows;
            this.columns = mOut.columns;

        }
    }

    double[][] Multiply(double[][] mIn) {
        /* Prekondisi : Ukuran kolom efektif Matrix = ukuran baris efektif mIn */
        /* Mengirim hasil perkalian matriks berupa array double 2-Dimensi */
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

    void Add(double[][] mIn) {
        /* Menambahkan elemen pada matrix utama dengan matrix lain */
        /* I.S. = Matrix terdefinisi, jumlah baris dan kolom kedua matriks sama */
        /* F.S. = Menambah matrix utama dengan matriks input */
        int i, j;
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.columns; j++) {
                this.matrix[i][j] += mIn[i][j];
            }
        }

    }

    void Substract(double[][] mIn) {
        /* Mengurangkan elemen pada matrix utama dengan matrix lain */
        /* I.S. = Matrix terdefinisi, jumlah baris dan kolom kedua matriks sama */
        /* F.S. = Mengurangkan matrix utama dengan matriks input */
        int i, j;
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.columns; j++) {
                this.matrix[i][j] -= mIn[i][j];
            }
        }
    }

    void MultiplyConst(double n) {
        /* Mengalikan setiap element matriks dengan konstanta n */
        /* I.S. = Matrix terdefinisi */
        /*
         * F.S. = Terbentuk Matrix yang setiap elementnya telah dikalikan dengan
         * konstanta n
         */
        int i, j;
        for (i = 0; i < this.rows; i++) {
            for (j = 0; j < this.columns; j++) {
                this.matrix[i][j] *= n;
            }

        }
    }

    double diagonalProduct() {
        /* Mengalikan setiap element diagonal matriks */
        /* I.S. = Matrix SQUARE terdefinisi */
        /*
         * F.S. = Mengeluarkan hasil perkalian setiap element diagonal utama Matrix
         * 
         */
        double result = 1.0;
        for (int i = 0 ; i < this.rows ; i++){
            result *= this.matrix[i][i];
        }
        return result;
    }

    /***** KELOMPOK PENYELESAIAN SPL MATRIX *****/
    void SPLbalikan() {
        /* Mencari Solusi SPL dengan metode inverse */
        /* I.S. = Matrix terdefinisi yang memiliki nilai determinan != 0 */
        /*
         * F.S. = Tercetak solusi penyelesaian variabel x1,x2,...,xN dengan N =
         * banyaknya baris matrix augmented yang dipisahkan dengan newline (\n)
         */
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
        mOut.cofactorInverse();
        this.matrix = mOut.Multiply(temp.matrix);
        this.columns = 1;
        this.DisplayMatrix();
    }

    void SPLcramer() {
        /* Mencari Solusi SPL dengan kaidah cramer */
        /* I.S. = Matrix terdefinisi yang memiliki nilai determinan != 0 */
        /*
         * F.S. = Tercetak solusi penyelesaian variabel x1,x2,...,xN dengan N =
         * banyaknya baris matrix augmented yang dipisahkan dengan newline (\n)
         */
        double det = this.cofactorDeterminan();
        Matrix result = new Matrix(this.rows, 1);
        for (int i = 0; i < this.rows; i++) {
            // Temporary Matrix for Value Assigning
            Matrix temp = new Matrix(this.rows, this.columns - 1);
            for (int tempRow = 0; tempRow < this.rows; tempRow++) {
                for (int tempCol = 0; tempCol < this.columns - 1; tempCol++) {
                    if (tempCol == i) {
                        temp.matrix[tempRow][tempCol] = this.matrix[tempRow][this.columns - 1];
                    } else {
                        temp.matrix[tempRow][tempCol] = this.matrix[tempRow][tempCol];
                    }
                }
            }
            // Assign Temporary Matrix Determinant for Variable's Resolver
            result.matrix[i][0] = temp.cofactorDeterminan() / det;
        }
        System.out.println("Hasil SPL :");
        this.matrix = result.matrix;
        this.columns = 1;
        this.DisplayMatrix();
    }

    /***** KELOMPOK ALGORITMA DETERMINAN *****/
    double cofactorDeterminan() {
        /* Prekondisi: Matrix berjenis matriks persegi (berukuran N x N) */
        /* Menghitung nilai determinan Matrix */
        if (this.rows == 1) {
            return this.matrix[0][0];
        } else if (this.rows == 2) {
            return this.matrix[0][0] * this.matrix[1][1] - this.matrix[1][0] * this.matrix[0][1];
        } else {
            int i, j, k;
            double det = 0;
            for (i = 0; i < this.rows; i++) {
                Matrix newM = new Matrix(this.rows - 1, this.columns - 1);
                for (j = 1; j < this.columns; j++) {
                    int row = j - 1, col = 0;
                    for (k = 0; k < this.rows; k++) {
                        if (k != i) {
                            newM.matrix[row][col] = this.matrix[j][k];
                            col++;
                        }
                    }
                }
                if (i % 2 == 0) {
                    det += this.matrix[0][i] * newM.cofactorDeterminan();
                } else {
                    det += (-1) * this.matrix[0][i] * newM.cofactorDeterminan();
                }
            }
            return det;
        }
    }

    double gaussDeterminan(){
        /* Prekondisi: Matrix berjenis matriks persegi (berukuran N x N) */
        /* Menghitung nilai determinan Matrix */
        double[] temp = this.GaussTransform();
        return this.diagonalProduct() * Math.pow(-1,temp[0]) / temp[1];
    }

    /***** KELOMPOK PENYELESAIAN INVERSE MATRIX *****/

    void addIdentity(){
        /* I.S. = Matrix Square terdefinisi */
        /* F.S. = Ditambahkan matrix identitas berukuran (n x n) --> untuk keperluan Inverse metode Gauss-Jordan */
        Matrix inverseMatrix = new Matrix(this.rows, this.columns * 2);
        for (int inverseRow = 0 ; inverseRow < inverseMatrix.rows ; inverseRow++){
          for (int inverseCol = 0 ; inverseCol < inverseMatrix.columns ; inverseCol++){
            if (inverseCol < this.columns){
              inverseMatrix.matrix[inverseRow][inverseCol] = this.matrix[inverseRow][inverseCol];
            }
            else{
              if (inverseCol == inverseRow + this.columns){
                inverseMatrix.matrix[inverseRow][inverseCol] = 1;
              }
              else{
                inverseMatrix.matrix[inverseRow][inverseCol] = 0;
              }
            }
          }
        }
        
        //converting original matrix
        this.columns = this.columns * 2;
        this.matrix = inverseMatrix.matrix;
    }

    void delIdentity(){
        /* I.S. = Matrix Terdefinisi ukuran (n x 2n) hasil bentukan metoda Gauss-Jordan */
        /* F.S. = Terbentuk matrix (n x n) setelah matrix identitas sebelah kiri terhapus */
        Matrix deletedMatrix = new Matrix(this.rows , this.columns / 2);
        for(int i = 0 ; i < this.rows ; i++){
            for (int j = this.columns / 2 ; j < this.columns ; j++){
                deletedMatrix.matrix[i][j - deletedMatrix.columns] = this.matrix[i][j];
            }
        }
        
        //converting original matrix
        this.columns = this.columns / 2;
        this.matrix = deletedMatrix.matrix;
    }


    void cofactorInverse() {
        /* Menghasilkan inverse / balikan dari suatu matriks */
        /* I.S. = Matrix terdefinisi bebas */
        /*
         * F.S. = Matriks yang bersangkutan akan berubah menjadi matriks balikan
         * terdefinisi , sebaliknya apabila tidak memiliki balikan akan tercetak pesan
         * peringatan pada layar.
         */
        int i, j, a, b;
        double det = this.cofactorDeterminan();
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
                    cofactor.matrix[i][j] = tempMatrix.cofactorDeterminan();
                } else {
                    cofactor.matrix[i][j] = (-1) * tempMatrix.cofactorDeterminan();
                }
            }
        }
        if (this.cofactorDeterminan() == 0) {
            System.out.println("Matriks tidak memiliki invers!");
        } else {
            cofactor.Transpose();
            cofactor.MultiplyConst(1 / det);
            this.matrix = cofactor.matrix;
        }
    }


    void gaussJordanInverse(){
        /* Menghasilkan inverse / balikan dari suatu matriks */
        /* I.S. = Matrix terdefinisi bebas */
        /*
         * F.S. = Matriks yang bersangkutan akan berubah menjadi matriks balikan
         * terdefinisi , sebaliknya apabila tidak memiliki balikan akan tercetak pesan
         * peringatan pada layar.
         */
        this.addIdentity();
        this.GaussJordanTransform();
        this.delIdentity();
    }

    /***** KELOMPOK ALGORITMA INTI GAUSS , GAUSS JORDAN *****/
    int argmax(int h, int k){
        /* Menghasilkan Index dari nilai absolute terbesar dari kolom k suatu 
        matriks mulai dari kolom h hingga matrix.rows - 1 */

        /* I.S. = Matrix terdefinisi bebas */
        /*
         * F.S. = Dikembalikan Index dengan nilai absolute terbesar.
         */
        int i_max = h;
        for (int i = h; i < this.rows; i++) {
            if (Math.abs(this.matrix[i][k]) > Math.abs(this.matrix[i_max][k])) {
               i_max = i;
            }
        }
        return i_max;
    }

    void swapRow(int i, int j){
        for(int col = 0 ; col < this.columns ; col++){
            double temp;
            temp = this.matrix[i][col];
            this.matrix[i][col] = this.matrix[j][col];
            this.matrix[j][col] = temp;
        } 
    }

    double[] GaussTransform(){
        /* I.S. = Matrix Terdefinisi */
        /* F.S. = Terbentuk Matrix eselon baris */
        double[] constraint = {0,1}; 
        int h = 0 , k = 0;
        while (h < this.rows && k < this.columns){
            //Cari k-th pivot
            int i_max = this.argmax(h, k);
            if (this.matrix[i_max][k] == 0){
                k++;
            }
            else{
                this.swapRow(h, i_max);
                constraint[0]++;

                for(int i = h+1 ; i < this.rows ; i++){
                    double f = this.matrix[i][k] / this.matrix[h][k];
                    this.matrix[i][k] = 0;
                    
                    for(int j = k+1 ; j < this.columns ; j++){
                        this.matrix[i][j] -= this.matrix[h][j] * f;
                    }
                }
                h++;
                k++;
            }
        }

        return constraint;
    }

    void transformOne(){
        //Membentuk Form matrix echelon dengan 1 utama
        for(int row = 0 ; row < this.rows ; row++){
            int j = 0;
            while(j < this.columns && this.matrix[row][j] == 0){
                j++;
            }
            if ( j < this.columns){
                double temp = this.matrix[row][j];
                for(int column = j ; column < this.columns ; column++){
                    this.matrix[row][column] /= temp;
                }
            }
        }
    }

    void GaussJordanTransform(){
        /* I.S. = Matrix Terdefinisi */
        /* F.S. = Terbentuk Matrix eselon baris */
        double[] temp = this.GaussTransform();
        this.transformOne();
        for(int row = 0 ; row < this.rows ; row++){
            int j = 0;
            while(j < this.columns && this.matrix[row][j] == 0){
                j++;
            }
            if ( j < this.columns){
                for(int tempRow = row-1 ; tempRow >= 0 ; tempRow--){
                    double constant = this.matrix[tempRow][j];
                    for(int tempCol = j ; tempCol < this.columns ; tempCol++){
                        this.matrix[tempRow][tempCol] -= constant*this.matrix[row][tempCol];
                    }
                }
            }
        }
    }


    /***** KELOMPOK ALGORITMA TURUNAN *****/

    void interpolation(double x) {
        this.SPLbalikan();
        double y = 0;
        String p = "y = ";
        for (int i = 0; i < this.rows; i++) {
            y = y + this.matrix[i][0] * (Math.pow(x, i));
            if (i == 0) {
                p += this.matrix[i][0];
            } else if (i == 1) {
                p += " + " + this.matrix[i][0] + "x";
            } else {
                p += " + " + this.matrix[i][0] + "x**" + i;
            }
        }
        System.out.println("Persamaan yang diperoleh: ");
        System.out.println(p);
        System.out.print("Untuk x dengan nilai " + x + ", hasil yang diperoleh: ");
        System.out.println(y);
    }

    void multipleLinearReg(double humidity, double temp, double p) {
        Matrix eq = new Matrix(this.columns, this.columns+1);
        for (int i = 0; i <eq.rows; i++) {
            for (int j = 0; j <eq.columns; j++) {
                double count = 0;
                for (int k=0; k<this.rows;k++){
                    if (i==0&j==0){
                        count = this.rows;
                        break;
                    }else if (i==0 && j==eq.columns-1){
                        count+=this.matrix[k][this.columns-1];
                    }else if (i!=0 && j==eq.columns-1){
                        count = count + this.matrix[k][i-1]*this.matrix[k][this.columns-1];
                    }else if (i==0 && (j!=eq.columns-1)){
                        count+=this.matrix[k][j-1];
                    } else if (j==0 && i!=0){
                        count+=this.matrix[k][i-1];
                    }else{
                        count+=this.matrix[k][i-1]*this.matrix[k][j-1];
                    }
                }
                // BigDecimal elmt = new BigDecimal(count).setScale(2, RoundingMode.HALF_UP);
                // eq.matrix[i][j] = elmt.doubleValue();
                eq.matrix[i][j] = count;
            }
        }
        // eq.DisplayMatrix();
        eq.SPLbalikan();

        for (int i=0; i<eq.rows;i++){
            for (int j=0;j<eq.columns;j++){
                if (i==eq.rows-2){
                    System.out.print(eq.matrix[i][j]+"b"+j);
                }else if(i==eq.rows-1){
                    System.out.print(" = "+eq.matrix[i][j]);
                }else{
                    System.out.print(eq.matrix[i][j]+"b"+j+" + ");
                }
            }
            System.out.println("");
        }

        double[] data = { 1, humidity, temp, p };
        String pers = "y = ";
        double y = 0;
        for (int i = 0; i < eq.rows; i++) {
            y = y + eq.matrix[i][0] * (data[i]);
            if (i == 0) {
                pers += eq.matrix[i][0];
            } 
            else {
                pers += " + x"+i+"*"+ eq.matrix[i][0];
            }
        }
        
        System.out.println("Persamaan yang diperoleh: ");
        System.out.println(pers);
        System.out.println("Untuk data humidity " + humidity + " temperature " + temp + " dan pressure " + p
                + ", estimasi NO yang diperoleh adalah sebanyak " + y);
    }
}
