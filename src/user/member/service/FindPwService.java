package user.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import user.member.dao.MemberDao;

public class FindPwService {
	private MemberDao memberDao = new MemberDao();
	
	public String findMember(String id) {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			String password = memberDao.findPw(conn, id);
			if(password.isEmpty()) {
				return "";
			}
			return password;
		}catch(SQLException e) {
			System.out.println("DB연결 실패하거나, SQL문이 틀렸습니다."); 
			System.out.print("사유 : " + e.getMessage());
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
	}

}
