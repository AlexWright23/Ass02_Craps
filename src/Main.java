import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        while (playAgain) {
            boolean done1 = false;
            boolean done2 = false;
            boolean validInput = false;
            boolean roundTwoOver = false;
            String inputYN;

            do {
                int die1 = random.nextInt(6) + 1;
                int die2 = random.nextInt(6) + 1;
                int firstDiceSum = die1 + die2;
                System.out.println("Die one is " + die1 + " and die two is " + die2 + " the total is " + firstDiceSum);

                if (firstDiceSum == 2 || firstDiceSum == 3 || firstDiceSum == 12) {
                    System.out.println("You crapped out, you lose!");
                    done1 = true;
                } else if (firstDiceSum == 7 || firstDiceSum == 11) {
                    System.out.println("It's natural, you win!");
                    done1 = true;
                }

                if (!done1) {
                    do {
                        die1 = random.nextInt(6) + 1;
                        die2 = random.nextInt(6) + 1;
                        int secondDiceSum = die1 + die2;
                        System.out.println("You are rolling to beat " + firstDiceSum + " die one is " + die1 + " die two is " + die2 + " the total is " + secondDiceSum);

                        if (secondDiceSum == 7) {
                            roundTwoOver = true;
                            System.out.println("You rolled a seven and took the L");
                        } else if (secondDiceSum == firstDiceSum) {
                            roundTwoOver = true;
                            System.out.println("The sum of the point is  " + firstDiceSum + ", so you won!");
                        }
                    } while (!roundTwoOver);
                }

                do {
                    System.out.print("Would you like to keep playing? [Y/N]: ");
                    inputYN = scanner.nextLine();
                    if (inputYN.equalsIgnoreCase("Y")) {
                        validInput = true;
                        done2 = false;
                    } else if (inputYN.equalsIgnoreCase("N")) {
                        validInput = true;
                        done2 = true;
                    } else {
                        System.out.println("You have entered " + inputYN + " Please enter a valid input");
                    }
                } while (!validInput);
            } while (!done2);

            System.out.print("Do you want to play again? [Y/N]: ");
            String playAgainChoice = scanner.nextLine();
            if (!playAgainChoice.equalsIgnoreCase("Y")) {
                playAgain = false;
                System.out.println("Thank you playing!");
            }
        }

        // Close the scanner at the end
        scanner.close();
    }
}
