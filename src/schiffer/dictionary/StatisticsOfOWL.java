package schiffer.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class StatisticsOfOWL {
	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>();
		String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
				"W", "X", "Y", "Z" };

		Scanner inputFile;
		try {
			inputFile = new Scanner(new File("./OWL.txt"));
			while (inputFile.hasNextLine()) {
				String[] delims = inputFile.nextLine().split("\\s");
				String first = delims[0];
				words.add(first);
			}
			inputFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found exception");
		}

		int[] numTimesUseLetterInWord = new int[26];
		int[] numTimesLetterInWordList = new int[26];
		int[] countLetterMoreThanOnce = new int[26];
		double[] percentLetterUsedInWordMoreThanOnce = new double[26];

		for (int q = 0; q < alphabet.length; q++) {
			for (int i = 0; i < words.size(); i++) {
				for (int j = 0; j < words.get(i).length(); j++) {
					String achar = words.get(i).substring(j, j + 1);

					if (alphabet[q].compareTo(achar) == 0) {
						numTimesUseLetterInWord[q]++;// adds one to
						// the
						// times this
						// letter is
						// used
						// in list at
						// letter's position
						// in array
					}

				}
				if (numTimesUseLetterInWord[q] > 0) {
					numTimesLetterInWordList[q] += numTimesUseLetterInWord[q];
					countLetterMoreThanOnce[q]++;
				}
				for (int f = 0; f < numTimesUseLetterInWord.length; f++) {
					numTimesUseLetterInWord[f] = 0;
				}
			}
		}
		for (int i = 0; i < countLetterMoreThanOnce.length; i++) {
			if (countLetterMoreThanOnce[i] > 0) {
				double wordsMultHundred = countLetterMoreThanOnce[i] * 100;
				double wordslength = words.size();
				percentLetterUsedInWordMoreThanOnce[i] = wordsMultHundred
						/ wordslength;
			}
		}

		DecimalFormat formatter = new DecimalFormat("0.00");
		for (int a = 0; a < alphabet.length; a++) {
			System.out.println(alphabet[a] + " " + numTimesLetterInWordList[a]
					+ " "
					+ formatter.format(percentLetterUsedInWordMoreThanOnce[a])
					+ "%");
		}
	}
}
