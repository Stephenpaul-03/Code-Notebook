import java.util.*;

class Stock {
    static int profit_checker(int[] arr) {
        int min = arr[0];
        int res  = 0;
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            res = Math.max(res, arr[i] - min);
        }
        return res;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            sc.nextLine();
            
            for (int i = 0; i < t; i++) {
                int[] arr = Arrays.stream(sc.nextLine().split(" "))
                                   .mapToInt(Integer::parseInt)
                                   .toArray();
            System.out.println(profit_checker(arr));
            }
        }
    }
}
