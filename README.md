# S-expression-calculator
******************************************************************
Author: Mahdiyeh Abbaspour
Version: 1
Created: 2023-01-09
******************************************************************
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
 * 
 * For full description please visit: https://gist.github.com/rraval/2ef5e2ff228e022653db2055fc12ea9d
******************************************************************
