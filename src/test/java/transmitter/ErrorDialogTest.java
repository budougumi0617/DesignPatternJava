/**
 * @file 2016/10/18
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
public class ErrorDialogTest {

	private ErrorDialog ed ;

	/**
	 * テスト初期設定
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ed = new ErrorDialog();
	}

	/**
	 * テスト終了時動作
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		ed = null;
	}

	/**
	 * {@link transmitter.ErrorDialog#showErrorDialog(java.lang.String)} のためのテスト・メソッド。
	 */

	/** 【正常系】 与えられたString引数をエラーダイアログに出力できるか確認 */
	@Test
	public void testShowErrorDialog() {
		try {
			ed.showErrorDialog("エラーメッセージを出力します。");
		}catch(Exception e) {
			fail(e.getMessage());
		}

	}

}
