package board.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import mvc.command.CommandHandler;

public class WriteSuccessHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		BoardDAO boardDAO = new BoardDAO();
		req.setAttribute("boardNum", boardDAO.selectBoardNum());
		
		return "writeSuccess.jsp";
	}

	
}
