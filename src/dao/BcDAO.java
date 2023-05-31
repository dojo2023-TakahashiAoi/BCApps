package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Bc;

public class BcDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Bc> search(String searchQuery, String id) {
		Connection conn = null;
		List<Bc> cardList = new ArrayList<Bc>(); //BCのオブジェクトを格納する用のリスト

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			String sql = "SELECT ID, NAME, COMPANY, DEPARTMENT, POSITION, ADDRESS, EMAIL, PHONE_NUMBER, POST_CODE, MEMO, LINKED_USER, TIMESTAMP " +
		             "FROM BC " +
		             "WHERE ID LIKE ? OR NAME LIKE ? OR COMPANY LIKE ? OR DEPARTMENT LIKE ? OR POSITION LIKE ? OR ADDRESS LIKE ? OR EMAIL LIKE ? OR PHONE_NUMBER LIKE ? OR POST_CODE LIKE ?" +
		             "AND LINKED_USER='" + id + "' ORDER BY TIMESTAMP;";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, "%" + searchQuery + "%");
			pStmt.setString(2, "%" + searchQuery + "%");
			pStmt.setString(3, "%" + searchQuery + "%");
			pStmt.setString(4, "%" + searchQuery + "%");
			pStmt.setString(5, "%" + searchQuery + "%");
			pStmt.setString(6, "%" + searchQuery + "%");
			pStmt.setString(7, "%" + searchQuery + "%");
			pStmt.setString(8, "%" + searchQuery + "%");
			pStmt.setString(9, "%" + searchQuery + "%");

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Bc card = new Bc(
				rs.getString("ID"),
				rs.getString("NAME"),
				rs.getString("COMPANY"),
				rs.getString("DEPARTMENT"),
				rs.getString("POSITION"),
				rs.getString("ADDRESS"),
				rs.getString("EMAIL"),
				rs.getString("PHONE_NUMBER"),
				rs.getString("POST_CODE"),
				rs.getString("MEMO"),
				rs.getString("LINKED_USER"),
				rs.getTimestamp("TIMESTAMP")
				);
				cardList.add(card);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		}

		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		return cardList;
	}


	//　名刺データを登録するメソッド
	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean cardAdd(Bc card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する
		String sql = "INSERT INTO BC VALUES (?, ?, ?,　?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, card.getId());
			pStmt.setString(2, card.getName());
			pStmt.setString(3, card.getCompany());
			pStmt.setString(4, card.getDepartment());
			pStmt.setString(5, card.getPosition());
			pStmt.setString(6, card.getAddress());
			pStmt.setString(7, card.getEmail());
			pStmt.setString(8, card.getPhone_number());
			pStmt.setString(9, card.getPost_code());
			pStmt.setString(10, card.getMemo());
			pStmt.setString(11, card.getLinkedUser());
			pStmt.setTimestamp(12, card.getTimestamp());

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
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

	// 名刺データを更新するメソッド
	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Bc card) {
		Connection conn = null;
		boolean result = false;

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");
			String sql = "UPDATE BC SET NAME=?, COMPANY=?, DEPARTMENT=?, POSITION=?, ADDRESS=?, EMAIL=?, PHONE_NUMBER=?, POST_CODE=?, MEMO=? WHERE ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, card.getName());
			pStmt.setString(2, card.getCompany());
			pStmt.setString(3, card.getDepartment());
			pStmt.setString(4, card.getPosition());
			pStmt.setString(5, card.getAddress());
			pStmt.setString(6, card.getEmail());
			pStmt.setString(7, card.getPhone_number());
			pStmt.setString(8, card.getPost_code());
			pStmt.setString(9, card.getMemo());

			pStmt.setString(10, card.getId());


			try {
			    // 更新処理の実行
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			} catch (Exception e) {
			    e.printStackTrace();
			    // 例外の処理またはエラーメッセージの表示など
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

	//　名刺データを削除するメソッド
	// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
	public boolean delete(String id) {
		Connection conn = null;
		boolean result = false;

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			String sql = "delete from BC where ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
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
