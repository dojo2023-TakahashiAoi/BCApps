package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import model.User;

public class RegisterDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	// 引数userで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(User user) {
		Connection conn = null;
		boolean result = false;

		// 現在時刻を取得する
		Date now = new Date();
		Timestamp ts = new Timestamp(now.getTime());

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する
			String sql = "insert into UserAccount (ID, PW, UserName, Date) values (?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getId());
			pStmt.setString(2, user.getPw());
			pStmt.setString(3, user.getName());
			pStmt.setTimestamp(4, ts);

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
				System.out.println("データの挿入/更新が成功しました。");
			} else {
			    System.out.println("データの挿入/更新が失敗しました。");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
}
