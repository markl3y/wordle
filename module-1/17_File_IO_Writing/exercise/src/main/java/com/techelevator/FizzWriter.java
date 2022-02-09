package com.techelevator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please enter a destination file:");
		String userInputString = userInput.nextLine();

		try(PrintWriter outputFile = new PrintWriter(userInputString)) {
			//If the number is divisible by 3, print Fizz.
			//If the number is divisible by 5, print Buzz.
			//If the number is divisible by 3 and 5, print FizzBuzz.
			//Otherwise, print the number.
			for (int i = 1; i < 301; i++) {
				if (i % 3 == 0 && i % 5 ==0) {
					outputFile.println("FizzBuzz");
				} else if (i % 3 == 0) {
					outputFile.println("Fizz");
				} else if (i % 5 == 0) {
					outputFile.println("Buzz");
				} else {
					outputFile.println(i);
				}
			}

		} catch (FileNotFoundException fnfe) {
			System.out.println("invalid destination file");
			System.exit(1);
		}
	}

}
