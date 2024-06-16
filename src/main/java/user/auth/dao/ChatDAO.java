package user.auth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import user.auth.service.ChatRoom;

public class ChatDAO {

	public String selectChannelKey(Connection con) throws SQLException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("select channel_key from channel where running = 'n'");
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(ps);
		}
		return null;
	}

	public int insertChatRoom(Connection con, String writerId, String userId, String channelKey, String title) throws SQLException{
		PreparedStatement ps = null;
		int result = 0;
		for(int i =0; i < 2; i++) {
			try {
				ps = con.prepareStatement("insert into chat values (?, ?, ?)");
				if(i == 0) {
					ps.setString(1, writerId);
				}else if(i == 1) {
					ps.setString(1, userId);
				}
				ps.setString(2, channelKey);
				ps.setString(3, title);
				result += ps.executeUpdate();
				 
			} finally {
				JdbcUtil.close(ps);
			}
			
		}
		return result;
	}

	public List<ChatRoom> selectChat(Connection con, String userId) throws SQLException{
		List<ChatRoom> chatRooms = new ArrayList<ChatRoom>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("select * from chat where user_id = ?");
			ps.setString(1, userId);
			rs = ps.executeQuery();
			while(rs.next()) {
				chatRooms.add(new ChatRoom(rs.getString("channel_key"), rs.getString("title")));
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(ps);
		}
		return chatRooms;
	}

	public void updateChannelRunning(Connection con, String channelKey) throws SQLException{
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("update channel set running = 'y' where channel_key = ?");
			ps.setString(1, channelKey);
			ps.executeUpdate();
			
		} finally {
			JdbcUtil.close(ps);
		}
		
	}

	
}
