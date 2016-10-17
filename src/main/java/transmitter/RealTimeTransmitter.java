/**
 * @file 2016/10/13
 */
package transmitter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * シリアルデータリアルタイム送信GUIを生成するクラス
 *
 * @author ema195y
 */
public class RealTimeTransmitter extends JFrame implements Transmitter {

	private JButton applyButton = new JButton("適用"); //適用ボタン

	/**
	 * コンストラクタ
	 */
	public RealTimeTransmitter(){
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

		textField.setBounds(12, 171, 546, 20);
		getContentPane().add(textField);
		textField.setColumns(16);

		applyButton.setBounds(411, 111, 91, 21);
		getContentPane().add(applyButton);

		panelComPort.setBounds(12, 32, 250, 60);
		getContentPane().add(panelComPort);

		panelBaudRate.setBounds(274, 32, 280, 60);
		getContentPane().add(panelBaudRate);

		//適用ボタンアクション
		applyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	action.applyButtonAction(panelComPort.getContent(),
            			panelBaudRate.getContent());
            }
		});
		
		//ボタンアクション
		textField.getDocument
		addDocumentListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	action.sendButtonAction(panelComPort.getContent(),
            			panelBaudRate.getContent(),textField.getText());

            }
		});
	}

}