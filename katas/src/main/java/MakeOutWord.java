import java.util.*;

//Exercise 52: MakeOutWord (new for V4)
//Create a string method called MakeOutWord that takes in two strings, “outword” and “word”.
//Given an "outword" string length 4, such as "<<>>", and a word, return a new string where the
//word is in the middle of the outword string, e.g. "<<word>>".
//makeOutWord("<<>>", "Yay") → "<<Yay>>"
//makeOutWord("<<>>", "WooHoo") → "<<WooHoo>>"
//makeOutWord("[[]]", "word") → "[[word]]"

public class MakeOutWord {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        boolean runCondition = false;
        String word1;
        do {
            do {
                promptUser1();
                word1 = userInput.nextLine();
                if (word1.length() != 4) {
                    System.out.print("\nThis is not a four letter word.\n");
                }
            } while (word1.length() != 4);
            promptUser2();
            String word2 = userInput.nextLine();
            String makeOutWord = makeOutWord(word1, word2);
            System.out.println("\nYour new word is: " + makeOutWord + ".");
            System.out.print("\nWould you like to go again? ");
            runCondition = checkYesNo();
        } while (runCondition);
    }

    static void promptUser1() {
        System.out.print("\nPlease enter a four letter word: ");
    }

    static void promptUser2() {
        System.out.print("\nPlease enter another word of any length: ");
    }

    static String makeOutWord(String word1, String word2) {
        char[] charArrayWord1 = new char[4];
        for (int i = 0; i < charArrayWord1.length; i++) {
            charArrayWord1[i] = word1.charAt(i);
        }
        //String returnString = Character.toString(charArrayWord1[0]) + Character.toString(charArrayWord1[1]) + word2 + charArrayWord1[2] + charArrayWord1[3];
        String returnString = "" + charArrayWord1[0] + charArrayWord1[1] + word2 + charArrayWord1[2] + charArrayWord1[3];
        return returnString;
    }

    static boolean checkYesNo() {
        Scanner userInput = new Scanner(System.in);
        String yorN = "";
        do {
            System.out.print("(Y)es or (N)o? : ");
            yorN = userInput.next();
            if (!yorN.equals("Y") && !yorN.equals("N")) {
                System.out.print("\nUnrecognized input.\n\n");
            }
        } while (!yorN.equals("Y") && !yorN.equals("N"));
        return yorN.equals("Y");
    }
}

