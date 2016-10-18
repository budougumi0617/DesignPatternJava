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
 * PanelComPortクラスのテスト
 *
 * @author ema195y
 *
 */
public class PanelComPortTest {

	private PanelComPort pc;

	/**
	 * テスト初期設定
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		pc = new PanelComPort();
	}

	/**
	 * テスト終了時動作
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		pc = null;
	}

	/**
	 * {@link transmitter.PanelComPort#getContent()} のためのテスト・メソッド。
	 */

	/** 【正常系／初期値】 コンボボックスの初期値""が返ってくる */
	@Test
	public void testGetContent1() {
		assertThat(pc.getContent(),is(""));
	}

}