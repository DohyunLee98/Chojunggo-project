package board.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.AssembledBoard;
import board.service.ReadService;
import mvc.command.CommandHandler;

public class ReadHandler implements CommandHandler {

	ReadService readService;
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String noVal = req.getParameter("no");
		int boardNum = 0;
		if (noVal.length() == 0) {
			boardNum = Integer.parseInt(req.getParameter("boardNum"));
		} else {
			boardNum = Integer.parseInt(noVal);
		}
		AssembledBoard assemble = readService.getBoard(boardNum);
		readService.insertRecentBoard(assemble.getBoard()); // 최근 본 게시판에 추가
		req.setAttribute("assemble", assemble);
		return "/WEB-INF/view/readBoard.jsp";
	}

}
