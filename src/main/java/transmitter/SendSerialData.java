/**
 * @file 2016/10/13
 */
package transmitter;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.stream.Stream;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

public class SendSerialData implements OutPut {

	private String comPort;
	private String baudRate;
	private String text;
	private SerialPort port;

	/**
	 * コンストラクタ
	 */
	public SendSerialData(){
	}

	@Override
	public void open() throws {
		   //使用するCOMポートを取得

			//try {
				CommPortIdentifier comID = CommPortIdentifier.getPortIdentifier( comPort );
				CommPort cm = comID.open("Arduino Uno",2000);
				port = (SerialPort)cm;
				port.setSerialPortParams(Integer.parseInt(baudRate) ,SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
				port.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);

			/*} catch (NoSuchPortException e1) {
				// TODO 自動生成された catch ブロック]
				throw e1;
			} catch (PortInUseException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (UnsupportedCommOperationException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				*/
		}
	}

	@Override
	public void stream() {
		try {
			   OutputStream out = port.getOutputStream();

			   Thread.sleep(2000);  //性能上固定の数値とする

			   //一文字ずつ送信する
			   for (int i = 0; i < text.length(); i++) {
				   out.write(text.charAt(i));
			   }
			   
			   //Arrays.streame(text.toCharArray()).forEachOrdered(c -> out.write(c));

			   out.close();

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();

		}
	}

	@Override
	public void close() {
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
