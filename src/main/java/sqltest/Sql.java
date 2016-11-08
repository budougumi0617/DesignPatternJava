package sqltest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Sql {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement ps = null;

		try {

			/* JDBCドライバをロード */
			Class.forName("com.mysql.jdbc.Driver");

			/* DBに接続 */
			con = DriverManager.getConnection("jdbc:mysql://localhost/food?autoReconnect = true & use SSL = false",
					"root", "root");

			/* SQL文作成 表示 */
			String sql = "select * from ramen";

			/* SQL文作成 レコード追加 */
			// String sql = "insert into ramen (id , name) values (2 , 'shio')";

			/* SQL文を事前コンパイル */
			ps = con.prepareStatement(sql);

			/*
			 * 指定されたSQL文を実行する
			 *
			 * executeQuery SELECTなどクエリ結果を取得する executeUpdate
			 * INSERTやUPDATEなどの結果が返されない場合
			 *
			 * executeQueryで作成されたデータはResultSetとして返る
			 */
			ResultSet rs = ps.executeQuery(sql);

			// ps.executeUpdate(sql);

			/* データ表示 */
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");

				System.out.println("id :" + id + " name :" + name);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			/* クローズ作業 */
			try {
				if (ps != null) {
					ps.close();
				}

				if (con != null) {
					con.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
