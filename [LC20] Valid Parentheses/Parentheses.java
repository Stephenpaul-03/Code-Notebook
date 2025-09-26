import java.util.*;

public class Parentheses {

    public static boolean validity_checker(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((top == '(' && ch != ')') || (top == '{' && ch != '}') || (top == '[' && ch != ']')) {
                    return false;
                }
            }
        }
        return stack.isEmpty(); 
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < t; i++) {
                String expression = scanner.nextLine();
                System.out.println(validity_checker(expression));
            }
        }
    }
}
