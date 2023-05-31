package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class User implements Serializable {
	private String id;
	private String pw;
	private String name;
	private Timestamp date;
	private String cardId;

	public User() {}

	public User(String id) { // IDからユーザ情報を取得するコンストラ
		this.id = id;
	}

	public User(String id, String pw, String name) { //フォームに入力された値を格納するコンストラクタ
		this.id = id;
		this.pw = PasswordHashing.hashPassword(pw); //PWをハッシュ化して格納
		this.name = name;

		// 現在時刻を取得する
		Date now = new Date();
		Timestamp ts = new Timestamp(now.getTime());
		this.date = ts;
	}

	public String getId() {return id;}
	public String getPw() {return pw;}
	public String getName() {return name;}
	public Timestamp getDate() {return date;}
	public String getCardId() {return cardId;}


	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

}