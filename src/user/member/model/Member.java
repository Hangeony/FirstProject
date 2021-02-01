package user.member.model;

import java.util.Date;

public class Member {
	private String id;
	private String password;
	private String name;
	private String birth;
	private String gender;
	private String cellphone;
	
	public String getId() {
		return id;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}
	public String getCellphone() {
		return cellphone;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	
	public boolean matchPassword(String pwd) {
		return password.equals(pwd);	
	}
	public void changePassword(String newpwd) {
		this.password = newpwd;
	}

}
