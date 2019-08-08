package implementation;

public class MatrixRotation {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[][] matrix = new int[][]{
                {1, 2, 3, 4}, {12, 1, 2, 5}, {11, 4, 3, 6}, {10, 9, 8, 7}
        };
        processMatrix(matrix, 4);
        //int[] shiftedArr = rotate(arr, 10);
        System.out.println();
    }


    public static void processMatrix(int[][] matrix, int factor) {
        int col = matrix[0].length;
        int row = matrix.length;
        System.out.println("row: " + row + " col: " + col);


        int totalElements = row * col;
        int currentElements = 0;
        int initIndex = 0;

        while (currentElements < totalElements) {
            currentElements += ((row * 2) + (col * 2)) - 4;
            fillArray2(matrix, ((row * 2) + (col * 2)) - 4, initIndex);
            row -= 2;
            col -= 2;
            initIndex++;

        }

        System.out.println();
    }

    public static int[] fillArray2(int[][] matrix, int totalElements, int initIndex) {
        int[] arr = new int[totalElements];
        fillBorders(matrix, arr, totalElements, initIndex, initIndex, 0);
        return arr;
    }

    public static void fillBorders(int[][] matrix, int[] arr, int totalElement, int startRow, int startCol, int indexArr) {

        if (indexArr == totalElement) return;
        else {

            arr[indexArr] = matrix[startRow][startCol];

            if (indexArr < (matrix[0].length - 1)) {
                fillBorders(matrix, arr, totalElement, startRow, startCol + 1, indexArr + 1);
                System.out.println();
            }
            if (startRow < (matrix.length - 1) && startCol != 0) {
                fillBorders(matrix, arr, totalElement, startRow + 1, startCol, indexArr + 1);
                System.out.println();
            }
            if (startCol > 0) {
                fillBorders(matrix, arr, totalElement, startRow, startCol - 1, indexArr + 1);
                System.out.println();
            }
            fillBorders(matrix, arr, totalElement, startRow - 1, startCol, indexArr + 1);
            System.out.println();
        }
    }


    public static int[] fillArray(int[][] matrix, int row, int col) {
        int totalElements = ((row * 2) + (col * 2)) - 4;
        int[] arr = new int[totalElements];

        int rowRef = matrix[0].length - row;
        int colRef = matrix.length - col;

        for (int ind = 0; ind < totalElements; ind++) {

            arr[ind] = matrix[rowRef][colRef];

            if ((rowRef == 0) && (colRef < col || colRef >= (totalElements - col))) {
                colRef++;
            } else if ((rowRef + 1) == row) {
                colRef--;
            } else if (colRef != 0 && rowRef < row) {
                rowRef++;
            } else if (colRef == 0 && rowRef > 1) {
                rowRef--;
            }

            if (colRef == col && rowRef < row) {
                rowRef++;
                colRef--;
            }
            if (rowRef == row) {
                rowRef--;
                colRef--;
            }

            if (colRef < 0) {
                colRef = 0;
                rowRef--;
            }

        }
        return arr;
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
}

