import java.util.Scanner;

public class Distance {

    public static int distance(String s1, String s2, int m, int n) {
        if (m == 0)
            return n;
        if (n == 0)
            return m;

        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return distance(s1, s2, m - 1, n - 1);

        return 1 + Math.min(
            distance(s1, s2, m, n - 1), 
            Math.min(
                distance(s1, s2, m - 1, n), 
                distance(s1, s2, m - 1, n - 1)
            )
        );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < t; i++) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(distance(s1, s2, s1.length(), s2.length()));
        }
        sc.close();
    }
}
