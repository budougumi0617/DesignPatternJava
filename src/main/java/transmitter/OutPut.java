/**
 * @file 2016/10/13
 */
package transmitter;

import gnu.io.NoSuchPortException;

/**
 * 出力インタフェース
 *
 * @author z00s600078
 */
public interface OutPut {

	void open() throws Exception;
	void stream() th;
	void close();

}