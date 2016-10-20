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
 * PanelBaudRateクラスのテスト
 *
 * @author ema195y
 *
 */
public class PanelBaudRateTest {

	private PanelBaudRate pb;

	/**
	 * テスト初期設定
	 *
	 */
	@Before
	public void setUp() {
		pb = new PanelBaudRate();
	}

	/**
	 * テスト終了時動作
	 *
	 */
	@After
	public void tearDown() {
		pb = null;
	}

	/**
	 * {@link transmitter.PanelBaudRate#getContent()} のためのテスト・メソッド。
	 */

	/** 【正常系／初期値】 コンボボックスの初期値""が返ってくる */
	@Test
	public void testGetContent1() {
		assertThat(pb.getContent(), is(""));
	}

}
