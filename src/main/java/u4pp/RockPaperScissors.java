package u4pp;

/**
* JAVADOC HERE
*/
import java.util.Scanner;

public class RockPaperScissors {

    private static int[] scores = new int[3];

    /**
     * the play method allows the user to keep playing and keeps track of their scores until they indicate that they want to stop the code
     */
    public static void play(Scanner sc) {
        /* PART B: YOUR CODE HERE */
        for(int i=0; i<3; i++) {
            scores[i] = 0;
        }
        System.out.println("Welcome to Rock Paper Scissors! ");
        boolean repeat;
        do{
            playRound(sc,scores);
            System.out.println("You have " + scores[2] + " wins and " + scores[0]+ " losses and " + scores[1] + " ties");
            repeat = getYesNoInput(sc,"Would you like to play again? (Y/N) " );
        } while(repeat);
        System.out.println("Thanks for Playing! ");
    }

    /**
     * Given a player and computers choices, it returns an integer which indicates who won, lost, or tied. 
     */
    public static int results(String playerChoice, String computerChoice) {
        int playerInt = "RPS".indexOf(playerChoice.toUpperCase());
        int computerInt = "RPS".indexOf(computerChoice.toUpperCase());
        if(playerInt == (computerInt+1)%3){
            return 1;
        }
        else if(playerInt == computerInt){
            return 0;
        }
        else{
            return -1;

        }
        
    }

    /* 
     * Helper methods for part b
     * These should be private static methods that help organize your code
     * 
     * Recommended helper methods:
     * 1. getRandomChoice() - returns a random "r", "p", or "s"
     * 2. getPlayerChoice(Scanner sc) - prompts user and returns valid R/P/S/A input
     * 3. getYesNoInput(Scanner sc, String prompt) - prompts user and returns true/false for Y/N
     * 4. playRound(Scanner sc, int[] scores) - handles one complete round of RPS
     * 5. formatChoice(String choice) - converts "r" to "Rock", "p" to "Paper", etc.
     */
    private static String getRandomChoice() { // getting the input for rock, paper, or scissor, used for Player if typed any and for Computer
        int rand = (int)(Math.random()*3);
       return "rps".substring(rand,rand+1);
    }

    private static String getPlayerChoice(Scanner sc) { // Gets the input of the player. Prompts the player to choose between r p or s.
        System.out.print("Choose (R)ock, (P)aper, (S)cissors, or (A)ny: ");
        String input = sc.nextLine().toLowerCase();
        while(input.length()>1 || "rpsa".indexOf(input)<0) {
            System.out.println("Invalid input, please try again");
            System.out.print("Choose (R)ock, (P)aper, (S)cissors, or (A)ny: ");
            input = sc.nextLine().toLowerCase();
        }
        return input;
    }

    private static boolean getYesNoInput(Scanner sc, String prompt) { //Asking the user if they want to try again. The prompt can be anything.
        System.out.print(prompt);
        String input = sc.nextLine().toLowerCase();
         while(input.length()>1 || "yn".indexOf(input)<0) {
            System.out.println("Invalid input, please try again");
            System.out.print(prompt);
            input = sc.nextLine().toLowerCase();
        }
        return input.equals("y");
    }

    private static void playRound(Scanner sc, int[] scores) { //executes the round that the player and computer plays, determines winner, loser, or stalemate.
        String playerChoice = getPlayerChoice(sc);
        String compChoice = getRandomChoice();
        int result = results(playerChoice, compChoice);
        System.out.print("You chose " + formatChoice(playerChoice) + ",  computer chose " + formatChoice(compChoice) + ". ");
        if(result == 1) {
            System.out.println("You win");
        }
        else if(result == 0){
            System.out.println("It's a tie");
        }
        else{
            System.out.println("You lose");
        }
        scores[result+1]++; //1 more plus the result
    }

    private static String formatChoice(String choice) { //converts a letter choice into its full word
        if(choice.equals("r")){
            return "Rock";
        }
        else if(choice.equals("p")){
            return "Paper";
        }
        else{
            return "Scissors";
        }
    }
}
