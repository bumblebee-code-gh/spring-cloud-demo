package org.example.entity;

public class User {

	private Integer userId;
	private String userName;
	private String sex;

	public User() {

	}

	public User(Integer userId, String userName, String sex) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", sex=" + sex + "]";
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
