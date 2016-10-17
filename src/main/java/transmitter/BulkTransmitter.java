/**
 * @file 2016/10/13
 */
package transmitter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * シリアルデータ一括送信GUIを生成するクラス
 *
 * @author ema195y
 */
public class BulkTransmitter extends JFrame implements Transmitter {

	/** 送信ボタン */
	private JButton sendButton = new JButton("送信");

	/**
	 * コンストラクタ
	 */
	public BulkTransmitter(){
	    setTitle("シリアルデータ通信アプリケーション");
	    setBounds(100, 100, 586, 287);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.initMember();
	}

	/**
	 * コンポーネント初期設定
	 *
	 */
	private void initMember() {

		getContentPane().setLayout(null);

		textField.setBounds(12, 171, 407, 20);
		getContentPane().add(textField);
		textField.setColumns(16);

		sendButton.setBounds(454, 171, 91, 21);
		getContentPane().add(sendButton);

		panelComPort.setBounds(12, 32, 250, 60);
		getContentPane().add(panelComPort);

		panelBaudRate.setBounds(274, 32, 280, 60);
		getContentPane().add(panelBaudRate);

		// 送信ボタンアクション
		sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	action.sendButtonAction(panelComPort.getContent(),
            			panelBaudRate.getContent(),textField.getText());

            }
		});
	}

}