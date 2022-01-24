package com.techelevator;
import java.util.Scanner;

//Write a command-line program which prompts the user for an integer value and display the Fibonacci sequence leading up to that number.
//Ex.
//Please enter a number: 17
//
//0, 1, 1, 2, 3, 5, 8, 13

//If the input is a number that appears in the Fibonacci sequence, print the sequence up to and including that number:
//Ex.
//Please enter a number: 34
//
//0, 1, 1, 2, 3, 5, 8, 13, 21, 34

//Otherwise
public class Fibonacci {
	public static void main(String[] args) {
		boolean runCondition = true;
		Scanner userInput = new Scanner(System.in);
		double inputNumber = 0;
		while (runCondition) {
			System.out.print("\nEnter a number: ");
			String numInput = userInput.nextLine();
			inputNumber = Double.parseDouble(numInput);
			if (inputNumber == 0){
				System.out.print("0\n");
			} else {
				int sum1 = 0;
				int sum2 = 1;
				for (int i = 0; i <= inputNumber;) {
					if (i < inputNumber) {
						System.out.print(sum1 + ", ");
						int sum3 = sum2 + sum1;
						sum1 = sum2;
						sum2 = sum3;
						i = sum3;
					}
					if (i > inputNumber) {
						System.out.print(sum1);
						break;
					} else if (i == inputNumber) {
						System.out.format(sum1 + ", %.0f\n", inputNumber);
						break;
					}
				}
			}
			System.out.print("\nWould you like to quit? (Y) (N): ");
			String exitYN = userInput.nextLine();
			if (exitYN.equals("Y")) {
				runCondition = false;
			}
		}
	}
}

