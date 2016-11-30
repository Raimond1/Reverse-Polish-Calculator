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
//		rpnc.calculate("3 2 5 + *");
		
		assertThat(rpnc.calculate("2 3 5 + *"), is(16));
		
	}
}
