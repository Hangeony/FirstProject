 package board.article.service;

import java.sql.Connection;
import java.sql.SQLException;

import board.article.dao.ArticleDao;
import board.article.model.Article;
import jdbc.ConnectionProvider;

public class ReadArticleService {
	private ArticleDao articleDao = new ArticleDao();

	public ArticleData getArticle(int articleNum, boolean increaseReadCount) {
		try(Connection conn = ConnectionProvider.getConnection()){
			Article article = articleDao.selectById(conn, articleNum);
			if(article == null) {
				throw new ArticleNotFoundException();
			}
			if(increaseReadCount) {
				articleDao.increaseReadCount(conn, articleNum);
			}
			return new ArticleData(article);
		}catch(SQLException e) {
			System.out.print("사유 : " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

}
