/**
 * @file 2016/10/18
 */
package transmitter;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * PanelBaudRateクラスのテスト
 *
 * @author ema195y
 *
 */
public class PanelBaudRateTest {

	private PanelBaudRate pb;

	/**
	 * テスト初期設定
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		pb = new PanelBaudRate();
	}

	/**
	 * テスト終了時動作
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		pb = null;
	}

	/**
	 * {@link transmitter.PanelBaudRate#getContent()} のためのテスト・メソッド。
	 */

	/** 【正常系／初期値】 コンボボックスの初期値""が返ってくる */
	@Test
	public void testGetContent1() {
		assertThat(pb.getContent(),is(""));
	}

}
