/* Author: Parsa
 * Date: 10/3/16
 * This code processes a user input of numbers and determines the minimum/maximum numbers, the largest even number, and 
 * the sum of even numbers.
 */
import java.util.*; 

public class ProcessingNumbers { 
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("How many numbers do you want to use?");
		int nums = console.nextInt(); 
		System.out.println("What are the numbers? (do not include commas between numbers)");
		int nextNum = console.nextInt();
		int max = nextNum;
		int min = nextNum;
		int total;
		if (nextNum % 2 == 0) {
			total = nextNum;
		} else {
			total = 0;
		}
		int largestEven = -1;
		for (int terms = 0; terms < (nums - 1); terms++) {
			nextNum = console.nextInt();
			if (nextNum > max) {
				max = nextNum;
			} 
			if (nextNum < min) {
				min = nextNum;
			} 
			if (nextNum % 2 == 0) {
				total += nextNum;
				if (largestEven == -1) {
					largestEven = nextNum;
				} 
				if (nextNum > largestEven) {
					largestEven = nextNum;	
				}
			}
		}
		System.out.println("The smallest number is " + min);
		System.out.println("The largest number is " + max);
		System.out.println("The sum of even numbers is " + total);
		if (largestEven != -1) {
			System.out.println("The largest even number is " + largestEven); 
		} else {
			System.out.println("The largest even number does not exist");
		}
	}
}