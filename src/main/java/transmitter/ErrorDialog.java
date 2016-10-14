package transmitter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorDialog {

	public ErrorDialog(){
	}

	public void showErrorDialog(String errorMessage){

		//エラーダイアログの生成
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, errorMessage);

	}

}
