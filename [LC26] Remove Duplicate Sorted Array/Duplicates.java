import java.util.*;

public class Duplicates {
    public static int remover(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return n;
        }
        
        int idx = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[idx] = arr[i];
                idx++;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            sc.nextLine();
            
            for (int i = 0; i < t; i++) {
                int[] arr = Arrays.stream(sc.nextLine().split(" "))
                                   .mapToInt(Integer::parseInt)
                                   .toArray();
                
                int newarr = remover(arr);
                
                for (int j = 0; j < newarr; j++) {
                    System.out.print(arr[j] + " ");
                }
                System.out.println();
            }
        }
    }
}
