package RPNCpackage;

import stacks.Stack;

/**
 * @author Raimond
 *
 */
public class RPNCalculator {

	Stack stack = new Stack();
	int accumilator = 0;

	public static void main(String[] args) {
		RPNCalculator calculator = new RPNCalculator();
		System.out.println(calculator.calculate("4 6 /"));

	}

	/**
	 * int getAccumulator() ñ tagastab akumulaatoris oleva v‰‰rtuse
	 * 
	 * @return
	 */
	public int getAccumilator() {
		return accumilator;
	}

	/**
	 * void setAccumulator(int number) ñ seab akumulaatori v‰‰rtuse
	 * 
	 * @param number
	 */
	public void setAccumilator(int number) {
		accumilator = number;
		enter();
	}

	/**
	 * void enter() ñ paneb akumulaatori pinusse
	 * 
	 */
	public void enter() {
		stack.push(accumilator);
	}

	/**
	 * void plus() ñ eemaldab pinust pealmise elemendi, liidab sellele
	 * akumulaatori ja paneb tulemuse akumulaatorisse
	 * 
	 */
	public void plus() {
		accumilator = stack.pop() + stack.pop();
		enter();
	}

	/**
	 * void multiply() ñ eemaldab pinust pealmise elemendi, korrutab sellele
	 */
	public void multiply() {
		accumilator = stack.pop() * stack.pop();
		enter();
	}
	
	/**
	 * void minus() ñ eemaldab pinust pealmise elemendi, lahutab sellest
	 * akumulaatori ja paneb tulemuse akumulaatorisse
	 * 
	 */
	public void minus() {
		int m1= stack.pop();
		int m2= stack.pop();
		
		accumilator = m2- m1;
		enter();
	}
	
	/**
	 * void divide() ñ eemaldab pinust pealmise elemendi, jagab sellega
	 * jagamine ei tˆˆta korrektselt paaritute arvude korral ja kui vastus peaks olema komakohtadega!
	 */
	public void divide() {
		int d1= stack.pop();
		int d2= stack.pop();
		
		accumilator = d2/ d1;
		enter();
	}

	/**
	 * 
	 * akumulaatoriga ja paneb tulemuse akumulaatorisse int calculate(String
	 * expression) ñ vıttab sisse avaldise stringi kujul ja tagastab selle
	 * v‰‰rtuse
	 * 
	 * @param expression
	 * @return 
	 */
	public int calculate(String expression) {
		String[] parts = expression.split(" ");
		for (int i = 0; i < parts.length; i++) {
			if (isNumber(parts[i])) {
				stack.push(Integer.parseInt(parts[i]));
			} else {
				if ((parts[i]).equals("+")) {
					plus();
				} else if ((parts[i]).equals("*")) {
					multiply();
				}else if ((parts[i]).equals("-")) {
					minus();
				} else if ((parts[i]).equals("/")) {
					divide();
				}
			}
		}
		return accumilator;
	}

	private boolean isNumber(String part) {
		try {
			Integer.parseInt(part);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}

		return true;
	}
}
