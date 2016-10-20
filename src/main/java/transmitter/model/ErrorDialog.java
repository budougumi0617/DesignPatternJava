/**
 * @file 2016/10/13
 */
package transmitter.model;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * エラーダイアログを生成する
 *
 * @author ema195y
 *
 */
public class ErrorDialog {

	private JFrame frame = new JFrame();

	/**
	 * エラーダイアログを生成するメソッド
	 *
	 * @param errorMessage
	 *            エラー内容のメッセージ
	 */
	public void showErrorDialog(String errorMessage) {

		JOptionPane.showMessageDialog(frame, errorMessage, "エラー発生", 0);
	}

}
