package schiffer.dictionaryHashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Test;

public class DictionaryHashTest {

	@Test
	public void testConstructor() throws FileNotFoundException {
		new DictionaryHash();
	}

	@Test
	public void existsAA() throws FileNotFoundException {
		DictionaryHash adic = new DictionaryHash();
		assertTrue(adic.exists("AA"));

	}

	@Test
	public void existsEmptyString() throws FileNotFoundException {
		DictionaryHash adic = new DictionaryHash();
		assertFalse(adic.exists(" "));
	}

}
