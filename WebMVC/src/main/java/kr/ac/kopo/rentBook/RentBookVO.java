package kr.ac.kopo.rentBook;


public class RentBookVO {
	private int rentNo;
	private String id;
	private String name;
	private String phone;
	private int bookNo;
	private String Title;
	private String Writer;
	private String Publisher;
	private String rentDate;
	private String rtDate;

	public RentBookVO(int rentNo, String id, String name, String phone, int bookNo, String title, String writer,
			String publisher, String rentDate, String rtDate) {
		super();
		this.rentNo = rentNo;
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.bookNo = bookNo;
		Title = title;
		Writer = writer;
		Publisher = publisher;
		this.rentDate = rentDate;
		this.rtDate = rtDate;
	}
	
	public RentBookVO() {
		// TODO Auto-generated constructor stub
	}

	public int getRentNo() {
		return rentNo;
	}
	public void setRentNo(int rentNo) {
		this.rentNo = rentNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getWriter() {
		return Writer;
	}
	public void setWriter(String writer) {
		Writer = writer;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public String getRentDate() {
		return rentDate;
	}
	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}
	public String getRtDate() {
		return rtDate;
	}
	public void setRtDate(String rtDate) {
		this.rtDate = rtDate;
	}
	

	@Override
	public String toString() {
		return "RentBookVO [rentNo=" + rentNo + ", id=" + id + ", name=" + name + ", phone=" + phone + ", bookNo="
				+ bookNo + ", Title=" + Title + ", Writer=" + Writer + ", Publisher=" + Publisher + ", rentDate="
				+ rentDate + ", rtDate=" + rtDate + "]";
	}
}

