package schiffer.dictionaryHashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Test;

public class DictionaryHashMapTest {

	@Test
	public void testConstructor() throws FileNotFoundException {
		new DictionaryHashMap();
	}

	@Test
	public void existsAA() throws FileNotFoundException {
		DictionaryHashMap adic = new DictionaryHashMap();
		assertTrue(adic.exists("AA"));

	}

	@Test
	public void existsEmptyString() throws FileNotFoundException {
		DictionaryHashMap adic = new DictionaryHashMap();
		assertFalse(adic.exists(" "));
	}

}
