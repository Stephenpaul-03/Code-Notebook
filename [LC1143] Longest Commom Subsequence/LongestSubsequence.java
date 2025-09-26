import java.util.*;

public class LongestSubsequence {

    public static int lcs(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return 1 + lcs(s1, s2, m - 1, n - 1);
        else
            return Math.max(lcs(s1, s2, m, n - 1), lcs(s1, s2, m - 1, n));
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter first string: ");
            String s1 = scanner.nextLine();

            System.out.print("Enter second string: ");
            String s2 = scanner.nextLine();

            int m = s1.length();
            int n = s2.length();

            System.out.println("Length of LCS: " + lcs(s1, s2, m, n));
        }
    }
}
