package hangman;

import java.util.Scanner;

public class rk222jy_asg2 {

	private static String[] words = {"terminator", "banana", "computer", "cow", 
			"rain", "water" ,"mark" , "equal" , "fungus" , "magic" , "kiss" , "web"};
	private static String word = words[(int) (Math.random() * words.length)];
	private static String aster = new String(new char[word.length()]).replace("\0", "*");
	private static int count = 0;

	static final int DEAD=13;   // amount of errors till loss

	private static String guess;
	static Scanner enter = new Scanner(System.in);
	private static boolean checkInput = false;
	private static boolean isValidInput = false;
	private static boolean isEnterName = false;
	private static String enterName = "";
	private static boolean isExit;
	public static void main(String[] args) {

		do{
			System.out.println("Choose From Menu\n1.Enter your name\n2.Play as guest");
			String input = enter.next();
			isValidInput = validInputChosenFromMenu(input);
			if(isValidInput && isEnterName) {
				System.out.println("Type your name: ");
				enterName = enter.next();
				System.out.println("Welcome "+enterName);
				startTheGame();
			}
			else if(isValidInput && isExit)
				System.exit(0);
			
			else if(isValidInput)
				startTheGame();
			
			else System.out.println("invalid input please enter again");

		}while(!isValidInput);


	}
	protected static boolean validInputChosenFromMenu(String input) {
		if(input.equals("1")) {
			isEnterName  = true;
			return true;
		}
		else if(input.equals("2")) {
			return true;
		}
		else if(input.equals("3"))
		{
			isExit = true;
			return true;
		}
		return false;
	}
	private static void startTheGame() {
		System.out.println("              GUESS THE WORD BEHIND THE STARS");
		System.out.println("  Chose letters from the keyboard to find the hidden word");
		System.out.println(aster);

		while (count < 7 && aster.contains("*")) {

			do {
				guess = enter.next();
				checkInput = checkIfValidInput(guess);
				if(checkInput)
					hang(guess);
				if(!checkInput)
					System.out.println("Please Input valid letter");

			}while(checkInput == false);
		}
		enter.close();
	}

	public static void hang(String guess) {
		String risk = ""; //newasterisk
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guess.charAt(0)) {
				System.out.println(" good job the letter exists, please continue ");
				risk += guess.charAt(0);
			} else if (aster.charAt(i) != '*') {
				risk += word.charAt(i);
			} else {
				risk += "*";
			}
		}

		if (aster.equals(risk)) {
			count++;
			THEhangmanImage();

		} else {
			aster = risk;
		}
		if (aster.equals(word)) {
			System.out.println("  GOoOOoOoD GUESS! CONGRATULATION YOU WIN :) "
					+ "THIS WAS THE HIDEN WORD   " + word);
		}
	}

	public static void THEhangmanImage() {
		if (count == 1) {
			System.out.println("OoPS! IT WAS A WRONG GUESS , WOULD YOU TRY AGAIN ");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___|___");
			System.out.println();
		}
		if (count == 2) {
			System.out.println("OoPS! IT WAS A WRONG GUESS , WOULD YOU TRY AGAIN ");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 3) {
			System.out.println("OoPS! IT WAS A WRONG GUESS , WOULD YOU TRY AGAIN ");
			System.out.println("   ____________");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (count == 4) {
			System.out.println(" OoPS! IT WAS A WRONG GUESS , WOULD YOU TRY AGAIN ");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /. .\\");
			System.out.println("   |         \\_@_/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 5) {
			System.out.println("OoPS! IT WAS A WRONG GUESS , WOULD YOU TRY AGAIN ");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /. .\\");
			System.out.println("   |         \\_@_/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 6) {
			System.out.println("OoPS! IT WAS A WRONG GUESS , WOULD YOU TRY AGAIN ");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /. .\\");
			System.out.println("   |         \\_@_/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
		}
		if (count == 7) {
			System.out.println("GAME OVER!");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /. .\\");
			System.out.println("   |         \\_@_/");
			System.out.println("   |          _|_");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("   |         /   \\");
			System.out.println("   |               ");
			System.out.println("___|___            ");
			System.out.println("GAME OVER! YOU LOSE ,YOU HANGED THE MAN "
					+"\n The hidden word was : " + word);
		}
	}


	protected static boolean checkIfValidInput(String input){
		Character check = input.charAt(0);
		if(Character.isLetter(check) && input.length() == 1) 
			return true;
		else
			return false;

	}}



