
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
		double answer = (x + y + z) / 2;
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
	
	public static int toImproperFrac(int x, int y, int z) {
		String answer = (x + y * z) + "/" + z;
		return answer;
	}
	
	public static int toMixedNum(int x, int y) {
		String answer = (x / y) + " " + (x % y) + "/" y;
		return answer;
	}
	 
	public static int foil(int w, int x, int y, int z, String "v") {
		String answer = (w * y) + "n^2 +" + (w * z + x * y) + "n +" + (x * z);
		return answer;
	}
}
