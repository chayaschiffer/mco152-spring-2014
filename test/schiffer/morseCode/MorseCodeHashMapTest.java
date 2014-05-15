package schiffer.morseCode;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import schiffer.morseCodeHashMap.MorseCodeHashMap;

public class MorseCodeHashMapTest {

	@Test
	public void toMorseCode() {
		MorseCodeHashMap acode = new MorseCodeHashMap();
		String testingString = "abcd";
		assertEquals(acode.toMorseCode(testingString.toUpperCase()),
				".- -... -.-. -.. ");
	}

	@Test
	public void testToMCWithSpace() {
		MorseCodeHashMap acode = new MorseCodeHashMap();
		String testingString = "abc d";
		assertEquals(acode.toMorseCode(testingString.toUpperCase()),
				".- -... -.-. / -.. ");
	}

	@Test
	public void testToMCLowerCase() {
		MorseCodeHashMap acode = new MorseCodeHashMap();
		String testingString = "a";
		assertEquals(".- ",acode.toMorseCode(testingString.toUpperCase()));
	}

	@Test
	public void testToMCEmptyString() {
		MorseCodeHashMap acode = new MorseCodeHashMap();
		String testingString = "";
		Assert.assertEquals("", acode.toMorseCode(testingString));
	}
	@Test
	public void testToMCNullString(){
		MorseCodeHashMap acode = new MorseCodeHashMap();
		String testingString=null;
		Assert.assertEquals( " ",acode.toMorseCode(testingString));
	}

	@Test
	public void testToTextWithSpace() {
		MorseCodeHashMap morse = new MorseCodeHashMap();
		String code = ".- -... -.-. / -..";
		assertEquals("ABC D",morse.toPlainText(code));
	}

	@Test
	public void testToTextQuestionMark() {
		MorseCodeHashMap morse = new MorseCodeHashMap();
		String code = "..--..";
		assertEquals( "?",morse.toPlainText(code));
	}


	@Test
	public void testToTextEmptyString() {
		MorseCodeHashMap morse = new MorseCodeHashMap();
		String code = null;
		Assert.assertEquals(" ",morse.toPlainText(code));

	}

}
