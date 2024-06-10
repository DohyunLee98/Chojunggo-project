package user.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import user.model.UserVO;

public class JoinDAO {

	public UserVO selectById(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from user where user_id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			UserVO user = null;
			if (rs.next()) {
				user = new UserVO(
						rs.getString("user_id"), 
						rs.getString("user_pwd"),
						rs.getString("user_name"), 
						rs.getString("user_nickname"), 
						rs.getString("user_address"), 
						rs.getString("user_account"), 
						rs.getString("user_location"));
			}
			return user;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public void insert(Connection conn, UserVO user) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into user values(?,?,?,?,?,?,?)")) {
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getNickname());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getAccount());
			pstmt.setString(7, user.getLocation());
			pstmt.executeUpdate();
			System.out.println(user.toString());
		}
	}

	
}
