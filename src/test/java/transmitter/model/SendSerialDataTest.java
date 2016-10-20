/**
 * @file 2016/10/19
 */
package transmitter.model;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

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
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ssd = new SendSerialData();
		MockitoAnnotations.initMocks(this);

		/** Mockitの作成 */
		cpiMock = mock(CommPortIdentifier.class);
		compMock = mock(CommPort.class);
		serialpMock = mock(SerialPort.class);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		ssd = null;
		cpiMock = null;
		compMock = null;
		serialpMock = null;
	}

	/**
	 * {@link transmitter.model.SendSerialData#open()} のためのテスト・メソッド。
	 */
	@Test
	public void testOpen() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link transmitter.model.SendSerialData#stream()} のためのテスト・メソッド。
	 */
	@Test
	public void testStream() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link transmitter.model.SendSerialData#close()} のためのテスト・メソッド。
	 */
	@Test
	public void testClose() {
		fail("まだ実装されていません");
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
			assertThat((String)field.get(ssd), is("COM1"));
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
			assertThat((String)field.get(ssd), is("9600"));
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
			assertThat((String)field.get(ssd), is("hello"));
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

}
