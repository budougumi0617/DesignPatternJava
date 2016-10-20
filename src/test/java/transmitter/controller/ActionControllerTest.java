/**
 *
 */
package transmitter.controller;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;
import transmitter.model.CheckParameter;
import transmitter.model.CheckText;
import transmitter.model.ErrorDialog;
import transmitter.model.SendSerialData;

/**
 * ErrorDialogクラスのテスト
 *
 * @author ema195y
 *
 */
public class ActionControllerTest {

	@InjectMocks
	private ActionController ac;

	@Mock
	private SendSerialData ssdMock;
	@Mock
	private ErrorDialog edMock;
	@Mock
	private CheckParameter cpMock;
	@Mock
	private CheckText ctMock;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		ac = new ActionController();

		/** Mockitの作成 */
		ssdMock = mock(SendSerialData.class);
		edMock = mock(ErrorDialog.class);
		cpMock = mock(CheckParameter.class);
		ctMock = mock(CheckText.class);

		MockitoAnnotations.initMocks(this);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		ac = null;
		ssdMock = null;
		edMock = null;
		cpMock = null;
		ctMock = null;
	}

	/* 要求仕様A */

	/**
	 * {@link transmitter.ActionController#sendButtonAction(java.lang.String, java.lang.String, java.lang.String)}
	 * のためのテスト・メソッド。
	 */

	/**
	 * 【正常系】 引数に正常値のCOMポート番号、ボーレート、文字列を渡した際にシリアル通信できるか判定
	 */
	@Test
	public void testSendButtonAction1() {
		try {
			when(cpMock.validate("COM1")).thenReturn(true);
			when(cpMock.validate("9600")).thenReturn(true);
			when(ctMock.validate("hello")).thenReturn(true);

			ac.sendButtonAction("COM1", "9600", "hello");
			verify(edMock, never()).showErrorDialog((String)anyObject());

		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/**
	 * 【異常系／引数】引数に異常値のCOMポート番号を渡した際にErrorDialogクラスのshowErrorDialogメソッドに
	 * 「COMポート番号が正しいか確認してください。」が引数として渡されるか判定
	 */
	@Test
	public void testSendButtonAction2() {
		try {
			when(cpMock.validate("9600")).thenReturn(true);
			when(cpMock.validate("")).thenReturn(false);
			when(ctMock.validate("hello")).thenReturn(true);

			ac.sendButtonAction("", "9600", "hello");
			verify(edMock).showErrorDialog("COMポート番号が正しいか確認してください。");

		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/**
	 * 【異常系／引数】 引数に異常値のボーレートを渡した際にErrorDialogクラスのshowErrorDialogメソッドに
	 * 「ボーレート（ビット／秒）の値が正しいか確認してください。」が引数として渡されるか判定
	 */
	@Test
	public void testSendButtonAction3() {
		try {
			when(cpMock.validate("COM1")).thenReturn(true);
			when(cpMock.validate("")).thenReturn(false);
			when(ctMock.validate("hello")).thenReturn(true);

			ac.sendButtonAction("COM1", "", "hello");
			verify(edMock).showErrorDialog("ボーレート（ビット／秒）の値が正しいか確認してください。");

		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/**
	 * 【異常系／引数】 引数に異常値のメッセージを渡した際にErrorDialogクラスのshowErrorDialogメソッドに
	 * 「メッセージは半角英数字16文字までです。」が引数として渡されるか判定
	 */
	@Test
	public void testSendButtonAction4() {
		try {
			when(cpMock.validate("COM1")).thenReturn(true);
			when(cpMock.validate("9600")).thenReturn(true);
			when(ctMock.validate("こんにちは")).thenReturn(false);

			ac.sendButtonAction("COM1", "9600", "こんにちは");
			verify(edMock).showErrorDialog("メッセージは半角英数字16文字までです。");

		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/**
	 * 【異常系／エラー】 SendSerialDataクラスopenメソッドでNoSuchPortExceptionエラーを検出した際に
	 * ErrorDialogクラスのshowErrorDialogメソッドに「COMポート番号が正しいか確認してください。」が引数として渡されるか判定
	 */
	@Test
	public void testSendButtonAction5() {
		try {
			when(cpMock.validate("COM1")).thenReturn(true);
			when(cpMock.validate("9600")).thenReturn(true);
			when(ctMock.validate("hello")).thenReturn(true);

			doThrow(new NoSuchPortException()).when(ssdMock).open();

			doNothing().when(edMock).showErrorDialog("COMポート番号が正しいか確認してください。");
			ac.sendButtonAction("COM1", "9600", "hello");
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/**
	 * 【異常系／エラー】 SendSerialDataクラスopenメソッドでPortInUseExceptionエラーを検出した際に
	 * ErrorDialogクラスのshowErrorDialogメソッドに「COMポート番号が正しいか確認してください。」が引数として渡されるか判定
	 */
	@Test
	public void testSendButtonAction6() {
		try {
			when(cpMock.validate("COM1")).thenReturn(true);
			when(cpMock.validate("9600")).thenReturn(true);
			when(ctMock.validate("hello")).thenReturn(true);

			doThrow(new PortInUseException()).when(ssdMock).open();

			doNothing().when(edMock).showErrorDialog("COMポート番号が正しいか確認してください。");
			ac.sendButtonAction("COM1", "9600", "hello");
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/**
	 * 【異常系／エラー】
	 * SendSerialDataクラスopenメソッドでUnsupportedCommOperationExceptionエラーを検出した際に
	 * ErrorDialogクラスのshowErrorDialogメソッドに「COMポート番号が正しいか確認してください。」が引数として渡されるか判定
	 */
	@Test
	public void testSendButtonAction7() {
		try {
			when(cpMock.validate("COM1")).thenReturn(true);
			when(cpMock.validate("9600")).thenReturn(true);
			when(ctMock.validate("hello")).thenReturn(true);

			doThrow(new UnsupportedCommOperationException()).when(ssdMock).open();

			doNothing().when(edMock).showErrorDialog("COMポート番号が正しいか確認してください。");
			ac.sendButtonAction("COM1", "9600", "hello");
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/**
	 * 【異常系／エラー】 SendSerialDataクラスstreamメソッドでExceptionエラーを検出した際に
	 * ErrorDialogクラスのshowErrorDialogメソッドに「エラーが発生しました。」が引数として渡されるか判定
	 */
	@Test
	public void testSendButtonAction8() {
		try {
			when(cpMock.validate("COM1")).thenReturn(true);
			when(cpMock.validate("9600")).thenReturn(true);
			when(ctMock.validate("hello")).thenReturn(true);

			doThrow(new Exception()).when(ssdMock).stream();

			doNothing().when(edMock).showErrorDialog("エラーが発生しました。");
			ac.sendButtonAction("COM1", "9600", "hello");
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/* 要求仕様B */

	/**
	 * {@link transmitter.ActionController#applyButtonAction(java.lang.String, java.lang.String)}
	 * のためのテスト・メソッド。
	 *
	 * @Test public void testApplyButtonAction() { fail("まだ実装されていません"); }
	 */

	/**
	 * {@link transmitter.ActionController#inputAction(java.lang.String)}
	 * のためのテスト・メソッド。
	 *
	 * @Test public void testInputAction() { fail("まだ実装されていません"); }
	 *
	 */

	/**
	 * {@link transmitter.ActionController#closeApp()} のためのテスト・メソッド。
	 *
	 * @Test public void testCloseApp() { fail("まだ実装されていません"); }
	 *
	 */

}
