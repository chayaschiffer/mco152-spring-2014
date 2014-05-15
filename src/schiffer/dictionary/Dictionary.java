package schiffer.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
	private ArrayList<String> listOfWords;

	public Dictionary() throws FileNotFoundException {
		String fileName = "./OWL.txt";
		listOfWords = new ArrayList<String>();
		readDataInFile(fileName);
	}

	public boolean exists(String aString) {
		String theWord = aString.trim().toUpperCase();
		return listOfWords.contains(theWord);
	}

	public void readDataInFile(String filename) throws FileNotFoundException {
		Scanner inputFile = new Scanner(new File(filename));

		while (inputFile.hasNextLine()) {
			String[] delims = inputFile.nextLine().split("\\s");
			String first = delims[0];
			listOfWords.add(first);
		}
		inputFile.close();

	}

}
