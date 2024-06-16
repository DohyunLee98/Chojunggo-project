package board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import board.dao.BoardDAO;
import jdbc.connection.ConnectionProvider;

public class SearchService {

	private int size = 16;
	BoardDAO boardDAO = new BoardDAO();
	
	public ListPage getListPage(int pageNum, String searchWord) {
		try(Connection con = ConnectionProvider.getConnection()){
			int total = boardDAO.selectCount(con);
			List<BoardDetail> content = boardDAO.search(con, (pageNum -1) * size, size, searchWord);
			return new ListPage(total, pageNum, size, content);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}


}