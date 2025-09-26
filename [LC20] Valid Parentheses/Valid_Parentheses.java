import java.util.*;

public class Valid_Parentheses {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Test Case Count: ");
            int t = sc.nextInt();
            sc.nextLine();
            
            while (t-- > 0) {
                System.out.print("Enter Parentheses: ");
                String par = sc.nextLine();

                if (isBalanced(par)) {
                    System.out.println("Balanced");
                } else {
                    System.out.println("Not Balanced");
                }
            }
        }
    }

    private static boolean isBalanced(String par) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : par.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}
