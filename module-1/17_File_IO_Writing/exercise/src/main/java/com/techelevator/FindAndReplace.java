package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {
//
//        Scanner userInput = new Scanner(System.in);
//
//        System.out.println("What is the search word?");
//        String findWord = userInput.nextLine();
//
//        System.out.println("What is the replacement word?");
//        String replaceWord = userInput.nextLine();
//
//        boolean isFile;
//        File sourceFile = null;
//        do {
//            System.out.println("What is the source file?");
//            String inputString = userInput.nextLine();
//
//            sourceFile = new File(inputString);
//
//            try (Scanner fileTestScanner = new Scanner(sourceFile)) {
//                isFile = true;
//            } catch (FileNotFoundException fnfe) {
//                System.out.println("The file was not found: " + sourceFile.getAbsolutePath());
//                isFile = false;
//            }
//
//        } while (!isFile);
//
//        Scanner inputFileFound = null;
//
//        try {
//            inputFileFound = new Scanner(sourceFile);
//        } catch (FileNotFoundException ignored) {
//        }
//
//        isFile = false;
//        String inputString;
//        do {
//            System.out.println("What is the destination file?");
//            inputString = userInput.nextLine();
//            try (PrintWriter outputFile = new PrintWriter(inputString)) {
//                isFile = true;
//            } catch (FileNotFoundException fnfe) {
//                System.out.println("The destination file was not found....");
//            }
//        } while (!isFile);
//
//        PrintWriter outputFile = null;
//
//        try {
//            outputFile = new PrintWriter(inputString);
//        } catch (FileNotFoundException ignored) {
//        }
//
//        List<String> extractedLines = new ArrayList<>();
//        while(inputFileFound.hasNextLine()) {
//            String lineInSource = inputFileFound.nextLine();
//            String lineToWrite;
//            if (lineInSource.contains(findWord)) {
//                String[] partialLine = lineInSource.split(findWord);
//                lineToWrite = partialLine[0] + replaceWord + partialLine[1];
//            } else {
//                lineToWrite = lineInSource;
//            }
//            extractedLines.add(lineToWrite);
//        }
//
//        for(String line : extractedLines) {
//            outputFile.println(line);
//        }
//    }
        Scanner userInput = new Scanner(System.in);

        System.out.println("What is the search word?");
        String findWord = userInput.nextLine();

        System.out.println("What is the replacement word?");
        String replaceWord = userInput.nextLine();

        System.out.println("What is the input file?");
        String inputFileString = userInput.nextLine();

        System.out.println("What is the destination file?");
        String destinationFileString = userInput.nextLine();

        try (Scanner inputFile = new Scanner(new File(inputFileString));
             PrintWriter outputFile = new PrintWriter(destinationFileString)) {
            List<String> inputLines = new ArrayList<>();
            while (inputFile.hasNextLine()) {
                String inputLine = inputFile.nextLine();
                if (inputLine.contains(findWord)) {
                    inputLine = inputLine.replaceAll(findWord, replaceWord);
                }
                inputLines.add(inputLine);
            }
            for (String line : inputLines) {
                outputFile.println(line);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found...");
        }
    }
}