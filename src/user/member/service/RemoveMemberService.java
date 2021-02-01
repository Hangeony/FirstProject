package user.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import user.auth.service.User;
import user.member.dao.MemberDao;
import user.member.model.Member;

public class RemoveMemberService {
	private MemberDao memberDao = new MemberDao();
	
	public void removeMember(User user, String password) {
		
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Member member = memberDao.selectById(conn, user.getId());
			
			if(member == null) {
			throw new MemberNotFoundException();
			}
			if(!member.matchPassword(password)) {
				throw new InvalidPasswordException();
			}
			memberDao.delect(conn, user.getId());
			conn.commit();

		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn);
		}
	}
	

}
