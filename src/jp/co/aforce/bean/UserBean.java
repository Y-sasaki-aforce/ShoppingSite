package jp.co.aforce.bean;

import java.io.Serializable;

public class UserBean implements Serializable {
	 private static final long serialVersionUID = 1L;

	private int member_id;
	private String name;
	private String mail_address;
	private String address;
	private String password;

	public UserBean(
		String name,
		String mail_address,
		String address,
		String password
		) {
			this.name = name;
			this.mail_address = mail_address;
			this.address = address;
			this.password = password;
	}

	public UserBean() {
	}

	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail_address() {
		return mail_address;
	}
	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}