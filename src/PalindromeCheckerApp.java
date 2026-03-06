import java.util.*;

interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        String str = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) stack.push(ch);
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
        for (char ch : str.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}

// Two-pointer strategy
class TwoPointerStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        String str = input.replaceAll("\\s+", "").toLowerCase();
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}

// Context class
class PalindromeChecker {
    private PalindromeStrategy strategy;
    public void setStrategy(PalindromeStrategy strategy) { this.strategy = strategy; }
    public boolean check(String input) { return strategy.isPalindrome(input); }
}

// Main class
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        PalindromeChecker checker = new PalindromeChecker();
        PalindromeStrategy[] strategies = {
                new StackStrategy(),
                new DequeStrategy(),
                new TwoPointerStrategy()
        };
        String[] names = {"Stack", "Deque", "Two-Pointer"};

        System.out.println("\nPerformance Comparison:");

        for (int i = 0; i < strategies.length; i++) {
            checker.setStrategy(strategies[i]);
            long startTime = System.nanoTime();
            boolean result = checker.check(input);
            long endTime = System.nanoTime();
            System.out.printf("%s: %s, Time: %d ns%n", names[i],
                    (result ? "Palindrome" : "Not Palindrome"),
                    (endTime - startTime));
        }

        sc.close();
    }
}