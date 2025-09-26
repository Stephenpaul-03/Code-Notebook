import java.util.*;


public class Wave {
    public static int[] waveForm(int[] arr) {
        for (int i = 0; i < arr.length; i += 2) {
            if (i > 0 && arr[i] < arr[i - 1]) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }
            if (i < arr.length - 1 && arr[i] < arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            sc.nextLine();
            
            for (int i = 0; i < t; i++) {
                int[] arr1 = Arrays.stream(sc.nextLine().split(" "))
                                   .mapToInt(Integer::parseInt)
                                   .toArray();
                int arr[] = waveForm(arr1);
                for (int num : arr) {
                    System.out.print(num + " ");
                }
                System.out.println("");
            }
        }
    }
}