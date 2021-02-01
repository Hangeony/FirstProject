package user.member.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import user.auth.service.User;
import user.member.service.InvalidPasswordException;
import user.member.service.MemberNotFoundException;
import user.member.service.RemoveMemberService;

public class RemoveMemberHandler implements CommandHandler {
	private static final String FORM_VIEW="removeMemberForm";
	private RemoveMemberService removeMemberSvc = new RemoveMemberService();
	
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

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);
		String password = req.getParameter("password");
		String id = req.getParameter("id");
		
		if(id == null || id.isEmpty()) {
			errors.put("no", true);
		}
		
		if(password == null || password.isEmpty()) {
			errors.put("password", true);
		}
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		User user = (User) req.getSession().getAttribute("authUser");
		
		try {
			
			if (user.getId().equals(id)) {
				removeMemberSvc.removeMember(user, password);
				req.getSession().invalidate();
				return "removeMemberSucesse";
			}else {
				errors.put("no1", true);
	
			}
			return "removeFail";
			
		}catch(InvalidPasswordException e) {
			errors.put("noPwd", true);
			return FORM_VIEW;
		}catch(MemberNotFoundException e) {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}

}
