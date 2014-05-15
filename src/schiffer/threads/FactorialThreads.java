package schiffer.threads;

public class FactorialThreads {
	public static void main(String[] args){
		Thread t1 = new Factorial(4);
		Thread t2 = new Factorial(100);
		
		t1.start();
		t2.start();
		
	}
}
