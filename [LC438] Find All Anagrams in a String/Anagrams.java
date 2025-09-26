import java.util.*;

class Anagrams {
    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            sc.nextLine();

            while (t-- > 0) {
                String s1 = sc.nextLine().trim();
                String s2 = sc.nextLine().trim();
                
                if (areAnagrams(s1, s2)) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
        }
    }
}
