package board.reply.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.reply.model.Replys;

public class ReplyDao {
	//뎃글에 뎃글달기 프로젝트 1일차
	public int insert(Connection conn, Replys replys) throws SQLException {
		String sql = "INSERT INTO replys(article_id, member_id, replycontent, group_id) " + 
				"VALUES (?, ?, ?, ?)";

		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			if(replys.getParentReplyId() > 0) {
				sql = "INSERT INTO replys(article_id, member_id, replycontent, " + 
						"group_id,parent_reply_id, depth, ORDER_NO ) " + 
						"VALUES (?, ?, ?, ?, ?, ? , ?)";
			}
			System.out.println(replys.getMemberId());
			pstmt.setInt(1, replys.getArticleId());
			pstmt.setString(2, replys.getMemberId());
			pstmt.setString(3, replys.getReplycontent());
			pstmt.setInt(4, replys.getGroupId());
			
			if(replys.getParentReplyId() > 0) {
				pstmt.setInt(5, replys.getParentReplyId());
				pstmt.setInt(6, replys.getDepth());
				pstmt.setInt(7, replys.getOrderNo());
			}

			return pstmt.executeUpdate();
		}
	}
 // 1번
	public List<Replys> getReplyListByArticleId (Connection conn, int articleNum) throws SQLException{
		String sql = "SELECT * " +
				"FROM replys WHERE article_id=? " +
				"ORDER BY group_id asc, order_no DESC";

		List<Replys> list = new ArrayList<>();
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, articleNum);

			ResultSet rs = pstmt.executeQuery();
			Replys r = null;
			
			while(rs.next()) {
				r = new Replys();
				r.setReplyId(rs.getInt(1));
				r.setArticleId(rs.getInt(2));
				r.setMemberId(rs.getString(3));
				r.setReplycontent(rs.getString(4));
				r.setGroupId(rs.getInt(5));
				r.setDepth(rs.getInt(6));
				r.setOrderNo(rs.getInt(7));

				list.add(r);
			}
			if(r == null) {
				return null;
			}
		}
		return list;

	}
	
//	reply_id가 ? 인 order_no 가져오기 4
	public int selectLatestOrderNoByParentReplyId(Connection conn, Replys replys) throws SQLException {
		String sql = "SELECT order_no FROM replys WHERE reply_id = ?";
		
	
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			ResultSet rs = null;
			pstmt.setInt(1, replys.getParentReplyId());
			rs = pstmt.executeQuery();
			
			rs.next();
			return rs.getInt(1);
		}
	}
	
	//reply_id가 ?인것부터 시작해서 parent_reply_id 와 reply_id가 같은거 순서대로 가져오기3
	public int selectMaxOrderNoByParentReplyId(Connection conn, Replys replys) throws SQLException {
		String sql = "SELECT order_no FROM ( SELECT DISTINCT * FROM replys START WITH  reply_id  =? " + 
				"CONNECT BY PRIOR reply_id = parent_reply_id ORDER BY order_no desc) where rownum = 1";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			ResultSet rs = null;
			
			pstmt.setInt(1, replys.getArticleId());
			rs = pstmt.executeQuery();		
			
			if(rs.next()) {
				return rs.getInt(1);
			}else {
				return 0;
			}	
		}
	}
	//parent_reply_id가 ?인거 가져오기 2
	public int selectCountParentReplyId(Connection conn, Replys replys) throws SQLException {
		String sql = "SELECT COUNT(reply_id) FROM replys WHERE parent_reply_id = ?";
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			ResultSet rs = null;
			
			pstmt.setInt(1, replys.getParentReplyId());
			
			rs = pstmt.executeQuery();
			rs.next();
			
			return rs.getInt(1);
			
		}
	}
	// update  쿼리 필요.... 쉬발 빡시다
	public void updateOrderNoByGroupId(Connection conn, Replys replys) throws SQLException {
		String sql = "UPDATE replys SET ORDER_NO = ? WHERE group_id = ?";
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, replys.getOrderNo());
			pstmt.setInt(2, replys.getGroupId());
			
			pstmt.executeUpdate();
		}
	
	}
}
