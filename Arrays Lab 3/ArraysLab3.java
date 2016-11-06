/* Author: Parsa Iranmahboub
 * Date: 11/6/16
 * The goal of this code is to to manipulate the arrays in the following way: 
 * 	1. adding the elements of two arrays, 
 * 	2. appending an integer to the end of the array, 
 * 	3. removing an element at a certain index of the array, 
 * 	4. finding the sum of the elements at the even indices of the array, 
 * 	5. moving the elements of the array one index to the right
 */

import java.util.Arrays;  //needed for Arrays.toString

public class ArraysLab3 {
	public static void main(String[] args) {
		int[] a1 = {5, 10, 15, 20, 25, 30, 35, 40};  //both constructs and declares the array
		int[] a2 = {7, 14, 21, 28, 35, 42, 49, 56};
		int[] sumArr = sum(a1, a2);
		int appendNum = 200;
		int[] appendArr = append(a1, appendNum);
		int removeIdx = 5;
		int[] removeArr = remove(a2, removeIdx);
		int sumOfEvens = sumEven(appendArr);
		rotateRight(a1);
		System.out.println(Arrays.toString(sumArr)); //Arrays.toString is needed so that the actual contents inside the array are printed and not random characters
		System.out.println(Arrays.toString(appendArr));
		System.out.println(Arrays.toString(removeArr));
		System.out.println(sumOfEvens);
		System.out.println(Arrays.toString(a1));
		
	}
	
	public static int[] sum(int[] arr1, int[] arr2) {  //Forms a new array of integers with the elements of arr1 and arr2 (at a specific index) added together
		int[] newArr = new int[arr1.length];  //since arr1 and arr2 are the same length, newArr will also be the same length
		for (int indexNum = 0; indexNum < arr1.length; indexNum++) {   //since we are dealing with two deals, a for loop would be better than a for/each loop
			int total = arr1[indexNum] + arr2[indexNum]; 
			newArr[indexNum] = total;   //stores the combined elements in the new array
		}
		return newArr;
	}
	
	public static int[] append(int[] arr, int num) { //Forms a new array of integers that has the same original elements but also adds a new integer to the end
		int[] newArr = Arrays.copyOf(arr, arr.length + 1);  //copies arr but the new array can store an extra int value
		newArr[newArr.length - 1] = num;     // the extra int value (at the end of the array) is used for num
		return newArr;	
	}
	
	public static int[] remove(int [] arr, int idx) {  //Forms a new array of integers that has an element at a certain index removed
		int[] newArr = new int[arr.length - 1];   //since we are removing an element, the new array will have a smaller size (by one int value)
		for (int indexNum = 0; indexNum < idx; indexNum++)   //the first for loop copies arr exactly until it reaches index idx
			newArr[indexNum] = arr[indexNum];
		for (int indexNum = idx; indexNum <= newArr.length - 1; indexNum++) {  //the second for loop starts at index idx and shifts every element to the left. The original element at idx is removed since we never stored and recalled it
			newArr[indexNum] = arr[indexNum +1];
		}
		return newArr;
	}
			
	public static int sumEven(int[] arr) {  //Returns an integer whose value is the sum of the elements of the array at the even indices
		int total = 0;
		for (int indexNum = 0; indexNum < arr.length; indexNum++) {   //use a for loop instead of a for/each loop because we are testing whether the index is even — not whether the element is even
			if (indexNum % 2 == 0) {  //tests to make sure that the index is even
				total = total + arr[indexNum];
			}
		}
		return total;
	}
	
	public static void rotateRight(int[] arr) {   //Moves each element of the original array one index to the right
		int last = arr[arr.length-1];  //stores the last element
		for (int indexNum = arr.length-1; indexNum > 0; indexNum--) { //shifts each element to the right; stops before indexNum = 0 so there will be no ArrayIndexOutofBoundsException
			arr[indexNum] = arr[indexNum - 1];  
		}
		arr[0] = last;  //recalls the last element as now the first element
	}

}
