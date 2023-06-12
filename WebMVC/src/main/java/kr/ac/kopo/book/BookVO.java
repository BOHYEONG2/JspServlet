package kr.ac.kopo.book;

import java.util.Date;

public class BookVO {

	private int no;
	private String title;
	private String writer;
	private String publisher;
	private boolean isAvailable;
	
	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public boolean getIsAvailable() {
		return isAvailable;
	}


	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	

	public BookVO() {
		super();
	}


	public BookVO(int no, String title, String writer, String publisher, boolean isAvailable) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.isAvailable = isAvailable;
	}


	@Override
	public String toString() {
		return "BookVO [no=" + no + ", title=" + title + ", writer=" + writer + ", publisher=" + publisher
				+ ",  isAvailable=" + isAvailable + "]";
	}
	
	
	
}
