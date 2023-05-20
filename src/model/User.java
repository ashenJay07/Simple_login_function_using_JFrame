package model;

public class User {
	private String userName;
	private String fullName;
	private String userType;
	private String address;
	private String phone;
	private String password;
	
	public User(String userName, String fullName, String userType, String address, String phone, String password) {
		this.userName = userName;
		this.fullName = fullName;
		this.userType = userType;
		this.address = address;
		this.phone = phone;
		this.password = password;
	}

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public String getFullName() {
		return fullName;
	}

	public String getUserType() {
		return userType;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getPassword() {
		return password;
	}

}
