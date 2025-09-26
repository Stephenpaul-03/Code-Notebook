import java.util.Scanner;

public class Unique {

    static final int MAX_CHAR = 26;

    public static char NRC(String s) {
        int[] arr = new int[MAX_CHAR];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }

        return 'N';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int _ = 0; _ < t; _++) {
            String s = scanner.nextLine();
            char res = NRC(s);
            if (res == 'N') {
                System.out.println("NONE");
            } else {
                System.out.println(res);
            }
        }

        scanner.close();
    }
}
