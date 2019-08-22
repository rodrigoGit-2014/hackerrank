package implementation;

public class SherlockAndSquares {

    public static void main(String[] args) {
        System.out.println(squares(17, 24));
    }

    static int squares(int a, int b) {

        String start = String.valueOf(Math.sqrt(a));

        boolean isExactStart = start.substring(start.indexOf('.') + 2, start.length()).length() == 0;

        int startValue, endValue, totSquares = 0;

        if (isExactStart) {
            startValue = (int) Math.sqrt(a);
        } else {
            startValue = (int) Math.sqrt(a) + 1;
        }

        endValue = (int) Math.sqrt(b);


        for (int count = startValue; count <= endValue; count++) totSquares++;

        return totSquares;
    }
}
