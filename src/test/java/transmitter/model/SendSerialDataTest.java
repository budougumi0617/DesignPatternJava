/**
 * @file 2016/10/19
 */
package transmitter.model;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.legacy.PowerMockRunner;

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

	private Field field;

	/**
	 * テスト初期設定
	 *
	 */
	@Before
	public void setUp() {
		ssd = new SendSerialData();
		MockitoAnnotations.initMocks(this);

		/** Mockitの作成 */
		cpiMock = mock(CommPortIdentifier.class);
		compMock = mock(CommPort.class);
		serialpMock = mock(SerialPort.class);

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
	 * 【正常系】 open()メソッドを呼び出した際getPortIdentifierを一度呼び出しているか判定
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testOpen1() {
		try {
			ssd.setText("hello");
			ssd.setComPort("COM1");
			ssd.setBaudRate("9600");

			PowerMockito.mockStatic(CommPortIdentifier.class);

			when(CommPortIdentifier.getPortIdentifier((String) anyObject())).thenReturn(cpiMock);

			ssd.open();

			verify(cpiMock, times(1)).getPortIdentifier((String) anyObject());

		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/**
	 * 【正常系】 open()メソッドを呼び出した際CommPortIdentifierクラスのopen()を一度呼び出しているか判定
	 */
	@Test
	public void testOpen2() {
		try {
			ssd.setText("hello");
			ssd.setComPort("COM1");
			ssd.setBaudRate("9600");

			ssd.open();
			verify(cpiMock, times(1)).open((String) anyObject(), (Integer) anyObject());

		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/**
	 * 【正常系】 open()メソッドを呼び出した際SerialPortクラスのsetSerialPortParams()を一度呼び出しているか判定
	 */
	@Test
	public void testOpen3() {
		try {
			ssd.setText("hello");
			ssd.setComPort("COM1");
			ssd.setBaudRate("9600");

			ssd.open();

			verify(serialpMock, times(1)).setSerialPortParams((Integer) anyObject(), (Integer) anyObject(),
					(Integer) anyObject(), (Integer) anyObject());

		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/**
	 * 【正常系】 open()メソッドを呼び出した際SerialPortクラスのsetFlowControlMode()を一度呼び出しているか判定
	 */
	@Test
	public void testOpen4() {
		try {
			ssd.setText("hello");
			ssd.setComPort("COM1");
			ssd.setBaudRate("9600");

			ssd.open();

			verify(serialpMock, times(1)).setFlowControlMode((Integer) anyObject());

		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/**
	 * {@link transmitter.model.SendSerialData#stream()} のためのテスト・メソッド。
	 */

	/**
	 * 【正常系】 stream()メソッドを呼び出した際OutputStreamクラスのgetOutputStream()を一度呼び出しているか判定
	 */
	@Test
	public void testStream1() {
		try {
			ssd.setText("hello");
			ssd.setComPort("COM1");
			ssd.setBaudRate("9600");

			ssd.stream();

			verify(serialpMock, times(1)).getOutputStream();

		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/**
	 * 【正常系】 stream()メソッドを呼び出した際OutputStreamクラスのgetOutputStream()を一度呼び出しているか判定
	 */
	@Test
	public void testStream2() {
		try {
			ssd.setText("hello");
			ssd.setComPort("COM1");
			ssd.setBaudRate("9600");

			ssd.open();
			ssd.stream();

			verify(serialpMock, times(1)).close();

		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/**
	 * 【異常系】 stream()メソッドのOutPutStreamから例外IOExceptionが返ったときThrowされるか判定
	 */
	@Test
	public void testStream3() {
		try {
			ssd.setText("hello");
			ssd.setComPort("COM1");
			ssd.setBaudRate("9600");

			when(serialpMock.getOutputStream()).thenThrow(new IOException());
			ssd.open();
			ssd.stream();

		} catch (IOException ex) {
			assertThat(ex, is(instanceOf(IOException.class)));
			try {
				ssd.close();
			} catch (Exception e) {
			}
		} catch (Exception ex) {
			fail(ex.getMessage());
			try {
				ssd.close();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * 【異常系】 portを開かずにstream()メソッドを呼び出すと例外NullPointerExceptionが返るか判定
	 */
	@Test
	public void testStream4() {
		try {
			ssd.setText("hello");
			ssd.setComPort("COM1");
			ssd.setBaudRate("9600");

			ssd.stream();

		} catch (NullPointerException ex) {
			assertThat(ex, is(instanceOf(NullPointerException.class)));
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/**
	 * {@link transmitter.model.SendSerialData#close()} のためのテスト・メソッド。
	 */

	/**
	 * 【正常系】SerialPortクラスのポートが開いているとき、close()メソッドで正常に閉じることができるか判定
	 */
	@Test
	public void testClose1() {
		try {
			ssd.setText("hello");
			ssd.setComPort("COM1");
			ssd.setBaudRate("9600");

			ssd.open();
			ssd.close();

		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	/**
	 * 【正常系】ポートが開いていない状態でclose()を呼び出しても例外は発生しないことの判定
	 */
	@Test
	public void testClose2() {
		try {
			ssd.close();
			verify(serialpMock, times(1)).close();

			// TODO time
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
