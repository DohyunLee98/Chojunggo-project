package board.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.PayRequest;
import board.service.AssembledBoard;
import board.service.ReadService;
import mvc.command.CommandHandler;

public class ReadHandler implements CommandHandler {

	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ReadService readService = new ReadService();
		String noVal = req.getParameter("no");
		int boardNum = 0;
		if (noVal.length() == 0) {
			boardNum = Integer.parseInt(req.getParameter("boardNum"));
		} else {
			boardNum = Integer.parseInt(noVal);
		}
		AssembledBoard assemble = readService.getBoard(boardNum);
		
		if(req.getSession(false).getAttribute("login") != null) { // 로그인 되어 있을 경우만 추가
			readService.insertRecentBoard(assemble.getBoard()); // 최근 본 게시판에 추가
		}
		
		PayRequest pay = new PayRequest(assemble.getBoardDetail().getTitle(), assemble.getBoardDetail().getPrice());
		req.setAttribute("assemble", assemble);
		req.setAttribute("pay", pay);
		return "/WEB-INF/view/read.jsp";
	}

}
