package implementation;

public class AppendAndDelete {

    private static String YES = "Yes";
    private static String NO = "No";

    public static void main(String[] args) {
        String s = "asdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv";
        String t = "asdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv";
        System.out.println(appendAndDelete(s, t, 7));
    }

    static String appendAndDelete(String s, String t, int k) {

        Handler handler = new Handler(s, t, k);

        int ind = handler.getIndex();
        handler.updateOperation(ind);
        return handler.calculateAnswer();
    }


    public static class Handler {
        public String s;
        public String t;
        public int k;
        public Operation operation;


        public Handler(String s, String t, int k) {
            this.s = s;
            this.t = t;
            this.k = k;
            this.operation = new Operation();
        }

        public int getIndex() {
            int ind = 0;
            while (ind < s.length() && ind < t.length()
                    && s.charAt(ind) == t.charAt(ind)) {
                ind++;
            }
            return ind;
        }

        public void updateOperation(int ind) {

            if (this.s.length() > this.t.length()) {
                operation.deleteCount = s.length() - ind;
            } else if (this.t.length() > this.s.length()) {
                operation.appendCount = t.length() - ind;
            } else {
                operation.deleteCount = s.length() - ind;
                operation.appendCount = t.length() - ind;
            }

        }

        public String calculateAnswer() {
            if ((operation.appendCount > 0 && operation.deleteCount == 0) ||
                    (operation.appendCount == 0 && operation.deleteCount > 0)) {

                if (operation.appendCount > 0 &&
                        (k - operation.appendCount) >= 0 &&
                        (k - operation.appendCount) % 2 == 0) {
                    return YES;

                }

                if (operation.deleteCount > 0 &&
                        k - operation.deleteCount >= 0 &&
                        (k - operation.deleteCount) >= 0) {
                    return YES;
                }
            }

            if (operation.appendCount > 0 && operation.deleteCount > 0 &&
                    ((operation.appendCount + operation.deleteCount == k) ||
                     (k - (operation.appendCount + operation.deleteCount)  >= 0))) {
                return YES;
            }

            if (operation.appendCount == 0 && operation.deleteCount == 0 &&
                    (k - s.length() >= 0 || s.length()>k )) {
                return YES;
            }

            return NO;
        }
    }

    public static class Operation {
        public int appendCount;
        public int deleteCount;


    }

}
