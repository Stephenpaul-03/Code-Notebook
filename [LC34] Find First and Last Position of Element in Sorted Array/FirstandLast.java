import java.util.*;

class FirstandLast {
	public static void Occurance(int arr[], int x) {
		int n = arr.length;
		int first = -1, last = -1;
		for (int i = 0; i < n; i++) {
			if (x != arr[i]) continue;
			if (first == -1) first = i;
			last = i;
		}
		if (first != -1) {
			System.out.println("First Occurrence: " + first);
			System.out.println("Last Occurrence: " + last);
		} else {
			System.out.println("Not Found");
		}
	}

	public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            sc.nextLine();
            
            for (int i = 0; i < t; i++) {
                int[] arr = Arrays.stream(sc.nextLine().split(" "))
                                   .mapToInt(Integer::parseInt)
                                   .toArray();
                int n = sc.nextInt();
                sc.nextLine();
                Occurance(arr, n);
                
            }
        }
    }
}
