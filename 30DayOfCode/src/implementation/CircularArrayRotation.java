package implementation;

public class CircularArrayRotation {
    public static void main(String[] args) {

        int[] a = new int[]{1, 2,    3};
        int k = 2;
        int[] queries = new int[]{0,1, 2};
        int[] answ = circularArrayRotation(a, k, queries);
        for (int i = 0; i < answ.length; i++) {
            System.out.println(answ[i]);
        }
    }

    static int[] circularArrayRotation(int[] a, int k, int[] queries) {

        int[] newArray = rotateArray(a, k);
        int[] answer = findElements(newArray, queries);

        return answer;
    }

    static int[] findElements(int[] na, int[] queries) {

        int[] answer = new int[queries.length];
        for (int ind = 0; ind < queries.length; ind++) {
            answer[ind] = na[queries[ind]];
        }
        return answer;

    }

    static int[] rotateArray(int[] a, int k) {
        int[] newArray = new int[a.length];

        if (k > a.length) k = k % a.length;

        int moveIndex = (a.length - k) - 1;
        while (moveIndex >= 0) {
            newArray[moveIndex + k] = a[moveIndex];
            moveIndex--;
        }
        moveIndex = 0;
        while (moveIndex < k) {
            newArray[moveIndex] = a[(a.length - k) + moveIndex];
            moveIndex++;
        }
        return newArray;
    }
}
