package implementation;

public class MatrixRotation {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {12, 1, 2, 5},
                {11, 4, 3, 6},
                {10, 9, 8, 7}
        };
        processMatrix(matrix, 4);
        //int[] shiftedArr = rotate(arr, 10);
        System.out.println();
    }


    public static void processMatrix(int[][] matrixRotation, int factor) {

        Matrix matrix = new Matrix(matrixRotation);
        while (matrix.isMoreSlayerToProcess()) {
            int[] slayer = getSlayerArray(matrixRotation, matrix);
            matrix.updateMatrix();
        }
    }

    public static int[] getSlayerArray(int[][] matrixRotation, Matrix matrix) {
        int[] arr = new int[matrix.getCurrentElement()];
        fillBorders(matrixRotation, arr, matrix.getCurrentElement(), matrix.getInitIndex(), matrix.getInitIndex(), 0, matrix);
        return arr;
    }

    public static void fillBorders(int[][] matrixRotation, int[] arr, int totalElement, int startRow,
                                   int startCol, int indexArr, Matrix matrix) {

        if (indexArr == totalElement) return;
        else {
            // if (indexArr < (matrixRotation[0].length - 1)) {
            if (indexArr < (matrix.col)) {
                arr[indexArr] = matrixRotation[startRow][startCol];
                if (indexArr + 1 == matrix.col) {
                    startRow = startRow + 1;
                    startCol = startCol - 1;
                }
                fillBorders(matrixRotation, arr, totalElement, startRow, startCol + 1, indexArr + 1, matrix);
                //   } else if (startRow < (matrixRotation.length - 1) && startCol != 0) {
                //} else if (startRow < (matrix.row - 1) && startCol != matrix.limitMinimum) {
            } else if (startRow < (matrixRotation.length) && startCol == matrixRotation[0].length - 1) {
                arr[indexArr] = matrixRotation[startRow][startCol];
                if (startRow + 1 == matrix.row) {
                    startRow = startRow - 1;
                    startCol = startCol - 1;
                }
                fillBorders(matrixRotation, arr, totalElement, startRow + 1, startCol, indexArr + 1, matrix);
                //} else if (startCol > 0) {
            } else if (startCol > matrix.limitMinimum) {
                arr[indexArr] = matrixRotation[startRow][startCol];
                if (startCol - 1 < matrix.limitMinimum) {
                    startCol = matrix.limitMinimum;
                }
                fillBorders(matrixRotation, arr, totalElement, startRow, startCol - 1, indexArr + 1, matrix);
                //} else if (startCol == 0) {
            } else if (startCol == matrix.limitMinimum) {
                arr[indexArr] = matrixRotation[startRow][startCol];
                fillBorders(matrixRotation, arr, totalElement, startRow - 1, startCol, indexArr + 1, matrix);
            }
        }
    }


    public static int[] rotate(int[] arr, int ntime) {
        int[] shiftArr = initArray(arr);
        int rotations = ntime % arr.length;
        int rotationsDiff = arr.length - rotations;

        shiftElements(arr, shiftArr, rotations, zeroValue());
        shiftElements(arr, shiftArr, zeroValue(), rotationsDiff);

        return shiftArr;
    }

    public static void shiftElements(int[] arr, int[] shiftArr, int startInd, int endInd) {
        if (startInd == arr.length || shiftArr[startInd] > 0) {
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

    public static class Matrix {
        public int row;
        public int col;
        public int totElement;
        public int currentTotElement;
        public int initIndex;
        public int limitMinimum;

        public Matrix(int[][] m) {
            this.row = m.length;
            this.col = m[0].length;
            this.totElement = this.row * this.col;
            this.currentTotElement = 0;
            this.initIndex = 0;
        }


        public boolean isMoreSlayerToProcess() {
            boolean continueProcessing = this.currentTotElement < totElement;
            this.currentTotElement = ((row * 2) + (col * 2)) - 4;
            return continueProcessing;
        }

        public int getCurrentElement() {
            return this.currentTotElement;
        }

        public void updateMatrix() {
            this.row -= 2;
            this.col -= 2;
            this.initIndex++;
            this.limitMinimum = this.initIndex;

        }

        public int getInitIndex() {
            return this.initIndex;
        }
    }
}

