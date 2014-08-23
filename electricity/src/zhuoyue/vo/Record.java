package zhuoyue.vo;

import java.util.List;

public class Record
{
	public int getPlanCode() {
		return planCode;
	}
	public void setPlanCode(int planCode) {
		this.planCode = planCode;
	}
	public static final int COUNTFFRONT = 5;
	public static final int COUNTBEHIND = 3;
	private int name;
	private int id;
	private String code;
	private String date;
	private String userCode;
	private String userName;
	private String remark;
	private int state;
	private List<String> parameter;
	private int planCode;
	public List<String> getParameter() {
		return parameter;
	}
	public void setParameter(List<String> parameter) {
		this.parameter = parameter;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
