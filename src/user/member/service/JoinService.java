package user.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import user.member.dao.MemberDao;
import user.member.model.Member;

public class JoinService {
	private MemberDao memberDao = new MemberDao();
	
	public void join(JoinRequest joinReq) {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			Member mem = memberDao.selectById(conn, joinReq.getId());
			
			if(mem != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			Member member = new Member();
			member.setId(joinReq.getId());
			member.setPassword(joinReq.getPassword());
			member.setName(joinReq.getName());
			member.setBirth(joinReq.getBirth());
			member.setGender(joinReq.getGender());
			member.setCellphone(joinReq.getCellphone());
			
			memberDao.insert(conn, member);
			conn.commit();
		}catch(SQLException e) {
			System.out.println("DB연결 실패하거나, SQL문이 틀렸습니다."); 
			System.out.print("사유 : " + e.getMessage());
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
		
	}
}
