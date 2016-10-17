/**
 * @file 2016/10/13
 */
package transmitter;

import javax.swing.JTextField;

/**
 * GUI共通コンポーネントを生成するインタフェース
 *
 * @author ema195y
 */
public interface Transmitter{

	JTextField textField = new JTextField();
	PanelComPort panelComPort = new PanelComPort();
	PanelBaudRate panelBaudRate = new PanelBaudRate();
	ActionController action = new ActionController();

}