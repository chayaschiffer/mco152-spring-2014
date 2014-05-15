package schiffer.morseCode;

public class MorseCode {
	public String toMorseCode(String plainText) {
		if (plainText == null) {
			return " ";
		}
		String trimmedPlainText = plainText.trim();
		StringBuilder morseText = new StringBuilder();
		for (int i = 0; i < trimmedPlainText.length(); i++) {
			if ("".equals(plainText)) {
				return "";
			} else {
				char thisChar = plainText.charAt(i);
				for (Alphabet a : Alphabet.values()) {
					if (thisChar == (a.getCharValue())) {
						morseText.append(a.getMorseValue());
						morseText.append(" ");
						break;
					}

				}
			}
		}
		return morseText.toString().trim();
	}

	public String toPlainText(String morseCode) {
		StringBuilder plainText = new StringBuilder();
		String trimmedMorseCode = morseCode.trim();
		if ("".equals(trimmedMorseCode)) {
			return "";
		} else {
			String[] morseCodedCharacters = new String[trimmedMorseCode
					.length()];// change
			// the
			// size
			int numMorseLetters = 0;

			int[] indexes = new int[morseCode.length()];// index of where
														// there's a
														// space, indicating the
														// end
														// of code of one
														// character
			int numSpaces = 0;
			int space = 0;
			for (int q = 0; q < trimmedMorseCode.length(); q++) {
				if (trimmedMorseCode.charAt(q) == ' ') {
					space++;
				}
			}
			if (space == 0) {
				numMorseLetters = 1;
				morseCodedCharacters[space] = trimmedMorseCode;
			} else {
				for (int i = 0; i < trimmedMorseCode.length(); i++) {
					if (trimmedMorseCode.charAt(i) == ' ') {
						indexes[numSpaces++] = i;
					}
				}
				morseCodedCharacters[numMorseLetters++] = trimmedMorseCode
						.substring(0, indexes[0]);
				for (int j = 0; j < numSpaces - 1; j++) {
					morseCodedCharacters[numMorseLetters++] = trimmedMorseCode
							.substring(indexes[j] + 1, indexes[j + 1]);// skip
																		// the
																		// space
				}
				morseCodedCharacters[numMorseLetters++] = trimmedMorseCode
						.substring(indexes[numSpaces - 1] + 1);// substring
																// starting
																// from the last
																// space
																// until the end
				// of the string
			}
			for (int k = 0; k < numMorseLetters; k++) {
				if (morseCodedCharacters[k] != null) {
					for (Alphabet b : Alphabet.values()) {
						morseCodedCharacters[k].trim();
						if (morseCodedCharacters[k].equals(b.getMorseValue())) {
							plainText.append(b.getCharValue());
							break;
						}
					}
				}
			}

		}
		return plainText.toString();

	}

}
