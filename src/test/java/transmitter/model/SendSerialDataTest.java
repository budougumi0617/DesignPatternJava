/**
 * @file 2016/10/19
 */
package transmitter.model;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.io.OutputStream;
import java.lang.reflect.Field;

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

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CommPortIdentifier.class)

/**
 * @author ema195y
 *
 */
public class SendSerialDataTest {

	@InjectMocks
	private SendSerialData ssd;

	@Mock
	private CommPortIdentifier cpiMock;
	@Mock
	private CommPort compMock;
	@Mock
	private SerialPort serialpMock;
	@Mock
	private OutputStream opsMock;

	private Field field;

	/**
	 * テスト初期設定
	 *
	 */
	@Before
	public void setUp() {
		ssd = new SendSerialData();

		/** Mockitの作成 */
		cpiMock = mock(CommPortIdentifier.class);
		compMock = mock(CommPort.class);
		serialpMock = mock(SerialPort.class);
		opsMock = mock(OutputStream.class);

		MockitoAnnotations.initMocks(this);
	}

	/**
	 * テスト終了時動作
	 *
	 */
	@After
	public void tearDown() {
		ssd = null;
		cpiMock = null;
		compMock = null;
		serialpMock = null;
	}

	/**
	 * {@link transmitter.model.SendSerialData#open()} のためのテスト・メソッド。
	 */

	/**
	 * 【正常系】 open()メソッドを呼び出して処理が通るか判定
	 */
	@Test
	public void testOpen() {

		try {
			ssd.setText("hello");
			ssd.setComPort("COM1");
			ssd.setBaudRate("9600");

			/* CommPortIdentifierのstaticメソッドを呼び出すためにMock化する */
			PowerMockito.mockStatic(CommPortIdentifier.class);
			when(CommPortIdentifier.getPortIdentifier((String) anyObject())).thenReturn(cpiMock);

			when(cpiMock.open(Mockito.anyString(), Mockito.anyInt())).thenReturn(serialpMock);
			doNothing().when(serialpMock).setSerialPortParams(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt(),
					Mockito.anyInt());
			doNothing().when(serialpMock).setFlowControlMode(Mockito.anyInt());

			ssd.open();

			PowerMockito.verifyStatic(Mockito.times(1));

			ssd.close();

		} catch (Exception ex) {
			fail(ex.getMessage());
		}

	}

	/**
	 * {@link transmitter.model.SendSerialData#stream()} のためのテスト・メソッド。
	 */

	/**
	 * 【正常系】 stream()メソッドを呼び出して処理が通るか判定
	 */
	@Test
	public void testStream1() {

		try {
			ssd.setText("hello");
			ssd.setComPort("COM1");
			ssd.setBaudRate("9600");

			when(serialpMock.getOutputStream()).thenReturn(opsMock);

			ssd.stream();

		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/**
	 * {@link transmitter.model.SendSerialData#close()} のためのテスト・メソッド。
	 */

	/**
	 * 【正常系】close()メソッドを呼び出した際に例外を排出せずに処理が通るか判定
	 */
	@Test
	public void testClose() {
		try {
			ssd.setText("hello");
			ssd.setComPort("COM1");
			ssd.setBaudRate("9600");

			ssd.close();

		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/**
	 * {@link transmitter.model.SendSerialData#setComPort(java.lang.String)}
	 * のためのテスト・メソッド。
	 */

	/**
	 * 【正常系】 引数で受け取ったString型COMポート番号がメンバに設定されているか判定
	 */
	@Test
	public void testSetComPort() {
		try {
			field = SendSerialData.class.getDeclaredField("comPort");
			field.setAccessible(true);

			ssd.setComPort("COM1");
			assertThat((String) field.get(ssd), is("COM1"));
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/**
	 * {@link transmitter.model.SendSerialData#setBaudRate(java.lang.String)}
	 * のためのテスト・メソッド。
	 */

	/**
	 * 【正常系】 引数で受け取ったString型ボーレートがメンバに設定されているか判定
	 */

	@Test
	public void testSetBaudRate() {
		try {
			field = SendSerialData.class.getDeclaredField("baudRate");
			field.setAccessible(true);

			ssd.setBaudRate("9600");
			assertThat((String) field.get(ssd), is("9600"));
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/**
	 * {@link transmitter.model.SendSerialData#setText(java.lang.String)}
	 * のためのテスト・メソッド。
	 */

	/**
	 * 【正常系】 引数で受け取ったString型入力文字列がメンバに設定されているか判定
	 */
	@Test
	public void testSetText() {
		try {
			field = SendSerialData.class.getDeclaredField("text");
			field.setAccessible(true);

			ssd.setText("hello");
			assertThat((String) field.get(ssd), is("hello"));
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

}
