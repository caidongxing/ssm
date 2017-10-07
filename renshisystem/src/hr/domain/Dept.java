package hr.domain;

import java.io.Serializable;

public class Dept implements Serializable {
	private Integer id;
	private String name;
	private String remark;
	public Dept() {
		super();
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", remark=" + remark + "]";
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getRemark() {
		return remark;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
