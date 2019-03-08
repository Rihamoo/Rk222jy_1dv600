package hangman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
@SuppressWarnings("static-access")
class rk222jy_asg2Test {

	
	private String validInput = "f";
	private String inValidInput = "that's long invalid input ";
	private String inValidIntegerInput = "6";
	
	private String validInputToChooseFromMenu = "1";
	private String validInputToChooseFromMenu2 = "2";

	rk222jy_asg2 hangman = new rk222jy_asg2();
	
	// when we press number 3 the game is finished and the return is true for valid input
	// but it should return false because it's a bug.
	@Test
	void testvalidInputChosenFromMenuBug() {
		assertEquals(true, hangman.validInputChosenFromMenu(validInputToChooseFromMenu));
		assertEquals(true, hangman.validInputChosenFromMenu(validInputToChooseFromMenu2));
		assertEquals(false, hangman.validInputChosenFromMenu("3"));
	}
	
	@Test
	void testvalidInputChosenFromMenu() {
		assertEquals(true, hangman.validInputChosenFromMenu(validInputToChooseFromMenu));
		assertEquals(true, hangman.validInputChosenFromMenu(validInputToChooseFromMenu2));
		assertEquals(false, hangman.validInputChosenFromMenu(inValidInput));
		assertEquals(false, hangman.validInputChosenFromMenu(inValidIntegerInput));
	}
	
	@Test
	void testCheckIfValidInput() {
		assertEquals(true, hangman.checkIfValidInput(validInput));
		assertEquals(false, hangman.checkIfValidInput(inValidIntegerInput));
		assertEquals(false, hangman.checkIfValidInput(inValidInput));

	}
		

	
	


}
