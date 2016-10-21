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
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
// SettingsDaoに対して利用
@PrepareForTest(JOptionPane.class)

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

	/**
	 * 【正常系】 showErrorDialog()メソッドを呼び出した際に、JOptionPaneクラスのshowMessageDialog()
	 * が呼び出されているか判定
	 */
	@Test
	public void testShowErrorDialog() {
		try {
			PowerMockito.mockStatic(JOptionPane.class);
			ed.showErrorDialog("エラーメッセージを出力します。");
			PowerMockito.verifyStatic(Mockito.times(1));

		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

}
