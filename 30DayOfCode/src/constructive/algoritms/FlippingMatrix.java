package constructive.algoritms;

public class FlippingMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {112, 42, 83, 119},
                {56, 125, 56, 49},
                {15, 78, 101, 43},
                {62, 98, 114, 108}
        };


        flippingMatrix(matrix);
    }


    static int flippingMatrix(int[][] matrix) {
        int rows = matrix.length;
        int half = rows / 2;

        for (int col = rows - 1; col >= half; col--) {
            //  inverseMatrixByColumn(matrix, row, true);
            inverseMatrixByColumn(matrix, col, false);
        }

        for (int row = 0; row < half; row++) {
            inverseMatrixByColumn(matrix, row, true);
        }

        int sum = 0;
        for(int row=0;row<half;row++){
            for(int col=0;col<half;col++){
                sum+=matrix[row][col];
            }
        }
        return sum;
    }

    static void inverseMatrixByColumn(int[][] matrix, int column, boolean isRow) {

        int totalLengthColumn = matrix.length;
        int indexToInverse = getIndexToInverse(matrix, column, isRow);
        int[] inverse = new int[totalLengthColumn];
        if (indexToInverse != 0) {
            for (int row = 0; row < inverse.length; row++) {
                if (isRow) {
                    inverse[row] = matrix[column][indexToInverse - 1];
                } else {

                    inverse[row] = matrix[indexToInverse - 1][column];
                }
                indexToInverse--;
                if (indexToInverse < 0) {
                    indexToInverse = totalLengthColumn - 1;
                }
            }
            updateMatrix(matrix, inverse, column, isRow);
        }


    }

    static void updateMatrix(int[][] matrix, int[] inverse, int reference, boolean isRow) {

        int total = matrix.length;

        for (int ind = 0; ind < total; ind++) {
            if (isRow) {
                matrix[reference][ind] = inverse[ind];
            } else {
                matrix[ind][reference] = inverse[ind];
            }

        }

    }

    static int getIndexToInverse(int[][] matrix, int reference, boolean isRow) {
        int quadrant = matrix[0].length / 2;
        int sum = 0, auxSum = 0;
        int countQuadrant = 0, startInverse = 0;

        for (int row = matrix.length - 1; row >= 0; row--) {
            if (isRow) {
                sum += matrix[reference][row];
            } else {

                sum += matrix[row][reference];
            }
            countQuadrant++;
            if (countQuadrant == quadrant) {
                if (sum > auxSum) {
                    auxSum = sum;
                    startInverse = row;
                }
                countQuadrant = 0;
                sum = 0;

            }
        }
        return startInverse != 0 ? startInverse + quadrant : startInverse;
    }
}
