/**
 * @file 2016/10/13
 */
package transmitter.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * シリアルデータ一括送信GUIを生成するクラス
 *
 * @author ema195y
 *
 */
public class BulkTransmitter extends JFrame implements Transmitter {

	/** 送信ボタン */
	private JButton sendButton = new JButton("送信");

	/**
	 * フレームの設定と初期設定メソッドinitMember()を呼び出すコンストラクタ
	 */
	public BulkTransmitter() {
		setTitle("Arduinoシリアルデータ送信アプリ");
		setBounds(100, 100, 586, 287);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.initMember();
		setVisible(true);
	}

	/**
	 * コンポーネント初期設定メソッド
	 */
	private void initMember() {

		/* GUIレイアウトの選択 */
		getContentPane().setLayout(null);

		/* テキスト入力フィールド初期設定 */
		textField.setBounds(12, 171, 407, 20);
		getContentPane().add(textField);
		textField.setColumns(16);

		/* 送信ボタンの初期設定 */
		sendButton.setBounds(454, 171, 91, 21);
		getContentPane().add(sendButton);

		/* COMポート番号を設定するcomboBoxを持つパネルの初期設定 */
		panelComPort.setBounds(12, 32, 250, 60);
		getContentPane().add(panelComPort);

		/* ボーレートを設定するcomboBoxを持つパネルの初期設定 */
		panelBaudRate.setBounds(274, 32, 280, 60);
		getContentPane().add(panelBaudRate);

		/* 送信ボタン押下時のアクションを設定 */
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action.sendButtonAction(panelComPort.getContent(), panelBaudRate.getContent(), textField.getText());

			}
		});
	}

}