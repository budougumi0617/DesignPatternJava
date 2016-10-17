/**
 * @file 2016/10/13
 */
package transmitter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * エラーダイアログを生成する
 *
 * @author ema195y
 */
public class ErrorDialog {

	/**
	 * コンストラクタ
	 */
	public ErrorDialog(){
	}

	/**
	 * エラーダイアログを生成する
	 *
	 * @param errorMessage
	 * @wbp.parser.entryPoint
	 */
	public void showErrorDialog(String errorMessage){
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, errorMessage);

	}

}
