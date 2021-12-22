package MatrixProcessing;

import java.util.Random;

public class MatrixProcessing3 {
    int n, m;
    int[][] mainMatrix;

    public MatrixProcessing3(int n, int m)
    {
        this.n = n;
        this.m = m;
        this.mainMatrix = new int[this.n][this.m];
    }

    public MatrixProcessing3(int [][] paramMatrix)
    {
        this.n = paramMatrix.length;
        this.m = paramMatrix[0].length;
        this.mainMatrix = paramMatrix;
    }

    public int getElement(int n, int m)
    {
        return this.mainMatrix[n][m];
    }

    public void setElement(int n, int m, int value)
    {
        this.mainMatrix[n][m] = value;
    }

    public int getVerticalLength()
    {
        return this.mainMatrix.length;
    }

    public int getHorizontalLength()
    {
        return this.mainMatrix[0].length;
    }

    public void fillRandomValues()
    {
        Random rand = new Random();

        for(int i = 0; i < this.n; i++)
        {
            for(int j = 0; j < this.m; j++)
            {
                this.mainMatrix[i][j] = rand.nextInt(100);
            }
        }
    }

    public void displayMatrix()
    {
        for(int i = 0; i < this.n; i++)
        {
            for(int j = 0; j < this.m; j++)
            {
                System.out.print(this.mainMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] transpone(int[][] paramMatrix)
    {
        int[][] tmpMatrix = new int[paramMatrix[0].length][paramMatrix.length];
        for(int i = 0; i < paramMatrix[0].length; i++)
        {
            for(int j = 0; j < paramMatrix.length; j++)
            {
                tmpMatrix[i][j] = paramMatrix[j][i];
            }
        }
        return tmpMatrix;
    }

    public static MatrixProcessing3 transpone(MatrixProcessing3 paramMatrix)
    {
        MatrixProcessing3 tmpMatrix = new MatrixProcessing3(paramMatrix.m, paramMatrix.n);
        for(int i = 0; i < paramMatrix.m; i++)
        {
            for(int j = 0; j < paramMatrix.n; j++)
            {
                tmpMatrix.setElement(i, j, paramMatrix.getElement(j, i));
            }
        }
        return tmpMatrix;
    }

    public static MatrixProcessing3 add(MatrixProcessing3 first, MatrixProcessing3 second) throws NotEqualLengthsOfMatrixException {
        if(first.getVerticalLength() != second.getVerticalLength() ||
                first.getHorizontalLength() != second.getHorizontalLength())
        {
            throw  new NotEqualLengthsOfMatrixException();
        }
        else {
            MatrixProcessing3 tmpMatrix = new MatrixProcessing3(first.getVerticalLength(), second.getHorizontalLength());
            for (int i = 0; i < tmpMatrix.getHorizontalLength(); i++) {
                for(int j = 0; j < tmpMatrix.getVerticalLength(); j++){
                    tmpMatrix.setElement(i, j, first.getElement(i, j) + second.getElement(i, j));
                }
            }
            return tmpMatrix;
        }
    }

    public static MatrixProcessing3 subtract (MatrixProcessing3 first, MatrixProcessing3 second) throws NotEqualLengthsOfMatrixException {
        if(first.getVerticalLength() != second.getVerticalLength() ||
                first.getHorizontalLength() != second.getHorizontalLength())
            throw  new NotEqualLengthsOfMatrixException();
        else {
            MatrixProcessing3 tmpMatrix = new MatrixProcessing3(first.getVerticalLength(), second.getHorizontalLength());
            for (int i = 0; i < tmpMatrix.getHorizontalLength(); i++) {
                for(int j = 0; j < tmpMatrix.getVerticalLength(); j++){
                    tmpMatrix.setElement(i, j, first.getElement(i, j) - second.getElement(i, j));
                }
            }
            return tmpMatrix;
        }
    }
    public static MatrixProcessing3 multiply (MatrixProcessing3 first, MatrixProcessing3 second) throws NotEqualLengthsOfMatrixException {
        if(first.getHorizontalLength() != second.getVerticalLength())
            throw  new NotEqualLengthsOfMatrixException();
        else {
            MatrixProcessing3 tmpMatrix;
            int n = first.getVerticalLength();
            int m = second.getHorizontalLength();
            int o = second.getVerticalLength();
            int[][] tmpArr = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    for (int k = 0; k < o; k++) {
                        tmpArr[i][j] += first.getElement(i, k) * second.getElement(k, j);
                    }
                }
            }
            tmpMatrix = new MatrixProcessing3(tmpArr);
            return tmpMatrix;
        }
    }
}


class NotEqualLengthsOfMatrixException extends Exception {}


class MatrixMain {

    public static void main(String[] args) throws java.lang.Exception
    {

        int[][] A =   {{33,34,12},
                {33,19,10},
                {12,14,17},
                {84,24,51},
                {43,71,21}};

        int[][] B =  {{10,11,34,55},
                {33,45,17,81},
                {45,63,12,16}};




        MatrixProcessing3 x = new MatrixProcessing3(A);
        MatrixProcessing3 y = new MatrixProcessing3(B);
        x.displayMatrix();
        y.displayMatrix();

        MatrixProcessing3 mM = MatrixProcessing3.multiply(x, y);

        mM.displayMatrix();

    }
}