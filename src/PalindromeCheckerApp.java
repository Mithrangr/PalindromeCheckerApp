import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.print("Enter word: ");
            String word = sc.nextLine();

            String reversed = "";

            for(int i = word.length() - 1; i >= 0; i--) {
                reversed = reversed + word.charAt(i);
            }

            if(word.equalsIgnoreCase(reversed)) {
                System.out.println("Palindrome");
            } else {
                System.out.println("Not Palindrome");
            }

            System.out.print("Continue? (yes/no): ");
            String choice = sc.nextLine();

            if(choice.equalsIgnoreCase("no")) {
                break;
            }

        }

    }

}