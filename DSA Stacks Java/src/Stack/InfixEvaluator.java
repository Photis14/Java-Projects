//Author: John Photis
//Purpose: This Java program evaluates an infix	arithmetic expressions.	

package Stack;


import java.util.*;

public class InfixEvaluator {
	// YOUR CODES
	private String s;


	public InfixEvaluator(String s) {
		this.s = s;
	} 


	public Double evaluateInfix(String s) {
		
		char[] expressions = s.toCharArray();
		
		Stack<Double> operands = new Stack<>(); 

		Stack<Character> operators = new Stack<>(); 
		String[] expression = s.split(" ");
		for (int i = 0; i < expressions.length; i++) {
			//String expressions  = expressions[i];
			if (expressions[i] == ' ')
				continue;

			if (expressions[i] >= '0' && expressions[i] <= '9') {
				StringBuilder sub = new StringBuilder();
				while (i < expressions.length && expressions[i] >= '0' && expressions[i] <= '9') {
					sub.append(expressions[i++]);
				}
				operands.push(Double.parseDouble(sub.toString()));
			}

			else if (expressions[i] == '(')
				operators.push(expressions[i]);

			else if (expressions[i] == ')') {
				while (operators.peek() != '(') {
					operands.push(signs(operators.pop(), operands.pop(), operands.pop()));
				}
				operators.pop();
			}

			else if (expressions[i] == '^' || expressions[i] == '+' || expressions[i] == '-' || expressions[i] == '*' || expressions[i] == '/') {

				while (!operators.empty() && pemdas(expressions[i], operators.peek())) {
					operands.push(signs(operators.pop(), operands.pop(), operands.pop()));
				}

				operators.push(expressions[i]);
			}
		}

		while (!operators.empty()) {
			operands.push(signs(operators.pop(), operands.pop(), operands.pop()));
		}

		return operands.pop();
	}

	public static boolean pemdas(char operator1, char operator2) {
		if (operator2 == '(' || operator2 == ')') {
			return false;
		}
		if (operator1 == '^' && (operator2 == '/' || operator2 == '*' || operator2 == '+' || operator2 == '-')
				|| ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-'))) {
			return false;
		} else {
			return true;
		}
	}

	public static double signs(char operator, double b, double a) {
		switch (operator) {
		case '^':
			return ((int) Math.pow(a, b));
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0)
				return a / b;
		default:
		}
		return a;
	}

	public static void main(String[] args) throws Exception {
		System.out.print("Please enter an arithmetic expression: ");
		Scanner input = new Scanner(System.in);
		String exp = input.nextLine();
		input.close();
		InfixEvaluator infix = new InfixEvaluator(exp);
		System.out.println("The result is: " + String.format("%.1f", infix.evaluateInfix(exp)));

	}
}