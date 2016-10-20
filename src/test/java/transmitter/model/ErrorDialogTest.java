/**
 * @file 2016/10/18
 */
package transmitter.model;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
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
	 */
	@Before
	public void setUp() {
		ed = new ErrorDialog();

		/** Mockitの作成 */
		jopMock = mock(JOptionPane.class);
		fMock = mock(JFrame.class);

		MockitoAnnotations.initMocks(this);

	}

	/**
	 * テスト終了時動作
	 *
	 */
	@After
	public void tearDown() {
		ed = null;
		jopMock = null;
		fMock = null;
	}

	/**
	 * {@link transmitter.ErrorDialog#showErrorDialog(java.lang.String)}
	 * のためのテスト・メソッド。
	 */

	/** 【正常系】 与えられたString引数をエラーダイアログに出力できるか確認 */

	@Test
	public void testShowErrorDialog() {
		try {
			doNothing().when(jopMock).showMessageDialog((JFrame) anyObject(), (String) anyObject(),
					(String) anyObject(), 0);
			ed.showErrorDialog("エラーメッセージを出力します。");
			verify(jopMock).showMessageDialog((JFrame) anyObject(), "エラーメッセージを出力します。", "エラー発生", 0);
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

}
