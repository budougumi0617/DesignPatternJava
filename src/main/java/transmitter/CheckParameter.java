/**
 * @file 2016/10/13
 */
package transmitter;

/**
 * コンボボックスで選択されたパラメータの入力値が異常値か判定するクラス
 *
 * @author ema195y
 *
 */
public class CheckParameter {

	/**
	 * 判定メソッドを管理する
	 *
	 * @param content String型 コンボボックス入力値
	 * @return 入力値が正常値ならtrueを返し、異常値ならfalseを返す
	 */
	public boolean validate(String content) {
		if(checkBlank(content)){
			return false;
		}
		return true;
	}

	/**
	 * 入力値が選択されているか判定する
	 *
	 * @param content String型 コンボボックス入力値
	 * @return 入力値が空白の場合trueを返し、値が選択されている場合はfalseを返す
	 */
	private boolean checkBlank(String content){
		return content.equals("");
	}

}