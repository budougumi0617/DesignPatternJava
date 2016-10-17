/**
 * @file 2016/10/13
 */
package transmitter;

import java.io.IOException;

import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;

/**
 * ボタン押下、入力時の動作を管理するクラス
 *
 * @author ema195y
 */
public class ActionController {

	private CheckParameter checkParameter = new CheckParameter();
	private CheckText checkText = new CheckText();
	private SendSerialData sendSerialData = new SendSerialData();
	private ErrorDialog errorDialog = new ErrorDialog();

	/**
	 * コンストラクタ
	 */
	public ActionController(){
	}

/**
 * 送信ボタン押下アクション
 *
 * @param comPort
 * @param baudRate
 * @param text
 */
	public void sendButtonAction(String comPort, String baudRate, String text) {

		//シリアルデータ通信パラメータの判定
		if(!checkParameter.validate(comPort)){
			errorDialog.showErrorDialog("COMポート番号が正しいか確認してください。");
			return;
		};
		if(!checkParameter.validate(baudRate)){
			errorDialog.showErrorDialog("ボーレート（ビット／秒）の値が正しいか確認してください。");
			return;
		};

		//文字列の判定
		if(!checkText.validate(text)){
			errorDialog.showErrorDialog("メッセージは半角英数字16文字までです。");
			return;
		};

		//シリアルデータ送信
		try{
			sendSerialData.setComPort(comPort);
			sendSerialData.setBaudRate(baudRate);
			sendSerialData.setText(text);

			sendSerialData.open();
			sendSerialData.stream();
			sendSerialData.close();

		} catch(NoSuchPortException ex){
			errorDialog.showErrorDialog("");
			return;
		} catch(PortInUseException ex){
			errorDialog.showErrorDialog("");
			return;
		} catch(UnsupportedCommOperationException ex){
			errorDialog.showErrorDialog("");
			return;
		} catch(IOException ex){
			errorDialog.showErrorDialog("");
			return;
		} catch(InterruptedException ex){
			errorDialog.showErrorDialog("");
			return;
		} catch(Exception e) {
			errorDialog.showErrorDialog("");
			return;
		}

	}

/**
 * 適用ボタン押下アクション
 *
 * @param comPort
 * @param baudRate
 */
	public void applyButtonAction(String comPort, String baudRate) {

		//シリアルデータ通信パラメータの判定
		if(!checkParameter.validate(comPort)){
			errorDialog.showErrorDialog("COMポート番号が正しいか確認してください。");
			return;
		};
		if(!checkParameter.validate(baudRate)){
			errorDialog.showErrorDialog("ボーレート（ビット／秒）の値が正しいか確認してください。");
			return;
		};

		sendSerialData.setComPort(comPort);
		sendSerialData.setBaudRate(baudRate);
	}

/**
 * テキスト入力アクション
 *
 * @param text
 */
	public void inputAction(String text) {

		//文字列の判定
		if(!checkText.validate(text)){
			errorDialog.showErrorDialog("メッセージは半角英数字16文字までです。");
			return;
		};

		//シリアルデータ送信
		try{
			sendSerialData.setText(text);

			sendSerialData.open();
			sendSerialData.stream();
		} catch(Exception ex){
			errorDialog.showErrorDialog("通信設定が正常に完了していません。");
			return;
		}
	}

/**
 * シリアルポートクローズアクション
 *
 * @param comPort
 * @param baudRate
 */
	public void closeApp() {

		//シリアルポートを閉じる
		try{
			sendSerialData.close();
		} catch(Exception ex){
			errorDialog.showErrorDialog("ポートを閉じる際にエラーが発生しました");
			return;
		}
	}

}