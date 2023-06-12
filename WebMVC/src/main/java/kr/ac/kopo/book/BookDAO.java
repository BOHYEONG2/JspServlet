package kr.ac.kopo.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.ConnectionFactory;

public class BookDAO {

	public void insertBook(BookVO book) throws Exception {
        String sql = "INSERT INTO books (no, title, writer, publisher) VALUES (t_book_no.nextval , ?, ?, ?)";
        
        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
         
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getWriter());
            pstmt.setString(3, book.getPublisher());
            
            pstmt.executeUpdate();
            
            System.out.println("책 등록 성공!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public BookVO getBook(BookVO vo) {
		BookVO book = null;
		 String sql = "SELECT * FROM books";
		try {
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
       if (rs.next()) {
            int no = rs.getInt("no");
            String title = rs.getString("title");
            String writer = rs.getString("writer");
            String publisher = rs.getString("publisher");
            boolean isAvailable = rs.getInt("isavailable") == 1;
            book = new BookVO(no, title, writer, publisher,isAvailable);	    	     
       }
				
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public List<BookVO> getBookList(BookVO vo) {
        List<BookVO> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        
        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
     
                int no = rs.getInt("no");
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                String publisher = rs.getString("publisher");
                boolean isAvailable = rs.getInt("isavailable") == 0;
           
                BookVO book = new BookVO(no, title, writer, publisher,isAvailable);
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return books;
    }


	public void deleteBook(BookVO book)  {
		String sql = "DELETE FROM books WHERE no = ?"; 
		
		try (Connection conn = new ConnectionFactory().getConnection();
		     PreparedStatement pstmt = conn.prepareStatement(sql)) {
		        
		        pstmt.setInt(1, book.getNo());
		        pstmt.executeUpdate(); 

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	}

	public List<BookVO> searchBook(BookVO searchBook) {
		List<BookVO> bookList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("select instr((no || title || writer || publisher), ?)as booksearch");
		sql.append(" , no, title, writer, publisher, isavailable");
		sql.append(" from books");
		sql.append(" where instr((no || title || writer || publisher), ?) != 0");
		sql.append(" order by no");	
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());	){
			
			 pstmt.setString(1, searchBook.getTitle());
		     pstmt.setString(2, searchBook.getTitle());
			
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BookVO book = new BookVO();
				book.setNo(rs.getInt("no"));
				book.setTitle(rs.getString("title"));
				book.setWriter(rs.getString("writer"));
				book.setPublisher(rs.getString("publisher"));
				
				int isAvailableValue = rs.getInt("isavailable");
			    boolean isAvailable = isAvailableValue == 1 ? true : false;
			    book.setIsAvailable(isAvailable);
			    
	//			book.setIsavailable(rs.getBoolean("isavailable"));
				
				bookList.add(book);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}
	
	public void rentAvailable(int bookNo) {
		
	      StringBuilder sql = new StringBuilder();
	      sql.append("update books set isavailable = 1 where no = ?");
	      try (Connection conn = new ConnectionFactory().getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
	         pstmt.setInt(1, bookNo);
	         pstmt.executeUpdate();
	
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }

	public void rentCheck(int bookNo) {
		StringBuilder sql = new StringBuilder();
		sql.append("update books set isavailable = 0 where no = ?");
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
}
	

