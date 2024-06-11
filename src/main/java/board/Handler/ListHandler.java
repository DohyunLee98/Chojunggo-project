package board.Handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import board.dao.BoardDAO;
import board.service.BoardDetail;
import jdbc.connection.ConnectionProvider;
import mvc.command.CommandHandler;

public class ListHandler implements CommandHandler{

	private BoardDAO boardDAO = new BoardDAO();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res)  {
		processJSON(req, res);
		return null;
	}
	
	private void processJSON(HttpServletRequest request, HttpServletResponse response) {
		JSONObject json = new JSONObject();
		try (Connection con = ConnectionProvider.getConnection()){
			List<BoardDetail> boardList= boardDAO.selectAllDetail(con); 
			
			json.put("list", boardList);
			
			PrintWriter out = response.getWriter();
			out.print(json.toString());
			out.flush();
		}catch (SQLException e){
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
		
	}
	
}
