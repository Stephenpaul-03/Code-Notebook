import java.util.Arrays;
import java.util.Scanner;

public class Longest_Common_Prefix {
    public static String longestCommonPrefix(String[] arr) {
        Arrays.sort(arr);
        String first = arr[0];
        String last = arr[arr.length - 1];
        int minLength = Math.min(first.length(), last.length());
        int i = 0;
        while (i < minLength && first.charAt(i) == last.charAt(i)) {
            i++;
        }
        return i == 0 ? "-1" : first.substring(0, i);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter words separated by spaces:");
            String[] arr = Arrays.stream(scanner.nextLine().split(" "))
                                 .toArray(String[]::new);
            System.out.println(longestCommonPrefix(arr));
        }
    }
}
