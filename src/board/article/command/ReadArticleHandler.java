package board.article.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.article.service.ArticleContentNotFoundException;
import board.article.service.ArticleData;
import board.article.service.ArticleNotFoundException;
import board.article.service.ReadArticleService;
import board.reply.model.Replys;
import board.reply.service.ReplyService;
import mvc.command.CommandHandler;

public class ReadArticleHandler implements CommandHandler {
	private ReadArticleService readService = new ReadArticleService();
 private ReplyService replyService = new ReplyService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String noVal = req.getParameter("no");
		System.out.println(noVal);
		int articleNum = Integer.parseInt(noVal);

		try {
			ArticleData articleData = readService.getArticle(articleNum, true);
			List<Replys> replyList = replyService.getReplys(articleNum); 
			req.setAttribute("articleData", articleData);
			req.setAttribute("replyList", replyList);
			return "readArticle";
		}catch(ArticleNotFoundException | ArticleContentNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
}
