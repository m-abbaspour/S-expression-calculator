package calculator;

import java.util.Scanner;
/**
 * 
 * @author Mahdiyeh Abbaspour
 * @version 1
 * Created: 2023-01-09
 *
 * Class Description: 
 * A command line program that acts as a simple calculator: 
 * it takes a single argument as an expression and prints out 
 * the integer result after evaluating it.
 * 
 * The program takes input from commandline if possible
 * else it will prompt the user
 * 
 * To run the program:
 * java -jar calc.jar EXP
 * 
 * EXP can be: "(add 12 12)" 
 * or (add 0 (add 3 4))
 * or (multiply 2 (add (multiply 2 3) (multiply 2 4 1 1)))
 * or if EXP is null:
 * 	The program will greet and then prompt you for an expression
 * For full description please visit: https://gist.github.com/rraval/2ef5e2ff228e022653db2055fc12ea9d
 */
public class Calc { 
	final private static String EXTRA_PARENTHESIS_ERROR_STRING = "Error: Expression contains an error";
	final private static String UNSUPPORTED_OPPERATION_ERROR_STRING = "Error: Unsupported Opperation!";
	final private static String UNSUPPORTED_EXPRESSION_ERROR_STRING ="Error: unsupported expression";
	
	final private static String MULTIPLY_STRING = "multiply";
	final private static String ADD_STRING = "add";
	
	final private static String OPEN_PARENTHESIS_STRING = "(";
	final private static String CLOSE_PARENTHESIS_STRING = ")";

	/**
	 * Class to run the program
	 * @param args
	 */
	public static void main(String[] args) {
		String exprString = "";
		if(args.length != 0) {
			exprString = args[0];

		} else {
			System.out.println("Wlcome to Calculator!");
			System.out.println("Please enter an expression:");
			Scanner scanner = new Scanner(System.in);
			exprString = scanner. nextLine();
			scanner.close();
		}
		System.out.println(tryExprEval(exprString));
		
	}
	
	public static String tryExprEval(String exprString) {
		try {
			return exprEval(exprString);
		} catch (Exception e) {
			return UNSUPPORTED_EXPRESSION_ERROR_STRING;
			
		}
	}
	
	/**
	 * Class Description: Finds the inner most expression that can be executed
	 * and substitutes it with the returned value from doCalc(String expression)
	 * 
	 * @param expr Expression to be evaluated
	 * @return answer of the evaluation
	 */
	private static String exprEval(String expr) {
		while (expr.contains(CLOSE_PARENTHESIS_STRING)){
			int closeparathesisIndex = expr.indexOf(CLOSE_PARENTHESIS_STRING);
			
			int openparanindex = expr.substring(0, closeparathesisIndex).lastIndexOf(OPEN_PARENTHESIS_STRING);
			if(openparanindex == -1) {
				return EXTRA_PARENTHESIS_ERROR_STRING;
			}
			String executable = expr.substring(openparanindex+1, closeparathesisIndex); 
			expr = expr.substring(0,openparanindex)+ doCalc(executable)+ expr.substring(closeparathesisIndex+1);			
		}  
		if (expr.contains(OPEN_PARENTHESIS_STRING)) {
			return EXTRA_PARENTHESIS_ERROR_STRING;
		} else {
			return expr.trim();
		}
	}
	
	/**
	 * Class Description: Runs a single expression that is passed from
	 * exprEval(String expr) and returns the answer
	 * 
	 * @param executable Single expressions
	 * @return the answer of the single expression
	 */
	private static String doCalc(String executable) {
		executable = executable.trim();
		String[] token = executable.split(" ");
		int answer = 0;
		if(token[0].toLowerCase().equals(ADD_STRING)) {
			for(int i=1; i<token.length; i++) {
				if (token[i].trim().length()>0)
					answer += Integer.parseInt(token[i]) ;
			}
		} else if(token[0].toLowerCase().equals(MULTIPLY_STRING)) {
			answer = 1;
			for(int i=1; i<token.length; i++) {
				if (token[i].trim().length()>0)
					answer *= Integer.parseInt(token[i]) ;
			}
		} else {
			return UNSUPPORTED_OPPERATION_ERROR_STRING;
		}
		return String.valueOf(" "+answer+" ");
	}
}
