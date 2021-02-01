package user.member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import user.auth.service.User;
import user.member.service.ChangePasswordService;
import user.member.service.InvalidPasswordException;
import user.member.service.MemberNotFoundException;

public class ChangePasswordHandler implements CommandHandler {
	private static final String FORM_VIEW ="changePwdForm";
	private ChangePasswordService changePwdSvc = new ChangePasswordService();
	
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

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception{
		User user = (User) req.getSession().getAttribute("authUser");
		
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);
		
		String curPwd = req.getParameter("curPwd");
		String newPwd = req.getParameter("newPwd");
		
		if(curPwd == null || curPwd.isEmpty() ) {
			errors.put("curPwd", true);
		}
		if(newPwd == null || newPwd.isEmpty()) {
			errors.put("newPwd", true);
		}
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			changePwdSvc.changePassword(user.getId(), curPwd, newPwd);
			return "index";
		}catch(InvalidPasswordException e) {
			errors.put("badCurPwd", true);
			return FORM_VIEW;
		}catch(MemberNotFoundException e) {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}

}
