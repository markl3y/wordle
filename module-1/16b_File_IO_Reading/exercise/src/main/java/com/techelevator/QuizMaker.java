package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuizMaker {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner userInput = new Scanner(System.in);
		boolean isFile;
		File quizQuestions;
		do {
			System.out.println("What is the fully qualified name of the quiz file?");
			String inputString = userInput.nextLine();
			quizQuestions = new File(inputString);

			try (Scanner fileTest = new Scanner(quizQuestions)) {
				isFile = true;
			} catch (FileNotFoundException fnfe) {
				System.out.println("The file was not found: " + quizQuestions.getAbsolutePath() + "\n");
				isFile = false;
			}
		} while (!isFile);
		System.out.println("File found: " + quizQuestions.getAbsolutePath() + "\n");
		Scanner fileFound = new Scanner(quizQuestions);

		int quizScore = 0;
		while (fileFound.hasNextLine()) {
			String quizLine = fileFound.nextLine();
			String rightAnswer = "";
			String[] parsedLine = quizLine.split("&");
			for (String answer : parsedLine) {
				if (answer.contains("*")) {
					rightAnswer = answer;
				}
			}
			rightAnswer = rightAnswer.substring(0, rightAnswer.length() - 1);
			System.out.println(parsedLine[0]);
			for (int i = 1; i < parsedLine.length; i++) {
				if (parsedLine[i].contains("*")) {
					System.out.println(i + ".) " + parsedLine[i].substring(0, parsedLine[i].length()-1));
				} else {
					System.out.println(i + ".) " + parsedLine[i]);
				}
			}
			int choice = 0;
			boolean isNumberChoice;
			do {
				System.out.println("\nPlease enter your choice: ");
				String questionChoice = userInput.nextLine();
				if (Integer.parseInt(questionChoice) == 1 || Integer.parseInt(questionChoice) == 2 || Integer.parseInt(questionChoice) == 3 || Integer.parseInt(questionChoice) == 4) {
					choice = Integer.parseInt(questionChoice);
					isNumberChoice = true;
				} else {
					System.out.println("Command unrecognized...\n");
					isNumberChoice = false;
				}
			} while (!isNumberChoice);

			if (parsedLine[choice].substring(0, parsedLine[choice].length()-1).equals(rightAnswer)) {
				quizScore++;
				System.out.println("Correct! Your score is now: " + quizScore + "\n");
			} else {
				System.out.println("Wrong! Your score is: " + quizScore + "\n");
			}
		}
		System.out.println("That's the end of the test! Your score is " + quizScore);
	}

}
