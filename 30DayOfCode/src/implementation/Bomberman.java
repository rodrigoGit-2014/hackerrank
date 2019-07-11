package implementation;

import java.util.*;

public class Bomberman {

    public static void main(String[] args) {

        String[] grid = new String[]{
                ".......",
                "...O...",
                "....O..",
                ".......",
                "OO.....",
                "OO....."
        };

        System.out.println(Arrays.toString(bomberMan(3, grid)));
    }

    static String[] bomberMan(int n, String[] grid) {

        boolean[] bombs = indexOfBombs(grid);

        detonateBombs(grid, bombs);

        return grid;

    }

    static void detonateBombs(String[] grid, boolean[] bombs) {
        int bombsByColums = grid[0].length();

        for (int row = 0; row < grid.length; row++) {
            String newColum = new String();
            for (int column = 0; column < grid[row].length(); column++) {
                int index = row * bombsByColums + column;
                if (!bombs[index]) {
                    newColum += "O";
                } else {
                    newColum += ".";
                }
            }
            grid[row] = newColum;
        }
    }

    static boolean[] indexOfBombs(String[] grid) {
        int bombsByColums = grid[0].length();
        int totalBombs = bombsByColums * grid.length;

        boolean[] indexes = new boolean[totalBombs];

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length(); column++) {
                int index = row * bombsByColums + column;

                if (isABomb(grid[row], column)) {
                    indexes[index] = true;
                    checkNeighboring(indexes, index, totalBombs, bombsByColums, column);
                }
            }
        }
        return indexes;
    }

    static void checkNeighboring(boolean[] indexes, int index, int totalBombs, int bombsByColums, int current) {

        if (isFloorValidIndex(index, bombsByColums, totalBombs)) {
            indexes[index + bombsByColums] = true;
        }

        if (isCeilValidIndex(index, bombsByColums)) {
            indexes[index - bombsByColums] = true;
        }

        if (isLeftValidIndex(current)) {
            indexes[index - 1] = true;
        }

        if (isRightValidIndex(index, totalBombs)) {
            indexes[index + 1] = true;
        }
    }

    static boolean isABomb(String grid, int index) {
        return grid.charAt(index) == 79;
    }

    static boolean isCeilValidIndex(int index, int colum) {
        return index - colum > 0;
    }

    static boolean isFloorValidIndex(int index, int bombsByColums, int maxBombs) {
        return index + bombsByColums < maxBombs;
    }

    static boolean isLeftValidIndex( int current) {
        return current - 1 > 0;
    }

    static boolean isRightValidIndex(int index, int maxBombs) {
        return index + 1 < maxBombs;
    }
}
