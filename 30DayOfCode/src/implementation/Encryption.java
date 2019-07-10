package implementation;

public class Encryption {

    public static void main(String[] arg) {

        String msg = "this is a test message";
        encryption(msg);
    }

    static String encryption(String s) {

        String cleanMsg = getCleanMsg(s);
        int[][] matrix = initMatrix(cleanMsg);
        return "";
    }

    static int[][] initMatrix(String msg) {

        int row = (int) Math.floor(Math.sqrt(msg.length()));
        int column = (int) Math.ceil(Math.sqrt(msg.length()));

        while (row * column < msg.length()) {
            row++;
        }

        int[][] matrix = new int[row][column];

        return matrix;
    }

    static String getCleanMsg(String msg) {
        String newMsg = new String();

        for (int i = 0; i < msg.length(); i++) {
            if (isInRange(msg.charAt(i))) {
                newMsg += msg.charAt(i);
            }
        }
        return newMsg;
    }

    static boolean isInRange(char c) {
        return c >= 'a' && c <= 'z';
    }
}
