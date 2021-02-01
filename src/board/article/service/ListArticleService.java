package board.article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import board.article.dao.ArticleDao;
import board.article.model.Article;
import jdbc.ConnectionProvider;

public class ListArticleService {
	private ArticleDao articleDao = new ArticleDao();
	private int size = 10;
	
	public ArticlePage getArticlePage(int pageNum) {
		try(Connection conn = ConnectionProvider.getConnection()){
			int total = articleDao.selectCount(conn);
			List<Article> content = articleDao.select(conn, pageNum, size);
			
			return new ArticlePage(total, pageNum, size, content);
		}catch(SQLException e) {
			System.out.print("사유 : " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public ArticlePage getSearchArticlePage(int pageNum,  String searchType, String keyword) {
		try(Connection conn = ConnectionProvider.getConnection()){
			int total = articleDao.selectCount(conn);
			List<Article> content = articleDao.search(conn, searchType, keyword, pageNum, total);
			
//			System.out.println("Service : "+ searchType);
//			System.out.println("Service : "+ keyword);
			
			return new ArticlePage(total, pageNum, size, content);
		}catch(SQLException e) {
			System.out.print("사유 : " + e.getMessage());
			throw new RuntimeException();
		}
	}
	

}
