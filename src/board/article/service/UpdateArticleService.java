package board.article.service;

import java.sql.Connection;
import java.sql.SQLException;

import board.article.dao.ArticleDao;
import board.article.model.Article;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class UpdateArticleService {
	private ArticleDao articleDao = new ArticleDao();
	
	public void update(UpdateRequest upReq) {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Article article = articleDao.selectById(conn, upReq.getArticleNumber());
			
			if(article == null) {
				throw new ArticleNotFoundException();
			}
			if(!conModify(upReq.getUserId(), article)) {
				throw new PermissionDeniedException();
			}
			articleDao.update(conn, upReq.getArticleNumber(), upReq.getTitle(), upReq.getContent());
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException();
		}catch(PermissionDeniedException e) {
			JdbcUtil.rollback(conn);
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
	}

	private boolean conModify(String userId, Article article) {
		return article.getWriter().getId().equals(userId);
	}


}
