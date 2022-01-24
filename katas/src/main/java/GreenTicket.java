import java.util.*;
import java.util.concurrent.TimeUnit;
//Create an integer method called GreenTicket that takes in three integers, "a". "b", and "c"
//You have a green lottery ticket, with ints a, b, and c on it. If the numbers are all different from
//each other, the result is 0. If all of the numbers are the same, the result is 20. If two of the
//numbers are the same, the result is 10.
//greenTicket(1, 2, 3) → 0
//greenTicket(2, 2, 2) → 20
//greenTicket(1, 1, 2) → 10

//Nah... I think I'll have some fun with this one.

public class GreenTicket {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        double minimumDailyPrize = 100000.00;
        double maximumDailyPrize = 1000000.00;
        final double GRAND_PRIZE = Math.floor(Math.random() * (maximumDailyPrize - minimumDailyPrize + 1) + minimumDailyPrize);
        Random numGen = new Random();
        int maxNumGen = 99999;
        final int winningNumberOne = numGen.nextInt(maxNumGen);
        final int winningNumberTwo = numGen.nextInt(maxNumGen);
        final int winningNumberThree = numGen.nextInt(maxNumGen);
        final double SECRET_NUMBER = Math.floor(Math.random() * (9999 - 1111 + 1) + 1111);
        String userYN = "";
        System.out.print("****************************************\n");
        System.out.print("****WELCOME TO THE SMOKING SQUIRREL*****\n");
        System.out.print("**************LOTTERY!******************\n");
        System.out.print("****************************************\n\n");
        System.out.print("Today's grand prize is $" + GRAND_PRIZE + "\n\n");
        while (!(userYN.equals("Y")) && !(userYN.equals("N"))) {
            System.out.print("Is this your first time? (Y) (N): ");
            userYN = userInput.nextLine();
            if (!(userYN.equals("Y")) && !(userYN.equals("N"))) {
                System.out.print("\nCommand unrecognized.\n\n");
            }
        }
        if (userYN.equals("Y")) {
            System.out.print("\nWelcome, new gambling addict! Here at\n");
            System.out.print("The Smoking Squirrel, we believe that\n");
            System.out.print("everyone deserves a totally fair chance\n");
            System.out.print("to win it big! ...or go broke trying!\n\n");
            System.out.print("As a gambler, you must first confirm\n");
            System.out.print("with us how much money you have on you.\n");
            System.out.print("You will be prompted to enter that first.\n");
            System.out.print("After that, you have two options: whether\n");
            System.out.print("you would like to purchase a ticket or\n");
            System.out.print("whether you'd like to call it a day.\n\nIf");
            System.out.print(" you decide to go home, your will receive\n");
            System.out.print("a title depending on your losses or wins.\n");
            System.out.print("However, should you choose to buy a ticket,\n");
            System.out.print("the real fun begins!\n");
            System.out.print("After you choose to buy a ticket, you will be\n");
            System.out.print("asked whether you would like a random ticket,\n");
            System.out.print("or whether you would like to enter your\n");
            System.out.print("own numbers.\n\n");
            System.out.print("After that, we will see if any of your\n");
            System.out.print("numbers match!\nWhat decides your winnings\n");
            System.out.print("is shown below:\n\n");
            System.out.print("Sample numbers: 01234 56789 10111\n\n");
            System.out.print("When ALL of your numbers match, you win\n");
            System.out.print("today's grand prize!\n\n");
            System.out.print("When two of your numbers match, you'll\n");
            System.out.print("win $10,000 dollars!\n\nIf one of your number\n");
            System.out.print("matches, you'll win $1,000 dollars!\n\n");
            System.out.print("If neither of the above happen, you still\n");
            System.out.print("have a chance to win! That's right!\n\n");
            System.out.print("If one of your numbers contains today's\n");
            System.out.print("four digit \"secret number\", you'll win\n");
            System.out.print("$500 dollars!\n\n");
            System.out.print("We hope you enjoy your time at The Smoking\n");
            System.out.print("Squirrel! Please don't gamble responsibly.\n\n");
            System.out.print("**********************************************\n\n");
        } else {
            System.out.print("\nWelcome back! Let's get rich today!\n\n");
        }
        System.out.print("What's your name partner?: ");
        String playerName = userInput.nextLine();
        System.out.print("\nHowdy, " + playerName + ", it's good to see you!\n\n");
        System.out.print("Before we begin taking all your mon--I mean before\n");
        System.out.print("you begin winning big, we need to know how much\n");
        System.out.print("money you're taking in with you. Don't worry, we\n");
        System.out.print("won't tell anyone... most of the time.... Just\n");
        System.out.print("ignore our EULA, it's too long anyway.\n\n");
        System.out.print("So about that money... how much ya got?: $");
        double moneySpent = 0;
        double wallet = Double.parseDouble(userInput.nextLine());
        if (wallet >= 1000.0) {
            System.out.print("\nHey there, high roller!\n\n");
        } else if (wallet < 1000.0 && wallet >= 100.0) {
            System.out.print("\nIt's not much, but we'll let you gamble.\n\n");
        } else if (wallet < 100.0 && wallet >= 10.0) {
            System.out.print("\nWho let this person in? *cough*\n\n");
        } else if (wallet < 10) {
            System.out.print("\nYou can't even buy a ticket! Get out of here!");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException ie) {
            }
            System.out.println("\nLater, loser!");
            System.exit(0);
        }
        int numBets = 0;
        boolean isGambling = true;
        String goHome = "HOME";
        while (isGambling) {
            System.out.println("\nWelcome to the home menu," + playerName + "!\n");
            System.out.println("If at any time you need to return here, just enter \"HOME\".\n");
            System.out.println("You can choose to do any of the following:\n\n");
            System.out.println("(B)uy a ticket!\n");
            System.out.println("(C)heck today's grand prize!\n");
            System.out.println("(G)o home...\n\n");
            System.out.println("You have $" + wallet + " right now.\n\n");
            System.out.println("So what's it gonna be," + playerName + "?: ");
            String playerMenuChoice = userInput.nextLine();
            while (!playerMenuChoice.equals(goHome)) {
                while (playerMenuChoice.equals("B")) {
                    System.out.println("\nWould you like to buy a random ticket?: (Y) or (N)\n");
                    userYN = userInput.next();
                    if (userYN.equals(goHome)) {
                        playerMenuChoice = goHome;
                        break;
                    }
                    if (!userYN.equals("Y") && !userYN.equals("N")) {
                        System.out.println("\nCommand unrecognized.\n");
                        playerMenuChoice = "B";
                    } else if (userYN.equals("Y")) {
                        System.out.println("\nGenerating your ticket...\nYou will be charged $5.00.\n");
                        moneySpent += 5;
                        wallet -= 5;
                        int randomNumberOne = numGen.nextInt(maxNumGen);
                        int randomNumberTwo = numGen.nextInt(maxNumGen);
                        int randomNumberThree = numGen.nextInt(maxNumGen);
                        if ((randomNumberOne == winningNumberOne) && (randomNumberTwo == winningNumberTwo) && (randomNumberThree == winningNumberThree)) {
                            System.out.print("\nI... I can't believe it... " + playerName + "...\n");
                            System.out.print("YOU JUST WON THE GRAND PRIZE!!!\n\n");
                            System.out.print("We... we can't afford to lose this money....\n");
                            System.out.print("Security! Remove this person from the building!\n");
                            try {
                                TimeUnit.SECONDS.sleep(5);
                            } catch (InterruptedException ie) {
                            }
                            System.out.println("\nWhere is my security?!\n");
                            try {
                                TimeUnit.SECONDS.sleep(5);
                            } catch (InterruptedException ie) {
                            }
                            System.out.println("\nOh no! They've all left! What can I do?\n");
                            try {
                                TimeUnit.SECONDS.sleep(5);
                            } catch (InterruptedException ie) {
                            }
                            System.out.println("Ugh... can't manage anything around here....\n");
                            System.out.println("Alright... take your damn money.\n");
                            wallet = wallet + GRAND_PRIZE;
                            System.out.print("\n\nCONGRATULATIONS! You've won! Your ending balance is $" + wallet + "!");
                            System.out.print("\nSince you have left The Smoking Squirrel bankrupt,\n");
                            System.out.print("\nit's time to go home! ...goodbye! Until next time!\n\n");
                            System.out.print("\nPlayer: " + playerName + " Cash: $" + wallet);
                            try {
                                TimeUnit.SECONDS.sleep(5);
                            } catch (InterruptedException ie) {
                            }
                            System.exit(0);
                        } else if ((((randomNumberOne == winningNumberOne) && (randomNumberTwo == winningNumberTwo)) || ((randomNumberTwo == winningNumberTwo) && (randomNumberThree == winningNumberThree))) || ((randomNumberOne == winningNumberOne) && (randomNumberThree == winningNumberThree))) {
                            System.out.println("\nCongratulations! Two of your numbers matched!\n");
                            System.out.println("You've won $10,000!\n");
                            wallet = wallet + 10000;
                            userYN = "";
                            while (!(userYN.equals("Y")) && !(userYN.equals("N"))) {
                                System.out.print("\nWould you like to but another? (Y) (N): ");
                                userYN = userInput.nextLine();
                                if (!(userYN.equals("Y")) && !(userYN.equals("N"))) {
                                    System.out.print("\nCommand unrecognized.\n\n");
                                }
                                if (userYN.equals(goHome)) {
                                    playerMenuChoice = goHome;
                                    break;
                                }
                            }
                            if (userYN.equals("Y")) {
                                playerMenuChoice = "B";
                                System.out.print("\n\n\n");
                                break;
                            } else if (userYN.equals("N")) {
                                System.out.print("\n\n\n");
                                playerMenuChoice = "";
                            }
                        } else if ((randomNumberOne == winningNumberOne) || (randomNumberTwo == winningNumberTwo) || (randomNumberOne == winningNumberThree)) {
                            System.out.println("\nCongratulations! One of your numbers matched!\n");
                            System.out.println("You've won $1,000!\n");
                            wallet = wallet + 1000;
                            userYN = "";
                            while (!(userYN.equals("Y")) && !(userYN.equals("N"))) {
                                System.out.print("\nWould you like to but another? (Y) (N): ");
                                userYN = userInput.nextLine();
                                if (userYN.equals(goHome)) {
                                    playerMenuChoice = goHome;
                                    break;
                                }
                                if (!(userYN.equals("Y")) && !(userYN.equals("N"))) {
                                    System.out.print("\nCommand unrecognized.\n\n");
                                }
                            }
                            if (userYN.equals(goHome)) {
                                playerMenuChoice = goHome;
                                break;
                            }
                            if (userYN.equals("Y")) {
                                playerMenuChoice = "B";
                                System.out.print("\n\n\n");
                                break;
                            } else {
                                System.out.print("\n\n\n");
                                playerMenuChoice = "";
                            }
                        }
                    }
                }
            }
        }
    }
}

//Eh, nevermind.