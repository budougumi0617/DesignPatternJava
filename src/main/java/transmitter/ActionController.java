/**
 * @file 2016/10/13
 */
package transmitter;

/**
 * 
 * 
 * @author ema195y
 *
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
 *
 *
 * @param comPort
 * @param baudRate
 * @param text
 */
	public void sendButtonAction(String comPort, String baudRate, String text) {
		// TODO 自動生成されたメソッド・スタブ

		//シリアルデータ通信パラメータの判定
		if(!checkParameter.validate(comPort)){
			errorDialog.showErrorDialog("");
			return;
		};

		if(!checkParameter.validate(baudRate)){
			errorDialog.showErrorDialog("");
		};

		//文字列の判定
		if(!checkText.validate(text)){
			errorDialog.showErrorDialog("");
		};

		//シリアルデータ送信
		try{




		} catch(Exception ex){
			errorDialog.showErrorDialog("");
		}

	}

/**
 * 
 * @param comPort
 * @param baudRate
 */
	public void applyButtonAction(String comPort, String baudRate) {
		// TODO 自動生成されたメソッド・スタブ

		//シリアルデータ通信パラメータの判定
		if(!checkParameter.validate(comPort)){
			errorDialog.showErrorDialog("");
		};

		if(!checkParameter.validate(baudRate)){
			errorDialog.showErrorDialog("");
		};
	}


	public void inputAction(String text) {
		// TODO 自動生成されたメソッド・スタブ

		//文字列の判定
		if(!checkText.validate(text)){
			errorDialog.showErrorDialog("");
		};

		//シリアルデータ送信
		try{




		} catch(Exception ex){
			errorDialog.showErrorDialog("");
		}
	}

	public void closeApp(String comPort, String baudRate) {
		// TODO 自動生成されたメソッド・スタブ

		//シリアルポートを閉じる
		try{




		} catch(Exception ex){
			errorDialog.showErrorDialog("");
		}
	}


}