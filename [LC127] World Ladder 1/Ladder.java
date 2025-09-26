import java.util.*;

public class Ladder {

    public static int ladder(String start, String target, Set<String> dict) {
        if (start.equals(target)) return 0;
        if (!dict.contains(target)) return 0;

        int level = 0;
        int wordLength = start.length();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                char[] word = queue.poll().toCharArray();

                for (int pos = 0; pos < wordLength; pos++) {
                    char originalChar = word[pos];

                    for (char c = 'a'; c <= 'z'; c++) {
                        word[pos] = c;
                        String newWord = new String(word);

                        if (newWord.equals(target)) {
                            return level + 1;
                        }

                        if (!dict.contains(newWord)) {
                            continue;
                        }

                        dict.remove(newWord);
                        queue.offer(newWord);
                    }

                    word[pos] = originalChar;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int _ = 0; _ < t; _++) {
            String[] inputWords = sc.nextLine().split(" ");
            Set<String> dict = new HashSet<>(Arrays.asList(inputWords));
            String start = sc.nextLine();
            String end = sc.nextLine();

            System.out.println(ladder(start, end, dict));
        }
        sc.close();
    }
}
