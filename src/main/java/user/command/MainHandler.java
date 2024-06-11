package user.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;

public class MainHandler implements CommandHandler {

	 public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		 HttpSession session = req.getSession(false); 
	        boolean loginCheck = (session != null && session.getAttribute("logins") != null);

	        req.setAttribute("loginCheck", loginCheck);
	        
	        req.getRequestDispatcher("/main.jsp").forward(req,res);
	        return null;
	}
}
