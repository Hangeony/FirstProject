package board.article.service;

import java.sql.Connection;
import java.sql.SQLException;

import board.article.dao.ArticleDao;
import board.article.model.Article;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class WriteArticleService {
	private ArticleDao articleDao = new ArticleDao();
 
	public Integer write(WriteArticleRequest req) {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Article article = toArticle(req);
			Article savedArticle = articleDao.insert(conn, article);
			
			if(savedArticle == null) {
				throw new RuntimeException("fail to insert article");
			}
			conn.commit();
			return savedArticle.getNumber();
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}catch(RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
		
	}

	private Article toArticle(WriteArticleRequest req) {
		return new Article(null, req.getWriter(), req.getTitle(), req.getContent(), null, null, 0, 0);
	}
}
