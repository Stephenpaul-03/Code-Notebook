import java.util.*;

public class NGE {

    public static void nge(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            result[i] = -1;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " -> " + result[i]);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            scanner.nextLine(); 

            for (int i = 0; i < t; i++) {
                String input = scanner.nextLine();
                int[] arr = Arrays.stream(input.split(" "))  
                                    .mapToInt(Integer::parseInt)   
                                    .toArray();
                nge(arr);
            }
        }
    }
}
