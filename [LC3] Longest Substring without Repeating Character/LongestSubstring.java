import java.util.Scanner;

public class LongestSubstring {
    public static int substr(String s) {
        int n = s.length();
        int res = 0;
        int[] lastIndex = new int[256];
        for (int i = 0; i < 256; i++) {
            lastIndex[i] = -1;
        }
        int start = 0;

        for (int end = 0; end < n; end++) {
            start = Math.max(start, lastIndex[s.charAt(end)] + 1);
            res = Math.max(res, end - start + 1);
            lastIndex[s.charAt(end)] = end;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < t; i++) {
            String s = sc.nextLine();
            System.out.println(substr(s));
        }
        sc.close();
    }
}
