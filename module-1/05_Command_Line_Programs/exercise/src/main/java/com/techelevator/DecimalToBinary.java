package com.techelevator;
import java.util.Scanner;

//Please enter a series of decimal values (separated by spaces): 460 8218 1 31313 987654321
//
//460 in binary is 111001100
//8218 in binary is 10000000011010
//1 in binary is 1
//31313 in binary is 111101001010001
//987654321 in binary is 111010110111100110100010110001

//I'm exhausted after that last exercise, so this is going to do exactly what you asked for.

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter a series of decimal values (separated by spaces): ");
		String userNumbers = userInput.nextLine();
		String[] userNumArray = userNumbers.split(" ");
		Integer[] convNumArray = new Integer[userNumArray.length];
		String[] binNumArray = new String[convNumArray.length];
		System.out.print("\n");
		for (int i = 0; i < userNumArray.length; i++) {
			convNumArray[i] = Integer.parseInt(userNumArray[i]);
			binNumArray[i] = Integer.toBinaryString(convNumArray[i]);
			System.out.print(convNumArray[i] + " in binary is " + binNumArray[i] + "\n");
		}
	}
}
