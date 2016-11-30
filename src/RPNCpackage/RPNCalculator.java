package RPNCpackage;

import java.util.ArrayList;

import javax.lang.model.type.ErrorType;

import stacks.Stack;

public class RPNCalculator {
	Stack stack = new Stack();
	int accumilator = 0;

	public static void main(String[] args) {
		
//		System.out.println();
	}

	// ArrayList<Integer> accumilator = new ArrayList();

	// int getAccumulator() � tagastab akumulaatoris oleva v��rtuse
	public int getAccumilator() {

		return accumilator;
	}

	// void setAccumulator(int number) � seab akumulaatori v��rtuse
	public void setAccumilator(int number) {
		accumilator = number;
		enter();

	}

	// void enter() � paneb akumulaatori pinusse
	public void enter() {
		stack.push(accumilator);
	}

	// void plus() � eemaldab pinust pealmise elemendi, liidab sellele
	// akumulaatori
	// ja paneb tulemuse akumulaatorisse
	public void plus() {
		int addend1 = stack.pop();
		int addend2 = stack.pop();
		accumilator = addend2 + addend1;
		enter();
	}

	// void multiply() � eemaldab pinust pealmise elemendi, korrutab sellele
	public void multiply() {
		int addend1 = stack.pop();

		accumilator = accumilator * addend1;
		enter();
	}

	// akumulaatoriga ja paneb tulemuse akumulaatorisse
	// int calculate(String expression) � v�ttab sisse avaldise stringi kujul
	// ja tagastab selle v��rtuse
	public int calculate(String expression) {
//		expression = "3 2 5 + *";

		String[] parts = expression.split(" ");
		
		
		for (int i = 0; i < parts.length; i++) {
			if ((parts[i]).equals(Integer.TYPE)) {
				setAccumilator(Integer.parseInt(parts[i]));
				
			}else if ((parts[i]).equals("+")) {
				plus();
				
			}else if ((parts[i]).equals("*")) {
				multiply();
				
			} 
		}
		

		return stack.pop();
	}
}
