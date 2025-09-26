import java.util.Scanner;

public class Palindrome {

    public static String palindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String longestPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            String oddPalindrome = center(s, i, i);
            if (oddPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = oddPalindrome;
            }

            String evenPalindrome = center(s, i, i + 1);
            if (evenPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = evenPalindrome;
            }
        }

        return longestPalindrome;
    }
    private static String center(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of test cases: ");
            int t = scanner.nextInt();
            scanner.nextLine(); 
            for (int i = 0; i < t; i++) {
                System.out.print("Enter a string: ");
                String input = scanner.nextLine();
                String result = palindrome(input);
                System.out.println(result);
            }
        }
    }
}
