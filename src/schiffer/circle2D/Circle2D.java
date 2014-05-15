package schiffer.circle2D;

public class Circle2D {
	private double x;
	private double y;
	private double radius;

	public Circle2D() {
		x = 0;
		y = 0;
		radius = 1;
	}

	public Circle2D(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getRadius() {
		return radius;
	}

	public double getArea() {
		return radius * radius * Math.PI;
	}

	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}

	public boolean contains(double x, double y) {
		return Math.sqrt((this.getX() - x) * (this.getX() - x)
				+ (this.getY() - y) * (this.getY() - y)) < this.getRadius();

	}

	public boolean contains(Circle2D circle) {
		return Math.sqrt((this.getX() - circle.getX())
				* (this.getX() - circle.getX()) + (this.getY() - circle.getY())
				* (this.getY() - circle.getY()))
				+ circle.getRadius() < this.getRadius();
	}

	public boolean overlaps(Circle2D circle) {
		return Math.sqrt((this.getX() - circle.getX())
				* (this.getX() - circle.getX()) + (this.getY() - circle.getY())
				* (this.getY() - circle.getY())) < this.getRadius()
				+ circle.getRadius();

	}

}
