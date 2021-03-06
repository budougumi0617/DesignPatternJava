/**
 * @file 2016/10/13
 */
package transmitter.model;

/**
 * 出力インタフェース
 *
 * @author ema195y
 *
 */
public interface OutPut {

	/**
	 * 出力先を接続するメソッドの定義
	 *
	 * @throws Exception
	 *             発生する例外を全てthrowsする
	 */
	void open() throws Exception;

	/**
	 * データを出力するメソッドの定義
	 *
	 * @throws Exception
	 *             発生する例外を全てthrowsする
	 */
	void stream() throws Exception;

	/**
	 * 出力先との接続を閉じるメソッドの定義
	 *
	 * @throws Exception
	 *             発生する例外を全てthrowsする
	 */
	void close() throws Exception;

}