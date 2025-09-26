import java.util.*;

public class LargestNumber {

    public static String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String order1 = s1 + s2;
                String order2 = s2 + s1;
                return order2.compareTo(order1); // descending order
            }
        });

        // If after sorting the largest number is 0, the entire number is 0
        if (arr[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < t; i++) {
            String[] parts = sc.nextLine().split(" ");
            int[] arr = new int[parts.length];
            for (int j = 0; j < parts.length; j++) {
                arr[j] = Integer.parseInt(parts[j]);
            }
            System.out.println(largestNumber(arr));
        }
        sc.close();
    }
}
