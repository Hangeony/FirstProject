package user.member.service;

import java.util.Map;

public class JoinRequest {
	private String id;
	private String password;
	private String confirmPassword;
	private String name;
	private String birth;
	private String cellphone1;
	private String cellphone2;
	private String cellphone3;
	
	
	
	public void setCellphone1(String cellphone1) {
		this.cellphone1 = cellphone1;
	}

	public void setCellphone2(String cellphone2) {
		this.cellphone2 = cellphone2;
	}

	public void setCellphone3(String cellphone3) {
		this.cellphone3 = cellphone3;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	private String gender;
	private String cellphone;
	
	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public String getName() {
		return name;
	}


	public String getGender() {
		return gender;
	}

	public String getCellphone() {
		return cellphone1 + "-"+ cellphone2+ "-" + cellphone3 ;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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

	public void validate(Map<String, Boolean> errors) {
		checkEmpty(errors, id, "id");
		checkEmpty(errors, password, "password");
		checkEmpty(errors, confirmPassword, "confirmPassword");
		checkEmpty(errors, name, "name");
		checkEmpty(errors, gender, "gender");
		checkEmpty(errors, cellphone1, "cellphone1");
		checkEmpty(errors, cellphone2, "cellphone2");
		checkEmpty(errors, cellphone3, "cellphone3");
		

		if(!errors.containsKey("confirmPassword")) {
			if(!isPasswordEqualToConfirm()) {
				errors.put("notMatch", true);
			}
		}
		
	}
	public boolean isPasswordEqualToConfirm() {
		return password != null && password.equals(confirmPassword);
	}

	private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if(value == null || value.isEmpty()) {
			errors.put(fieldName, true);
		}
	
		
	}
	
}
