package calculator;

/**
 * 
 * @author Mahdiyeh Abbaspour
 * @version 1
 * Created: 2023-01-09
 * */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalcTest {

	/**
	 * Integer value
	 */
	@Test
	void testExprEval1() {
		String inputString = "0";
		String actual = Calc.tryExprEval(inputString);
		String expected = "0";
		assertEquals(expected, actual);
		
	}
	
	/**
	 * Integer value
	 */
	@Test
	void testExprEval2() {
		String inputString = "123";
		String actual = Calc.tryExprEval(inputString);
		String expected = "123";
		assertEquals(expected, actual);
		
	}

	/**
	 * add function
	 */
	@Test
	void testExprEval3() {
		String inputString = "(add 12 12)";
		String actual = Calc.tryExprEval(inputString);
		String expected = "24";
		assertEquals(expected, actual);
		
	}

	/**
	 * add function
	 */
	@Test
	void testExprEval4() {
		String inputString = "(add 123 456)";
		String actual = Calc.tryExprEval(inputString);
		String expected = "579";
		assertEquals(expected, actual);
		
	}

	/**
	 * multiply function
	 */
	@Test
	void testExprEval5() {
		String inputString = "(multiply (add 1 2) 3)";
		String actual = Calc.tryExprEval(inputString);
		String expected = "9";
		assertEquals(expected, actual);
		
	}

	/**
	 * add function
	 */
	@Test
	void testExprEval6() {
		String inputString = "(add 1 1)";
		String actual = Calc.tryExprEval(inputString);
		String expected = "2";
		assertEquals(expected, actual);
		
	}

	/**
	 * add function
	 */
	@Test
	void testExprEval7() {
		String inputString = "(add 0 (add 3 4))";
		String actual = Calc.tryExprEval(inputString);
		String expected = "7";
		assertEquals(expected, actual);
		
	}

	/**
	 * add function
	 */
	@Test
	void testExprEval8() {
		String inputString = "(add 3 (add (add 3 3) 3))";
		String actual = Calc.tryExprEval(inputString);
		String expected = "12";
		assertEquals(expected, actual);
		
	}
	
	/**
	 * multiply function
	 */
	@Test
	void testExprEval9() {
		String inputString = "(multiply 1 1)";
		String actual = Calc.tryExprEval(inputString);
		String expected = "1";
		assertEquals(expected, actual);
		
	}

	/**
	 * multiply function
	 */
	@Test
	void testExprEval10() {
		String inputString = "(multiply 0 (multiply 3 4))";
		String actual = Calc.tryExprEval(inputString);
		String expected = "0";
		assertEquals(expected, actual);
		
	}

	/**
	 * multiply function
	 */
	@Test
	void testExprEval11() {
		String inputString = "(multiply 2 (multiply 3 4))";
		String actual = Calc.tryExprEval(inputString);
		String expected = "24";
		assertEquals(expected, actual);
		
	}

	/**
	 * multiply function
	 */
	@Test
	void testExprEval12() {
		String inputString = "(multiply 3 (multiply (multiply 3 3) 3))";
		String actual = Calc.tryExprEval(inputString);
		String expected = "81";
		assertEquals(expected, actual);
		
	}

	/**
	 * add and multiply mix 
	 */
	@Test
	void testExprEval13() {
		String inputString = "(add 1 (multiply 2 3))";
		String actual = Calc.tryExprEval(inputString);
		String expected = "7";
		assertEquals(expected, actual);
		
	}

	/**
	 * add and multiply mix 
	 */
	@Test
	void testExprEval14() {
		String inputString = "(multiply 2 (add (multiply 2 3) 8))";
		String actual = Calc.tryExprEval(inputString);
		String expected = "28";
		assertEquals(expected, actual);
		
	}

	/**
	 * add and multiply mix 
	 */
	@Test
	void testExprEval15() {
		String inputString = "(add 1 2 3 4 (multiply 2 3 5))";
		String actual = Calc.tryExprEval(inputString);
		String expected = "40";
		assertEquals(expected, actual);
		
	}

	/**
	 * add and multiply mix with an arbitrary number of arguments
	 */
	@Test
	void testExprEval151() {
		String inputString = "(multiply 2 (add (multiply 2 3) (multiply 2 4 1 1)))";
		String actual = Calc.tryExprEval(inputString);
		String expected = "28";
		assertEquals(expected, actual);
		
	}
	
	/**
	 * add and multiply mix with extra blank spaces
	 */
	@Test
	void testExprEval16() {
		String inputString = "     (multiply 2               (add(multiply 2   3) 8))";
		String actual = Calc.tryExprEval(inputString);
		String expected = "28";
		assertEquals(expected, actual);
		
	}

	/**
	 * Invalid Expression
	 */
	@Test
	void testExprEval17() {
		String inputString = "(add 2 (add(multiply 2 3) 8)))))";
		String actual = Calc.tryExprEval(inputString);
		String expected = "Error: Expression contains an error";
		assertEquals(expected, actual);
		
	}

	/**
//	 * Invalid Expression. Unsupported command "exponent"
	 */
	@Test
	void testExprEval18() {
		String inputString = "(exponent 2 (add(multiply 2 3) 8))";
		String actual = Calc.tryExprEval(inputString);
		String expected = "Error: Unsupported Opperation!";
		assertEquals(expected, actual);
		
	}

	/**
	 * Invalid Expression. Extra open Parenthesis "("
	 */
	@Test
	void testExprEval19() {
		String inputString = "(add( 2 (add(multiply 2 3) 8))";
		String actual = Calc.tryExprEval(inputString);
		String expected = "Error: Expression contains an error";
		assertEquals(expected, actual);
		
	}

	/**
	 * add and multiply mix with an arbitrary number of arguments
	 */
	@Test
	void testExprEval20() {
		String inputString = "(add  (add(multiply 2 3) 8))";
		String actual = Calc.tryExprEval(inputString);
		String expected = "14";
		assertEquals(expected, actual);
		
	}

	


}
