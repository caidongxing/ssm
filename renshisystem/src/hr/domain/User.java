package hr.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private Date createDate;
	private Integer id;
	private String loginname;
	private String password;
	private Integer status;
	private String username;
	@Override
	public String toString() {
		return "User [createDate=" + createDate + ", id=" + id + ", loginname="
				+ loginname + ", password=" + password + ", status=" + status
				+ ", username=" + username + "]";
	}
	public User() {
		super();
	}
	public Date getCreateDate() {
		return createDate;
	}
	public Integer getId() {
		return id;
	}
	public String getLoginname() {
		return loginname;
	}
	public String getPassword() {
		return password;
	}
	public Integer getStatus() {
		return status;
	}
	public String getUsername() {
		return username;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
