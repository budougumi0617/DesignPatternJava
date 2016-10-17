/**
 * @file 2016/10/13
 */
package transmitter;

/**
 * mainメソッドを持つクラス
 *
 * @author ema195y
 */
public class Main {

	/**
	 * 通信アプリGUIインスタンスを生成する
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		BulkTransmitter bulkTransmitter = new BulkTransmitter();
		bulkTransmitter.setVisible(true);
	}

}