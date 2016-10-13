package transmitter;

import javax.swing.JTextField;

public interface Transmitter{

	JTextField textField = new JTextField();
	PanelComPort panelComPort = new PanelComPort();
	PanelBaudRate panelBaudRate = new PanelBaudRate();
	ActionController action = new ActionController();

	void initMember();

}