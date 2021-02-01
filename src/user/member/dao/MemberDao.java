package user.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;*/

import jdbc.JdbcUtil;
import user.member.model.Member;

public class MemberDao {
	/*
	 * private Date toDate(Timestamp timestamp) { return timestamp == null ? null :
	 * new Date(timestamp.getTime()) ; }
	 */
	public Member selectById(Connection conn, String id) throws SQLException{

		String sql ="SELECT * FROM mem WHERE id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();


			Member member = null;
			if(rs.next()) {

				member = new Member();
				member.setId(rs.getString("id"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				/*
				 * if(rs.getTimestamp("birth") != null) { SimpleDateFormat transFormat = new
				 * SimpleDateFormat("YYYY-MM-dd"); String to =
				 * transFormat.format(rs.getTimestamp("birth")); member.setBirth(to);
				 * 
				 * }
				 */
				member.setBirth(rs.getString("birth"));
				member.setGender(rs.getString("gender"));
				member.setCellphone(rs.getString("cellphone"));
			}
			return member;
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(" SQL문이 틀렸습니다."); 
			System.out.print("사유 : " + e.getMessage());
			throw e;
		}finally {
			JdbcUtil.close(rs, pstmt);
		}
	}

	public void insert(Connection conn, Member member) throws SQLException{
		System.out.println(member);
		String sql = "INSERT INTO mem(id,password,name,birth,gender,cellphone)  " + 
				"VALUES(?,?,?, TO_DATE(?, 'YYYYMMDD') ,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getBirth());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getCellphone());

			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			JdbcUtil.close(pstmt);
		}
	}

	public void update(Connection conn, Member member) throws SQLException {
		String sql = "UPDATE mem SET name = ?, password = ? WHERE id =?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getId());

			pstmt.executeUpdate();
		}


	}

	public void delect(Connection conn, String id) throws SQLException {
		String sql = "DELETE mem WHERE id = ? ";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}

	}
	public String findId(Connection conn, String cellphone) throws SQLException {
		String sql="SELECT id FROM mem WHERE cellphone = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cellphone);
			rs = pstmt.executeQuery();

			Member member = null;
			if(rs.next()) {
				member = new Member();
				member.setId(rs.getString("id"));
				return member.getId();
			}
			return "";
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(" SQL문이 틀렸습니다."); 
			System.out.print("사유 : " + e.getMessage());
			throw e;
		}finally {
			JdbcUtil.close(rs, pstmt);
		}
	}
	public String findPw(Connection conn, String id) throws SQLException {
		String sql="SELECT password FROM mem WHERE id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			Member member = null;
			if(rs.next()) {
				member = new Member();
				member.setPassword(rs.getString("password"));
				return member.getPassword();
			}
			return "";
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(" SQL문이 틀렸습니다."); 
			System.out.print("사유 : " + e.getMessage());
			throw e;
		}finally {
			JdbcUtil.close(rs,pstmt);
		}
	}
}

