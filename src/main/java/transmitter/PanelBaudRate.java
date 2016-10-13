package transmitter;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBaudRate extends JPanel implements PanelParameter {

	JLabel labelBaudRate;
	@SuppressWarnings("rawtypes")
	JComboBox comboBaudRate;

	public PanelBaudRate() {
		init();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void init() {
		// TODO 自動生成されたメソッド・スタブ

		//コンボボックスに値を設定する
		String[] combodata = {"", "", "", ""};
		comboBaudRate = new JComboBox(combodata);

		//ラベルに文字を設定する
		labelBaudRate = new JLabel("ボーレート（ビット/秒）");

		//パネル上のコンポーネント配置を設定する


	}

	@Override
	public String getContent() {
		String content = (String)comboBaudRate.getSelectedItem();
		return content;
	}

}