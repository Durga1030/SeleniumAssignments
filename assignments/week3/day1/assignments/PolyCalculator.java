package week3.day1.assignments;

public class PolyCalculator {

	public static void main(String[] args) {
		System.out.println("Polymorphism using calculator");

		PolyCalculator calc = new PolyCalculator();
		System.out.println("--- Inside Main Method ---");

		calc.addition(10, 20);
		calc.addition(10, 20, 30);
		calc.multiply(5, 3);
		calc.multiply(20, 25.5);
		calc.subtract(20, 60);
		calc.subtract(123, 23.5);
		calc.divide(12, 2468);
		calc.divide(2.5, 1.5);
	}

	public void addition(int add1, int add2) {

		int addition = add1 + add2;

		System.out.println("Addition int #1: " + addition);
	}

	public void addition(int addA, int addB, int addC) {

		int addc = addA + addB + addC;
		System.out.println("Addition int #2: " + addc);
	}

	public void multiply(int mul1, int mul2) {

		int multiply = mul1 * mul2;
		System.out.println("Multiplication int : " + multiply);
	}

	public void multiply(int mulA, double mulB) {

		double mulc = mulA * mulB;
		System.out.println("Multiplication double : " + mulc);
	}

	public void subtract(int sub1, int sub2) {
		if (sub1 > sub2) {
			int subtract = sub1 - sub2;
			System.out.println("Subtraction int : " + subtract);
		} else {
			int subtract = sub2 - sub1;
			System.out.println("Subtraction int : " + subtract);
		}
	}

	public void subtract(double subA, double subB) {
		if (subA > subB) {
			double subc = subA - subB;
			System.out.println("Subtraction double : " + subc);
		} else {
			double subc = subB - subA;
			System.out.println("Subtraction double : " + subc);

		}
	}

	public void divide(int div1, int div2) {
		int division = div1 / div2;
		System.out.println("Division int : " + division);
	}

	public void divide(double divA, double divB) {
		double divc = divA / divB;
		System.out.println("Division double : " + divc);
	}

}
