/**
 * @file 2016/10/18
 */
package transmitter.view;

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
	 *
	 */
	@Before
	public void setUp() {
		pc = new PanelComPort();
	}

	/**
	 * テスト終了時動作
	 *
	 */
	@After
	public void tearDown() {
		pc = null;
	}

	/**
	 * {@link transmitter.PanelComPort#getContent()} のためのテスト・メソッド。
	 */

	/** 【正常系／初期値】 コンボボックスの初期値""が返ってくる */
	@Test
	public void testGetContent1() {
		assertThat(pc.getContent(), is(""));
	}

}