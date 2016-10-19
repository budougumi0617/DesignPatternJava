/**
 * @file 2016/10/13
 */
package transmitter.model;

/**
 * 入力文字列が異常値か判定するクラス
 *
 * @author ema195y
 *
 */
public class CheckText {

	/** 入力値の最大文字数 */
	private final int TEXT_MAX_LENGTH = 16;

	/**
	 * 判定メソッドを管理する
	 *
	 * @param text
	 *            String型 入力文字列
	 * @return 入力値が正常値の場合trueを返し、異常値の場合falseを返す
	 */
	public boolean validate(String text) {
		if (checkBlank(text) || checkLength(text) || checkType(text)) {
			return false;
		}
		return true;
	}

	/**
	 * 入力値に空白（タブキー全角・半角スペース）が含まれているか判定する
	 *
	 * @param text
	 *            String型 入力文字列
	 * @return 入力値に空白が含まれている場合trueを返し、含まれていなければfalseを返す
	 */
	private boolean checkBlank(String text) {
		return text.matches("" + "[\t 　]*+");
	}

	/**
	 * 入力値の文字数が16文字以内か判定する
	 *
	 * @param text
	 *            String型 入力文字列
	 * @return 入力値が17字以上の場合trueを返し、16字以内の場合falseを返す
	 */
	private boolean checkLength(String text) {
		return text.length() > TEXT_MAX_LENGTH;
	}

	/**
	 * 入力値が半角英数字か判定する
	 *
	 * @param text
	 *            String型 入力文字列
	 * @return 入力値が半角英数字でない場合trueを返し、半角英数字の場合falseを返す
	 */
	private boolean checkType(String text) {
		return text.matches("[^0-9a-zA-Z]+");
	}

}
