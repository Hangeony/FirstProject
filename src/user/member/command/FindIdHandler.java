package user.member.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import user.member.service.FindIdService;
import user.member.service.MemberNotFoundException;

public class FindIdHandler implements CommandHandler{
	private static final String FORM_VIEW="findid";
	private FindIdService findIdService = new FindIdService();
	
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
		Map<String , Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		String cellphone = req.getParameter("cellphone");
		
		if(cellphone == null || cellphone.isEmpty()) {
			errors.put("noCell", true);
		}
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			String userID = findIdService.findMember(cellphone);
			System.out.println(userID);
			req.setAttribute("userID",userID);
			return "findid";
		}catch(MemberNotFoundException e) {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		
	}

}
