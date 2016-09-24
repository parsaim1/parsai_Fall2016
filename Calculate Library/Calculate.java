
/* author: Parsa
 * Date: 9/24/16
 * This code contains methods that calculate different mathematical functions
 */
public class Calculate {
	public static int square(int number) {
		int answer = number * number;
		return answer;
	}
	
	public static int cube(int number) {
		int answer = number * number * number;
		return answer;
	}
	
	public static double average(double numb1, double numb2) {
		double answer = (numb1 + numb2) / 2;
		return answer;
	}
	
	public static double average(double numb1, double numb2, double numb3) {
		double answer = (numb1 + numb2 + numb3) / 3;
		return answer;
	}
	
	public static double toDegrees(double radian) {
		double answer = radian * 180 / 3.14159;
		return answer;
	}
	
	public static double toRadians(double degrees) {
		double answer = degrees / 180 * 3.14159;
		return answer;
	}
	
	public static double discriminant(double a, double b, double c) {
		double answer = b * b - 4 * a * c;
		return answer;
	}
	
	public static String toImproperFrac(int wholeNumb, int numerator, int denominator) {
		String answer = (wholeNumb * denominator + numerator) + "/" + denominator;
		return answer;
	}
	
	public static String toMixedNum(int numerator, int denominator) {
		String answer = (numerator / denominator) + " " + (numerator % denominator) + "/" + denominator;
		return answer;
	}
	 
	public static String foil(int coeff1, int constant1, int coeff2, int constant2, String n) {
		String answer = (coeff1 * coeff2) + n + "^2 + " + (coeff1 * constant2 + constant1 * coeff2) + n + " + " + (constant1 * constant2);
		return answer;
	}
	
	public static boolean isDivisibleBy(int dividend, int divisor) {
		if (divisor == 0) {
			throw new IllegalArgumentException("Dividing a number by zero is undefined.");
		} else if (dividend % divisor == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static double absValue(double value) {
		if (value >= 0) {
			return value;
		} 
		else {
			double answer = (-1) * value;
			return answer;
		}
	}
		
	public static int max(int numb1, int numb2) {
		if (numb1 >= numb2) {
			return numb1;
		}
		else {
			return numb2;
		}
	}
	
	public static double max(double numb1, double numb2, double numb3) {
		if (numb1 >= numb2 && numb1 >= numb3) {
			return numb1;
		}
		else if (numb2 >= numb1 && numb2 >= numb3) {
			return numb2;
		}
		else {
			return numb3;
		}
	}
	
	public static int min(int numb1, int numb2) {
		if (numb1 <= numb2) {
			return numb1;
		}
		else {
			return numb2;
		}
	}
	
	public static double round2(double original) {
		double step1;
		if (original >= 0) {
			step1 = (original * 100) + .5;
		} else {
			step1 = (original * 100) - .5;
		}
		int step2 = (int) step1;
		double answer = step2 / 100.0;
		return answer;
	}
	
	public static double exponent(double base, int exponent) {
		if (exponent > 0) {
			double growingNumb = 1.0;
			for (int i = 1; i <= exponent; i++) {
				growingNumb = growingNumb * base;  
			}
			return growingNumb;
		} else if (exponent == 0) {
			return 1;
		} else {
			throw new IllegalArgumentException("The exponent is negative.");
		}
	}
	
	public static int factorial(int numb) {
		if (numb > 0) {
			int growingNumb = 1;
			for (int j = 1; j < numb; j++) {
				int oneMore = (j + 1);
				growingNumb = growingNumb * oneMore;
			}
			return growingNumb;
		} if (numb == 0) {
			return 1;
		} else {
			throw new IllegalArgumentException("The original value is negative.");
		}
	}
	
	public static boolean isPrime(int value) {
		for (int j = 2; j <= value / 2; j++) {
				if (Calculate.isDivisibleBy(value, j) == true) {
					return false;
				}
		}
		if (value <= 1) {
			return false;
		} else {
			return true;
		}
	}
	
	public static int gcf(int value1, int value2) {
		while (value1 != 0 && value2 != 0) {
			int testNumb = value2;
			value2 = value1 % value2;
			value1 = testNumb;
		}
		return (int) Calculate.absValue((value1 + value2));
	}
	
	public static double sqrt(double value) {
		if (value < 0) {
			throw new IllegalArgumentException("The square root of a negative number will be imaginary.");
		}
		if (value == 0) {
			return 0;
		}
		double answer = value / 2;
		double i;
		do {
			i = answer;
			answer = (answer + value / answer) / 2;
		} while (i - answer != 0);
		return Calculate.round2(answer);
	}
	
	public static String quadForm(int a, int b, int c) {
		double discrim = Calculate.discriminant(a, b, c);
		if (discrim < 0) {
			return ("no real roots");
		}
		double answer1 = Calculate.round2((-b + Calculate.sqrt(discrim)) / (2 * a));
		double answer2 = Calculate.round2((-b - Calculate.sqrt(discrim)) / (2 * a));
		if (answer1 == answer2) {
			return (answer1 + "");
		}
		if (answer1 > answer2) {
			return (answer2 + " and " + answer1);
		} else {
			return (answer1 + " and " + answer2);
		}
	}
}


