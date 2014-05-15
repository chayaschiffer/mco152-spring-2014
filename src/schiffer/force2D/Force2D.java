package schiffer.force2D;

public class Force2D {
	private double x;
	private double y;

	public Force2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getMagnitude() {
		return Math.sqrt(x * x + y * y);
	}

	public double getAngle() {
		double radians = Math.atan2(y, x);
		return (radians * 180) / Math.PI;
	}

	public Force2D add(Force2D aforce) {
		return new Force2D(this.getX() + aforce.getX(), this.getY()
				+ aforce.getY());

	}

}
