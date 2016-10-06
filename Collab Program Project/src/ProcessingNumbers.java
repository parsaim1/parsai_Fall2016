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
		System.out.println("What are the numbers? (do not include commas between numbers)"); //If the user enters commas, the tokens will include commas as oppose to only integers.
		int nextNum = console.nextInt();
		int max = nextNum; //Zero can't be used to initialize the max or min because if the user inputed only negative integers, then the output would not be accurate. 
		int min = nextNum;
		int total;
		if (nextNum % 2 == 0) {
			total = nextNum;
		} else {
			total = 0;
		}
		int largestEven = -1;
		for (int terms = 0; terms < (nums - 1); terms++) { //Terms has to be less than nums minus one because the program already took the first integer input when initializing the min, max, and total.
			nextNum = console.nextInt();
			if (nextNum > max) {
				max = nextNum;
			} 
			if (nextNum < min) {
				min = nextNum;
			} 
			if (nextNum % 2 == 0) {
				total += nextNum;
				if (largestEven == -1) { //since -1 is not an even integer, the only time when largestEven will equal -1 is if there have been no prior even integers that the initial value the programmer gave is still stored as largestEven. So this allows the first even integer to be stored as largestEven.
					largestEven = nextNum;
				} 
				if (nextNum > largestEven) {
					largestEven = nextNum;	
				}
			}
		}
		System.out.println("The smallest number is " + min);
		System.out.println("The largest number is " + max);
		System.out.println("The sum of even numbers is " + total); //If there are no even integers, the sum of even numbers should equal zero.
		if (largestEven != -1) {
			System.out.println("The largest even number is " + largestEven); 
		} else {
			System.out.println("The largest even number does not exist"); //If there are no even integers, it does not make sense to print a largest even number.
		}
	}
}