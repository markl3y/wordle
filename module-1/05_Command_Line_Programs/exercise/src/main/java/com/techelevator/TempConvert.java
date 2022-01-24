package com.techelevator;

import java.util.Scanner;

/*
Write a command-line program which prompts a user to enter a temperature, and whether it's in degrees (C)elsius or
(F)ahrenheit. Convert the temperature to the opposite degrees, and display the old and new temperatures to the console.
Ex. Output:
Please enter the temperature: 58
Is the temperature in (C)elsius, or (F)ahrenheit? F
58F is 14C.
 */
public class TempConvert {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);                                        //Declare a new scanner called user input.
        System.out.print("Please enter the temperature: ");                                // Ask the user for the temperature.
        String inputTemp = userInput.nextLine();                                           // Create a new string to store the users input.
        double dblTemp = Double.parseDouble(inputTemp);                                    // Convert that input into a double.
        System.out.print("Is the temperature in (C)elcius, or (F)ahrenheit? ");            // Now, ask the user what scale the temperature is in.
        String strScale = userInput.nextLine();                                            // Create a new scale string to store the users input.
        String newScale = "";                                                              // Initialize a string to hold the opposite scale.
        double dblConvertedTemp = 0.0;                                                     // Initialize a double variable to store a converted temperature.
        if (strScale.equals("F")) {                                                        // If the user's input scale is equal to F...
            dblConvertedTemp = (dblTemp - 32) / 1.8;                                       // Then store the converted Celsius into converted temperature double.
            newScale = "C";
        } else if (strScale.equals("C")) {                                                 // Otherwise, store the converted Fahrenheit into the converted temperature double.
            dblConvertedTemp = (dblTemp * 1.8) + 32;                                       // ...
            newScale = "F";
        } else                                                                             // Simple error handler because why not.
        {
            System.out.println("Unexpected input! Please rerun program!");
        }
        System.out.format("%.0f" + strScale + " is " + "%.0f" + newScale + ".", dblTemp, dblConvertedTemp); // Print out results.
    }
}
