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
		if(!checkBlank(text) || !checkLength(text) || !checkType(text)){
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
		return text.matches("[\t 　]+");
	}

	/**
	 * 入力値の長さ判定
	 *
	 * @param text
	 * @return
	 */
	private boolean checkLength(String text) {
		return text.length() > 16;
	}

	/**
	 * 入力値の半角英数字判定
	 *
	 * @param text
	 * @return
	 */
	private boolean checkType(String text) {
		return text.matches("^[0-9a-zA-Z]+");
	}

}
