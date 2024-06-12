package board.handler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.service.BoardDetail;
import jdbc.connection.ConnectionProvider;
import mvc.command.CommandHandler;
import user.auth.service.User2;

public class RecentBoardHandler implements CommandHandler{

	private BoardDAO boardDAO = new BoardDAO();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		User2 user = (User2) req.getSession(false).getAttribute("login");

		try (Connection con = ConnectionProvider.getConnection()) {
			List<Integer> boardNumList = boardDAO.selectRecentBoard(con, user); //최근 본 게시판 번호 가져오기
			List<BoardDetail> boardList = boardDAO.selectDetailById(con, boardNumList); // 게시판 정보 가져오기
			
			req.setAttribute("board", boardList);
			return "/WEB-INF/view/recentBoard.jsp";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	
}
