/**
 * @file 2016/10/13
 */
package transmitter.view;

import javax.swing.JTextField;

import transmitter.controller.ActionController;

/**
 * GUI共通コンポーネントを生成するインタフェース
 *
 * @author ema195y
 *
 */
public interface Transmitter {

	/** テキスト入力フィールド */
	JTextField textField = new JTextField();

	/** COMポート番号を設定するcomboBoxを持つパネル */
	PanelComPort panelComPort = new PanelComPort();

	/** ボーレートを設定するcomboBoxを持つパネル */
	PanelBaudRate panelBaudRate = new PanelBaudRate();

	/** ボタン押下時、テキスト入力時の動作を呼び出すActionControllerクラスのインスタンス */
	ActionController action = new ActionController();

}