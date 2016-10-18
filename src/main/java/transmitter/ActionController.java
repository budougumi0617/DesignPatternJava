/**
 * @file 2016/10/13
 */
package transmitter;

import java.io.IOException;

import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;

/**
 * ボタン押下、テキスト入力時の動作を管理するクラス
 *
 * @author ema195y
 */
public class ActionController {

	/**
	 * パラメータの入力値を判定する
	 * CheckParameterクラスのインスタンス
	 */
	private CheckParameter checkParameter = new CheckParameter();

	/**
	 * 入力文字列を判定する
	 * CheckTextクラスのインスタンス
	 */
	private CheckText checkText = new CheckText();

	/**
	 * パラメータコンボボックスの入力値を判定する
	 * CheckParameterクラスのインスタンス
	 */
	private SendSerialData sendSerialData = new SendSerialData();

	/**
	 * パラメータコンボボックスの入力値を判定する
	 * CheckParameterクラスのインスタンス
	 * */
	private ErrorDialog errorDialog = new ErrorDialog();


	/**
	 * コンストラクタ
	 */
	public ActionController(){
	}


	/**
	 * 【要求仕様A】シリアルデータ一括送信
	 *
	 * 送信ボタン押下時の動作を管理する
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
			errorDialog.showErrorDialog("COMポート番号が正しいか確認してください。");
			return;
		} catch(PortInUseException ex){
			errorDialog.showErrorDialog("COMポート番号が正しいか確認してください。");
			return;
		} catch(UnsupportedCommOperationException ex){
			errorDialog.showErrorDialog("COMポート番号が正しいか確認してください。");
			return;
		} catch(IOException ex){
			errorDialog.showErrorDialog("エラーが発生しました。");
			return;
		} catch(InterruptedException ex){
			errorDialog.showErrorDialog("エラーが発生しました。");
			return;
		} catch(Exception e) {
			errorDialog.showErrorDialog("エラーが発生しました。");
			return;
		}

	}

	/**
	 * 【要求仕様B】シリアルデータリアルタイム送信
	 *
	 * 適用ボタン押下時の動作を管理する
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
	 * 【要求仕様B】シリアルデータリアルタイム送信
	 *
	 * テキスト入力時の動作を管理する
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
	 * 【要求仕様B】シリアルデータリアルタイム送信
	 *
	 * シリアルポートを閉じる
	 *
	 * @param comPort
	 * @param baudRate
	 */
	public void closeApp() {
		try{
			sendSerialData.close();
		} catch(Exception ex){
			errorDialog.showErrorDialog("ポートを閉じる際にエラーが発生しました。");
			return;
		}
	}

}