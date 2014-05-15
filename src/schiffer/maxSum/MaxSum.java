package schiffer.maxSum;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MaxSum {
	public static void main(String[] args) {
		int[][] numbersArray;
		int sizeOfArray;

		Scanner inputFile;
		try {
			inputFile = new Scanner(new File("./numbers.txt"));
			sizeOfArray = inputFile.nextInt();
			numbersArray = new int[sizeOfArray][sizeOfArray];
			while (inputFile.hasNext()) {
				for (int i = 0; i < sizeOfArray; i++) {
					for (int j = 0; j < sizeOfArray; j++) {
						numbersArray[i][j] = inputFile.nextInt();

					}
				}
			}

			int max = getMaxSum(numbersArray, sizeOfArray);
			System.out.println("Max Sum: " + max);

		} catch (IOException e) {
			System.out.println("File not found");
		}
	}

	public static int getMaxSum(int[][] integers, int size) {
		int maxSum = Integer.MIN_VALUE;
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				for (int rowEnd = 0; rowEnd < size; rowEnd++) {
					for (int columnEnd = 0; columnEnd < size; columnEnd++) {
						int sum = 0;
						for (int thisRow = row; thisRow <= rowEnd; thisRow++) {
							for (int thisColumn = column; thisColumn <= columnEnd; thisColumn++) {
								sum += integers[thisRow][thisColumn];
							}
						}
						if (sum > maxSum) {
							maxSum = sum;
						}
					}
				}
			}
		}
		return maxSum;
	}

}