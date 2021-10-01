import java.io.*;
import java.util.*;
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
        System.out.print("Pilihan masukkan (1 : Manual Keyboard, 2 : Masukkan nama file): ");
        int choice = in.nextInt();
        if (choice == 1) {
            System.out.print("Masukkan ukuran matriks m(baris) n(kolom): ");
            this.rows = in.nextInt();
            this.columns = in.nextInt();

            System.out.println("Masukkan elemen matriks: ");
            this.matrix = new double[this.rows][this.columns];

            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    this.matrix[i][j] = in.nextFloat();
                }
            }
        } else if (choice == 2) {
            try {
                System.out.print("Silahkan masukkan nama file beserta extension(.txt): ");
                Scanner scnr = new Scanner(System.in);
                File text = new File(scnr.nextLine());
                scnr = new Scanner(text);

                System.out.print("Masukkan ukuran matriks m(baris) n(kolom): ");
                this.rows = in.nextInt();
                this.columns = in.nextInt();
                this.matrix = new double[this.rows][this.columns];

                for (int i = 0; i < this.rows; i++) {
                    for (int j = 0; j < this.columns; j++) {
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
            System.out.print("Masukkan ukuran matriks n(baris & kolom): ");
            int n = in.nextInt();
            this.rows = n;
            this.columns = n;

            System.out.println("Masukkan elemen matriks: ");
            this.matrix = new double[n][n];

            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    this.matrix[i][j] = in.nextFloat();
                }
            }
        } else if (choice == 2) {
            try {
                System.out.print("Silahkan masukkan nama file beserta extension(.txt): ");
                Scanner scnr = new Scanner(System.in);
                File text = new File(scnr.nextLine());
                scnr = new Scanner(text);

                System.out.print("Masukkan ukuran matriks n(baris & kolom): ");
                int n = in.nextInt();
                this.rows = n;
                this.columns = n;
                this.matrix = new double[n][n];

                for (int i = 0; i < this.rows; i++) {
                    for (int j = 0; j < this.columns; j++) {
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

    void SaveToFile(int choice) {
        /* Membaca dan Membuat File Baru untuk memasukkan matrix*/
        /* I.S. = - */
        /* F.S. = Terbentuk file baru atau menulis file yang sudah ada */
        try {
            Scanner in = new Scanner(System.in);
            if (choice == 1) {
                System.out.print("Masukkan nama file beserta extension(.txt): ");
                FileWriter myWriter = new FileWriter(in.nextLine());
                for (int i = 0; i < this.rows; i++) {
                    for (int j = 0;j< this.columns;j++){
                        myWriter.write(Double.toString(this.matrix[i][j]));
                        myWriter.write(" ");
                    }
                    myWriter.write("\n");
                }
                System.out.println("File telah berhasil dibuat!\n");
                myWriter.close();
            } else {
                System.out.println("");
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void SaveToFile2(int choice, double det) {
        /* Membaca dan Membuat File Baru untuk memasukkan determinan*/
        /* I.S. = - */
        /* F.S. = Terbentuk file baru atau menulis file yang sudah ada */
        try {
            Scanner in = new Scanner(System.in);
            if (choice == 1) {
                System.out.print("Masukkan nama file beserta extension(.txt): ");
                FileWriter myWriter = new FileWriter(in.nextLine());
                myWriter.write("Determinan = ");
                myWriter.write(Double.toString(det));
                myWriter.write("\n");
                System.out.println("File telah berhasil dibuat!\n");
                myWriter.close();
            } else {
                System.out.println("");
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void SaveToFile3(int choice, String sentence) {
        /* Membaca dan Membuat File Baru untuk memasukkan determinan*/
        /* I.S. = - */
        /* F.S. = Terbentuk file baru atau menulis file yang sudah ada */
        try {
            Scanner in = new Scanner(System.in);
            if (choice == 1) {
                System.out.print("Masukkan nama file beserta extension(.txt): ");
                FileWriter myWriter = new FileWriter(in.nextLine());
                myWriter.write(sentence);
                myWriter.write("\n");
                System.out.println("File telah berhasil dibuat!\n");
                myWriter.close();
            } else {
                System.out.println("");
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
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

    void DisplayMatrix2() {
        /* Mencetak matrix ke layar dengan format SPL*/
        /* I.S. = Matrix bebas terdefinisi */
        /*
         * F.S. = Tercetak elemen-elemen Matrix ke layar sesuai dengan format penulisan
         * matriks contoh : 1 0 0 0 1 0 0 0 1
         */
        int i = 1;
        for (double[] row : this.matrix) {
            for (double col : row) {
                System.out.print("X" + i + " = " + col + " ");
                i++;
            }
            System.out.println();
        }
    }

    /***** KELOMPOK OPERASI PRIMITIF TERHADAP MATRIX *****/

    void validateZero(){
        /* I.S. = Matrix terdefinisi */
        /* F.S. = Elemen matriks dengan besar < abs(10^-8) diubah menjadi 0 */
        for (int i = 0 ; i<this.rows ; i++){
            for(int j = 0 ; j < this.columns ; j++){
                if (Math.abs(this.matrix[i][j]) <= 0.00000001){
                    this.matrix[i][j] = 0.0;
                }
            }
        }
    }


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

    double DiagonalProduct() {
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
    void SPLInverse() {
        /* Mencari Solusi SPL dengan metode inverse */
        /* I.S. = Matrix terdefinisi yang memiliki nilai determinan != 0 */
        /*
         * F.S. = Tercetak solusi penyelesaian variabel x1,x2,...,xN dengan N =
         * banyaknya baris matrix augmented yang dipisahkan dengan newline (\n)
         */
        if (this.rows != this.columns-1){
            System.out.println("Dibutuhkan " + this.columns +" persamaan untuk " + this.columns + " buah variabel!");
        } else {
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
            if(Math.abs(mOut.CofactorDeterminan()) <= 0.0000000001) {
                System.out.println("Matriks tidak memiliki invers!");
            } else {
                System.out.println("Hasil SPL :");
                mOut.GaussJordanInverse();
                this.matrix = mOut.Multiply(temp.matrix);
                this.columns = 1;
                this.DisplayMatrix2();
            }
        }
        
        
    }

    void SPLCramer() {
        /* Mencari Solusi SPL dengan kaidah cramer */
        /* I.S. = Matrix terdefinisi yang memiliki nilai determinan != 0 */
        /*
         * F.S. = Tercetak solusi penyelesaian variabel x1,x2,...,xN dengan N =
         * banyaknya baris matrix augmented yang dipisahkan dengan newline (\n)
         */
        if(this.rows != this.columns-1){
            System.out.println("Dibutuhkan " + this.columns +" persamaan untuk " + this.columns + " buah variabel!");
        } else {
            double det = this.GaussDeterminan();
            if(Math.abs(det) <= 0.00000001) {
                System.out.println("Determinan matriks 0!");
            } else {
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
                    result.matrix[i][0] = temp.CofactorDeterminan() / det;
                }
                System.out.println("Hasil SPL :");
                this.matrix = result.matrix;
                this.columns = 1;
                this.DisplayMatrix2();
            }
        }
       
       
    }

    void gaussUniqueSolution(){
        /* Penyelesaian tipe matrix Unique Solution (Gauss/Gauss-Jordan SPL Method) */
        /* I.S. = Matrix echelon baris biasa / tereduksi bertipe Unique Solution */
        /*
         * F.S. = Tercetak solusi penyelesaian variabel x1,x2,...,xN dengan N = matrix.rows
         */
        double[] result = new double[this.rows];
        for(int i = this.rows - 1; i >= 0 ; i--){
            result[i] = this.matrix[i][this.columns - 1];
            for (int j = this.columns - 2 ; j > i; j--){
                result[i] -= this.matrix[i][j] * result[j];
            }
        }
        System.out.println("-----UNIQUE SOLUTION(S)-----");
        for(int i = 0 ; i < this.rows ; i++){
            System.out.println("X" + (i+1) + " = " + result[i]);
        }
    }

    boolean zeroRow(int i){
        /* Memeriksa suatu baris terdiri atas 0 seluruhnya. */
        /* Prekondisi : Matrix tidak kosong, minimal 1x1 */
        /* Mengembalikan true apabila suatu baris memiliki elemen 0 seluruhnya */
        boolean flag = true;
        int col = 0;
        while (col < this.columns && flag){
            if (this.matrix[i][col] != 0){flag = false;} 
            col++;
        }
        return flag;
    }

    int countZeroRow(){
        int count = 0;
        for (int i = 0 ; i < this.rows ; i++){
            if (this.zeroRow(i)){
                count++;
            }
        }
        return count;
    }

    void gaussMultipleSolution(){
        /* Penyelesaian tipe matrix Unique Solution (Gauss/Gauss-Jordan SPL Method) */
        /* I.S. = Matrix echelon baris biasa / tereduksi bertipe Multiple Solution */
        /*
         * F.S. = Tercetak solusi penyelesaian variabel x1,x2,...,xN dengan N = matrix.rows, menggunakan
         * pendekatan parametrik dengan batasan alfabet (p - z) [ASCII 112 - 122]
         */
    }


    void SPLGauss(){
        /* Mencari Solusi SPL dengan metode Gauss */
        /* I.S. = Matrix terdefinisi yang memiliki nilai determinan != 0 */
        /*
         * F.S. = Tercetak solusi penyelesaian variabel x1,x2,...,xN dengan N =
         * banyaknya baris matrix augmented yang dipisahkan dengan newline (\n)
         */
        double[] temp = this.GaussTransform();
        this.TransformOne();
        if (this.rows < this.columns - 1){
            this.addZeroBelow();
        }
        switch(this.CheckMatrix()){

            //Segmen Solusi Unik
            case 0:
            this.gaussUniqueSolution();
            break;
            
            //Segmen Solusi Banyak
            case 1:
            this.gaussMultipleSolution();
            break;

            //Segmen Tidak Terdapat Solusi
            case 2:
            System.out.println("SPL tidak memiliki solusi penyelesaian.");
            break;
            
            default:

            break;
        }
    }


    void SPLGaussJordan(){
        /* Mencari Solusi SPL dengan metode Gauss-Jordan */
        /* I.S. = Matrix terdefinisi yang memiliki nilai determinan != 0 */
        /*
         * F.S. = Tercetak solusi penyelesaian variabel x1,x2,...,xN dengan N =
         * banyaknya baris matrix augmented yang dipisahkan dengan newline (\n)
         */
        this.GaussJordanTransform();
        if (this.rows < this.columns - 1){
            this.addZeroBelow();
        }
        switch(this.CheckMatrix()){

            //Segmen Solusi Unik
            case 0:
            this.gaussUniqueSolution();
            break;
            
            //Segmen Solusi Banyak
            case 1:
            this.gaussMultipleSolution();
            break;

            //Segmen Tidak Terdapat Solusi
            case 2:
            System.out.println("SPL tidak memiliki solusi penyelesaian.");
            break;
            
            default:

            break;
        }
    }

    int CheckMatrix(){
        /* Mengecek apakah matriks memiliki satu unik, banyak, atau tidak ada solusi*/
        /* I.S. = Matrix sudah merupakan matrix baris tereduksi */
        /*
         * F.S. = Tercetak solusi apakah matriks memiliki satu unik, banyak, atau tidak ada solusi
         * 0 = Satu solusi yang unik
         * 1 = Banyak solusi
         * 2 = Tidak ada solusi
         */
        boolean temp = true;
        for(int j = 0; j < this.columns ; j++) {
            if (this.matrix[this.rows-1][j] != 0) {
                temp = false;
            }
        }
        if (temp) {
            for(int i = this.rows - 1 ; i >= 0; i--){
                boolean isZero = true; // 0 0 0 0 0 0 0 0 0 0 (0)
                for(int j = 0 ; j < this.columns - 1;j++){
                    if(this.matrix[i][j] != 0){
                        isZero = false;
                    }
                }
                if (isZero){
                    if(this.matrix[i][this.columns - 1] != 0){
                        temp = false;
                    }
                }
                if (!temp){break;}
            }

            if (temp){
                return 1;
            }
            else{
                return 2;
            }

        } else {
            boolean temp2 = true;
            for(int j = 0; j < this.columns ; j++) {
                if(j == this.columns - 1) {
                    if(this.matrix[this.rows-1][j] == 0){
                        temp2 = false;
                    }
                } else {
                    if(this.matrix[this.rows-1][j] != 0) {
                        temp2 = false;
                    }
                }
            }
            if (temp2) {
                return 2;
            } else {
                return 0;
            }
        }

    }

    /***** KELOMPOK ALGORITMA DETERMINAN *****/
    double CofactorDeterminan() {
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
                    det += this.matrix[0][i] * newM.CofactorDeterminan();
                } else {
                    det += (-1) * this.matrix[0][i] * newM.CofactorDeterminan();
                }
            }
            return det;
        }
    }

    double GaussDeterminan(){
        /* Prekondisi: Matrix berjenis matriks persegi (berukuran N x N) */
        /* Menghitung nilai determinan Matrix */
        double[] temp = this.GaussTransform();
        return this.DiagonalProduct() * Math.pow(-1,temp[0]) / temp[1];
    }

    /***** KELOMPOK PENYELESAIAN INVERSE MATRIX *****/

    void AddIdentity(){
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

    void DelIdentity(){
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

    void addZeroBelow(){
        Matrix tempMatrix = new Matrix(this.columns -1 , this.columns);
        for(int i = 0 ; i < tempMatrix.rows ; i++){
            for (int j =0 ; j < tempMatrix.columns ;j++){
                if (i < this.rows){
                    tempMatrix.matrix[i][j] = this.matrix[i][j];
                }
                else{
                    tempMatrix.matrix[i][j] = 0.0;
                }
            }
        }
        this.matrix = tempMatrix.matrix;
        this.rows = this.columns - 1;
    }


    void CofactorInverse() {
        /* Menghasilkan inverse / balikan dari suatu matriks */
        /* I.S. = Matrix terdefinisi bebas */
        /*
         * F.S. = Matriks yang bersangkutan akan berubah menjadi matriks balikan
         * terdefinisi , sebaliknya apabila tidak memiliki balikan akan tercetak pesan
         * peringatan pada layar.
         */
        int i, j, a, b;
        double det = this.CofactorDeterminan();
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
                    cofactor.matrix[i][j] = tempMatrix.CofactorDeterminan();
                } else {
                    cofactor.matrix[i][j] = (-1) * tempMatrix.CofactorDeterminan();
                }
            }
        }
        if (this.CofactorDeterminan() == 0) {
            System.out.println("Matriks tidak memiliki invers!");
        } else {
            cofactor.Transpose();
            cofactor.MultiplyConst(1 / det);
            this.matrix = cofactor.matrix;
        }
    }


    void GaussJordanInverse(){
        /* Menghasilkan inverse / balikan dari suatu matriks */
        /* I.S. = Matrix terdefinisi bebas */
        /*
         * F.S. = Matriks yang bersangkutan akan berubah menjadi matriks balikan
         * terdefinisi , sebaliknya apabila tidak memiliki balikan akan tercetak pesan
         * peringatan pada layar.
         */
        this.AddIdentity();
        this.GaussJordanTransform();
        this.DelIdentity();
    }

    /***** KELOMPOK ALGORITMA INTI GAUSS , GAUSS JORDAN *****/
    int ArgMax(int h, int k){
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

    void SwapRow(int i, int j){
        /* I.S. = Matrix terdefnisi , i dan j merupakan index baris terdefinisi */
        /*
         * F.S. = Mempertukarkan baris i dengan baris j pada Matrix.
         */
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
            int i_max = this.ArgMax(h, k);
            if (this.matrix[i_max][k] == 0){
                k++;
            }
            else{
                this.SwapRow(h, i_max);
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
        this.validateZero();
        return constraint;
    }

    void TransformOne(){
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
        /* F.S. = Terbentuk Matrix eselon baris tereduksi*/
        double[] temp = this.GaussTransform();
        this.TransformOne();
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

    String Interpolation(double x) {
    /*Menghasilkan persamaan dan taksiran nilai dari suatu persamaan yang dicari melalui beberapa titik dengan x nilai yang dicari*/
    /*I.S. = titik-titik pembentuk persamaan didefinisikan dalam bentuk matrix berukuran sesuai banyaknya titik*/
    /*F.S = didapat persamaan yang melewati semua titik yang diketahui dan taksiran nilai y untuk x yang dicari*/

        // Scanner in = new Scanner(System.in);
        this.SPLInverse();
        double y = 0;
        String p = "y = ";

        for (int i = 0; i < this.rows; i++) {
            if (i == 0) {
                p += this.matrix[i][0];
            } else if (i == 1) {
                p += " + " + this.matrix[i][0] + "x";
            } else {
                p += " + " + this.matrix[i][0] + "x**" + i;
            }
        }
        // System.out.print("Masukkan nilai x: ");
        // double x = in.nextFloat();
        for (int i = 0; i < this.rows; i++) {
            y = y + this.matrix[i][0] * (Math.pow(x, i));
        }
        return ("Persamaan yang diperoleh: \n"+ p + "\nUntuk x dengan nilai " + x + ", hasil yang diperoleh: " + y +"\n");
    }

    String MultipleLinearReg() {
    /*Menghasilkan persamaan dan taksiran nilai dari suatu persamaan yang dicari melalui beberapa data*/
    /*I.S. = data-data pembentuk persamaan didefinisikan dalam bentuk matrix berukuran sesuai banyaknya data*/
    /*F.S = didapat persamaan dari semua data yang diketahui dan taksiran dari data dengan memasukkan data yang ingin dicari taksirannya*/

        Scanner in = new Scanner(System.in);
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
        
        eq.SPLInverse();
        
        System.out.print("Masukkan data X1: ");
        double humidity= in.nextDouble(); 
        System.out.print("Masukkan data X2: ");
        double temp= in.nextDouble(); 
        System.out.print("Masukkan data X3: ");
        double p= in.nextDouble();
        double[] data = { 1, humidity, temp, p };

        String pers = "y = ";
        double y = 0;
        for (int i = 0; i < eq.rows; i++) {
            y = y + eq.matrix[i][0] * (data[i]);
            if (i == 0) {
                pers += eq.matrix[i][0];
            } 
            else {
                pers += " + X"+i+"*"+ eq.matrix[i][0];
            }
        }
        
        return("Persamaan yang diperoleh: \n" + pers +"\nUntuk data X1 " + humidity + " X2 " + temp + " dan X3 " + p
                + ", estimasi Y yang diperoleh adalah sebanyak " + y);
    }
}
