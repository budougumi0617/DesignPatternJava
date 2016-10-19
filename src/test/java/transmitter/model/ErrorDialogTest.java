/**
 * @file 2016/10/18
 */
package transmitter.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * ErrorDialogクラスのテスト
 *
 * @author ema195y
 *
 */
public class ErrorDialogTest {

	@InjectMocks
	private ErrorDialog ed;

	@Mock
	private JOptionPane jopMock;
	@Mock
	private JFrame fMock;

	/**
	 * テスト初期設定
	 *
	 * @throws java.lang.Exception
	 */

	@SuppressWarnings("static-access")
	@Before
	public void setUp() throws Exception {
		ed = new ErrorDialog();

		jopMock = mock(JOptionPane.class);
		fMock = mock(JFrame.class);

		MockitoAnnotations.initMocks(this);

		doNothing().when(jopMock).showMessageDialog(fMock, "エラーメッセージを出力します。", "エラー発生", jopMock.ERROR_MESSAGE);
	}

	/**
	 * テスト終了時動作
	 *
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		ed = null;
	}

	/**
	 * {@link transmitter.ErrorDialog#showErrorDialog(java.lang.String)}
	 * のためのテスト・メソッド。
	 */

	/** 【正常系】 与えられたString引数をエラーダイアログに出力できるか確認 */

	@Test
	public void testShowErrorDialog() {
		try {
			ed.showErrorDialog("エラーメッセージを出力します。");
		} catch (Exception ex) {
			fail(ex.getMessage());
		}

	}

}
