package implementation;

import java.util.Arrays;
import java.util.Comparator;

public class BigSorting {

    public static void main(String[] args) {

        String[] numbers = new String[]{"33342", "473648723684723687", "373773"};
        bigSorting(numbers);
    }


    public static String[] bigSorting(String[] unsorted) {

        Arrays.sort(unsorted, new Comparator<String>() {
            @Override
            public int compare(String source, String dest) {


                if (source.length() > dest.length()) {
                    return 1;
                } else if (source.length() < dest.length()) {
                    return -1;
                } else if (source.length() == dest.length()) {
                    for (int i = 0; i < source.length(); i++) {
                        if (source.charAt(i) > dest.charAt(i)) {
                            return 1;
                        } else if (source.charAt(i) < dest.charAt(i)) {
                            return -1;
                        } else if (i == (source.length() - 1)) return 0;
                    }
                }
                return 0;
            }
        });

        return unsorted;
    }


}
