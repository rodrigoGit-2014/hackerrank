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

        int totalElements = ((row * 2) + (col * 2)) - 4;
        int[] arr = fillArray(matrix, row, col);

        while (totalElements < row * col) {
            //totalElements += (((row - 2) * 2) + ((col - 2) * 2)) - 4;
            arr = fillArray(matrix, row - 2, col - 2);
            System.out.println();
        }

        System.out.println();
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


 /* public static void rotate(int[] arr, int ntime) {

        int totalRotations = ntime % arr.length;

        int[] arrRotated = new int[arr.length];
        int indOfArr = 0;

        for (int ind = totalRotations; ind < arr.length; ind++) {
            arrRotated[ind] = arr[indOfArr];
            indOfArr++;
        }
        indOfArr = 0;

        for (int ind = arr.length - totalRotations; ind < arr.length; ind++) {
            arrRotated[indOfArr] = arr[ind];
            indOfArr++;
        }
    }*/
