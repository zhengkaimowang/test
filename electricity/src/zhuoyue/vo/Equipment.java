package zhuoyue.vo;

public class Equipment {
	private String code;
	private String typecode;
	private String typename;
	private String project;
	private String subproject;
	private String address;
	private String date;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTypecode() {
		return typecode;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getTypename() {
		return typename;
	}

	private String producer;
}
