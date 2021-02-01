package board.article.service;

import java.sql.Connection;
import java.sql.SQLException;

import board.article.dao.ArticleDao;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import user.auth.service.User;
import user.member.dao.MemberDao;
import user.member.model.Member;

public class DeleteArticleService {
	private MemberDao memberDao = new MemberDao();
	private ArticleDao articleDao = new ArticleDao();

	public void delete(int no, User authUser, String Password) {
		Connection conn = ConnectionProvider.getConnection();
		try {
			conn.setAutoCommit(false);
			Member member = memberDao.selectById(conn, authUser.getId());
			
			if(!member.getPassword().equals(Password)) {
				throw new PermissionDeniedException();
			}
			articleDao.delet(conn, no);
			conn.commit();
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}
	}
}


