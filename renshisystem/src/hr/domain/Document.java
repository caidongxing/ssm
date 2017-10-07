package hr.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Document implements Serializable {
	private Date createDate;
	private MultipartFile file;
	private String fileName;
	private int id;
	private String remark;
	private String title;
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Document() {
		super();
	}
	public Date getCreateDate() {
		return createDate;
	}
	public MultipartFile getFile() {
		return file;
	}
	public String getFileName() {
		return fileName;
	}
	public int getId() {
		return id;
	}
	public String getRemark() {
		return remark;
	}
	public String getTitle() {
		return title;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Document [createDate=" + createDate + ", file=" + file
				+ ", fileName=" + fileName + ", id=" + id + ", remark="
				+ remark + ", title=" + title + ", user=" + user + "]";
	}
}
