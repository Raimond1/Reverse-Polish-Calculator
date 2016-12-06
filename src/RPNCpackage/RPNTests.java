package RPNCpackage;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RPNTests {
	
	@Test
	public void accumilatorIsZeroWhenCreated(){
		RPNCalculator rpnc = new RPNCalculator();
		assertThat(rpnc.getAccumilator(), is(0));
	}
	@Test
	public void accumilatorReturnsValueWhenSet(){
		RPNCalculator rpnc = new RPNCalculator();
		rpnc.setAccumilator(5);
		assertThat(rpnc.getAccumilator(), is(5));
	}
	@Test
	public void accumilatorIsPushedToStack(){
		RPNCalculator rpnc = new RPNCalculator();
		rpnc.setAccumilator(5);
		rpnc.setAccumilator(7);
		assertThat(rpnc.stack.pop(), is(7));
		assertThat(rpnc.stack.pop(), is(5));
	}

	@Test
	public void calculateMethodTest(){
		RPNCalculator rpnc = new RPNCalculator();
		int calc = rpnc.calculate("1 2 +"); //	– kontrolli, et kalkulaator arvutab õigesti 1 2 + -> 3
		int calc2 = rpnc.calculate("1 2 + 4 *"); //– kontrolli, et kalkulaator arvutab õigesti 1 2 + 4 * -> 12
		int calc3 = rpnc.calculate("4 3 + 2 1 + *");//	– kontrolli, et kalkulaator arvutab õigesti 4 3 + 2 1 + * -> 21
		int calc4 = rpnc.calculate("1 2 + 4 *");//	– kontrolli, et kalkulaator (calculate meetod) arvutab õigesti  1 2 + 4 * -> 12
		
		int calcOriginal = rpnc.calculate("3 2 5 + *");
		
		
		assertThat(calc, is(3));
		assertThat(calc2, is(12));
		assertThat(calc3, is(21));
		assertThat(calc4, is(12));
		assertThat(calcOriginal, is(21));
	}
}
