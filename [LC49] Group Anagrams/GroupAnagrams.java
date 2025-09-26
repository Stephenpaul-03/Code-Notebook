import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            anagrams.putIfAbsent(sortedStr, new ArrayList<>());
            anagrams.get(sortedStr).add(s);
        }

        return new ArrayList<>(anagrams.values());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();  // consume newline after integer

        for (int i = 0; i < t; i++) {
            String[] strs = sc.nextLine().split(" ");
            List<List<String>> result = groupAnagrams(strs);
            System.out.println(result);
        }

        sc.close();
    }
}
