/**
 * @file 2016/10/13
 */
package transmitter.model;

import javax.swing.JOptionPane;

/**
 * エラーダイアログを生成する
 *
 * @author ema195y
 *
 */
public class ErrorDialog {

	/**
	 * エラーダイアログを生成するメソッド
	 *
	 * @param errorMessage
	 *            String型 エラー内容のメッセージ
	 */
	public void showErrorDialog(String errorMessage) {

		Object[] selectvalue = { "戻る" };
		JOptionPane.showOptionDialog(null, errorMessage, "エラー発生", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE,
				null, selectvalue, null);

	}

}
