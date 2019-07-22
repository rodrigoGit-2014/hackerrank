package geekforgeeks;

public class GameOfLife {


    public static void main(String[] args) {

        boolean[][] cells = new boolean[][]{
                {false, false, false, false},
                {false, true, false, true},
                {false, true, true, false},
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false}
        };


        boolean[][] result = generateCells(cells, 1);
    }


    static boolean[][] generateCells(boolean[][] cells, int generations) {
        int maxRow = cells.length;
        int maxColumn = cells[0].length;

        for (int row = 0; row < maxRow; row++) {
            for (int column = 0; column < maxColumn; column++) {
                int count = neighborsCount(cells, row, column);
                if (isCellAlive(cells[row][column])) {
                    if (count < 2 || count > 3) {
                        cells[row][column] = false;
                    }
                } else {
                    if (count == 3) {
                        cells[row][column] = true;
                    }
                }

            }
        }

        return cells;

    }

    static int neighborsCount(boolean[][] cells, int row, int col) {

        int count = 0, maxRow = cells.length, maxColumn = cells[0].length;

        if (isUpperValid(row, 0) && isCellAlive(cells[row - 1][col])) {
            count++;
        }
        if (isDownValid(row, maxColumn) && isCellAlive(cells[row + 1][col])) {
            count++;
        }
        if (isLeftValid(col, 0) && isCellAlive(cells[row][col - 1])) {
            count++;
        }
        if (isRightValid(col, maxColumn) && isCellAlive(cells[row][col + 1])) {
            count++;
        }
        if (isCrossUpperLeftValid(row, col) && isCellAlive(cells[row - 1][col - 1])) {
            count++;
        }
        if (isCrossUpperRightValid(row, col, maxColumn) && isCellAlive(cells[row - 1][col + 1])) {
            count++;
        }
        if (isCrossDownLeftValid(row, col, maxRow) && isCellAlive(cells[row + 1][col - 1])) {
            count++;
        }
        if (isCrossDownRightValid(row, col, maxColumn) && isCellAlive(cells[row + 1][col + 1])) {
            count++;
        }

        return count;
    }


    static boolean isCellAlive(boolean status) {
        return status;
    }


    static boolean isUpperValid(int row, int min) {
        return row - 1 > min;
    }

    static boolean isDownValid(int row, int max) {
        return row + 1 < max;
    }

    static boolean isLeftValid(int column, int min) {
        return column - 1 > min;
    }

    static boolean isRightValid(int columnm, int max) {
        return columnm + 1 < max;
    }

    static boolean isCrossUpperLeftValid(int row, int column) {
        return row - 1 > 0 && column - 1 > 0;
    }

    static boolean isCrossUpperRightValid(int row, int column, int max) {
        return row - 1 > 0 && column + 1 < max;
    }

    static boolean isCrossDownLeftValid(int row, int column, int max) {
        return row + 1 < max && column - 1 > 0;
    }

    static boolean isCrossDownRightValid(int row, int column, int max) {
        return row + 1 < max && column + 1 < max;
    }
}
