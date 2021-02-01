package board.article.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.article.service.ArticleData;
import board.article.service.ArticleNotFoundException;
import board.article.service.PermissionDeniedException;
import board.article.service.ReadArticleService;
import board.article.service.UpdateArticleService;
import board.article.service.UpdateRequest;
import mvc.command.CommandHandler;
import user.auth.service.User;

public class UpdateHandler implements CommandHandler{
	private static final String FORM_VIEW = "updateForm";
	private ReadArticleService readService = new ReadArticleService();
	private UpdateArticleService updateService = new UpdateArticleService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		}else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			String noVal = req.getParameter("no");
			int no = Integer.parseInt(noVal);
			
			ArticleData articleData = readService.getArticle(no, false);
			User authUser = (User) req.getSession().getAttribute("authUser");
			
			if(!canModify(authUser, articleData)) {
				res.sendError(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
			
			UpdateRequest upReq = new UpdateRequest(
					authUser.getId(), 
					no, 
					articleData.getArticle().getTitle(), 
					articleData.getArticle().getContent());
			req.setAttribute("upReq", upReq);
			return FORM_VIEW;
			
		}catch(ArticleNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	private boolean canModify(User authUser, ArticleData articleData) {
		String writerId = articleData.getArticle().getWriter().getId();
		return authUser.getId().equals(writerId);
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		User authUser = (User) req.getSession().getAttribute("authUser");
		String noVal = req.getParameter("no");
		int no = Integer.parseInt(noVal);
		
		UpdateRequest upReq = new UpdateRequest(authUser.getId(), no, req.getParameter("title"), req.getParameter("content"));
		req.setAttribute("upReq", upReq);
		
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);
		upReq.validate(errors);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			updateService.update(upReq);
			return"updateSuccess";
		}catch(ArticleNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}catch(PermissionDeniedException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

}
