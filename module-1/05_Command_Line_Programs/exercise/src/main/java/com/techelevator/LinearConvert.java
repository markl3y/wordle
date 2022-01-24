package com.techelevator;
import java.util.Scanner;
// Write a command-line program which prompts a user to enter a length, and whether the measurement is in (m)eters or (f)eet.
// Convert the length to the opposite measurement, and display the old and new measurements to the console.
// Ex.
// Please enter the length: 58
// Is the measurement in (m)eter, or (f)eet? f
// 58f is 17m.

public class LinearConvert {
	public static void main(String[] args) {
		boolean runCondition = true;
		Scanner userInput = new Scanner(System.in);
		double oldVal = 0.0;
		double newVal = 0.0;
		String newMeasure;
		while (runCondition) {
			System.out.print("Please enter the length: ");
			String inputLength = userInput.nextLine();
			oldVal = Double.parseDouble(inputLength);
			System.out.print("Is the measurement in (m)eter, or (f)eet? ");
			String oldMeasure = userInput.nextLine();
			if (oldMeasure.equals("m")) {
				newVal = oldVal * 3.2808399;
				newMeasure = "f";
			} else {
				newVal = oldVal * 0.3048;
				newMeasure = "m";
			}
			System.out.format("%.0f" + oldMeasure + " is " + "%.0f" + newMeasure + ".%n", oldVal, newVal);
			System.out.print("Run again? (Y) (N): ");
			String reply = userInput.nextLine();
			if (reply.equals("N")) {
				runCondition = false;
			}
		}
	}
}
