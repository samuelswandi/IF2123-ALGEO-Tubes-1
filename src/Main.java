import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("Selamat Datang di Aplikasi Pengolah Matrix!");
    System.out.println("Sebelum masuk dan mengolah sebuah matrix, silahkan masukkan matrix lebih dahulu");

    // Input matrix
    System.out.print("Masukkan ukuran matriks: ");
    Scanner in = new Scanner(System.in);
    int rows = in.nextInt();
    int columns = in.nextInt();

    System.out.println("Masukkan ukuran matriks : ");

    int matrix[][] = new int[rows][columns];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        matrix[i][j] = in.nextInt();
      }
    }
    System.out.print("\nMatriks yang telah dimasukkan : \n");
    for (int[] row : matrix) {
      for (int col : row) {
        System.out.print(col + " ");
      }
      System.out.println();
    }

    System.out.println("Selamat telah memasukkan matrix!");
    System.out.println("Sekarang mari berangkat ke menu pengolahan matriks!");
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

    while (choice != 6) {
      switch (choice) {
        case 1:

          System.out.print("Masukkan angka untuk memilih operasi lain: ");
          choice = in.nextInt();
          break;
        case 2:

          System.out.print("Masukkan angka untuk memilih operasi lain: ");
          choice = in.nextInt();
          break;
        case 3:

          System.out.print("Masukkan angka untuk memilih operasi lain: ");
          choice = in.nextInt();
          break;

        case 4:
          System.out.print("Masukkan angka untuk memilih operasi lain: ");
          choice = in.nextInt();
          break;

        case 5:

          System.out.print("Masukkan angka untuk memilih operasi lain: ");
          choice = in.nextInt();
          break;
        default:

          System.out.print("Angka yang anda masukkan salah, silahkan masukkan angka baru: ");
          choice = in.nextInt();
      }

      System.out.println("Terimakasih telah menggunakan Pengolah Matriks!");
    }
  }
}
// Salam, Ada Nyamuk :D
