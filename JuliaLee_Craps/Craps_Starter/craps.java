/** Craps Game
 * @author Julia Lee
 * Course: CSCI 2001-51 Object Oriented Programming
 * Fall Semester 2026
 * 
 * Use the starter code to implement a game of Craps
 * Do a combination of decomposing the figure from the textbook and implementing the game logic.
 * Combined using the Die class to roll the dice.
 * Extend the textbook example to include betting and a simple user interface.
 * 
 * @attributions: this code is based on the example in the textbook "Java: How to Program: An object Neutral Approach" by Paul Deitel and Harvey Deitel, 12th Edition
 * 
 */


package Craps_Starter;


import java.util.Scanner;


public class craps {

    private enum Status {
        CONTINUE, WON, LOST
    }

    // One shared Scanner for all input
    private static final Scanner scan = new Scanner(System.in);

    // Plays one game of craps.
    public static void main(String[] args) {
        System.out.println("--- Welcome to Craps! ---");

        // Prompt for the initial bankroll (must be > 0)
        System.out.print("Enter your starting bankroll (e.g. 100: $");
        int bankroll = scan.nextInt();
        scan.nextLine(); // consume the leftover newline

        while (bankroll <= 0) {
            System.out.println("Bankroll must be greater than 0.");
            System.out.print("Enter your starting bankroll (e.g. 100): $");
            bankroll = scan.nextInt();
            scan.nextLine();
        }

        System.out.printf("Your starting bankroll is $%d%n%n", bankroll);


        boolean playing = true;

        // Game loop: continue until broke or the player quits
        while (playing && bankroll > 0) {

            // Prompt for a valid wager: 0 < wager <= bankroll
            System.out.printf("Enter your wager (1-%d): $", bankroll);
            int wager = scan.nextInt();
            scan.nextLine();


            while (wager <= 0 || wager > bankroll) {
                System.out.printf("Wager must be between 1 and %d.%n", bankroll);
                System.out.printf("Enter your wager (1-%d): $", bankroll);
                wager = scan.nextInt();
                scan.nextLine();
            }


            // Play one round
            Status result = playRound();

            // Resolve the bet and update the bankroll
            if (result == Status.WON) {
                bankroll += wager;
                System.out.printf("!!! You WON! Bankroll: $%d !!!%n%n", bankroll);
            } else {
                bankroll -= wager;
                System.out.printf("¡¡¡ You LOST. Bankroll: $%d ¡¡¡%n%n", bankroll);
            }

            // Auto-terminate if the player is broke
            if (bankroll <= 0) {
                System.out.println("You're out of money! Game Over.");
                break;
            }

            // Ask whether to play another round
            System.out.print("Play another round? (y/n): ");
            String answer = scan.nextLine().trim();
            playing = answer.equalsIgnoreCase("y");

        }

        System.out.printf("%nThanks for playing! You cashed out with $%d.%n", bankroll);
        scan.close();
    }

    /**
     * The comeOut method will simulate the first roll of a round of craps.
     *
     * @return -1 if the player loses, 1 if the player wins, otherwise return the point value.
     */

    public static int comeOut() {
        int sum = rollDice();

        switch (sum) {
            case 7:
            case 11:
                return 1; // Natural - win
            case 2:
            case 3:
            case 12:
                return -1; // Craps - loss
            default:
                System.out.println("Point is " + sum);
                return sum;   // Point established
        }
    }

    /**
     * The rollOn method will simulate the subsequent rolls of a round of craps
     * @param point the established point values
     * @return the Status of the game after the player is done rolling.
     *         The player continues rolling until they either roll the point value again (WON) or roll a 7 (LOST).
     */

    public static Status rollOn(int point) {
        while (true) {
            int sum = rollDice();

            if (sum == point) {
                return Status.WON;
            }
            if (sum == 7) {
                return Status.LOST;
            }
            // otherwise keep rolling
        }
    }

    /**
     * The playRound method will simulate a round of craps.
     * 
     * @return the Status of the game after the round is complete.
     *          This return values can be used to resolve the betting for the round.
     */

    public static Status playRound() {
        int comeOutResult = comeOut();

        if (comeOutResult == 1) {
            return Status.WON;
        }
        if (comeOutResult == -1) {
            return Status.LOST;
        }


        // A point was established - continue rolling
        int point = comeOutResult;
        return rollOn(point);
    }

    /**
     * rollDice method simulate rolling two dice, calculates the sum, and display the results.
     * 
     * @return the sum of the two dice.
     */

    public static int rollDice() {

        // Instance methods need an object - create two Die instances.
        die die1 = new die(6);
        die die2 = new die(6);

        int roll1 = die1.roll();   // instance method call
        int roll2 = die2.roll();  // instance method call
        int sum = roll1 + roll2;

        System.out.printf("Player rolled %d + %d = %d%n", roll1, roll2, sum);
        return sum;
    }


}