package MatrixProcessing;

import java.util.Scanner;

public class MatrixProctssing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice = 0;
        while(true){
            System.out.println("""
                    Choice
                    2.\tAdd matrices
                    3.\tMultiply matrix by a constant
                    4.\tMultiply matrices
                    5.\tTranspose matrix
                    6.\tCalculate a determinant
                    7.\tInverse matrix
                    1.\tExit
                    Your choice:""");
            choice = in.nextInt();
            if(choice == 1) return;
            int[] length = getLength("");
            int rows = length[0], columns = length[1];
            try{
                switch (choice) {
                    case 2 -> MethodAdd(rows, columns);
                    case 3 -> MethodMultiply(rows, columns);
                    case 4 -> MethodMultiplyMatrix(rows, columns);
                    case 5 -> MethodTranspose(rows, columns);
                    case 6 -> MethodDeterminant(rows, columns);
                    case 7 -> MethodInverseMatrix(rows, columns);
                }
            }
            catch(Exception ex){
                System.out.println("Error in input data");
            }
        }
    }


    public static void testMultiply(){
        System.out.println("---Multiply---");
        System.out.println("Вход:");

        double[][] A = new double[][] {
                {3, 3},
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {0}
        };
        print(A);
        System.out.println("Выход:");
        print(multiply(A));
    }

    private static void MethodAdd(int rows, int columns){
        double[][] matrix1 = getMatrix(rows, columns);

        int[] length = getLength("2");
        double[][] matrix2 = getMatrix(length[0], length[1]);

        System.out.println("The result is:");
        print(add(matrix1, matrix2));
    }
    private static void MethodMultiply(int rows, int columns){
        Scanner in = new Scanner(System.in);
        System.out.println("Constant for multiply matrix :");
        int iterator = in.nextInt();
        double[][] matrix = getMatrixMultiply(rows, columns, iterator);
        System.out.println("The result is:");
        print(multiply(matrix));
    }
    private static void MethodMultiplyMatrix(int rows, int columns) {
        double[][] matrix1 = getMatrix(rows, columns);

        int[] length = getLength("2");
        double[][] matrix2 = getMatrix(length[0], length[1]);

        System.out.println("The result is:");
        print(multiplyMatrix(matrix1, matrix2));
    }
    private static void MethodTranspose(int rows, int columns) {
        double[][] matrix = getMatrix(rows, columns);
        System.out.println("The result is:");
        print(transpose(matrix));
    }
    private static void MethodDeterminant(int rows, int columns){
        double[][] matrix = getSimpleMatrix(rows, columns);
        determinant(matrix, 1);
        System.out.println("The result is: " + determinant);
    }
    private static void MethodInverseMatrix(int rows, int columns){
        double[][] matrix = getSimpleMatrix(rows, columns);
        System.out.println("The result is:");
        print(inverse(matrix));
    }

    public static void print(double[][] matrix){
        if(matrix == null)
            return;
        for (double[] doubles : matrix) {
            for (double aDouble : doubles) {
                System.out.print(getValue(aDouble) + " ");
            }
            System.out.print("\n");
        }
    }
    private static String getValue(double value){
        String _value = (value + "");
        return (_value.substring(_value.indexOf('.') + 1).equals("0"))? (int)value + "": value + "";
    }
    private static double[][] getMatrix(int rows, int columns){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter matrix:");
        double[][] matrix = new double[rows + 1][columns];
        matrix[0][0] = rows;
        matrix[0][1] = columns;
        for(int i = 0; i < rows; i++){
            String[] lineNumbers = in.nextLine().split(" ");
            for(int j = 0; j < columns; j++){
                matrix[i + 1][j] = Double.parseDouble(lineNumbers[j]);
            }
        }
        return matrix;
    }
    private static double[][] getSimpleMatrix(int rows, int columns){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter matrix:");
        double[][] matrix = new double[rows][columns];
        for(int i = 0; i < rows; i++){
            String[] lineNumbers = in.nextLine().split(" ");
            for(int j = 0; j < columns; j++){
                matrix[i][j] = Double.parseDouble(lineNumbers[j]);
            }
        }
        return matrix;
    }
    private static double[][] getMatrixMultiply(int rows, int columns, int iterator){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter matrix:");
        double[][] matrix = new double[rows + 2][columns];
        matrix[0][0] = rows;
        matrix[0][1] = columns;
        matrix[rows + 1][0] = iterator;
        for(int i = 0; i < rows; i++){
            String[] lineNumbers = in.nextLine().split(" ");
            for(int j = 0; j < columns; j++){
                matrix[i + 1][j] = Double.parseDouble(lineNumbers[j]);
            }
        }
        return matrix;
    }
    private static int[] getLength(String numberMatrix){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter " + numberMatrix + " matrix size:");
        String line = in.nextLine();
        String[] size = line.split(" ");
        return new int[] {Integer.parseInt(size[0]), Integer.parseInt(size[1])};
    }

    public static double[][] add(double[][] matrix1, double[][] matrix2){
        if((matrix1[0][0] == matrix2[0][0]) && (matrix1[0][1] == matrix2[0][1])){
            int lengthRow = (int)matrix1[0][0];
            int lengthColumn = (int)matrix1[0][1];
            for (int i = 1; i < (lengthRow + 1); i++) {
                for (int j = 0; j < lengthColumn; j++) {
                    matrix1[i][j] += matrix2[i][j];
                }
            }
            return matrix1;
        }
        System.out.println("ERROR\nIncorrect input matrix's");
        return null;
    }
    public static double[][] multiply(double[][] matrix){
        int lengthRow = (int)matrix[0][0];
        int lengthColumn = (int)matrix[0][1];
        double coefficient = matrix[matrix.length - 1][0];
        for (int i = 1; i < (1 + lengthRow); i++) {
            for (int j = 0; j < lengthColumn; j++) {
                matrix[i][j] *= coefficient;
            }
        }
        return matrix;
    }
    public static double[][] multiplyMatrix(double[][] matrix1, double[][] matrix2){
        if(matrix1[0][1] == matrix2[0][0]){
            int lengthRow = (int)matrix1[0][0];
            int countIteration = (int)matrix1[0][1];
            int lengthColumn = (int)matrix2[0][1];
            double[][] result = new double[lengthRow][lengthColumn];
            for (int i = 1; i < (lengthRow + 1); i++) {
                for (int j = 0; j < lengthColumn; j++) {
                    double summa = 0;
                    for (int k = 0; k < countIteration; k++) {
                        summa += matrix1[i][k] * matrix2[k + 1][j];
                    }
                    result[i - 1][j] = summa;
                }
            }
            return result;
        }
        System.out.println("ERROR\nIncorrect input matrix's");
        return null;
    }
    public static double[][] transpose(double[][] matrix){
        int lengthRow = (int)matrix[0][0];
        int lengthColumn = (int)matrix[0][1];
        double[][] result = new double[lengthColumn][lengthRow];
        for (int i = 0; i < lengthRow; i++) {
            for (int j = 0; j < lengthColumn; j++) {
                result[j][i] = matrix[i + 1][j];
            }
        }
        return result;
    }
    public static double[][] inverse(double[][] matrix){
        double temp;
        int N = matrix.length;

        float [][] E = new float [N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++){
                E[i][j] = 0f;

                if (i == j)
                    E[i][j] = 1f;
            }

        for (int k = 0; k < N; k++){
            temp = matrix[k][k];

            for (int j = 0; j < N; j++){
                matrix[k][j] /= temp;
                E[k][j] /= temp;
            }

            for (int i = k + 1; i < N; i++){
                temp = matrix[i][k];

                for (int j = 0; j < N; j++){
                    matrix[i][j] -= matrix[k][j] * temp;
                    E[i][j] -= E[k][j] * temp;
                }
            }
        }

        for (int k = N - 1; k > 0; k--){
            for (int i = k - 1; i >= 0; i--){
                temp = matrix[i][k];

                for (int j = 0; j < N; j++){
                    matrix[i][j] -= matrix[k][j] * temp;
                    E[i][j] -= E[k][j] * temp;
                }
            }
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                matrix[i][j] = E[i][j];
        return matrix;
    }
    private static double determinant = 0;
    public static void determinant(double[][] matrix, double elemParentMinor){
        if (matrix.length > 1){
            double [][] tmpMinor = new double[matrix.length - 1][matrix[0].length - 1];
            for (int c = 0; c < matrix[0].length; c++) {
                for (int i = 1; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        if (j < c)
                            tmpMinor[i - 1][j] = matrix[i][j];
                        else if (j > c)
                            tmpMinor[i - 1][j - 1] = matrix[i][j];
                    }
                }
                double paramForSub = Math.pow(-1, c + 2) * matrix[0][c] * elemParentMinor;
                determinant(tmpMinor, paramForSub);
            }
        }
        else
            determinant += elemParentMinor * matrix[0][0];
    }
}
