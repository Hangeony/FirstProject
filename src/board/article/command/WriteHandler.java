package board.article.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.article.model.Writer;
import board.article.service.WriteArticleRequest;
import board.article.service.WriteArticleService;
import mvc.command.CommandHandler;
import user.auth.service.User;

public class WriteHandler implements CommandHandler{
	private static final String FORM_VIEW = "writeForm";
	private WriteArticleService writeService = new WriteArticleService();
	
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

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);
		
		User user = (User)req.getSession().getAttribute("authUser");
		WriteArticleRequest writeReq = createWriteRequest(user, req);
		writeReq.validate(errors);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		int newArticleNo = writeService.write(writeReq);
		req.setAttribute("newArticleNo", newArticleNo);
		return "writeSuccess";
	}

	private WriteArticleRequest createWriteRequest(User user, HttpServletRequest req) {
		return new WriteArticleRequest(
				new Writer(user.getId(), 
				user.getName()),
				req.getParameter("title"),
				req.getParameter("content"));
	}

}
