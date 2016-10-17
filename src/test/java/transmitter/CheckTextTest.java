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
	 */
	@Test
	public void testCheckText(){
	}


	/**
	 * {@link transmitter.CheckText#validate(java.lang.String)} のためのテスト・メソッド。
	 */

	/* 正常系 半角英数かつ16文字以下かつ空白を含まない場合trueを返す */
	@Test
	public void testValidate1() {
		assertEquals(true, ct.validate("hello"));
	}

	/* 異常系 半角英数でない、または17文字以上、または空白を含む場合falseを返す */
	@Test
	public void testValidate2() {
		assertEquals(false, ct.validate("こんにちは"));
	}


	/**
	 * {@link transmitter.CheckText#CheckBlank(java.lang.String)} のためのテスト・メソッド。
	 */

	/* 正常系 文字列に空白がない場合falseを返すか判定 */
	@Test
	public void testCheckBlank1() {
		Method method;
		try {
			method = CheckText.class.getDeclaredMethod("checkBlank", String.class);
			method.setAccessible(true);
			assertEquals(false, method.invoke(ct ,"あいうえお"));
		}catch(Exception ex){
			fail(ex.getMessage());
		}
	}

	/* 異常系 文字列に空白がある場合trueを返すか判定 */
	@Test
	public void testCheckBlank2() {
		Method method;
		try {
			method = CheckText.class.getDeclaredMethod("checkBlank", String.class);
			method.setAccessible(true);
			assertEquals(true, method.invoke(ct ,"		"));
		}catch(Exception ex){
			fail(ex.getMessage());
		}
	}

	/**
	 * {@link transmitter.CheckText#CheckLength(java.lang.String)} のためのテスト・メソッド。
	 */
	/* 正常系 文字列が16文字以下の場合falseを返すか判定 */
	@Test
	public void testCheckLength1() {
		Method method;
		try {
			method = CheckText.class.getDeclaredMethod("checkLength", String.class);
			method.setAccessible(true);
			assertEquals(false, method.invoke(ct ,"koreha16mojidesu"));
		}catch(Exception ex){
			fail(ex.getMessage());
		}
	}

	/* 異常系 文字列に空白がある場合trueを返すか判定 */
	@Test
	public void testCheckLength2() {
		Method method;
		try {
			method = CheckText.class.getDeclaredMethod("checkLength", String.class);
			method.setAccessible(true);
			assertEquals(true, method.invoke(ct ,"koreha17mojidesu!"));
		}catch(Exception ex){
			fail(ex.getMessage());
		}
	}

	/**
	 * {@link transmitter.CheckText#CheckType(java.lang.String)} のためのテスト・メソッド。
	 */

	/* 正常系 文字列が半角英数字の場合falseを返すか判定 */
	@Test
	public void testCheckType1() {
		Method method;
		try {
			method = CheckText.class.getDeclaredMethod("checkType", String.class);
			method.setAccessible(true);
			assertEquals(false, method.invoke(ct ,"aiueo"));
		}catch(Exception ex){
			fail(ex.getMessage());
		}
	}

	/* 異常系 文字列が半角英数字以外の文字を含む場合trueを返すか判定 */
	@Test
	public void testCheckType2() {
		Method method;
		try {
			method = CheckText.class.getDeclaredMethod("checkType", String.class);
			method.setAccessible(true);
			assertEquals(true, method.invoke(ct ,"あいうえお"));
		}catch(Exception ex){
			fail(ex.getMessage());
		}
	}


}
