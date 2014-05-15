package schiffer.triangle;

public class Triangle {
	private int height;

	public Triangle(int height) {
		this.height = height;

	}

	@Override
	public String toString() {
		StringBuilder triangle = new StringBuilder();
		int numBlanks;
		char blank = ' ';
		int printBlanks;
		int blanks;
		int stars;
		
		for (int i = 0; i < height; i++) {
			triangle.append("\n");
			numBlanks = height - i;
			printBlanks =1;
			while (printBlanks < numBlanks) {
				triangle.append(blank);
				printBlanks++;
			}
			if (i < height - 1) {
				triangle.append("*");
				blanks = (2 * i) - 1;
				for (int j = 0; j < blanks; j++) {
					triangle.append(' ');
				}
				if (i != 0) {
					triangle.append("*");
				}
			}

			else {
				stars = (height * 2) - 1;
				for (int k = 0; k < stars; k++) {
					triangle.append("*");
				}
			}

		}
		return triangle.toString();
	}

	public static void main(String[] args) {
		System.out.println(new Triangle(3).toString());
	}
}
