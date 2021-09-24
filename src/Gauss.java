
public class Gauss {
    int rows;
    int columns;
    double[][] matrix;

    Gauss(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new double[rows][columns];
    }
    
    private void swap(int row1, int row2) {
        double[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    void GaussElimination(int choice){

    
    }

}
