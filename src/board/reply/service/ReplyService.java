package board.reply.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import board.reply.dao.ReplyDao;
import board.reply.model.Replys;
import jdbc.ConnectionProvider;

public class ReplyService {
	private ReplyDao repDao = new ReplyDao();
	
	public List<Replys> getReplys(int articleNum){
		Connection conn = ConnectionProvider.getConnection();
		
		List<Replys> list;
		try {
			list = repDao.getReplyListByArticleId(conn, articleNum);
		}catch(SQLException e){
			e.printStackTrace();
			System.out.print("사유 : " + e.getMessage());
			throw new RuntimeException(e);
		}
		
		return list;
	}


}
