package board.article.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.article.service.ArticleData;
import board.article.service.DeleteArticleService;
import board.article.service.ReadArticleService;
import mvc.command.CommandHandler;
import user.auth.service.User;

public class DeleteArticleHandler implements CommandHandler {
	private static final String FORM_VIEW = "deleteForm";
	
	private ReadArticleService readService = new ReadArticleService();
	private DeleteArticleService deleteService = new DeleteArticleService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		}else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		User authUser = (User) session.getAttribute("authUser");
		int no = Integer.parseInt(req.getParameter("no"));
		String password = req.getParameter("password");
		
		ArticleData articleData = readService.getArticle(no, false);
		
		if (!authUser.getId().equals(articleData.getArticle().getWriter().getId())) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return FORM_VIEW;
		}
		
		try {
			deleteService.delete(no, authUser, password);
			
		} catch (Exception e) {
			System.out.print("사유 : " + e.getMessage());
			throw new RuntimeException(e);
		}
		
		return "deleteSuccess";
	}

}
