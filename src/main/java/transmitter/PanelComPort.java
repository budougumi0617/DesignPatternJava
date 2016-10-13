package transmitter;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelComPort extends JPanel implements PanelParameter {

	JLabel labelComPort;
	@SuppressWarnings("rawtypes")
	JComboBox comboComPort;

	public PanelComPort() {
		this.init();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void init() {
		// TODO 自動生成されたメソッド・スタブ

		//コンボボックスに値を設定する
		String[] combodata = {"", "", "", ""};
		comboComPort = new JComboBox(combodata);

		//ラベルに文字を設定する
		labelComPort = new JLabel("COMポート番号");

		//パネル上のコンポーネント配置を設定する


	}

	@Override
	public String getContent() {
		String content = (String)this.comboComPort.getSelectedItem();
		return content;
	}

}