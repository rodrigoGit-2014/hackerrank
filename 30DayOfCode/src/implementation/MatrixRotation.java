package implementation;

import java.util.List;

public class MatrixRotation {


    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {7, 8, 9, 10},
                {13, 14, 15, 16},
                {19, 20, 21, 22},
                {25, 26, 27, 28}
        };

        processMatrix(matrix, 40);
        
    }

    static void matrixRotation(List<List<Integer>> matrix, int r) {
        int col = matrix.get(0).size();
        int row = matrix.size();
        int[][] matrixConverted = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrixConverted[i][j] = matrix.get(i).get(j);
            }
        }

        processMatrix(matrixConverted, r);
    }

    public static void processMatrix(int[][] matrixRotation, int factor) {

        Matrix matrix = new Matrix(matrixRotation);

        while (matrix.isMoreSlayerToProcess()) {
            int[] slayer = doAntiClock(matrixRotation, matrix);
            int[] slayerShifted = rotate(slayer, factor);
            matrix.cleanIndexs();
            relocateRotationMatrix(slayerShifted, matrixRotation, matrix, 0);
            matrix.updateMatrix();
        }
        printMatrixRotated(matrixRotation);
    }

    public static void printMatrixRotated(int[][] matrixRotated) {
        for (int iRow = 0; iRow < matrixRotated.length; iRow++) {
            for (int iCol = 0; iCol < matrixRotated[0].length; iCol++) {
                System.out.print(matrixRotated[iRow][iCol] + " ");
            }
            System.out.println();
        }
    }

    public static int[] doAntiClock(int[][] matrixRotation, Matrix matrix) {
        int[] arr = new int[matrix.getCurrentElement()];
        fillBorders(matrixRotation, arr, matrix);
        return arr;
    }

    public static void relocateRotationMatrix(int[] shiftedArr, int[][] rotationM, Matrix matrix, int index) {
        if (index == shiftedArr.length) return;
        else {
            if (matrix.upperColumIndex < matrix.col) {
                rotationM[matrix.realMatrixRowIndex][matrix.realMatrixColIndex] = shiftedArr[index];
                matrix.updateUpperCol();
                relocateRotationMatrix(shiftedArr, rotationM, matrix, index + 1);
            } else if (matrix.downRowIndex < matrix.row - 1) {
                rotationM[matrix.realMatrixRowIndex][matrix.realMatrixColIndex] = shiftedArr[index];
                matrix.updateVerticalRight();
                relocateRotationMatrix(shiftedArr, rotationM, matrix, index + 1);

            } else if (matrix.downColumnIndex < matrix.col) {
                rotationM[matrix.realMatrixRowIndex][matrix.realMatrixColIndex] = shiftedArr[index];
                matrix.updateDownRow();
                relocateRotationMatrix(shiftedArr, rotationM, matrix, index + 1);

            } else if (matrix.upperRowColumnIndex < matrix.row - 1) {
                rotationM[matrix.realMatrixRowIndex][matrix.realMatrixColIndex] = shiftedArr[index];
                matrix.updateUpperRow();
                relocateRotationMatrix(shiftedArr, rotationM, matrix, index + 1);

            }
        }
    }


    public static void fillBorders(int[][] matrixRotation, int[] arr, Matrix matrix) {

        if (matrix.isArrayCompleted()) return;
        else {

            if (matrix.upperColumIndex < matrix.col) {
                arr[matrix.indexArr] = matrixRotation[matrix.realMatrixRowIndex][matrix.realMatrixColIndex];
                matrix.updateUpperCol();
                fillBorders(matrixRotation, arr, matrix);

            } else if (matrix.downRowIndex < matrix.row - 1) {
                arr[matrix.indexArr] = matrixRotation[matrix.realMatrixRowIndex][matrix.realMatrixColIndex];
                matrix.updateVerticalRight();
                fillBorders(matrixRotation, arr, matrix);

            } else if (matrix.downColumnIndex < matrix.col) {
                arr[matrix.indexArr] = matrixRotation[matrix.realMatrixRowIndex][matrix.realMatrixColIndex];
                matrix.updateDownRow();
                fillBorders(matrixRotation, arr, matrix);

            } else if (matrix.upperRowColumnIndex < matrix.row - 1) {
                arr[matrix.indexArr] = matrixRotation[matrix.realMatrixRowIndex][matrix.realMatrixColIndex];
                matrix.updateUpperRow();
                fillBorders(matrixRotation, arr, matrix);
            }
        }
    }


    public static int[] rotate(int[] arr, int ntime) {
        int[] shiftArr = initArray(arr);
        int rotations = ntime % arr.length;

        shiftElements(arr, shiftArr, zeroValue(), rotations);
        shiftElements(arr, shiftArr, arr.length - rotations, zeroValue());
        return shiftArr;
    }

    public static void shiftElements(int[] arr, int[] shiftArr, int startInd, int endInd) {
        if (endInd == arr.length || startInd == shiftArr.length) {
            return;
        } else {
            shiftArr[startInd] = arr[endInd];
            shiftElements(arr, shiftArr, incrementIndex(startInd), incrementIndex(endInd));
        }
    }

    private static int zeroValue() {
        return 0;
    }

    private static int[] initArray(int[] arr) {
        int[] shiftArr = new int[getSize(arr)];
        return shiftArr;
    }

    private static int getSize(int[] arr) {
        return arr.length;
    }

    private static int incrementIndex(int ind) {
        return ind + 1;
    }

    private static int decrementIndex(int ind) {
        return ind - 1;
    }

    public static class Matrix {
        public int row;
        public int col;
        public int totElement;
        public int currentTotElement;
        public int initIndex;
        public int limitMinimum;

        public int indexArr;

        public int realMatrixRowIndex;
        public int realMatrixColIndex;

        public int upperColumIndex;
        public int downRowIndex;
        public int downColumnIndex;
        public int upperRowColumnIndex;

        public Matrix(int[][] m) {
            this.row = m.length;
            this.col = m[0].length;
            this.totElement = this.row * this.col;
            this.currentTotElement = 0;
            this.initIndex = 0;
        }


        public boolean isMoreSlayerToProcess() {
            boolean continueProcessing = this.currentTotElement < totElement;
            this.currentTotElement += ((row * 2) + (col * 2)) - 4;
            return continueProcessing;
        }

        public int getCurrentElement() {
            return ((row * 2) + (col * 2)) - 4;
        }

        public void updateMatrix() {
            this.row -= 2;
            this.col -= 2;
            this.initIndex++;
            this.limitMinimum = this.initIndex;
            cleanIndexs();
        }

        public void cleanIndexs() {
            this.realMatrixColIndex = this.initIndex;
            this.realMatrixRowIndex = this.initIndex;
            this.downRowIndex = 0;
            this.upperColumIndex = 0;
            this.downColumnIndex = 0;
            this.upperRowColumnIndex = 0;
            this.indexArr = 0;
        }

        public void updateUpperCol() {
            this.realMatrixColIndex++;
            this.upperColumIndex++;
            this.indexArr++;
            if (upperColumIndex == col) {
                this.realMatrixRowIndex++;
                this.realMatrixColIndex--;
                this.downRowIndex++;
            }
        }

        public void updateVerticalRight() {
            this.realMatrixRowIndex++;
            this.downRowIndex++;
            this.indexArr++;
        }

        public void updateDownRow() {
            this.downColumnIndex++;
            this.realMatrixColIndex--;
            this.indexArr++;
            if (downColumnIndex == col) {
                this.realMatrixColIndex = initIndex;
                this.realMatrixRowIndex--;
            }
        }

        public void updateUpperRow() {
            this.realMatrixRowIndex--;
            this.indexArr++;
            this.upperRowColumnIndex++;
        }

        public boolean isArrayCompleted() {
            return this.indexArr == ((row * 2) + (col * 2)) - 4;
        }

    }
}
