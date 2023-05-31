package model;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class Bc implements Serializable {
	private String id;	// ID
	private String name;	// NAME
	private String company;
	private String department;
	private String position;
	private String address;	// ADDRESS
	private String email;
	private String phone_number;
	private String post_code;
	private String memo;
	private String linkedUser;
	private Timestamp timestamp;

	public Bc(String id) {
		this.id = id;
	}

	// 名刺の検索用
	public Bc(String id, String name, String company, String department, String position, String address, String email, String phone_number, String post_code, String memo, String linkedUser, Timestamp ts) {
		this.id = id;
		this.name = name;
		this.company = company;
		this.department = department;
		this.position = position;
		this.address = address;
		this.email = email;
		this.phone_number = phone_number;
		this.post_code = post_code;
		this.memo = memo;
		this.linkedUser = linkedUser;
		this.timestamp = ts;
	}

	public Bc() {}

	// 名刺の新規登録用
	public Bc(String name, String company, String department, String position, String address, String email, String phone_number, String post_code, String memo, String linkedId) {
		UUID uuid = UUID.randomUUID(); // 一意のUUIDを生成
		String uuidString = uuid.toString();

		this.id = uuidString;
		this.name = name;
		this.company = company;
		this.department = department;
		this.position = position;
		this.address = address;
		this.email = email;
		this.phone_number = phone_number;
		this.post_code = post_code;
		this.memo = memo;
		this.linkedUser = linkedId;

		// 現在時刻を取得する
		Date now = new Date();
		Timestamp ts = new Timestamp(now.getTime());
		this.timestamp = ts;
	}

	// 名刺の更新用
	public void update(String id, String name, String company, String department, String position, String address, String email, String phone_number, String post_code, String memo) {
		this.id = id;
		this.name = name;
		this.company = company;
		this.department = department;
		this.position = position;
		this.address = address;
		this.email = email;
		this.phone_number = phone_number;
		this.post_code = post_code;
		this.memo = memo;
	}


	public String getId() {return id;}
	public String getName() {return name;}
	public String getAddress() {return address;}
	public String getCompany() {return company;}
	public String getDepartment() {return department;}
	public String getPosition() {return position;}
	public String getEmail() {return email;}
	public String getPhone_number() {return phone_number;}
	public String getPost_code() {return post_code;}
	public String getMemo() {return memo;}
	public String getLinkedUser() {return linkedUser;}
	public Timestamp getTimestamp() {return timestamp;}

	public void setId(String id) { this.id = id; }
	public void setName(String name) { this.name = name; }
	public void setAddress(String address) { this.address = address; }
	public void setCompany(String company) { this.company = company; }
	public void setDepartment(String department) { this.department = department; }
	public void setPosition(String position) { this.position = position; }
	public void setEmail(String email) { this.email = email; }
	public void setPhone_number(String phone_number) { this.phone_number = phone_number; }
	public void setPost_code(String post_code) { this.post_code = post_code; }
	public void setMemo(String memo) { this.memo = memo; }
	public void setLinkedUser(String linkedUser) { this.linkedUser = linkedUser; }
	public void setTimestamp(Timestamp timestamp) { this.timestamp = timestamp; }


}
