import java.util.Scanner;
import java.util.Stack;

// Encapsulated class for palindrome checking
class PalindromeChecker {

    // Method to check if string is palindrome
    public boolean checkPalindrome(String input) {
        // Normalize input (optional: remove spaces, ignore case)
        String str = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        // Pop and compare
        for (char ch : str.toCharArray()) {
            if (stack.pop() != ch) {
                return false;
            }
        }

        return true;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Create object and check palindrome
        PalindromeChecker checker = new PalindromeChecker();

        if (checker.checkPalindrome(input)) {
            System.out.println("The string is a Palindrome");
        } else {
            System.out.println("The string is NOT a Palindrome");
        }

        sc.close();
    }
}