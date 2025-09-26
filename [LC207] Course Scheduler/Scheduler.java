import java.util.*;

class Pair {
    int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class TaskScheduler {

    // Build adjacency list graph
    static List<List<Integer>> define(int tasks, List<Pair> pre) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < tasks; i++) {
            graph.add(new ArrayList<>());
        }

        for (Pair p : pre) {
            graph.get(p.second).add(p.first);
        }

        return graph;
    }

    // DFS to detect cycles
    static boolean dfs(List<List<Integer>> graph, int node, boolean[] onPath, boolean[] visited) {
        if (visited[node]) {
            return false;
        }
        onPath[node] = true;
        visited[node] = true;

        for (int neigh : graph.get(node)) {
            if (onPath[neigh] || dfs(graph, neigh, onPath, visited)) {
                return true;  // Cycle detected
            }
        }

        onPath[node] = false;
        return false;
    }

    // Check if all tasks can be finished (no cycles)
    static boolean finish(int tasks, List<Pair> pre) {
        List<List<Integer>> graph = define(tasks, pre);
        boolean[] onPath = new boolean[tasks];
        boolean[] visited = new boolean[tasks];

        for (int i = 0; i < tasks; i++) {
            if (!visited[i] && dfs(graph, i, onPath, visited)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int numTasks = sc.nextInt();
            int numPrerequisites = sc.nextInt();

            List<Pair> prerequisites = new ArrayList<>();
            for (int i = 0; i < numPrerequisites; i++) {
                int first = sc.nextInt();
                int second = sc.nextInt();
                prerequisites.add(new Pair(first, second));
            }

            if (finish(numTasks, prerequisites)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
