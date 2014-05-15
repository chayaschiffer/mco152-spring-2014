package schiffer.pi;

public class CalculatePi {

	public static double calculate() {
		double pi = 0;
		for (int i = 1; i < 1000000000; i++) {
			double pow = Math.pow(-1, i + 1);
			pi += 4 * (pow) / (2 * i - 1);
		}
	return pi;
	}
}

//this program executes in one thread
//