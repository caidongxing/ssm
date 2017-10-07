package hr.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee implements Serializable {
	private Integer id;
	private Dept dept;
	private Job job;
	private String name;
	private String cardId;
	private String address;
	private String postCode;
	private String tel;
	private String phone;
	private String qqNum;
	private String email;
	private Integer sex;
	private String party;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	private String race;
	private String education;
	private String speciality;
	private String hobby;
	private String remark;
	private Date createDate;
	public Employee() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public Dept getDept() {
		return dept;
	}
	public Job getJob() {
		return job;
	}
	public String getName() {
		return name;
	}
	public String getCardId() {
		return cardId;
	}
	public String getAddress() {
		return address;
	}
	public String getPostCode() {
		return postCode;
	}
	public String getTel() {
		return tel;
	}
	public String getPhone() {
		return phone;
	}
	public String getQqNum() {
		return qqNum;
	}
	public String getEmail() {
		return email;
	}
	public Integer getSex() {
		return sex;
	}
	public String getParty() {
		return party;
	}
	public Date getBirthday() {
		return birthday;
	}
	public String getRace() {
		return race;
	}
	public String getEducation() {
		return education;
	}
	public String getSpeciality() {
		return speciality;
	}
	public String getHobby() {
		return hobby;
	}
	public String getRemark() {
		return remark;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setQqNum(String qqNum) {
		this.qqNum = qqNum;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", dept=" + dept + ", job=" + job
				+ ", name=" + name + ", cardId=" + cardId + ", address="
				+ address + ", postCode=" + postCode + ", tel=" + tel
				+ ", phone=" + phone + ", qqNum=" + qqNum + ", email=" + email
				+ ", sex=" + sex + ", party=" + party + ", birthday="
				+ birthday + ", race=" + race + ", education=" + education
				+ ", speciality=" + speciality + ", hobby=" + hobby
				+ ", remark=" + remark + ", createDate=" + createDate + "]";
	}

}
