package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Login {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId; // 顧客ID

	@Column(name = "user_name")
	private String userName; // 名前

	private String password;//パスワード

	private String email; // メールアドレス

	private String address; // 住所

	private String status; // 会員情報

	private String status_id; // 会員情報判別

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus_id() {
		return status_id;
	}

	public void setStatus_id(String status_id) {
		this.status_id = status_id;
	}

	//	// コンストラクタ
	//	public Login() {
	//	}
	//
	//	public Login(String userName, String password, String email, String address, String status) {
	//		this.userName = userName;
	//		this.password = password;
	//		this.email = email;
	//		this.address = address;
	//		this.status = status;
	//	}

	// コンストラクタ
	public Login() {
	}

	public Login(String userName, String email, String address) {
		this.userName = userName;
		this.email = email;
		this.address = address;
	}
}
