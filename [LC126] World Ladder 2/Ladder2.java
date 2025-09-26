import java.util.*;

class Node {
    String word;
    int len;

    public Node(String word, int len) {
        this.word = word;
        this.len = len;
    }
}

public class Ladder2 {

    // Check if two words differ by exactly one character
    private static boolean isAdjacent(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
            if (count > 1) return false;
        }
        return count == 1;
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        Map<String, Integer> vis1 = new HashMap<>();
        Map<String, Integer> vis2 = new HashMap<>();

        q1.offer(new Node(beginWord, 1));
        vis1.put(beginWord, 1);
        q2.offer(new Node(endWord, 1));
        vis2.put(endWord, 1);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            // Expand from the beginWord side
            int size1 = q1.size();
            for (int i = 0; i < size1; i++) {
                Node curr1 = q1.poll();

                for (String word : wordList) {
                    if (isAdjacent(curr1.word, word) && !vis1.containsKey(word)) {
                        Node temp = new Node(word, curr1.len + 1);
                        q1.offer(temp);
                        vis1.put(word, temp.len);

                        if (word.equals(endWord)) return temp.len;
                        if (vis2.containsKey(word))
                            return temp.len + vis2.get(word) - 1;
                    }
                }
            }

            // Expand from the endWord side
            int size2 = q2.size();
            for (int i = 0; i < size2; i++) {
                Node curr2 = q2.poll();

                for (String word : wordList) {
                    if (isAdjacent(curr2.word, word) && !vis2.containsKey(word)) {
                        Node temp = new Node(word, curr2.len + 1);
                        q2.offer(temp);
                        vis2.put(word, temp.len);

                        if (word.equals(beginWord)) return temp.len;
                        if (vis1.containsKey(word))
                            return temp.len + vis1.get(word) - 1;
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int test = 0; test < t; test++) {
            String[] words = sc.nextLine().split(" ");
            List<String> wordList = Arrays.asList(words);
            String start = sc.nextLine().trim();
            String end = sc.nextLine().trim();

            System.out.println(ladderLength(start, end, wordList));
        }

        sc.close();
    }
}
