package kr.ac.kopo.rentBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionFactory;

public class RentBookDAO {

	public void rentBook(RentBookVO vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into rental (rentno, id, no) values(seq_rental_no.nextval, ?, ?) ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
			
			pstmt.setString(1, vo.getId());
			pstmt.setInt(2, vo.getBookNo());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	public void returnBook(int bookNo) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from rental where no = ?");
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			pstmt.setInt(1, bookNo);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

		// 대출 도서 목록 조회
	    public List<RentBookVO> getRentedBooks(String id) {
	        List<RentBookVO> rentedBooks = new ArrayList<>();

	        StringBuilder sql = new StringBuilder();
	        sql.append("SELECT r.rentNo, r.id, m.name, m.phone, r.no AS bookNo, b.title AS bookTitle, ");
	        sql.append("b.writer AS bookWriter, b.publisher AS bookPublisher, r.rentDate ");
	        sql.append("FROM rental r ");
	        sql.append("JOIN books b ON r.no = b.no ");
	        sql.append("JOIN t_member2 m ON r.id = m.id ");
	        sql.append("WHERE r.id = ?");

	        try (
	            Connection conn = new ConnectionFactory().getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	        ) {
	            pstmt.setString(1, id);

	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	            	int rentNo = rs.getInt("rentNo");
	            	String name = rs.getString("name");
	            	String phone = rs.getString("phone");
	            	int bookNo = rs.getInt("bookNo");
	            	String bookTitle = rs.getString("bookTitle");
	            	String bookWriter = rs.getString("bookWriter");
	            	String bookPublisher = rs.getString("bookPublisher");
	            	String rentDate = rs.getString("rentDate");
	            	String rtDate = rs.getString("rentDate");  // 반환 날짜 열의 별칭을 수정




	            	RentBookVO rentedBook = new RentBookVO(rentNo, id, name, phone, bookNo, bookTitle, bookWriter, bookPublisher, rentDate, rtDate);
	                rentedBooks.add(rentedBook);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return rentedBooks;
	    }


	}
	
	
	
	


