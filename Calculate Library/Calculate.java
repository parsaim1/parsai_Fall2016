
public class Calculate {
	public static int square(int number) {
		int answer = number * number;
		return answer;
	}
	
	public static int cube(int number) {
		int answer = number * number * number;
		return answer;
	}
	
	public static double average(double x, double y) {
		double answer = (x + y) / 2;
		return answer;
	}
	
	public static double average(double x, double y, double z) {
		double answer = (x + y + z) / 3;
		return answer;
	}
	
	public static double toDegrees(double radian) {
		double answer = radian * 57.2958;
		return answer;
	}
	
	public static double toRadians(double degrees) {
		double answer = degrees / 57.2958;
		return answer;
	}
	
	public static double discriminant(double x, double y, double z) {
		double answer = y * y - 4 * x * z;
		return answer;
	}
	
	public static String toImproperFrac(int x, int y, int z) {
		String answer = (x * z + y) + "/" + z;
		return answer;
	}
	
	public static String toMixedNum(int x, int y) {
		String answer = (x / y) + " " + (x % y) + "/" y;
		return answer;
	}
	 
	public static String foil(int w, int x, int y, int z, String n) {
		String answer = (w * y) + "n^2 + " + (w * z + x * y) + "n + " + (x * z);
		return answer;
	}
	
	public static int isDivisibleBy(int x, int y) {
		int answer = x % y;
		return answer;
	}
	
	public static double absValue(double x) {
		if (x >= 0) {
			double answer = x;
		} 
		else {
			double answer = (-1) * x;
		}
		return answer;
	}
		
	public static int max(int x, int y) {
		if (x >= y) {
			int answer = x;
		}
		else {
			int answer = y;
		}
		return answer;
	}
	
	public static double max(double x, double y, double z) {
		if (x >= y && y >= z) {
			double answer = x;
		}
		else {
			if (x >= z && z > y) {
				double answer = x;
			}
			else {
				if (y > x && x >= z) {
					double answer = y;
				}
				else {
					if (y >= z && z > x) {
						double answer = y;
					}
					else {
						double answer = z;
					}
				}
			}
		}
		return answer;
	}
	
	public static int min(int x, int y) {
		if (x <= y) {
			int answer = x;
		}
		else {
			int answer = y;
		}
		return answer;
	}
	
	public static double round2(double x) {
		double start = (x * 100) + .5;
		int start2 = (int) start;
		double answer = start2 / 100.0
		return answer;
	}
	
	public static double exponent(double base, int exp) {
		if (exp = 0) {
			for (int i = 1; i <= exp; i++)
		}
		
	
		
	}
		
}
