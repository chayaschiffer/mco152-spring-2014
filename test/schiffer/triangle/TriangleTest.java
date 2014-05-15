package schiffer.triangle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TriangleTest {

	@Test
	public void testTriangleWithThreeRows() {
		Triangle atriangle = new Triangle(3);
		final String expected = "\n" + "  *\n" + " * *\n*****";
		assertEquals(expected, atriangle.toString());
	}

	@Test
	public void testTriangleToStringWithTwoRows() {
		Triangle atriangle = new Triangle(2);
		final String expected = "\n *\n" + "***";
		assertEquals(expected, atriangle.toString());
	}
}
