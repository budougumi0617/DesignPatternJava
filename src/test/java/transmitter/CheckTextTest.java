/**
 *
 */
package transmitter;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author z00s600078
 *
 */
public class CheckTextTest {

	private CheckText ct;

	@Before
	public void setUp() throws Exception {
		ct = new CheckText();
	}

    @After
    public void tearDown() throws Exception {
    	ct = null;
    }

	/**
	 * {@link transmitter.CheckText#CheckText()} のためのテスト・メソッド。
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	@Test
	public void testCheckText(){

	}

	/**
	 * {@link transmitter.CheckText#validate(java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testValidate1() {
		//fail("まだ実装されていません");
	}


	@Test
	public void testValidate2() {
			//fail("まだ実装されていません");
	}

	@Test
	public void testValidate3() {
		//fail("まだ実装されていません");
	}





	@Test
	public void testCheckBlank() {
		Method method;
		try {
			method = CheckText.class.getDeclaredMethod("checkBlank", String.class);
			method.setAccessible(true);
			assertEquals(false, method.invoke(ct ,"		"));
		}catch(Exception ex){

		}
	}

	public void testCheckLength() {
		Method method;
		try {
			method = CheckText.class.getDeclaredMethod("checkBlank", String.class);
			method.setAccessible(true);
			assertEquals(false, method.invoke(ct ,"aaaaaaaaaaaaaaaaa"));
		}catch(Exception ex){

		}
	}


	public void testCheckType() {
		Method method;
		try {
			method = CheckText.class.getDeclaredMethod("checkBlank", String.class);
			method.setAccessible(true);
			assertEquals(false, method.invoke(ct ,"あいうえお"));
		}catch(Exception ex){

		}
	}




}
