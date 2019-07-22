package implementation;

import java.sql.SQLOutput;
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

      /*  String[] grid = new String[]{
                ".......",
                "...O.O.",
                "....O..",
                "..O....",
                "OO...OO",
                "OO.O...",
        };*/

     /*   String[] grid = new String[]{
                ".OO.O....OO....OO.O.O.O..........O....O..OOO.....O....O.O...O..O.O..O..OO.OOOO.....OOOO....OOO...O......O..OO..OO..O.O.O.........O..O.........O.O.O..OO..O.O.........O.O.O......OO....O....",
                ".O.....O.OOO..OOO.O....OO.O...O...O.....O.OOO...O.OOOOO.O..O................O........OO....OO.O.OO...O..O....O.O..OO..O..O...OO...O..O.O.....OO..O.O.O.OO...O.OO.O...OO........O.O.......O.",
                ".O..O.O...O.O.OO.......O......O...OOOO..OOOO.O.OO........O....O....OOOOOO.O..O.O..O.O.O.O...OOOOOO..........O...O..OO.OO...OO...OO.O..O..O.O.......O....O.OO..O.OO....O....O.O.OOOOO.OOOO..",
                "OO..OO...O.OO..O.......OO...O.O.O..O..OOOO....O..O.....O......O..O..O.O...O.OO..O...O..O.....O.O...O...O.....O.O.O...OOOO...O.O.............OO...O.O..O...O.OOOOO.O.O....O.O.OO....O....O.."

                /*  "O.O..O..O.OO..O..O....O..O..O....O.O..O..OO.OO......OO...O..OO.O.........OO...OO.OO.O.O.O..OOO..",
                  "..OOO..........OO.O.....O.OOO...O...O.O..O...O..........O..O..........O.OO....OO.O.O..O......O..",
                  ".OOO..OO.O...O..O...O......O.O..OO.........O....O.......OOO.O.....O..O.....O....O..OO......OO..O",
                  ".OO.............O.....O...O.O...O...OO.O..O....OOO.O..OO....O.O....O....O....O.........O...O..O.",
                  ".O.O.......O.O.O...O..O...O....O.O...O.......OO.....O...O.........O...OOOO..O...O.OOOO....O.O.O.",
                  "OOO......OOOO.O.O...O.O.....O.O.........O...O....O...OO.O.O.O..O..O.O...OOO........OO..OOOO.O.OO",
                  "..O...O..O.OOO......O.OOOOOO...O..O...O.OOO..O.OO...O.....O.O..OO.O.O...OO..O...O...O......O.OO.",
                  "....O...O....OOO.OO..O.........O.O..OO.O.......OO.O....O....O...O.OOO...O..O...OOO..O.O....OOO..",
                  ".....O.....O......O...O..O.....O.O....O..O.O.....O...O.O...OO..OO.....O..OO.OOO.OO.....O....O..O",
                  "O...O...O.OOO.O...O..O.O.O.O....OO.O.O.O.OO....O.O.....O...O....O...O....O.OOO.OOO......O...OO.O",
                  "..OO........O...OOOOOO..O.O.OO.O..OO.....OOO..OO...O.OO..O..O.OO..OO.O.O.O....O...OO..O.......O.",
                  "O.O.O.O....O.OO.O...OO..OOOO.OOO....OOO...O..O..O....OO.........O.OO...O.O.O.OO..O..OO....OOO..O",
                  "O...OO...O...O.........O...O.O.......O.OO..OOO.O.....OOO.O.OO.......O..O.....O.....OOOO.....O.O.",
                  "OO...O..OO.......OO.OOO....O.O..OOO...O.OO....O.O.OOOO.....OO........OO.OO...OOO.OO.OO..O...O.O.",
                  "..OOO....OO.........O.O..OO.O....O.O.OOO.OO.O.OO...O.........OO...................OOOOO.OO....OO",
                  "O....OO......OO...OOO..OO.O.O.....OO.......O.....OO.....O.......O...........O....O..O...O.O.....",
                  "OOO.......O.O.OOOO......O..O...O..O....OO.O..O.O....O...O...OO....OOOO.........O..O.OO.....OOOO.",
                  "...O.OO....O..O.O.OO.OOOO.....OO.O..OO...OO.O..OOO......O..O......O...OO.OOO.O........O.O.......",
                  "....O..O.......OOO....O..OO.........O.O...O.OO..O...O......O.O.O..OOO.O..O.O...OOO.O....O.....O.",
                  ".O.O.OOOO.O..OO...OO.....O.......OO...O.......O..OO.O...O.O.OOOOO....O.OOO...O.O.O.O...O..OO...O",
                  ".O.O......O.O..O.O...OO.O.........OOOO..OOO..O.......O..........OOO...OO.OOO....O.......O..OO...",
                  ".O...O..O.O...O.OO....O.OO....O..O.............O.OOO...OO.O..OO.......OO.O.O.O...O.O..O..O.....O",
                  "..O.O....OOOO....O..OO......O.....OO.O....OO.....OOOO..O..OO..O......O....OO..OO.OO.O....OOO...O",
                  ".O..OO..O.O......O....OOO.......O..O.........O.......OO...O............O..O..OOOOO.O..........O.",
                  ".......O..O...OOOO...O..O.OO.O.O.O..O..OO.OO....O.OO...........O.O...OO.OOOOO.....OO........O..O",
                  ".OOO.OO.O....OOO....O...O........O......OO...OOO.OOO.O......OOO.OO...O....O..OOO.....O....OO..O.",
                  "....O.OO..O.O..OO.....OO........O.O.................O.O..OOO...OOOO..O.O...O...O.OO....OO...O...",
                  "....O..O......O..O....OOO.....OOOO..O.OO.OO.O...OO.......OOOO.O.O....O......OO....O.....OO....OO",
                  "........O.O.O...OO.OOOO...O...O.....O.OO..O.OOO.O.......O..O..O..O.......O.....OO....O..O......O",
                  "OO.OO.O..OO..O.OO.O.O....OO..O..OOO.....O..O...OOOO...OO.O.O...O..O.OOOO............OO.O.OO.....",
                  ".OO...OO.........O..OO.O.O.O..O.O..OO..O..................OOOO...OOO........O..OO...O.O.O.OOOO..",
                  "...O.O...O.O.O..OO.O.O..OO.....O....O.O...O.O.O.O.O.O...OO............O.O.OO.O.O.O..O..OO.O.....",
                  "...O...OO.O..O....O....O.O.O.OO.....OO.O.O....OO..O..O.O.........O.O.O...O.O..O.O..O..O..OO..O.O",
                  "..O.OO.O..O.OO..O..O...O.O.OOOO.....OO..O.OO..O.OO....O.OOO.O..O.........O.....O.O.OO..O....O...",
                  "..O.O.O..O....O.O....OOOOOO..O.O...O...........O..O..OOO..O.....OOO......OO.O.O.......O.......O.",
                  "OOO.O.OO.O...O.O....OOO...O.....O....O..O........O.O......O...OO.......OO.O.......O..O..OO......",
                  ".O.O.O......OOOOO..O..OO....OO....O...O.OOO..O.O.OO....O.........O...OO.O....OO.....O..O....O..O",
                  "..O.....O...OOO..........O..OO.O.......O.OO.....O.....O......O...OOOO.O..O.OO...O.O.OOOO..O....O",
                  "O....O...O...O.O....O...OO.O..OO...OOOO..O...OO...O.......OO..O......O.OO....O..O.O..O..........",
                  "...OO..........O..O..OO..OO.....OOO..OO.O.OO.O....O...O..O....O....O....O..OOO...O.OOOOOOOOO.O..",
                  ".OO.O...O...........O....O.....O....OO.O......OOO..O..O.O.O....OO.O.O.O.....O.......O...OO.....O",
                  "..O.....O.O.OO.OOOOO..O.O..O.O..OOO..OOO....OO..OO..OOO.O....O......O...O.O....O.......O.O.OOOO.",
                  "OO....O...O.OO...O.OO..O.......O.O..O.O.............O.O....OO...O..OOO.OOO.......OO...OOO.....O.",
                  ".O.O...O.O....OOOO..O.OO....O...OO........O.......OO...O.O...O..O.O.O....O.........O............",
                  ".O.O.OO.O....O.O.O........O....O.........O.OO......OO..O..O.OO.O....O..OOOO...OO..O...O.O.O.OO..",
                  ".....OO.O....OO.O...OO...OO.....O...O.O....O.O....O..........O.O.O.......O......O.O..OOOO...O.O.",
                  ".O...O.O....O.O.O.O........O....OOOO..OO..O.......O.........OO..O..OOOO..O........O.O....O..O...",
                  "O....O....OO..O...O.O.OO...O...O..OOO...O.O.OO.O.O...O.....O...O...O.O.O.O..O..O...O.OO........O",
                  "..O.......O...O..OO.O....OOO........OO..O..OO.OO.OO.O.OOO......O.....O..OOO.OO...O.....O.O..OO..",
                  ".O..OO...OO..OO..O...O.OO.......O..OOOO.OO.OO..OO.............O..OO.O..O.O......O..OOOO.O.O..O.O",
                  "O.OO.OOO....OOO......OO.....OO.......O........OO.O...OO.....O.O..OO..O....O..O...O.O....OO..O..O",
                  "O..O......O.O......OO..OO.O....OO..OOO.O..O.O..O.O....OO..OOOO.O....OO..O...O.O.OO..OO.OO..O.O..",
                  "O.OO...OOOOO..O....O......OOOOOO..O...O.O.....O.O..O....O.O....O.....O.O.O....OO......O.OO.....O",
                  "......OOOO....OOOO...O.O.O..O.....O...OOO.O.OOO..OO..OOO..OO.O.O.O..O..........OO.OO.O...O.O..O.",
                  "O..O..O...O.........O.O.....O......O.OO..O.O.OOOO...O.O......O.O....O...O....O.....O..O..OO.....",
                  "O...........OO....O....O.....O.O...OO....O.........OO...O......OO..O.O..O...O...OO.O.O.O.OOO....",
                  "O.O..OOO.O.O......O...OO..OO.........O..OO.O.....O.....OO.....OO...........O....OO.....O.OOOO..O",
                  "O.O..O.OO.OOO......O....O.OOO.OO....OO.O..OO...O.......O...OO..OO...OOO.O.O....OOO.OOO....O..OO.",
                  "..O...O.OOO...O..O....OO.O.O.O.......O..O.....O...O..OO..OO...O..O..O.OO.O.......O....OOO....O..",
                  "..OOO...O.OO.O.O..O...O........OO...OOO...O....OOOOOO..O...O..O.O...O...O....O..OOO.O.........OO",
                  "OO.....O.....O.OO.O..O.OOO.OOO...O...O..O.O.O.OOO......OO...OO..O..O.OOOOO....O.O..O..OO...O...O",
                  ".O.O..OO..OO....OOO.....O....O.O..O.....O.OO.O.OOOO..O..OOO..OO.OO.O...O....O.....O..........O..",
                  "..O..O...O.O....O....O....O....O...O..OOO..OO.O...OO.O....O.O.....OO...O...O..O...OOOO...O......",
                  "...O..........O.O.O.O....OO..O.O..OO.OO..OOOOO......O....OO...O...........O.O.O..O.O...OO.O.....",
                  "..OO.O....O.......O..O.OO..O.....OOO...OOO.....O.O.O.O.O.......O.O..OO........O.O.OO...O..O..O..",
                  ".....O.....O....O....O..O.O...O....O.OO.O..O.OO.....O...OO.OO....O.OO..O...O..O.OO...OOO...OO..O",
                  ".O.........O...O....OO..OOO..O...O...OO.O..O.O.O...O...O...OO.OO.O...OOO...OOO..O..OO..O.......O",
                  ".O.O.OO....OO..OO........O..O...O...O...O....O..O....O..O......O........O.O.O...O....OOO..O..OO.",
                  "O......OO...OO.O..O.O.O...O.O....O.......O..O..O....O...OO.....OOO...OO...O..O.OO.....O.OO..OO..",
                  ".O.O....O...O....O...O..O..O..O..O..OOOOO...O.O..OO....OO..O..OOO.OOO....O..O..O...O.....OO....O",
                  "O...O.OO..O.O..O..O.O.O...O......OO..O..OO.....O.OO.OOO.O.OO...O.O..O.O....OOOO.O..O.....O....O.",
                  "..O...O.O.OOO..O.O.....OO..O....O.O...O.OO..O..O..O....O...OOO...O............OOOOO...O..O..O.OO",
                  "...O.O...OO...O.O.........OO..O..O.O......O...O..OOOOO....OO..O.....O..OO.......O......OOO.OO..O",
                  ".OO.OO.O.OO.O..O.O.OO...O.O...OO....OOOO....OOO.O........O.O...O....O.O....O.OOO......O..OO....O",
                  "O...O...O.......OO..O..O...OO.OO....O...O.....O..OOO.....O.O..O.......OO.OO......O..O...OO...O..",
                  "........OOO..O....O.OO.O.OO........OO..O...OO.O......O.....O.O........O..O.OO..O..O.O.O.OO...O..",
                  ".OO......O...O....OOO.O...O....OO..........O......O................OO....OO...OO....OOO.........",
                  "OOO..O.OOOO.OO.....O.OOO........O....OOO.O..OOO.........OO....OO...........O.O.O....O..O...OO...",
                  "....O........O..OO...O.OO.O.O..O.O...O.O.O..O.O.O.....O......OOO.O.O..O...OOO.OO...O.O.O........",
                  "..O.OO...O..O..O..OO.OO..OOOO..O...O..OOO..O.O..OO.O....O.O.O.......O..........OO.O...O.OO...O.O",
                  "OOOOOOO...O.OOO.OOO.O...O...OO.O.OOOOO...O..........O.....O..OO..OO...OO..O...OO..O......O......",
                  "....O..O.OOO....O...OO..O......O.O...OOO..OO....OO.O.......O.O..OOO.O.O....O.O.......OO..O.O....",
                  "..O...O.....OOO.O.O.....O.....O.O...O...O..O..O...O.OOOO.O.....O..O.O..O......O.O.OO.O..OO.O....",
                  "O.O.....O.OOO...OO.O..O...OO...O.OO..O.....O.O.......OOO.....O...O..O...OO.O................OO..",
                  ".O.O...O......OO..OO.......O.O.......OO...O..O..O.OO..O.O.O.OOO..OOO..O..OO..O.O....OO........OO",
                  ".O.O...O.....O.O..........O....O..O.......O....OO....O...O..OO..O.OO......OO.....O.OOO...O......",
                  ".O...O..O..O...O..O...O...O.....OO...O...OOO..O..O..O.O......O....O........OOO...............O..",
                  ".......O.OO.O..O...O.....O.....OO.......OO.OOOO...........OOO.O..OO....O..O.O.........O...O....O",
                  "OO.....OOOO.OO........O..........OO...O.OOOO.OO....OOO.OO..O.O.OO..........O....O...OO.O..O.....",
                  ".......O.O...O...O.O.........O....OO.....O.OOOO......O...O..O....O...OOOO..O...O...OOO.OO.O.O...",
                  "OO..O.OOOO....OOOO........O.OOO.OO...O............O..O....O.....O..O.O...O.OO..O..O......O.OO...",
                  "...OO.O..O...O...O.O..O..O...OO.O.........O.OOO.OO......OOOO.O..O....O..O....OOOO..O..O..O....OO",
                  "OO.O..OO.O.O..OO.O.O..OO......O..OOO.OO..OO..OOO....O..OO....OO....OOOOO..O..O.......O..O.OO....",
                  "..O.........OO........O...O...O...OO....O.O...O....O..OO.OOO..OO.....O.O..OO...OOOOO....OO..O..O",
                  "....O.O...O...O........O.O.O.OO.O.O..O.....O.O.......OO.O....OOO....O.OOO..OO....OO....O........",
                  ".O......O.OO....O....O....O.O...O...O..O...OO.O........O..OO..O..O.O.....O...OOO..O..OO..O......",
                  "OO...O...O.......O.O....O..O..OO.OO...O.O...OO..O..O.OO.O..........O...O....O.......OO....OO.O..",
                  ".OO...........O..OO..O....OOO...O....O.......O.O....OOO.OO.OO.O.O..OO..O.O...OOO.........O....OO",
                  "..O..OO.O..O.....OO.O...O....O.O.OO.OOOO...O....O....O..O.....O..OOOO...O.O............O.OO.O...",
                  ".O.O..O......O.O.....OO.........O......O...O.O..O...OOOOO.O...OO..O.............O.....O..O.....O",
                  ".O..OOO.O.O.O........O.OOOO..O....O.O..OOOO..O...OO.O.OO.O....OOOO.O..OOO....OO.O..OO..OOOO...O.",
                  "..OO..OO.O...O...OO....O......O...O.O..O...O.O.O.O.....OO.O......OO.OO......O...OO..OO.....O...O",
                  ".OO...O.O...O....O..O.O.O.....O..O.....OO.......OO...OO.O..OO..O...O....OO.......O..O..O.....O..",
                  "...O..O...OO........OO.....O.......OOO.....O.OOOO.......O....O.O.OO..O...........O..OOO.....OO.O",
                  "O.O..O...O.OO.............O.O...O....O.OOO....OO...OOO..O...O.OO..O....OO..O......O..O.OOO......",
                  "..O........O.OO....OOOO.O..O.OO....O.O......O..OO..OOO....OOO.O.O..O..OOO..O..OOO.O.OO...OOO.O..",
                  "..O.OOOO.O..O..O.OO..OO.O..O...OO...O...O..O..O.O.O.....O.OOO..OOO...OO..O...O.OO.O.OO...O.OO.OO",
                  "O....O......O...O....O....O......O..OO.OO...OO..O..O...O.......OO.O.O.O....O.....OO..O.O...O....",
                  "O.......OO.OOO...O..OO.O..O..O.....OOO.O.........O..O..O.O.OO.OO.......O..O.O...OOO.OO..O.....OO",
                  "..O..OOO.O..O.O.O.O....OO.....OO...O..O........OOO..........OOO........O....OO.O.OOOO...OOO..OO.",
                  "....O.......OO.O....O...O...O....OO....O......OO....O....O..OO..OO.....OO...OOOO.OO.O......O....",
                  "..O.O.O...O...O.O.OO.O..O........O..O..O.O.OO.OO....O..O......O......O..........O...O...O...OOO.",
                  ".O...OO.....OO..OO.OOO..O.O..O....O...O.....O.O.O..........OOO.OOOO.O....OO..OO.O..O..O...O.OO..",
                  "..OO.O.O.O..OOO.....O...OO...OOO..O..O.O.O.O.O.OO...........O.OO.OO.O...O....OOO..OO....O.......",
                  ".....OO...O.O..OO..O.O..O.OO.O.O...OO..OOO...OO.OO.O.O.....OO.O.O....O.O....O.OO.O..OO...O..O..O",
                  "O....O....OO...O...O.OO...O..O..O..O.OOO...OO.......OO.....O...O....O..O.OO.O.O.O.....O.O.O...O.",
                  ".O..O..O.....O..O....O...OO.....OO.....O........O.O......O......O...O......OO..O.........OO...O.",
                  "..O.OOO.O..O.OO.O..O.OO...O........O..O..OO.O.O...O...O...........O...O...O..O.....O...O.......O",
                  "O.....O....OO....OO.O.....O.OO...OOO.O..OO.O.O.O.OO..O...O.OO.O.OO.O..........OO.....O...OOO.O.O",
                  ".O...O.....O..O.OO........O..O...O.O.O.OO..O..O...OOO...O.......OO.OO...O.O..O.....O.O..O.......",
                  "...OOO.....OOOO.O..O.O.....OO.......OO..O.O.OOO...O...O......OOO.O.O..OO..O......O..O.OO.O....O.",
                  ".O......O..O......O..OO....O.....OO..O..OO.O.OO.O..O..OOO.....O.O.......O.O.OO..O.O.OOOO........",
                  "O..OO.O.OO..O..OO..OOO...........O.....O.O.O....O...O.....OO..OO...O..O..O.O.....O.O......O.OOO.",
                  ".O..O.....OO......O..O.O.......O....OO.OO.O.O........O...O.O...O.......O.......OO........OOO....",
                  "OO.....OO.O......O....O..OO....OO.......O...OO.....OO......O....O.O.....O.O.O.O.......OOO...O..O",
                  ".O..OOOOO...O..OO.O..O..O........O.O..O....O...........OOO..O...OO.........OOO.O......O.O..O.O.O",
                  ".OOOO........O..O.......O.OO...O....O..O.OO....OO.O....O.O..O...OO..OO...O......O.......OO..O.O.",
                  ".O.O..OO....O..O..OO..........O......O.....OO...O.OOO......O.......OO......OO...O...O.....O...OO",
                  ".....O......OO..OO..OO..O..OO......OO......O.O.OO.O.OO.....OO..O...O..O.....OO.OOOO...O...O.O...",
                  ".OO......O..OO...OO..O..O.........OO.O.O..O.O.O....O...OO.OO....O.......OO..O..O..OOO......O..O.",
                  "......O...O.OOOO.O..O.O..O.O....O.O......O..OOOO..OO.......O.OO..O..OO..OOO..O...O.OOO..OO.O.O..",
                  "OO.O........O......OO...O..OOO.OO..O...O...O.OO.......O.....OO.....O.O...O.OOO.O.....OOO..O.....",
                  "OO....OO....O..O..O.O..OO...OOOO........OOO..OO........O..O.......O.....OOOO....O.OO..O.O.O...O.",
                  "OO...OOO.OO.O...O..O..O...O..O..O.OO............O........O......O.OOO.....O...........O..OO.O..O",
                  "...OO.........OO.O.O.O..............O........O.......O.......OO....O.....O..OO.....OO...OO.O..OO",
                  "O...OOOO.O....O.....O...O.......OO.O.O..O..O.O.O..OO..........O.O....OO.....O..O..OO...O.O..O...",
                  "O...O.OO....O.O...O....OO...O..O...OOO.O...OOO.O....O..OO.OO...O..O.O...O.OOO.O..O.....O..OO.O..",
                  "O.OOOO.OO..O..O...OOO.OO...O...O..OOOOO.....O..OOOOO.OOOOO.O..O.O.....O..O..OO..O.OO..O.....OOOO",
                  "...O.....O.O.O....O.O........OOO....O....OOO.O........O..........OOO.OO...O.O...OO.....OOO....O.",
                  "O.OO.O.OOOO.OO..OOO.OO...O.O.O...O...O.....OO.O....OO..O......OOO.OOO..O.....O.......O.OO.O..O..",
                  "..O...O..O...O..O..O.O..OO...O..O..OO.O.O.O..O...O..O.OOO......OO.......OO....O.OO.O.O.O.OO..O.O",
                  "O.O.O.OO....OO.....OO.O...O.O...O...OOOO.....O..OO..OO....O.O...O.OOO...OOOO.OO...O..O.OO.....O.",
                  ".......O..O..OO.O.O...O...O....OO...........O.....O....O..O...O....O...O.O...O....OOO.OO.O......",
                  "....OO.....OOO...O.....O....OOOOO.OO.OO...OO......O..OOOOO.O.O.OO...O.....OO.O........O..O..O.O.",
                  "...........O..OOO..O..O..O.O.O.OO.OO....O......O.O......O..O.........O.....OOO...O...O.OO......O",
                  ".....O.OO.....O...O.O...O.O..O...O.O.O.O..O.OO.........OO.O..OO.O.....O.....OOOOO..........OO..O",
                  "OO.O.....O...O....OOO....OO...........O..O....OOOO...O....OO..O......O..O.OOO.O.O..O....O..O....",
                  "O.O..OO...O....OO.OO......O...O.OO..O.O.O..OO.OO..OOO.....O...O.OO....O.O....O.OO.O.O.OO.O..O.O.",
                  "..OO..OO..O...OOO..........O...OO..............O.O.O.O.....O...O.O.O.OO..O.OO.O..O..O.OOO.O.....",
                  ".O...OO.OO..............O.O.O.....OOOO.O.......O.......O............O.OOO........O.O..O.OOO...OO",
                  ".O..OOOO........O..............O..O.O....OOOO.......OOO...O.O.O..OO...OO....O...OOO...O.O...O..O",
                  ".O....O.OOOOO..O.........O......OO..OO.......O...O...OOOO.O......OO..OO...OO.O......O...OOO.O.OO",
                  ".O....O...OO..O..O....O.O.O....O....OO..O.OO..O..O.O..........OO...OO.OOOO.O...O.O..............",
                  "O..O..............O..OOOO.....O..OO..OO..OO......OOO........O.......O..O..O...O..OO..O.O......O.",
                  "O.OO.OO.O.O.OO..O..O.....OOOOO.O.O.O...O.OO..OO....OO...O..O.OO.O...O.O.......O.......OO....O...",
                  "O......O..O........OO.......O.OOO.OO.O.O.O.....O.OO.....O.O..........OOO..O.O...OO.O......OOO...",
                  "..OO.......OO..OOO........OO..O...O..O.O.....OO..O...O.....OO..OOOO...O....O.OOOO.....O.O..OO.OO",
                  "......OO..OO..........O.OO...O...O...O.OOO.......OO...........OOO..O....OO..O...O..O.O....O.O...",
                  ".O...O....OO......O.O..OO....O.O..OO...O......O.O...O........O.O..OOOO....OOOO.O.....O..O.O.....",
                  "..O....O.....OO...OO......OO.......O...O.....O.....O..O...OOO.O..O.O..O.OO..O..O..O..O..OO....O.",
                  ".......OO...O.OOO.OOO.O..O....OO..O.O..O....O....O.....OOO..O.OO....OO.O.O........OOOO..O....O.O",
                  "..OO....O....O..O.....OO.O......O...O.OOO.....O.O...O......O.O.....OOO........O.OO..O.O.O.O.....",
                  "....O.....O...O.O..O...O..O.O.O...O..O..O............O..O.....O....OO.OO....O.....O..O.....O..O.",
                  "..OO.....O...O..O....O.O....OOOOO..OOO......OOO..O.......OO.O.O........OO.O.OO.O.......OOOOOO...",
                  ".O.OO..OO.OO.......OO..O.OO..O..OO.OOO.OOO.....OO.O....OO...O.O.........O.OO..O..OO.....OOO...OO",
                  "O.OO.OO....O....O.......O.O.OO......O............O...O...OO.....OOO..OO.O.O.OOO...O.O....O...OO.",
                  "..O...O.O...O..O..O..O..O..........OO.....OO...OOO..O.........O..O...O...OO..O.O.O..OOO..O.....O",
                  ".O.O.OO.O.OO..O...OO.O..OO.O....O...O..O..O..O.O........O...O.....O.O........OO..OO.O..O.O..OO..",
                  ".OO.........OOO.O..OOO.OO...OOO.O..O........OOO..OO.......O.O.O...O.O.O.OO.OO.OO...O.O.....O...O",
                  "O.....O...O....OO..OO..O.OOO.O.O.O.......O.O.OOO........O.O.O.........O..O....O........OO.OO..O.",
                  "...O.O...OO..........O....O....O.....OOO...O...O..O.....OOO...OO..O....OO.....OO.O...OOOO.......",
                  "....O...O.O.....OO.O.O.....OOO.O.O.O..O..O.O...OO..O..O.O..O.O.O..OOOOO.....O.O...O.....O.......",
                  ".O.OO.........OO..OO....O...O...O.......OO...O.....OO.OO...O...O.O......O..OO.OOOO......OO..OO..",
                  "...OO.OO..O...O..OO.O.O...O..O............O...O..O..O.O.OO.O..O.OO..OO...OOO....OO.O....O.......",
                  ".....O...OOO.....O.OOOOO.OOOOO..O.....OO.O.....OO..O.....OO..O.OO.OOOO.O.O..O......O...O.OOO....",
                  "O...OO.O..O..O.OOO....O.....OO..O..........O.....O.OOO.O..O........O...O.O.....O......OOO...O...",
                  "..OOO.OOO...O.O....OO.....O..OO..OO.......O..OOO....O..OOO..O..OO..O.O..O.O.O.O.O.O.O...O.O.O..O",
                  ".OO..OOO....OOO.O......OOO..O...OO......O.....O.OOOO.O.........O.OO..O.O..O....O..O.O.......O...",
                  "...........OO..O.O.........OOO.O.O.O..O.O.O...O...O...O...OOOO..O.....O.O..O....OO.....O..O.O...",
                  ".O..O..OO....O...O.....OO.....OO.O..OO.........O...O.O..OOO........OO..O...OO...O..O..........O.",
                  "..O..O.....OO..OO......O.....O.O..........OO....O...O.....O...O..OOOO.OOOOOO......O.OOOOO.O...OO",
                  "..OO....O.......O.O......OOO.O.....OOOOOOO.OO...O...OO.....O..O...OO.......O.OO..O.O...O....O..O",
                  ".O.O...O.OO.O.O.O.O........O......OO..OO.........O.O.....O...O.....O..OO....O...OO.......OOO.O.O",
                  "O...OO.....O...O.O.O.O...O..O...OOO....O..O..O.....OO..OOO.O..O..OO.O.O.O.OO..O....O....O.....O.",
                  "O.O.......OO.OO.....O..OO....O...O..O...O....O....O.OO.O....O.OOOO..O.....O.O...OO.O.O..O...OO..",
                  "..O..OO...OO.O.O..O..OO.....O...OOO...O....O.....O..O..O.O..OO......O.OOO.O.O.....O.OO.O..OO...."*/
        //   };

        bomberMan(3, grid);
    }

    static String[] bomberMan(int n, String[] grid) {

        Map<Integer, Boolean> cycleMap = new HashMap<>();

        if (n % 2 == 0) {
            plantsAllBombs(grid);
        } else {
            int hashCode = 0;
            boolean[] bombs = null;
            while (!cycleMap.containsKey(hashCode)) {
                cycleMap.put(hashCode, true);
                bombs = plantBombs(grid);
                hashCode = detonateBombs(grid, bombs);
            }
            int realIndex = n - (n / (cycleMap.size() - 1)) * (cycleMap.size() - 1) + 1;
            while (realIndex > 0) {
                bombs = plantBombs(grid);
                hashCode = detonateBombs(grid, bombs);

            }
        }


        return grid;
    }

    static void plantsAllBombs(String[] grid) {
        char c = 'O';
        char[] repeat = new char[grid[0].length()];
        Arrays.fill(repeat, c);
        String bombs = new String(repeat);
        for (int i = 0; i < grid.length; i++) {
            grid[i] = bombs;
        }


    }

    static int detonateBombs(String[] grid, boolean[] bombs) {
        int bombsByColums = grid[0].length();
        int hashCodeExplosion = 0;

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
            hashCodeExplosion += newColum.hashCode();


            System.out.println(grid[row]);
        }
        System.out.println("---------");
        System.out.println("hasCode: " + hashCodeExplosion);
        System.out.println("---------");
        return hashCodeExplosion;
    }

    static boolean[] plantBombs(String[] grid) {

        int total = grid[0].length() * grid.length;

        boolean[] bombs = new boolean[total];

        for (int row = 0; row < grid.length; row++) {
            fillNextBombs(grid[row], row, bombs);
        }
        return bombs;
    }

    static void fillNextBombs(String actualBombs, int row, boolean[] futureBombs) {

        for (int column = 0; column < actualBombs.length(); column++) {

            if (isABomb(actualBombs, column)) {
                int index = row * actualBombs.length() + column;

                futureBombs[index] = true;

                if (isFloorValidIndex(index, actualBombs.length(), futureBombs.length)) {
                    futureBombs[index + actualBombs.length()] = true;
                }

                if (isCeilValidIndex(index, actualBombs.length())) {
                    futureBombs[index - actualBombs.length()] = true;
                }

                if (isLeftValidIndex(column)) {
                    futureBombs[index - 1] = true;
                }

                if (isRightValidIndex(index, futureBombs.length)) {
                    futureBombs[index + 1] = true;
                }
            }
        }

    }

    static boolean isABomb(String grid, int index) {
        return grid.charAt(index) == 79;
    }

    static boolean isCeilValidIndex(int index, int colum) {
        return index - colum > 0;
    }

    static boolean isFloorValidIndex(int index, int colums, int maxBombs) {
        return index + colums < maxBombs;
    }

    static boolean isLeftValidIndex(int current) {
        return current - 1 > 0;
    }

    static boolean isRightValidIndex(int index, int maxBombs) {
        return index + 1 < maxBombs;
    }
}
