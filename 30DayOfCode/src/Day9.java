import java.util.Scanner;
/*
 Euclid's Algorithm
 */
public class Day9 {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        int gcd = find_gcd(a, b);

        System.out.println(gcd);
    }

    static int find_gcd(int a, int b) {
        if (a == b) return a;

        if (a ==0 && b > 0 ) return b;
        if (b ==0 && a > 0 ) return a;

        if (b > a)
            return find_gcd(b % a, a);
        else
            return find_gcd(a % b, b);

    }
}
