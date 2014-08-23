package zhuoyue.vo;

public class Problem {
	private int code;
	private String typename;
	private String typecode;
	private String project;
	private String subproject;
	private String date;
	private String problemState;
	private String equipmentcode;

	public void setEquipmentcode(String equipmentcode) {
		this.equipmentcode = equipmentcode;
	}

	public String getEquipmentcode() {
		return equipmentcode;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getSubproject() {
		return subproject;
	}

	public void setSubproject(String subproject) {
		this.subproject = subproject;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getProblemState() {
		return problemState;
	}

	public void setProblemState(String problemState) {
		this.problemState = problemState;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	public String getTypecode() {
		return typecode;
	}

}
