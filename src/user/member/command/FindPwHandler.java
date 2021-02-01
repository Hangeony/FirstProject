package user.member.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import user.member.service.FindPwService;
import user.member.service.MemberNotFoundException;

public class FindPwHandler implements CommandHandler {
	private static final String FORM_VIEW = "findpw";
	private FindPwService findPwService = new FindPwService();
	
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
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);
		
		String id = req.getParameter("id");
		
		if(id == null || id.isEmpty()) {
			errors.put("noId", true);
		}
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			String userPw = findPwService.findMember(id);
			req.setAttribute("userPw", userPw);
			return "findpw";
		}catch(MemberNotFoundException e) {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}

}
