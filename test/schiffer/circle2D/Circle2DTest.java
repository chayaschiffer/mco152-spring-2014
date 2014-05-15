package schiffer.circle2D;

import org.junit.Assert;
import org.junit.Test;

public class Circle2DTest {
	@Test
	public void testArea() {
		Circle2D acircle = new Circle2D(2, 3, 4);
		Assert.assertEquals(acircle.getArea(), 4 * 4 * Math.PI, 0);
	}

	@Test
	public void testPerimeter() {
		Circle2D acircle = new Circle2D(2, 3, 4);
		Assert.assertEquals(acircle.getPerimeter(), 4 * 2 * Math.PI, 0);

	}

	@Test
	public void testContains1() {
		Circle2D acircle = new Circle2D(3, 2, 10);
		Circle2D anotherCircle = new Circle2D(5, 2, 1);
		Assert.assertTrue(acircle.contains(anotherCircle));
	}

	@Test
	public void testOverlaps() {
		Circle2D acircle = new Circle2D(3, 2, 10);
		Circle2D anotherCircle = new Circle2D(5, 2, 1);
		Assert.assertTrue(acircle.overlaps(anotherCircle));
	}

	@Test
	public void testContains2() {
		Circle2D acircle = new Circle2D(3, 2, 10);
		Assert.assertTrue(acircle.contains(5, 2));
	}

}
