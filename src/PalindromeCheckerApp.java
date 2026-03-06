import java.util.*;

// Strategy interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        String str = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }
        for (char ch : str.toCharArray()) {
            if (stack.pop() != ch) return false;
        }
        return true;
    }
}

// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        String str = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : str.toCharArray()) {
            deque.addLast(ch);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}

// Context class
class PalindromeChecker {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        return strategy.isPalindrome(input);
    }
}

// Main class
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Choose strategy: 1-Stack, 2-Deque");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        switch (choice) {
            case 1:
                checker.setStrategy(new StackStrategy());
                break;
            case 2:
                checker.setStrategy(new DequeStrategy());
                break;
            default:
                System.out.println("Invalid choice! Using default Stack strategy.");
                checker.setStrategy(new StackStrategy());
        }

        if (checker.check(input)) {
            System.out.println("The string is a Palindrome");
        } else {
            System.out.println("The string is NOT a Palindrome");
        }

        sc.close();
    }
}