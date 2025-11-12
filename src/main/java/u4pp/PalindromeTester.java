package u4pp;
/**
* YOUR COMMENTS HERE
*/
import java.util.Scanner;

public class PalindromeTester {
    
    public static void execute(Scanner sc) { //executes and gets the input from the user. It lets the user keep testing until the user says no.
        boolean repeat;
        System.out.println("Welcome to Palindrome Tester:");
        do{
            System.out.print("Enter a phrase: ");
            String phrase = sc.nextLine();
            if(isPalindrome(phrase)) {
                System.out.println(phrase + " is a palindrome");
            }
            else {
                System.out.println(phrase + " is not a palindrome");
            }

            repeat = getYesNoInput(sc,"Keep testing? (Y/N): " );
        } while(repeat);
    }

    /**
     * YOUR JAVADOC HERE
     */
    public static boolean isPalindrome(String phrase) { //checks if the user input is a palindrome
        phrase = processInput(phrase);
        int len = phrase.length();
        for(int i=0; i<len/2; i++) {
            int j = len-i-1;
            if(phrase.charAt(i) != phrase.charAt(j)) {
                return false;
            }
        }
        return true;

    }

    private static boolean getYesNoInput(Scanner sc, String prompt) { //prompts the user for a yes or no answer to the given prompt.
        System.out.print(prompt);
        String input = sc.nextLine().toLowerCase();
         while(input.length()>1 || "yn".indexOf(input)<0) {
            System.out.println("Invalid Input, please try again");
            System.out.print(prompt);
            input = sc.nextLine().toLowerCase();
        }
        return input.equals("y");
    }
    private static String processInput(String input) { //Removes punctuations, white spaces, and numbers from the phrase or input that the user gave.
        input = input.replaceAll("\\p{Punct}","");
        input = input.replaceAll("\\s","");
        input = input.replaceAll("\\d","");
        return input.toLowerCase();
    }
}