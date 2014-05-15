package schiffer.morseCodeHashMap;

import java.util.HashMap;
import java.util.Map;

public class MorseCodeHashMap {
	private final Map<String, String> codeAndChar;

	public MorseCodeHashMap() {
		codeAndChar = new HashMap<String, String>();
		for (Alphabet a : Alphabet.values()) {
			codeAndChar.put(a.getCharValue(), a.getMorseValue());
			codeAndChar.put(a.getMorseValue(), a.getCharValue());
		}

	}

	public String toMorseCode(String plainText) {
		if (plainText == null) {
			return " ";
		} else {
			plainText = plainText.trim();
			StringBuilder stringbuilder = new StringBuilder();
			for (int i = 0; i < plainText.length(); i++) {
				stringbuilder.append(codeAndChar.get(Character.toString(plainText.charAt(i))));
				stringbuilder.append(" ");
			}
			return stringbuilder.toString();
		}
	}

	public String toPlainText(String morseCode) {
		if (morseCode == null) {
			return " ";
		} else {
			morseCode = morseCode.trim();
			StringBuilder stringbuilder = new StringBuilder();
			String[] code = morseCode.split(" ");
			for (int i = 0; i < code.length; i++) {
				stringbuilder.append(codeAndChar.get(code[i]));

			}
			return stringbuilder.toString();
		}
	}

}