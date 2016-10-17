/**
 * @file 2016/10/13
 */
package transmitter;

/**
 * 出力インタフェース
 *
 * @author z00s600078
 */
public interface OutPut {

	void open() throws Exception;
	void stream() throws Exception;
	void close() throws Exception;

}