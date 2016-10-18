/**
 * @file 2016/10/18
 */
package transmitter;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * CheckParameterクラスのテスト
 *
 * @author ema195y
 *
 */
public class CheckParameterTest {

	private CheckParameter cp ;
	private Method method;

	/**
	 * テスト初期設定
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		cp = new CheckParameter();
	}

	/**
	 * テスト終了時動作
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		cp = null;
		method = null;
	}


	/**
	 * {@link transmitter.CheckParameter#validate(java.lang.String)} のためのテスト・メソッド。
	 */

	/** 【正常系】 入力値が空白でない場合trueを返す */
	@Test
	public void testValidate1() {
		assertThat(cp.validate("COM1"), is(true));
	}

	/** 【異常系】 入力値が空白の場合falseを返す */
	@Test
	public void testValidate2() {
		assertThat(cp.validate(""), is(false));
	}

	/**
	 * {@link transmitter.CheckParameter#CheckBlank(java.lang.String)} のためのテスト・メソッド。
	 */

	/** 【正常系】 入力値が空白でない場合falseを返すか判定 */
	@Test
	public void testCheckBlank1() {
		try {
			method = CheckParameter.class.getDeclaredMethod("checkBlank", String.class);
			method.setAccessible(true);
			assertThat(method.invoke(cp ,"COM1"), is(false));
		}catch(Exception ex){
			fail(ex.getMessage());
		}
	}

	/** 【異常系】 入力値が空白の場合trueを返すか判定 */
	@Test
	public void testCheckBlank2() {
		try {
			method = CheckParameter.class.getDeclaredMethod("checkBlank", String.class);
			method.setAccessible(true);
			assertThat(method.invoke(cp ,""), is(true));
		}catch(Exception ex){
			fail(ex.getMessage());
		}
	}

}
