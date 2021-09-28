import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Selamat Datang di Aplikasi Pengolah Matrix!");
    System.out.println();

    System.out.println("MENU");
    System.out.println("1. Sistem Persamaan Linier");
    System.out.println("2. Determinan");
    System.out.println("3. Matriks balikan");
    System.out.println("4. Interpolasi Polinom");
    System.out.println("5. Regresi linear berganda");
    System.out.println("6. Keluar");

    System.out.print("Silahkan masukan angka untuk pengolahan matriks: ");
    int choice = in.nextInt();
    Matrix matrix = new Matrix(0, 0);

    while (choice != 6) {
      matrix.CreateMatrix();
      System.out.println("Matriks yang telah dibuat: ");
      matrix.DisplayMatrix();
      switch (choice) {
        case 1:
          System.out.println("Penyelesaian matriks menggunakan : ");
          System.out.println("1. Metode eliminasi Gauss");
          System.out.println("2. Metode eliminasi Gauss-Jordan ");
          System.out.println("3. Metode matriks balikan ");
          System.out.println("4. Kaidah Cramer ");
          System.out.print("Masukkan angka untuk memilih metode: ");
          int case1Choice = in.nextInt();

          switch (case1Choice) {
            case 1:
              matrix.GaussTransform();
              matrix.DisplayMatrix();
              break;
            case 2:
              matrix.GaussJordanTransform();
              matrix.DisplayMatrix();
              break;
            case 3:
              // Metode invers
              matrix.SPLbalikan();

              break;
            case 4:
              matrix.SPLcramer();
              break;
            default:

              break;
          }

          System.out.print("Masukkan angka untuk memilih menu lain: ");
          choice = in.nextInt();
          break;
        case 2:
          while (matrix.rows != matrix.columns) {
            System.out.print("Matrix bukan merupakan matriks persegi, silahkan masukkan matriks kembali!\n");
            matrix.CreateMatrix();
            System.out.println("Matriks yang telah dibuat: ");
            matrix.DisplayMatrix();
          }
          System.out.print("Determinan dari matriks adalah :");

          double det = matrix.Determinan();
          System.out.print(det);

          System.out.print("\nMasukkan angka untuk memilih menu lain: ");
          choice = in.nextInt();
          break;
        case 3:
          while (matrix.Determinan() == 0) {
            System.out.print("Determinan dari matriks adalah 0, silahkan masukkan matriks kembali!\n");
            matrix.CreateMatrix();
            System.out.println("Matriks yang telah dibuat: ");
            matrix.DisplayMatrix();
          }
          System.out.println("Matriks Balikan : ");
          matrix.Inverse();
          matrix.DisplayMatrix();

          System.out.print("Masukkan angka untuk memilih menu lain: ");
          choice = in.nextInt();
          break;

        case 4:
          String x= in.nextLine();
          x = x.replaceAll(" ","").replaceAll("\\(","").replaceAll("\\)","");
          String[] arrayIn = x.split(",");
          double[] arrayDouble = new double[Integer.parseInt(arrayIn[0])*2+2];
          for (int i=0; i<Integer.parseInt(arrayIn[0])*2+2;i++){
              arrayDouble[i] = Double.parseDouble(arrayIn[i]);
          }
              for (double a : arrayDouble)
                  System.out.println(a);
            Matrix matrixInterpolasi = new Matrix(Integer.parseInt(arrayIn[0]), 2);
          for (int i=0;i<matrixInterpolasi.rows;i++ ){
            for (int j=0;j<matrixInterpolasi.columns;j++){
              
            }
          }
          matrixInterpolasi.interpolation(Integer.parseInt(arrayIn[arrayIn.length-1]));
          System.out.print("Masukkan angka untuk memilih menu lain: ");
          choice = in.nextInt();
          break;

        case 5:
          matrix.multipleLinearReg(0.5,76,29.30);
          System.out.print("Masukkan angka untuk memilih menu lain: ");
          choice = in.nextInt();
          break;
        default:
          System.out.print("Angka yang anda masukkan salah, silahkan masukkan angka baru: ");
          choice = in.nextInt();
      }
    }
    System.out.println("Terimakasih telah menggunakan Pengolah Matriks!");
    in.close();
  }
}
// Salam, Ada Nyamuk :D
