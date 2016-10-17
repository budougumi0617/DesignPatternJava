/**
 * @file 2016/10/13
 */
package transmitter;

/**
 * パラメータコンボボックス入力値が異常値か判定するクラス
 *
 * @author ema195y
 */
public class CheckParameter {

	/**
	 * コンストラクタ
	 */
	public CheckParameter(){
	}

	/**
	 * 判定メソッドを管理する
	 *
	 * @param content
	 * @return 
	 */
	public boolean validate(String content) {
		if(!checkBlank(content)){
			return false;
		}
		return true;
	}

	/**
	 * 入力値空白判定
	 *
	 * @param content
	 * @return
	 */
	private boolean checkBlank(String content){
		if(content.equals("[null ]+")){
			return false;
		}
		return true;
	}

}