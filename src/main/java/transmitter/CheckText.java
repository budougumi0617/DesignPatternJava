/**
 * @file 2016/10/13
 */
package transmitter;

/**
 * 入力文字列が異常値か判定するクラス
 *
 * @author ema195y
 */
public class CheckText {

	/**
	 * コンストラクタ
	 */
	public CheckText(){
	}

	/**
	 * 判定メソッドを管理する
	 *
	 * @param text
	 * @return
	 */
	public boolean validate(String text) {
		if(!checkBlank(text)){
			return false;
		}
		if(!checkLength(text)){
			return false;
		}
		if(!checkType(text)){
			return false;
		}
		return true;
	}


	/**
	 * 入力値空白判定
	 *
	 * @param text
	 * @return
	 */
	private boolean checkBlank(String text){
		if(text.matches("[\t 　]+")){
			return false;
		}
		return true;
	}

	/**
	 * 入力値の長さ判定
	 *
	 * @param text
	 * @return
	 */
	private boolean checkLength(String text) {
		if(text.length() > 16){
			return false;
		}
		return true;
	}

	/**
	 * 入力値の半角英数字判定
	 *
	 * @param text
	 * @return
	 */
	private boolean checkType(String text) {
		if(text.matches("^[0-9a-zA-Z]+")){
			return false;
		}
		return true;
	}

}
