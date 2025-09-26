import java.util.*;
import java.util.stream.*;

public class Intervals {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Test Case Count: ");
            int t = scanner.nextInt();
            scanner.nextLine(); 
            
            while (t-- > 0) {
                System.out.print("Enter intervals (space-separated): ");
                String input = scanner.nextLine();

                List<int[]> intervals = Arrays.stream(input.split("\\s+"))
                        .map(interval -> {
                            String[] parts = interval.replaceAll("[\\[\\]]", "").split(",");
                            int start = Integer.parseInt(parts[0].trim());
                            int end = Integer.parseInt(parts[1].trim());
                            return new int[]{start, end};
                        })
                        .collect(Collectors.toList());

                intervals.sort(Comparator.comparingInt(a -> a[0]));
                List<int[]> merged = new ArrayList<>();
                for (int[] interval : intervals) {
                    if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                        merged.add(interval);
                    } else {
                        merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
                    }
                }
                System.out.print("Merged intervals: ");
                for (int[] interval : merged) {
                    System.out.print("[" + interval[0] + "," + interval[1] + "] ");
                }
                System.out.println(); 
            }
        }
    }
}
