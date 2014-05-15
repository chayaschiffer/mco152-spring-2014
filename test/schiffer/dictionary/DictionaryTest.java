package schiffer.dictionary;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Test;

public class DictionaryTest {

	@Test
	public void testConstructor() throws FileNotFoundException {
		new Dictionary();
	}

	@Test
	public void existsAA() throws FileNotFoundException {
		Dictionary adic = new Dictionary();
		assertTrue(adic.exists("AA"));

	}

	@Test
	public void existsEmptyString() throws FileNotFoundException {
		Dictionary adic = new Dictionary();
		assertFalse(adic.exists(" "));
	}

}
