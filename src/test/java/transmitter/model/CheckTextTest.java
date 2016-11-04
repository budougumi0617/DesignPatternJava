/**
 * @file 2016/10/17
 */
package transmitter.model;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * CeckTextクラスのテスト
 *
 * @author ema195y
 *
 */
public class CheckTextTest {

	private CheckText ct;
	private Method method;

	/**
	 * テスト初期設定
	 *
	 */
	@Before
	public void setUp() {
		ct = new CheckText();
	}

	/**
	 * テスト終了時動作
	 *
	 */
	@After
	public void tearDown() {
		ct = null;
		method = null;
	}

	/**
	 * {@link transmitter.CheckText#validate(java.lang.String)} のためのテスト・メソッド。
	 */

	/** 【正常系】 半角英数かつ16文字以下かつ空白を含まない場合trueを返す
	 *
	 * テスト項目書 IT004-1
	 *  */
	@Test
	public void testValidate1() {
		assertThat(ct.validate("hello"), is(true));
	}

	/** 【異常系】 半角英数でない、または17文字以上、または空白を含む場合falseを返す
	 *
	 *  テスト項目書 IT004-5
	 *  */
	@Test
	public void testValidate2() {
		assertThat(ct.validate("こんにちは"), is(false));
	}

	/** 【正常系】 半角英数かつ16文字以下かつ空白を含む場合falseを返す
	 *
	 * テスト項目書 IT004-9
	 *  */
	@Test
	public void testValidate3() {
		assertThat(ct.validate("ab c"), is(false));
	}

	/**
	 * {@link transmitter.CheckText#CheckBlank(java.lang.String)} のためのテスト・メソッド。
	 */

	/** 【正常系】 文字列に空白がない場合falseを返すか判定 */
	@Test
	public void testCheckBlank1() {
		try {
			method = CheckText.class.getDeclaredMethod("checkBlank", String.class);
			method.setAccessible(true);
			assertThat(method.invoke(ct, "あいうえお"), is(false));
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/** 【異常系】 文字列に空白がある場合trueを返すか判定
	 *
	 *  テスト項目書 IT004-10
	 *  */
	@Test
	public void testCheckBlank2() {
		try {
			method = CheckText.class.getDeclaredMethod("checkBlank", String.class);
			method.setAccessible(true);
			assertThat(method.invoke(ct, "		"), is(true));
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/**
	 * {@link transmitter.CheckText#CheckLength(java.lang.String)} のためのテスト・メソッド。
	 */
	/** 【正常系】 文字列が16文字以下の場合falseを返すか判定
	 *
	 *  テスト項目書 IT004-15
	 *  */
	@Test
	public void testCheckLength1() {
		try {
			method = CheckText.class.getDeclaredMethod("checkLength", String.class);
			method.setAccessible(true);
			assertThat(method.invoke(ct, "koreha16mojidesu"), is(false));
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/** 【異常系】 文字列が17文字以上の場合trueを返すか判定
	 *
	 *  テスト項目書 IT004-16
	 *  */
	@Test
	public void testCheckLength2() {
		try {
			method = CheckText.class.getDeclaredMethod("checkLength", String.class);
			method.setAccessible(true);
			assertThat(method.invoke(ct, "koreha17mojidesu!"), is(true));
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/**
	 * {@link transmitter.CheckText#CheckType(java.lang.String)} のためのテスト・メソッド。
	 */

	/** 【正常系】 文字列が半角英数字の場合falseを返すか判定
	 *
	 *  テスト項目書 IT004-6
	 *  */
	@Test
	public void testCheckType1() {
		try {
			method = CheckText.class.getDeclaredMethod("checkType", String.class);
			method.setAccessible(true);
			assertThat(method.invoke(ct, "aiueo"), is(false));
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/** 【異常系】 文字列が半角英数字以外の文字を含む場合trueを返すか判定
	 *
	 *  テスト項目書 IT004-5
	 *  */
	@Test
	public void testCheckType2() {
		try {
			method = CheckText.class.getDeclaredMethod("checkType", String.class);
			method.setAccessible(true);
			assertThat(method.invoke(ct, "あいうえお"), is(true));
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/** 【異常系】 文字列が半角英数字と半角英数字以外の文字を含む場合trueを返すか判定
	 *
	 * テスト項目書 IT004-7,8
	 *  */
	@Test
	public void testCheckType3() {
		try {
			method = CheckText.class.getDeclaredMethod("checkType", String.class);
			method.setAccessible(true);
			assertThat(method.invoke(ct, "aａ1１"), is(true));
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

}
