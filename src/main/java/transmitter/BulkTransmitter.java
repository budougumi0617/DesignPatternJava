package transmitter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class BulkTransmitter extends JFrame implements Transmitter {

	private JButton sendButton = new JButton(); //送信ボタン
	private JTextField textField;


	public BulkTransmitter(){
		getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(22, 190, 272, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
	}


	@Override
	public void initMember() {
		// TODO 自動生成されたメソッド・スタブ



		sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	action.sendButtonAction(panelComPort.getContent(),
            			panelBaudRate.getContent(),textField.getText());

            }
		});

	}

}