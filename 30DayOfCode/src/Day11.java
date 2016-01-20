import java.util.Scanner;
/*
   ****  Hourglass *****

 This algorithm get the max sum possible in a matrix. The pattern that has to look for is like a hourglass

   1 3 4
     2
   3 4 5
 */
public class Day11 {

    static int arr[][];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        arr = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }

        int max = getMaximunHourGlass(arr);

        System.out.println(max);

    }

    public static int getMaximunHourGlass(int[][] hourGlass){
        int max =  Integer.MIN_VALUE;
        int temp = Integer.MIN_VALUE;

        for(int i=0; i < hourGlass.length - 2; i++)

            for(int j=0; j < hourGlass.length - 2; j++){

                temp = sumUpperRow(i,j) + sumCenter(i,j) + sumLowerRow(i, j);

                if (temp > max) max = temp;

            }


        return max;
    }

    public static int sumUpperRow(int row, int col){
        return arr[row][col] + arr[row][col+1] + arr[row][col+2];

    }

    public static int sumCenter(int row, int col){
        return arr[row + 1][col + 1];

    }

    public static int sumLowerRow(int row, int col){
        return arr[row + 2][col] + arr[row + 2][col + 1] + arr[row + 2][col + 2];
    }

}
