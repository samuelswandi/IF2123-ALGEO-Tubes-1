import java.util.Arrays;
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
      switch (choice) {
        case 1:
          matrix.CreateMatrix();
          System.out.println("Matriks yang telah dibuat: ");
          matrix.DisplayMatrix();

          System.out.println("Penyelesaian matriks menggunakan : ");
          System.out.println("1. Metode eliminasi Gauss");
          System.out.println("2. Metode eliminasi Gauss-Jordan ");
          System.out.println("3. Metode matriks balikan ");
          System.out.println("4. Kaidah Cramer ");
          System.out.print("Masukkan angka untuk memilih metode: ");
          int case1Choice = in.nextInt();

          switch (case1Choice) {

            case 1:
              matrix.SPLGauss();
              break;
            
            case 2:
              matrix.SPLGaussJordan();
              matrix.DisplayMatrix();
              break;

            case 3:
              // Metode invers
              matrix.SPLInverse();
              int temp = menuSave();
              matrix.SaveToFile(temp);
              break;

            case 4:
              matrix.SPLCramer();
              int temp1 = menuSave();
              matrix.SaveToFile(temp1);
              break;
            default:

              break;
          }

          System.out.print("Masukkan angka untuk memilih menu lain: ");
          choice = in.nextInt();
          break;
        case 2:
          matrix.CreateMatrix2();
          System.out.println("Matriks yang telah dibuat: ");
          matrix.DisplayMatrix();

          System.out.println("Penyelesaian determinan matriks menggunakan : ");
          System.out.println("1. Metode eliminasi Gauss");
          System.out.println("2. Metode kofaktor ");
          
          System.out.print("Masukkan angka untuk memilih metode: ");
          int case2Choice = in.nextInt();
          
          //Initialize Value for Determinant
          double det = 0.0;

          switch (case2Choice) {
            case 1:
              det = matrix.GaussDeterminan();
              break;
            case 2:
              det = matrix.CofactorDeterminan();
              break;
            default:
              break;
          }

          System.out.print("Determinan dari matriks adalah: ");
          System.out.println(det);

          int temp = menuSave();
          matrix.SaveToFile2(temp,det);

          System.out.print("\nMasukkan angka untuk memilih menu lain: ");
          choice = in.nextInt();
          break;
        case 3:
          matrix.CreateMatrix2();
          System.out.println("Matriks yang telah dibuat: ");
          matrix.DisplayMatrix();

          System.out.println("Penyelesaian balikan matriks menggunakan : ");
          System.out.println("1. Metode eliminasi Gauss");
          System.out.println("2. Metode kofaktor ");
          
          System.out.print("Masukkan angka untuk memilih metode: ");
          int case3Choice = in.nextInt();
          
          if (matrix.CofactorDeterminan() != 0){
            switch (case3Choice) {
              case 1:
                matrix.GaussJordanInverse();
                break;

              case 2:
                matrix.CofactorInverse();
                break;

              default:
                break;
            }

            System.out.println("Matriks Balikan : ");
            matrix.DisplayMatrix();

            int temp2 = menuSave();
            matrix.SaveToFile(temp2);

          }
          else{
            System.out.println("Matriks tidak memiliki balikan.");
          }

          System.out.print("Masukkan angka untuk memilih menu lain: ");
          choice = in.nextInt();
          break;

        case 4:
          System.out.println("Masukkan input dengan format n,(X1,Y1),...,(Xn,Yn),X");
          Scanner sc = new Scanner(System.in);
          String x = sc.nextLine();
          x = x.replaceAll(" ", "").replaceAll("\\(", "").replaceAll("\\)", "");
          String[] arrayIn = x.split(",");

          double[] arrayDouble = new double[Integer.parseInt(arrayIn[0]) * 2];
          for (int i = 1; i < Integer.parseInt(arrayIn[0]) * 2 + 1 ; i++) {
            arrayDouble[i - 1] = Double.parseDouble(arrayIn[i]);
          }

          //initialize Equation Matrix
          Matrix eqMatrix = new Matrix(Integer.parseInt(arrayIn[0]), Integer.parseInt(arrayIn[0]) + 1);


          for (int i = 0 ; i < Integer.parseInt(arrayIn[0]) ; i++){
            for (int j = 0 ; j < Integer.parseInt(arrayIn[0]) + 1 ; j++){
                if (j == Integer.parseInt(arrayIn[0])){
                  eqMatrix.matrix[i][j] = arrayDouble[i*2 + 1];
                }
                else{
                  eqMatrix.matrix[i][j] = Math.pow(arrayDouble[i*2], j);
                }
            }
          }
          
          String sentence = eqMatrix.Interpolation(Double.parseDouble(arrayIn[Integer.parseInt(arrayIn[0]) * 2 + 1]));
          System.out.println(sentence);

          int temp3 = menuSave();
          matrix.SaveToFile3(temp3,sentence);

          System.out.print("Masukkan angka untuk memilih menu lain: ");
          choice = in.nextInt();
          break;

        case 5:
          matrix.CreateMatrix();
          System.out.println("Matriks yang telah dibuat: ");
          matrix.DisplayMatrix();

          String sentence1 = matrix.MultipleLinearReg();
          System.out.println(sentence1);
          int temp4 = menuSave();
          matrix.SaveToFile3(temp4, sentence1);

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

  public static int menuSave(){
    Scanner in = new Scanner(System.in);
    System.out.print("Apakah anda ingin menyimpan hasil dalam file(1:ya, 2:tidak): ");
    int choice = in.nextInt();
    return choice;
  }

}
