package schiffer.force2D;

import org.junit.Assert;
import org.junit.Test;

public class Force2DTest {
	@Test
	public void testGetMagnitude() {
		Force2D force = new Force2D(1, 2);
		Assert.assertEquals(Math.sqrt(1 * 1 + 2 * 2), force.getMagnitude(), 0);

	}

	@Test
	public void testGetAngle() {
		Force2D force = new Force2D(1, 2);
		Assert.assertEquals(force.getAngle(), Math.atan2(2, 1) * 180 / Math.PI,
				.01);
	}

	@Test
	public void testAdd() throws Exception {
		Force2D aforce = new Force2D(2, 3);
		Force2D anotherForce = new Force2D(3, 4);
		Force2D combinedForce = new Force2D(5, 7);
		Assert.assertEquals(combinedForce, aforce.add(anotherForce));
	}

}
