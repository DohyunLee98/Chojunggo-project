package user.auth.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;

public class LogoutHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		HttpSession session = req.getSession(false);
		if (session != null) {
            session.invalidate();
            req.setAttribute("logoutSuccess", "true");
        } else {
            req.setAttribute("logoutSuccess", "false");
        }
		 req.getRequestDispatcher("/main.do").forward(req, res);
	        return null;
	}

}
