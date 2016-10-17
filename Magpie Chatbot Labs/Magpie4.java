/* Author: Parsa Iranmahboub
 * Date: 10/17/16
 * This program creates a chatbot that allows the user to input a string and to 
 * receive a response.
 */

public class Magpie4 {
	
	public String getGreeting() { //Get a default greeting and return a greeting
		return "Hello, let's talk.";
	}
	
	public String getResponse(String statement) { // Gives a response to a user statement 
		
		String response = "";
		if (statement.trim().length() < 1) {
			return response = "Say something, please.";
		} if (findKeyword(statement, "no") >= 0) {
			return response = "Why so negative?";
		} if (findKeyword(statement, "yeah") >= 0) {
			return response = "Why are you so happy?";
		} if (findKeyword(statement, "Mr.") >= 0  
				|| findKeyword(statement, "Ms.") >= 0 
				|| findKeyword(statement, "Mrs.") >= 0) {
			return response = "What a great person!";
		} if (findKeyword(statement, "mother") >= 0
				|| findKeyword(statement, "father") >= 0
				|| findKeyword(statement, "sister") >= 0
				|| findKeyword(statement, "brother") >= 0
				|| findKeyword(statement, "grandmother") >= 0
				|| findKeyword(statement, "grandfather") >= 0) {
			return response = "Tell me more about your family.";

		} if (findKeyword(statement, "I want to", 0) >= 0) { //Since "I want to" contains "I want", this if statement must come before line 35
			return response = transformIWantToStatement(statement);
		} if (findKeyword(statement, "I want", 0) >= 0) {
			return response = transformIWantStatement(statement);
		} else { //I used "else" instead of "if" because I needed two if statements for the I/you and you/me statements, but I had to declare two different psn variables outside the if statements
			int psn = findKeyword(statement, "I", 0);
			if (psn >= 0 && findKeyword(statement, "you", psn) >= 0) {
				return response = transformIYouStatement(statement);
			} else {
			psn = findKeyword(statement, "you", 0);

			if (psn >= 0 && findKeyword(statement, "me", psn) >= 0) {
				return response = transformYouMeStatement(statement);
				} else {
					return response = getRandomResponse();
				}
			}
		}
	}
	

	private String transformIWantToStatement(String statement) { //Take a statement with "I want to <something>." and transform it into "What would it mean to <something>?"
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1); //Removes the final period if there is one
		}
		int psn = findKeyword(statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "What would it mean to " + restOfStatement + "?";
	}
	
	
	private String transformIWantStatement(String statement) { //Take a statement with "I want <something>." and transform it into "Would you really be happy if you had <something>?"
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() -1);
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() -1); //Removes the final period if there is one
		}
		int psn = findKeyword(statement, "I want", 0);
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Would you really be happy if you had " + restOfStatement + "?";
	}
	
	
	private String transformYouMeStatement(String statement) { //Take a statement with "you <something> me" and transform it into "What makes you think that I <something> you?"
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1); 
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1); //Removes the final period if there is one
		}

		int psnOfYou = findKeyword(statement, "you", 0);
		int psnOfMe = findKeyword(statement, "me", psnOfYou + 3);

		String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim(); //assumes the user statement contains "you" followed by "me"
	
		return "What makes you think that I " + restOfStatement + " you?";
	}
	
	
	private String transformIYouStatement(String statement) { //Take a statement with "I <something> you" and transform it into "Why do you <something> me?"
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1); 
		if (lastChar.equals(".")) {
			statement = statement.substring(0, statement.length() - 1); //Removes the final period if there is one
		}
		int psnOfI = findKeyword(statement, "I", 0);
		int psnOfYou = findKeyword(statement, "you", 0);
		String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim(); //assumes the user statement contains "I" followed by "you"
		return "Why do you " + restOfStatement + " me?";
	}

	
	private int findKeyword(String statement, String goal, int startPos) { //searches for a word in the user's input
		String phrase = statement.trim(); 
		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos); //allows the code to find the index of a specified character or string in the user's input when starting the search at a specific index.
		while (psn >= 0) { 	//the while loop makes sure the specified string (i.e. goal) isn't part of another word
			String before = " ", after = " ";
			if (psn > 0) {
				before = phrase.substring(psn - 1, psn).toLowerCase(); //Finds the character of length 1 before the word
			}
			if (psn + goal.length() < phrase.length()) {
				after = phrase.substring(psn + goal.length(), //Finds the character of length 1 after the word
						psn + goal.length() + 1).toLowerCase();
			}
			if (before.equals(" ") && after.equals(" ")) { //The specified string is a word in the user's input if there are spaces before and after the substring
				return psn;
			}
			psn = phrase.indexOf(goal.toLowerCase(), psn + 1); //If the actual word was not found, the program continues to search if the user's input once again contains the specified string
		}
		return -1; //returns -1 if the specified string is not found
	}

	
	private int findKeyword(String statement, String goal) { //assumes that the index of where to start searching for the specified string is zero 
		return findKeyword(statement, goal, 0);
	}

	
	private String getRandomResponse() { //returns a non-committal string if no other responses fit the user's input
		
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES); //initializes whichResponse as an integer between 0 and 5 (including both zero and five)
		String response = "";

		if (whichResponse == 0) {
			response = "Interesting, tell me more.";
		} else if (whichResponse == 1) {
			response = "Hmmm.";
		} else if (whichResponse == 2) {
			response = "Do you really think so?";
		} else if (whichResponse == 3) {
			response = "You don't say.";
		} else if (whichResponse == 4) {
			response = "Oh, okay.";	
		} else if (whichResponse == 5) {
			response = "Can you tell me more?";
		}
		return response;
	}

}
