package board.article.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import board.article.model.Article;
import board.article.model.Writer;
import jdbc.JdbcUtil;

public class ArticleDao {
	//값추가
	public Article insert(Connection conn, Article article) throws SQLException {
		String sql = "INSERT INTO bbs (writer_id, writer_name, title,content, regdate, moddate, read_cnt) "
				   +"VALUES(?, ?, ?, ?, SYSDATE, SYSDATE, 0)";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql,
					new String[] {"article_no", "regdate", "moddate"});
			
			pstmt.setString(1,article.getWriter().getId());
			pstmt.setString(2, article.getWriter().getName());
			pstmt.setString(3, article.getTitle());
			pstmt.setString(4, article.getContent());
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt == 1) {
				rs = pstmt.getGeneratedKeys();
				int key = 0;
				Date regDate = null;
				Date modDate = null;
				
				if(rs.next()) {
					key = rs.getInt(1);
					regDate = rs.getTimestamp(2);
					modDate = rs.getTimestamp(3);
				}
				return new Article(key, article.getWriter(), article.getTitle(),article.getContent() ,regDate, modDate, 0, 0);
				
			}else {
				return null;
			}
		}finally {
			JdbcUtil.close(rs, pstmt);
		}
	}
	//페이지 네이션 처리 코드
	public List<Article> select(Connection conn, int pageNum, int size) throws SQLException{
		String sql = "SELECT rn, article_no, writer_id, writer_name, title, content, regdate, moddate, read_cnt, (select COUNT(*) from replys where replys.article_id = article_no group by replys.article_id) as comment_count " + 
				"FROM(SELECT article_no, writer_id, writer_name, title, content, regdate, moddate, read_cnt ,ROW_NUMBER() OVER(ORDER BY article_no DESC) rn FROM bbs) WHERE rn BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNum-1)*size +1);
			pstmt.setInt(2, pageNum*size);
			
			rs = pstmt.executeQuery();
			List<Article> result = new ArrayList<Article>();
			
			while(rs.next()) {
				result.add(convertArticles(rs));
			}
			return result;
		}finally {
			JdbcUtil.close(conn);
		}
		
	}
	private Article convertArticle(ResultSet rs) throws SQLException {		
		return new Article(rs.getInt("article_no"),
				new Writer(
						rs.getString("writer_id"),
						rs.getString("writer_name")
						),
				rs.getString("title"),
				rs.getString("content"),
				rs.getTimestamp("regdate"),
				rs.getTimestamp("moddate"),
				rs.getInt("read_cnt"),
				0
				);
		
	}
	
	private Article convertArticles(ResultSet rs) throws SQLException {		
//		System.out.println(rs.getInt("comment_count"));
		
		return new Article(rs.getInt("article_no"),			
				new Writer(
						rs.getString("writer_id"),
						rs.getString("writer_name")
						),
				rs.getString("title"),
				rs.getString("content"),
				rs.getTimestamp("regdate"),
				rs.getTimestamp("moddate"),
				rs.getInt("read_cnt"),
				rs.getInt("comment_count")
				);
		
	}
	
	public int selectCount(Connection conn) throws SQLException {
		String sql = "SELECT COUNT(*) FROM bbs";
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		}finally {
			JdbcUtil.close(rs, stmt);
		}
	}
	public Article selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM bbs WHERE article_no= ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			Article article = null;
			
			if(rs.next()) {
				article = convertArticle(rs);
			}
			return article;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	//조회수 +1 올리는 쿼리
	public void increaseReadCount(Connection conn, int articleNum) throws SQLException {
		String sql = "UPDATE bbs SET read_cnt = read_cnt +1 WHERE article_no=?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, articleNum);
			pstmt.executeUpdate();
		}
		
	}
	//수정
	public int update(Connection conn, int no ,String title, String content) throws SQLException {
		String sql = "UPDATE bbs SET title= ? ,content=?, moddate = SYSDATE " 
				+"WHERE article_no= ?"; 
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, no);
			
			int cnt = pstmt.executeUpdate();
			return cnt;
		}
	}
	//글삭제
	public void delet(Connection conn, int no) throws SQLException {
		String sql = "DELETE FROM bbs WHERE article_no = ?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}
	}
	
	//검색기능
	public List<Article> search(Connection conn, String searchType, String keyword, int pageNum, int size ) throws SQLException{
		String sql = "SELECT rn, article_no, writer_id, writer_name, title, content, regdate, moddate, read_cnt, (select COUNT(*) from replys where replys.article_id = article_no group by replys.article_id) as comment_count " 
				+ "FROM(SELECT article_no, writer_id, writer_name, title, content, regdate, moddate, read_cnt ,ROW_NUMBER() "
				+ "OVER(ORDER BY article_no DESC) rn FROM bbs where "+ searchType +" LIKE '%"+ keyword + "%') WHERE rn BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
//		System.out.println("Dao : "+ searchType);
//		System.out.println("Dao : "+ keyword);
		
		try {
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setInt(1, (pageNum-1)*size +1);
			pstmt.setInt(2, pageNum*size);
			
			rs = pstmt.executeQuery();
			List<Article> result = new ArrayList<Article>();
			
			while(rs.next()) {
				result.add(convertArticles(rs));
			}
			return result;
		}finally {
			JdbcUtil.close(conn);
		}
	}
	

}
