package board.service;

import java.sql.Connection;
import java.sql.SQLException;

import board.dao.BoardDAO;
import jdbc.connection.ConnectionProvider;

public class ReadService {

	BoardDAO boardDAO;
	
	public AssembledBoard getBoard(int boardNum) {
		try(Connection con = ConnectionProvider.getConnection()){
			Board board = boardDAO.selectBoard(con, boardNum); // 정보 가져오기
			BoardContent content = boardDAO.selectContent(con, boardNum); 
			BoardDetail detail = boardDAO.selectDetail(con, boardNum);
			Photo photo = boardDAO.selectPhoto(con, boardNum);
			
			return new AssembledBoard(board, detail, content, photo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void insertRecentBoard(Board board) {
		try(Connection con = ConnectionProvider.getConnection()){
			boardDAO.insertRecentBoard(con, board);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
	}

}
