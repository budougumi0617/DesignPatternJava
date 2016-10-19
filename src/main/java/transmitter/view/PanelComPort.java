/**
 * @file 2016/10/13
 */
package transmitter.view;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * COMポート番号を設定するクラス
 *
 * @author ema195y
 *
 */
public class PanelComPort extends JPanel implements PanelParameter {

	/** COMポートラベル */
	private JLabel labelComPort;
	/** COMポートコンボボックス */
	private JComboBox<String> comboComPort;
	/** COMポートコンボボックスの最大格納数 */
	private final int CONTENT_MAX_NUM = 257;

	/**
	 * 初期設定メソッドinit()を呼び出すコンストラクタ
	 */
	public PanelComPort() {
		setMinimumSize(new Dimension(250, 60));
		this.init();
	}

	/**
	 * コンポーネント初期設定
	 */
	private void init() {
		/* コンボボックスに値を設定する */
		String[] combodata = new String[CONTENT_MAX_NUM];

		/* コンボボックス初期値の設定 */
		combodata[0] = "";

		for (int i = 1; i < CONTENT_MAX_NUM; i++) {
			combodata[i] = "COM" + Integer.toString(i);
		}

		comboComPort = new JComboBox<String>(combodata);

		/* パネル上のコンポーネント配置を設定する */
		setLayout(null);

		/* COMポート番号ラベルの配置 */
		labelComPort = new JLabel("COMポート番号");
		labelComPort.setBounds(12, 25, 99, 13);
		add(labelComPort);

		/* ボーレート選択コンボボックスの配置 */
		comboComPort.setBounds(129, 22, 99, 19);
		add(comboComPort);
	}

	/**
	 * コンボボックス入力値を返す
	 *
	 * @return
	 */
	@Override
	public String getContent() {
		return comboComPort.getItemAt(comboComPort.getSelectedIndex());
	}

}