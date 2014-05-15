package schiffer.morseCodeHashMap;

public enum Alphabet {

		A("A", ".-"), B("B", "-..."), C("C", "-.-."), D("D", "-.."), E("E", "."), F(
				"F", "..-."), G("G", "--."), H("H", "...."), I("I", ".."), J("J",
				".---"), K("K", "-.-"), L("L", ".-.."), M("M", "--"), N("N", "-."), O(
				"O", "---"), P("P", ".--."), Q("Q", "--.-"), R("R", ".-."), S("S",
				"..."), T("T", "-"), U("U", "..-"), V("V", "...-"), W("W", ".--"), X(
				"X", "-..-"), Y("Y", "-.--"), Z("Z", "--.."), SPACE(" ", "/"), ZERO(
				"0", "-----"), ONE("1", ".----"), TWO("2", "..---"), THREE("3",
				"...--"), FOUR("4", "....-"), FIVE("5", "....."), SIX("6", "-...."), SEVEN(
				"7", "--..."), EIGHT("8", "---.."), NINE("9", "----."), PERIOD(".",
				".-.-.-"), COMMA(",", "--..--"), QUERY("?", "..--.."), EQUALS("=",
				"-...-");

		private final String characterValue;
		private final String morseValue;

		private Alphabet(String charValue, String morseValue) {
			this.characterValue = charValue;
			this.morseValue = morseValue;
		}

		public String getCharValue() {
			return characterValue;
		}

		public String getMorseValue() {
			return morseValue;
		}
	}

