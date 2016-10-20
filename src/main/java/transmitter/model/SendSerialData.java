/**
 * @file 2016/10/13
 */
package transmitter.model;

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

	/** String型 COMポート番号 */
	private String comPort;
	/** String型 ボーレート */
	private String baudRate;
	/** String型 入力文字列 */
	private String text;
	/** シリアルポート */
	private SerialPort port = null;

	/**
	 * 使用するCOMポートを取得するメソッド
	 * 
	 * @throws Exception
	 *             発生する例外を全てthrowsする
	 * 
	 */

	@Override
	public void open() throws Exception {

		CommPortIdentifier comID = CommPortIdentifier.getPortIdentifier(comPort);
		CommPort cm = comID.open("Arduino Uno", 2000);
		port = (SerialPort) cm;
		port.setSerialPortParams(Integer.parseInt(baudRate), SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
				SerialPort.PARITY_NONE);
		port.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);

	}

	/**
	 * OutPutStreamで文字列データを一文字づつ送信する
	 * 
	 * @throws Exception
	 *             発生する例外を全てthrowsする
	 * 
	 */
	@Override
	public void stream() throws Exception {

		OutputStream out = port.getOutputStream();

		/* 通信の時間差を加味して、送信をずらす性能上固定の数値とする */
		Thread.sleep(2000);

		for (int i = 0; i < text.length(); i++) {
			out.write(text.charAt(i));
		}

		// Arrays.streame(text.toCharArray()).forEachOrdered(c -> out.write(c));

		out.close();
	}

	/**
	 * シリアルポートを閉じるメソッド
	 * 
	 * @throws Exception
	 *             発生する例外を全てthrowsする
	 * 
	 */
	@Override
	public void close() throws Exception {
		port.close();
	}

	/**
	 * セッターメソッド
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
