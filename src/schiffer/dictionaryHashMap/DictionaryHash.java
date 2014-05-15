package schiffer.dictionaryHashMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DictionaryHash {
	private Set<String> set;

	public DictionaryHash() throws FileNotFoundException {
		String fileName = "./OWL.txt";
		set = new HashSet<String>();
		readDataInFile(fileName);
	}

	public boolean exists(String aString) {
		String theWord = aString.trim().toUpperCase();
		return set.contains(theWord);
	}

	public void readDataInFile(String filename) throws FileNotFoundException {
		Scanner inputFile = new Scanner(new File(filename));

		while (inputFile.hasNextLine()) {
			String[] delims = inputFile.nextLine().split("\\s");
			String first = delims[0];
			set.add(first);
		}
		inputFile.close();

	}

}
