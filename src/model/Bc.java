package model;
import java.io.Serializable;

public class Bc implements Serializable {
	private String number;	// NUMBER
	private String name;	// NAME
	private String address;	// ADDRESS

	public Bc(String number, String name, String address) {
		this.number = number;
		this.name = name;
		this.address = address;
	}

	public Bc() {
		this.number = "";
		this.name = "";
		this.address = "";
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
