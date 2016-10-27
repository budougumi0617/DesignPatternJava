/**
 * @file 2016/10/13
 */
package transmitter;

import transmitter.view.BulkTransmitter;
import transmitter.view.Transmitter;

/**
 * mainメソッドを持つクラス
 *
 * @author ema195y
 *
 */
public class Main {

	/**
	 * 通信アプリGUIインスタンスを生成する
	 *
	 * @param args
	 *            引数
	 */
	public static void main(String[] args) {

		/** 【要求仕様A】シリアルデータ一括送信 */
		@SuppressWarnings("unused")
		Transmitter bulkTransmitter = new BulkTransmitter();

		/** 【要求仕様B】シリアルデータリアルタイム送信 */
		/*
		 * @SuppressWarnings("unused") Transmitter RealTimeTransmitter = new
		 * RealTimeTransmitter();
		 */

	}

}