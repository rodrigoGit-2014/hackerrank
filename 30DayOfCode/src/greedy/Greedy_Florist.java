package greedy;

public class Greedy_Florist {


    public static void main(String[] args) {
        int[] c = {390225, 426456, 688267, 800389, 990107, 439248, 240638, 15991, 874479, 568754, 729927, 980985, 132244, 488186, 5037, 721765, 251885, 28458, 23710, 281490, 30935, 897665, 768945, 337228, 533277, 959855, 927447, 941485, 24242, 684459, 312855, 716170, 512600, 608266, 779912, 950103, 211756, 665028, 642996, 262173, 789020, 932421, 390745, 433434, 350262, 463568, 668809, 305781, 815771, 550800};
        //int[] c = {1, 3, 5, 7, 9};
       //  int[] c = {2, 5, 6};
       // int[] c = {1, 2, 3, 4};
        int k = 3;

        Math.sqrt(54);
        System.out.println(getMinimumCost(k, c));

    }

    static int getMinimumCost(int k, int[] c) {
        //k=3 c=1 3 5 7 9
        int flowers = c.length;

        int auxK = k, sum = 0, auxInd = c.length - 1;
        while (auxK > 0) {
            sum += c[auxInd];
            auxInd--;
            auxK--;
        }
        auxK = (flowers - k) - 1;
        int constAdd = 1;

        while (auxK >= 0) {
            sum += (constAdd + 1) * c[auxK];
            auxK--;
        }

        return sum;
    }
}