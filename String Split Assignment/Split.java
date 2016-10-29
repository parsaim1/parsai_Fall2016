/* Author: Parsa Iranmahboub
 * Date: 10/28/16
 * The purpose of this code is to determine whether the user inputed a proper sandwich, and if so, to print the ingredients inside the sandwich.
 */
public class Split {
	public static void main(String[] args) {					
		sandwich("breadbread"); //calls the method that actually finds the ingredients in the sandwich
	}
	
	public static void sandwich(String str) {
		if (str.toLowerCase().indexOf("bread") == -1) { //tests to see if bread even exists in the String input
			System.out.println("You need bread to make a sandwich");
		} 
		if (str.toLowerCase().indexOf("bread", str.length()-5) != str.length() - 5 || str.toLowerCase().indexOf("bread", 0) != 0) { //tests to makes sure the sandwich begins and ends with bread
			System.out.println("In order to have a complete sandwich, you need to have a piece of bread at both ends of the sandwich.");
		} else {
			String afterOuterBread = str.substring(5, str.length() - 5); //removes the outer breads that must exist in order to have a legitimate sandwich
			String[] afterSpaces = afterOuterBread.split(" "); //removes the spaces
			String listOfIngredients = "";  
			for (String ingredient : afterSpaces) {
				listOfIngredients = listOfIngredients + ingredient; //creates a total list of ingredients with no spaces between the ingredients
			}
			String[] afterInnerBread = listOfIngredients.split("bread"); //removes bread from the list of ingredients
			int numbOfBread = 1; //numbOfBread is used to number the slices of bread (helps to describe the sandwich more clearly)
			for (String filling : afterInnerBread) { //prints all the ingredients that are within the same slices of bread (and indicates those specific slices of bread)
				System.out.println("The ingredient(s) between bread slices " + numbOfBread + " and " + (numbOfBread +1) + " are " + filling);
				numbOfBread++;
			}
		}
	}
}


//Your task:
/*Write a method that take in a string like "applespineapplesbreadlettustomatobaconmayohambreadcheese" describing a sandwich
 * use String.split to split up the sandwich by the word "bread" and return what's in the middle of the sandwich and ignores what's on the outside
 * What if it's a fancy sandwich with multiple pieces of bread?
*/


//Your task pt 2:
/*Write a method that take in a string like "apples pineapples bread lettus tomato bacon mayo ham bread cheese" describing a sandwich
 * use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of the sandwich and ignores what's on the outside
 * Again, what if it's a fancy sandwich with multiple pieces of bread?
*/
