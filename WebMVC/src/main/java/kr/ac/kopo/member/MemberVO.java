package kr.ac.kopo.member;

public class MemberVO {

	private String id;
	private String password;
	private String name;
	private String phone;
	private String birthday;

	
	public MemberVO() {
	}
	
	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}



	public MemberVO(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone + ", birthday="
				+ birthday + "]";
	}



	public MemberVO(String id, String password, String name, String phone, String birthday) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.birthday = birthday;
	}
	
	
}
