package kr.ac.kopo.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionFactory;

public class MemberDAO {
	
	public MemberVO login(MemberVO login) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 오라클 드라이버 로드
		String user = "hr";
		String pass = "hr";
		
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("  from t_member2 ");
		sql.append(" where id = ? and password = ? ");
		// SQL 쿼리를 작성하기 위한 StringBuilder 객체입니다.
		// 해당 쿼리는 t_member2 테이블에서 id와 password가 일치하는 회원 정보를 조회합니다.
		
		try(
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			
			pstmt.setString(1, login.getId());
			pstmt.setString(2, login.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				MemberVO loginUser = new MemberVO();
				loginUser.setId(rs.getString("id"));
				loginUser.setPassword(rs.getString("password"));
				loginUser.setName(rs.getString("name"));
				loginUser.setPhone(rs.getString("phone"));
				loginUser.setBirthday(rs.getString("birthday"));
				
				return loginUser;
			}
		}
		return null;
	}

	public void insertUser(MemberVO vo) {
	    StringBuilder sql = new StringBuilder();
	    sql.append("insert into t_member2(id, password, name, phone, birthday) values(?, ?, ?, ?, to_date(?, 'yyyyMMdd'))");

	    try (Connection conn = new ConnectionFactory().getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
	        pstmt.setString(1, vo.getId());
	        pstmt.setString(2, vo.getPassword());
	        pstmt.setString(3, vo.getName());
	        pstmt.setString(4, vo.getPhone());
	        pstmt.setString(5, vo.getBirthday());

	        pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
//	public void insertUser(MemberVO vo) {
//	    StringBuilder sql = new StringBuilder();
//	    sql.append("INSERT INTO t_member2(id, password, name, phone, birthday) VALUES (?, ?, ?, ?, TRUNC(TO_DATE(?, 'yyyyMMdd')))");
//
//	    try (Connection conn = new ConnectionFactory().getConnection();
//	         PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
//	        pstmt.setString(1, vo.getId());
//	        pstmt.setString(2, vo.getPassword());
//	        pstmt.setString(3, vo.getName());
//	        pstmt.setString(4, vo.getPhone());
//	        pstmt.setString(5, new SimpleDateFormat("yyyyMMdd").format(vo.getBirthday()));
//
//	        pstmt.executeUpdate();
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	}
	public void deleteUser(MemberVO vo) {

		StringBuilder sql = new StringBuilder();
		sql.append("delete from t_member2 where id = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, vo.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean checkDuplicateId(String id) {
	    StringBuilder sql = new StringBuilder();
	    sql.append("SELECT id FROM t_member2 WHERE id = ?");
	    
	    try (
	        Connection conn = new ConnectionFactory().getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	    ) {
	        pstmt.setString(1, id);
	        ResultSet rs = pstmt.executeQuery();
	        
	        if (rs.next()) {
	            // If the result set has any rows, it means the ID already exists
	            return true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return false;
	}
	
	public MemberVO getUser(String id) {
	    StringBuilder sql = new StringBuilder();
	    sql.append("SELECT * FROM t_member2 WHERE id = ?");
	    
	    try (
	        Connection conn = new ConnectionFactory().getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	    ) {
	        pstmt.setString(1, id);
	        ResultSet rs = pstmt.executeQuery();
	        
	        if (rs.next()) {
	            MemberVO user = new MemberVO();
	            user.setId(rs.getString("id"));
	            user.setPassword(rs.getString("password"));
	            user.setName(rs.getString("name"));
	            user.setPhone(rs.getString("phone"));
	            user.setBirthday(rs.getString("birthday"));
	            
	            return user;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return null;
	}
	

	 public void updateInfo(MemberVO vo) throws Exception {
		
		    StringBuilder sql = new StringBuilder();
		    sql.append("UPDATE t_member2 ");
		    sql.append("SET password = ?, name = ?, phone = ? ");
		    sql.append("WHERE id = ?");

		    try (Connection conn = new ConnectionFactory().getConnection();
		         PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

		        pstmt.setString(1, vo.getPassword());
		        pstmt.setString(2, vo.getName());
		        pstmt.setString(3, vo.getPhone());
		        pstmt.setString(4, vo.getId());

		        pstmt.executeUpdate();
		       
		    } catch (Exception e) {
		        e.printStackTrace();
		        throw new Exception("회원 정보 업데이트 중 오류가 발생했습니다.");
		    }
		}
	 
	 public List<MemberVO> allUsers(){
		    List<MemberVO> userList = new ArrayList<>();
		    MemberVO user = null;
		    StringBuilder sql = new StringBuilder();
		    sql.append("select id, password, name, phone, birthday from t_member2 where id != 'manager' order by id ");
		    try (
		        Connection conn = new ConnectionFactory().getConnection();
		        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		    ){
		        ResultSet rs = pstmt.executeQuery();
		        while(rs.next()) {
		            user = new MemberVO();
		            user.setId(rs.getString("id"));
		            user.setPassword(rs.getString("password"));
		            user.setName(rs.getString("name"));
		            user.setPhone(rs.getString("phone"));
		            user.setBirthday(rs.getString("birthday"));
		                    
		            userList.add(user);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return userList;
		}
	 
	 
	
	
	}
	
	
	
			

