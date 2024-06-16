package user.auth.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import user.auth.dao.ChatDAO;

public class ChatService {

	ChatDAO chatDAO = new ChatDAO();
	
	public void makeChatRoom(String writerId, String userId, String title) {
		try(Connection con = ConnectionProvider.getConnection()){
			String channelKey = chatDAO.selectChannelKey(con);
			if(channelKey == null) {
				System.out.println("이용가능한 채팅방이 없습니다.");
			}
			
			int result = chatDAO.insertChatRoom(con, writerId, userId, channelKey, title);
			if(result == 0) {
				System.out.println("채팅방 개설 실패");
			} else {
				chatDAO.updateChannelRunning(con, channelKey);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

	public List<ChatRoom> getChatRooms(String userId) {
		List<ChatRoom> chatRooms = null;
		try(Connection con = ConnectionProvider.getConnection()){
			chatRooms = chatDAO.selectChat(con, userId);
			if(chatRooms.isEmpty()) {
				System.out.println("select Chat 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chatRooms;
	}

	
}
