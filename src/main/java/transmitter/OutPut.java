/**
 * @file 2016/10/13
 */
package transmitter;

/**
 * 出力インタフェース
 *
 * @author ema195y
 */
public interface OutPut {

	/**
	 * 出力先を接続するメソッドの定義
	 * @throws Exception
	 */
	void open() throws Exception;

	/**
	 * データを出力するメソッドの定義
	 * @throws Exception
	 */
	void stream() throws Exception;

	/**
	 * 出力先との接続を閉じるメソッドの定義
	 * @throws Exception
	 */
	void close() throws Exception;

}