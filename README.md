# Tugas Besar Aljabar Linear dan Geometri - IF2123

## Tugas Besar ini dibuat oleh :

    13520075 - Samuel Christopher Swandi
    13520078 - Grace Claudia
    13520109 - Patrick Amadeus Irawan

## _Repository_ ini berisi:

    Folder bin berisi java bytecode (*.class)
    Folder src berisi source code dari program java
    Folder test berisi data uji.
    Folder doc berisi laporan

## Code **Syntax** and **Semantics** Guide :triangular_ruler:
---
1.  _procedure_ : Short desc; IS and FS.
    ```java
        void SPLbalikan() {
        /* Mencari Solusi SPL dengan metode inverse */
        /* I.S. = Matrix terdefinisi yang memiliki nilai determinan != 0 */
        /* F.S. = Tercetak solusi penyelesaian variabel x1,x2,...,xN dengan N = banyaknya 
                  baris matrix augmented yang dipisahkan dengan newline (\n)  */
            int i, j, row = 0;
            Matrix mOut = new Matrix(this.rows, this.columns - 1);
            Matrix temp = new Matrix(this.rows, 1);
            for (i = 0; i < this.rows; i++) {
                for (j = 0; j < this.columns; j++) {
        ...
    ```
2. _function_ : Short Desc; return something
    ```java
        double[][] Multiply(double[][] mIn) {
        /* Prekondisi : Ukuran kolom efektif Matrix = ukuran baris efektif mIn */
        /* Mengirim hasil perkalian matriks berupa array double 2-Dimensi */
            int i, j, k;
            double[][] mOut = new double[this.rows][mIn[0].length];
            for (i = 0; i < this.rows; i++) {
        ...
    ```

3. Functional Grouping : Pakai /***** CAPITAL LETTERS *****/
    ```java
       /***** KELOMPOK PENYELESAIAN SPL MATRIX *****/
    void SPLbalikan() {
        ...
    }

    void SPLcramer(){
        ...
    }
    ...
    ```

4. Short Comment using `//comment`
    ```java
        double[][] Multiply(double[][] mIn) {
            //variable untuk indexing
            int i, j, k;

            //initialize nested array
            double[][] mOut = new double[this.rows][mIn[0].length];
            for (i = 0; i < this.rows; i++) {
        ...
    ```
