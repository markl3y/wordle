package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

    public static void main(String[] args) throws FileNotFoundException {

        //Step One: Collect user input and perform search
        Scanner userInput = new Scanner(System.in);
        boolean isFile;
        File aliceBook;
        do {
            System.out.println("What is the fully qualified name of the quiz file that should be searched?");
            String inputString = userInput.nextLine();
            aliceBook = new File(inputString);

            try (Scanner fileTest = new Scanner(aliceBook)) {
                isFile = true;
            } catch (FileNotFoundException fnfe) {
                System.out.println("The file was not found: " + aliceBook.getAbsolutePath());
                isFile = false;
            }
        } while (!isFile);

        Scanner fileFound = new Scanner(aliceBook);

        System.out.println("What is the search word you are looking for?");
        String wordSearch = userInput.nextLine();

        boolean escapeSequence = false;
        boolean isCaseSensitive = false;
        String YorN = "";
        while (!escapeSequence) {
            System.out.print("Should the search be case sensitive? (Y or N) ");
            YorN = userInput.nextLine();
            if (YorN.equals("Y")) {
                isCaseSensitive = true;
                escapeSequence = true;
            } else if (YorN.equals("N")) {
                escapeSequence = true;
            } else {
                System.out.println("Command unrecognized...");
            }
        }

        int lineCounter = 1;
        while (fileFound.hasNextLine()) {
            String lineOfText = fileFound.nextLine();
            if (isCaseSensitive) {
                if (lineOfText.contains(wordSearch)) {
                    System.out.println(lineCounter + ") " + lineOfText);
                }
            } else {
                String lineOfTextLower = lineOfText.toLowerCase();
                String wordSearchLower = wordSearch.toLowerCase();
                if (lineOfTextLower.contains(wordSearchLower)) {
                    System.out.println(lineCounter + ") " + lineOfText);
                }
            }
            lineCounter++;
        }
    }
}
