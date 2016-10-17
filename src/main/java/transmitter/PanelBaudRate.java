/**
 * @file 2016/10/13
 */
package transmitter;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ボーレートを設定するクラス
 *
 * @author ema195y
 */
public class PanelBaudRate extends JPanel implements PanelParameter {

	/** ボーレートラベル */
	private JLabel labelBaudRate;
	/** ボーレートコンボボックス */
	private JComboBox<String> comboBaudRate;

	/**
	 * コンストラクタ
	 */
	public PanelBaudRate() {
		setMinimumSize(new Dimension(280, 60));
		this.init();
	}

	/**
	 * コンポーネント初期設定
	 */
	private void init() {
		//コンボボックスに値を設定する
		String[] comboData = {"","75","110","134","150","300","600","1200","1800",
				"2400","4800","7200","9600","14400","19200","38400","57600","115200","128000"};
		comboBaudRate = new JComboBox<String>(comboData);

		//パネル上のコンポーネント配置を設定する
		setLayout(null);

		labelBaudRate = new JLabel("ボーレート(ビット/秒)");
		labelBaudRate.setBounds(12, 25, 140, 13);
		add(labelBaudRate);

		comboBaudRate.setBounds(169, 22, 99, 19);
		add(comboBaudRate);
	}

	/**
	 * コンボボックス入力値を返す
	 */
	@Override
	public String getContent() {
		return comboBaudRate.getItemAt(comboBaudRate.getSelectedIndex());
	}

}