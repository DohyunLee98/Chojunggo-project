package user.command;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import user.service.JoinDTO;
import user.service.JoinService;

public class JoinHandler implements CommandHandler {

	private static final String FORM_VIEW = "/join.jsp";
	private JoinService joinService = new JoinService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		JoinDTO joindto = new JoinDTO();
		joindto.setId(req.getParameter("id"));
		joindto.setPwd(req.getParameter("pwd"));
		joindto.setName(req.getParameter("name"));
		joindto.setNickname(req.getParameter("nickname"));
		joindto.setAddress(req.getParameter("address")+ " " +req.getParameter("address_detail"));
		joindto.setAccount(req.getParameter("account"));
		joindto.setLocation(req.getParameter("location"));
		joinService.join(joindto);
		return "/login.jsp";

	}
}
