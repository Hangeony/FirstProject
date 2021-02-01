package board.reply.command;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.article.service.ArticleData;
import board.article.service.ReadArticleService;
import board.reply.model.Replys;
import board.reply.service.AddReplyService;
import board.reply.service.ReplyService;
import jdbc.ConnectionProvider;
import mvc.command.CommandHandler;
import user.auth.service.User;

public class AddReplyHandler implements CommandHandler{
	private AddReplyService addRep = new AddReplyService();
	private ReadArticleService readService = new ReadArticleService();
	private ReplyService replyService = new ReplyService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int articleId = Integer.parseInt(req.getParameter("articleId"));
		int depth = Integer.parseInt(req.getParameter("depth"));
		int parentReplyId = Integer.parseInt(req.getParameter("parentReplyId"));
		int groupId = Integer.parseInt(req.getParameter("groupId"));
		int orderNo = Integer.parseInt(req.getParameter("orderNo"));
		int replyId = Integer.parseInt(req.getParameter("replyId"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));

		Connection conn = ConnectionProvider.getConnection();

		String replys = req.getParameter("replycontent");
		replys = replys.replace("\n", "<br/>");

		Replys reply = new Replys();
		reply.setArticleId(articleId);
		reply.setDepth(depth);
		reply.setParentReplyId(parentReplyId);
		reply.setGroupId(groupId);
		reply.setOrderNo(orderNo);
		reply.setReplycontent(replys);
		reply.setReplyId(replyId);
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("authUser");

		if(user != null ) {
			reply.setMemberId(user.getId());
		}
		
		addRep.addNewReplyDepthOne(conn,reply);
		res.sendRedirect(req.getContextPath() + "/article/read.do?no="+articleId+ "&pageNo="+ pageNum);
		
		return null;
	}

}
