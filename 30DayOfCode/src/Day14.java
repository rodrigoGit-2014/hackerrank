import java.util.Scanner;

/*
  The absolute difference between two integers, a and b, is |a−b|. The maximum absolute difference of two integers in a set of positive integers, elements, is the largest
  absolute difference of any two integers in elements.

The class Difference is started for you in the editor. It has a private instance array (elements) for storing N non-negative integers, and a public integer (maxDifference) for
storing the maximum absolute difference.

Code for handling Input/Output is provided for you in the editor. Your task is to write the class constructor for Difference and the computeDifference method so that it finds
the maximum absolute difference between any two numbers in N and stores it in maxDifference.

Good Luck!

Input Format

The first line contains a positive integer, N, denoting the size of array elements. The second line contains N space-separated positive integers describing elements.

Constraints
1≤N≤10
1≤elements[i]≤100, where 0≤i≤N−1
Output Format

Print the maximum absolute difference between any two integers in elements.

Sample Input

3
1 2 5
Sample Output

4
Explanation

|1-2|=1
|1-5|=4
|2-5|=3
We print the maximum of these absolute differences, which is 4.

Submissions: 3804
Max Score: 75
Difficulty: Easy
More
Current Buffer (saved locally, editable)

 */
public class Day14 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        Difference D = new Difference(a);

        D.computeDifference();

        System.out.print(D.maximumDifference);
    }

    public static class Difference {
        public int maximumDifference;
        private int[] elements;

        public Difference(int[] e) {
            this.elements = e;
        }

        public void computeDifference() {

            int smallest = Integer.MAX_VALUE;
            int bigger = Integer.MIN_VALUE;

            for (int i = 0; i < elements.length; i++) {

                if (elements[i] < smallest) smallest = elements[i];
                if (elements[i] > bigger) bigger = elements[i];
            }

            this.maximumDifference = Math.abs(smallest - bigger);
        }


    }
}
