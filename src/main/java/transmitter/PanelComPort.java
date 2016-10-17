/**
 * @file 2016/10/13
 */
package transmitter;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * COMポート番号を設定するクラス
 *
 * @author ema195y
 */
public class PanelComPort extends JPanel implements PanelParameter {

	/** COMポートラベル */
	private JLabel labelComPort;
	/** COMポートコンボボックス */
	private JComboBox<> comboComPort;

	/**
	 * コンストラクタ
	 */
	public PanelComPort() {
		setMinimumSize(new Dimension(250, 60));
		this.init();
	}

	/**
	 * コンポーネント初期設定
	 */
	private void init() {
		//コンボボックスに値を設定する
		String[] combodata = new String[256];

		combodata[0] = "";

		for(int i = 1 ; i < 256 ; i++){
			combodata[i] = "COM"+ Integer.toString(i);
		}

		comboComPort = new JComboBox<>(combodata);

		//パネル上のコンポーネント配置を設定する
		setLayout(null);

		labelComPort = new JLabel("COMポート番号");
		labelComPort.setBounds(12, 25, 99, 13);
		add(labelComPort);

		comboComPort.setBounds(129, 22, 99, 19);
		add(comboComPort);
	}

	/**
	 * コンボボックス入力値を返す
	 */
	@Override
	public String getContent() {
		String content = (String)this.comboComPort.getSelectedItem();
		return content;
	}

}