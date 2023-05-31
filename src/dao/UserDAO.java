package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAO {
	public User show(User user) { //IDからユーザ情報を取得するDAO
		Connection conn = null;

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			String sql = "select ID, PW, USERNAME, DATE, CARDID from UserAccount where ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getId());

			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
			    // String name = rs.getString("USERNAME");
			    // String cardID = rs.getString("cardID");
			    user.setName(rs.getString("USERNAME"));
			    user.setDate(rs.getTimestamp("DATE"));
			    user.setCardId(rs.getString("CARDID"));
			} else {
			    // 指定したIDに対応するデータが存在しない場合の処理
			    System.out.println("指定されたIDに対応するデータが見つかりませんでした");
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
		return user;
	}
}
