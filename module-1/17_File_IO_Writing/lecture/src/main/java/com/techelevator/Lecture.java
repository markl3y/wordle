package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {
		File file = new File("unsorted.txt");
		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

//		File tempDir = new File("temp");
//		if (!tempDir.exists()) {
//			Files.createDirectory(tempDir.toPath());
//		} else {
//			System.out.println("temp folder already exists");
//		}

		try (Scanner inputFile = new Scanner(new File("unsorted.txt"));
		PrintWriter outputFile = new PrintWriter("sorted.txt")){
//			while(inputFile.hasNextLine()) {
//				outputFile.println(inputFile.nextLine());
//			}
			List<String> inputLines = new ArrayList<>();
			while (inputFile.hasNextLine()) {
				String inputLine = inputFile.nextLine();
			}

			Collections.sort(inputLines);

			for (String line : inputLines) {
				outputFile.println(line);
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found...");
		}
	}

}
