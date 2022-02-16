package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingCheckpoint {

	public static void main(String[] args) {
		List<HotelReservation> reservationList = new ArrayList<>();
		try {
			Scanner fileInput = new Scanner(new File ("data-files\\HotelInput.csv"));
			String inputLine;

			while (fileInput.hasNextLine()) {
				inputLine = fileInput.nextLine();
				inputLine = inputLine.replaceAll(" ", "");
				String[] parsedLine = inputLine.split(",");
				int convertedNumberOfNights = Integer.parseInt(parsedLine[1]);
				HotelReservation hotelReservation = new HotelReservation(parsedLine[0], convertedNumberOfNights);
				reservationList.add(hotelReservation);
			}

		} catch (FileNotFoundException e) {
			System.out.println("Input file not found.");
		}

		BigDecimal allReservationEstimatedTotals = new BigDecimal("0");

		for (HotelReservation hotelReservation : reservationList) {
			allReservationEstimatedTotals = allReservationEstimatedTotals.add(hotelReservation.getEstimatedTotal());
		}

		System.out.print(NumberFormat.getCurrencyInstance().format(allReservationEstimatedTotals));
	}
}
