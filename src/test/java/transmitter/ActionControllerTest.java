/**
 *
 */
package transmitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * ErrorDialogクラスのテスト
 *
 * @author ema195y
 *
 */
public class ActionControllerTest {

	private ActionController ac;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ac = new ActionController();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		ac = null;
	}

	/**
	 * {@link transmitter.ActionController#sendButtonAction(java.lang.String, java.lang.String, java.lang.String)} のためのテスト・メソッド。
	 */

	/** 【正常系】 引数に正常値のCOMポート番号、ボーレート、文字列を渡した際にシリアル通信できるか判定 */
	//@Test
	public void testSendButtonAction1() {
		try{
			ac.sendButtonAction("COM4","9600","s");
		}catch(Exception ex){
			fail(ex.getMessage());
		}
	}

	/** 【異常系／引数】 引数に異常値のCOMポート番号を渡した際に
	 * エラーダイアログ「"COMポート番号が正しいか確認してください。」が出力されるか判定 */
	//@Test
	public void testSendButtonAction2() {
		try{
			ac.sendButtonAction("","9600","hello");
		}catch(Exception ex){
			fail(ex.getMessage());
		}
	}

	/** 【異常系／引数】 引数に異常値のボーレートを渡した際に
	 * エラーダイアログ「"ボーレート（ビット／秒）の値が正しいか確認してください。」が出力されるか判定 */
	//@Test
	public void testSendButtonAction3() {
		try{
			ac.sendButtonAction("COM1","","hello");
		}catch(Exception ex){
			fail(ex.getMessage());
		}
	}

	/** 【異常系／引数】 引数に異常値のメッセージを渡した際に
	 * エラーダイアログ「"メッセージは半角英数字16文字までです。」が出力されるか判定 */
	//@Test
	public void testSendButtonAction4() {
		try{
			ac.sendButtonAction("COM1","9700","こんにちは");
		}catch(Exception ex){
			fail(ex.getMessage());
		}
	}


	/**
	 * {@link transmitter.ActionController#applyButtonAction(java.lang.String, java.lang.String)} のためのテスト・メソッド。

	@Test
	public void testApplyButtonAction() {
		fail("まだ実装されていません");
	}
	*/

	/**
	 * {@link transmitter.ActionController#inputAction(java.lang.String)} のためのテスト・メソッド。

	@Test
	public void testInputAction() {
		fail("まだ実装されていません");
	}

	*/

	/**
	 * {@link transmitter.ActionController#closeApp()} のためのテスト・メソッド。

	@Test
	public void testCloseApp() {
		fail("まだ実装されていません");
	}

	*/


}
