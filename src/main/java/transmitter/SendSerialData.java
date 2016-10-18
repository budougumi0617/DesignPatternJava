/**
 * @file 2016/10/13
 */
package transmitter;

import java.io.OutputStream;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;


/**
 * シリアルデータ通信クラス
 *
 * @author ema195y
 *
 */
public class SendSerialData implements OutPut {

	private String comPort;
	private String baudRate;
	private String text;
	private SerialPort port;

	@Override
	public void open() throws Exception{

		   //使用するCOMポートを取得
				CommPortIdentifier comID = CommPortIdentifier.getPortIdentifier( comPort );
				CommPort cm = comID.open("Arduino Uno",2000);
				port = (SerialPort)cm;
				port.setSerialPortParams(Integer.parseInt(baudRate) ,SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
				port.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);

	}

	@Override
	public void stream() throws Exception {

			   OutputStream out = port.getOutputStream();

			   Thread.sleep(2000);  //性能上固定の数値とする

			   //一文字ずつ送信する
			   for (int i = 0; i < text.length(); i++) {
				   out.write(text.charAt(i));
			   }

			   //Arrays.streame(text.toCharArray()).forEachOrdered(c -> out.write(c));

			   out.close();
	}

	@Override
	public void close() throws Exception{
		port.close();
	}

	/**
	 * セッター
	 */
	public void setComPort(String comPort) {
		this.comPort = comPort;
	}

	public void setBaudRate(String baudRate) {
		this.baudRate = baudRate;
	}

	public void setText(String text) {
		this.text = text;
	}

}
