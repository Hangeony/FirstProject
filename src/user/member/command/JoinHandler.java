package user.member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import user.member.service.DuplicateIdException;
import user.member.service.JoinRequest;
import user.member.service.JoinService;

public class JoinHandler implements CommandHandler {
	private static final String FORM_VIEW = "joinForm";
	private JoinService joinService = new JoinService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return ProcessFrom(req, res);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return ProcessSubmit(req, res);
		}else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
		
	}

	private String ProcessFrom(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String ProcessSubmit(HttpServletRequest req, HttpServletResponse res) {
		
		JoinRequest joinReq = new JoinRequest();
		joinReq.setId(req.getParameter("id"));
		joinReq.setPassword(req.getParameter("password"));
		joinReq.setConfirmPassword(req.getParameter("confirmPassword"));
		String birth = req.getParameter("yyyy") + req.getParameter("mm") + req.getParameter("dd"); 
		joinReq.setBirth(birth);
		joinReq.setName(req.getParameter("name"));
		joinReq.setGender(req.getParameter("gender"));
		joinReq.setCellphone1(req.getParameter("cellphone1"));
		joinReq.setCellphone2(req.getParameter("cellphone2"));
		joinReq.setCellphone3(req.getParameter("cellphone3"));
		
		
		
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);
		
		joinReq.validate(errors);
		
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			joinService.join(joinReq);
			return "joinSucess";
		}catch(DuplicateIdException e) {
			errors.put("duplicateId", true);
			return FORM_VIEW;
		}
	}

}
