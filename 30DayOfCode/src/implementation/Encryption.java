package implementation;

public class Encryption {

    public static void main(String[] arg) {

        String msg = "this is a test message";
        encryption(msg);
    }

    static String encryption(String s) {

        String cleanMsg = getCleanMsg(s);
        int[] gridAxis = getGridAxis(cleanMsg);
        String encrypted = encryptMsg(cleanMsg, gridAxis);
        return encrypted;
    }


    static String encryptMsg(String msg, int[] gridAxis) {

        String encrypted = new String();

        int row = 0;

        for (int ind1 = 0; ind1 < gridAxis[1]; ind1++) {
            int column = 0 + row;
            while (column < msg.length()) {
                encrypted += msg.charAt(column);
                column += gridAxis[1];
            }
            row++;
            encrypted += " ";
        }
        return encrypted;
    }


    static int[] getGridAxis(String msg) {

        int[] matrix = new int[2];

        int row = (int) Math.floor(Math.sqrt(msg.length()));
        int column = (int) Math.ceil(Math.sqrt(msg.length()));

        while (row * column < msg.length()) {
            row++;
        }

        matrix[0] = row;
        matrix[1] = column;

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
