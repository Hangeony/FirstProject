package board.reply.service;

import java.sql.Connection;
import java.sql.SQLException;

import board.reply.dao.ReplyDao;
import board.reply.model.Replys;

public class AddReplyService {
	private ReplyDao repDao = new ReplyDao();
	
	public boolean addNewReplyDepthOne(Connection conn, Replys replys) throws SQLException {
		
		int orderNo = this.getNewOrderNo(conn , replys);
		replys.setOrderNo(orderNo);
		
		if(orderNo > 0) {
			repDao.updateOrderNoByGroupId(conn, replys);
		}
		return repDao.insert(conn, replys) > 0;
	}

	private int getNewOrderNo(Connection conn, Replys replys) throws SQLException {
		if(repDao.selectCountParentReplyId(conn, replys) > 0) {
			int newOrderNo = repDao.selectMaxOrderNoByParentReplyId(conn, replys);
			return newOrderNo + 1;
		}else {
			if(replys.getParentReplyId() != 0) {
				int newOrderNo = repDao.selectLatestOrderNoByParentReplyId(conn, replys);
				return newOrderNo + 1;
			}
		}
		return 0;
	}
}
