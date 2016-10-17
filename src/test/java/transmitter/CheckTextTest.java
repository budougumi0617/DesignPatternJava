/**
 *
 */
package transmitter;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author z00s600078
 *
 */
public class CheckTextTest {

	/**
	 * {@link transmitter.CheckText#CheckText()} のためのテスト・メソッド。
	 */
	@Test
	public void testCheckText() {
		CheckText ct = new CheckText();
		assertFalse(ct.checkBlank("	"));
	}

	/**
	 * {@link transmitter.CheckText#validate(java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testValidate() {
		//fail("まだ実装されていません");
	}

}
