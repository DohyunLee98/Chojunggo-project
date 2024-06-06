package user.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import user.model.User;

public class UserDao {

	public User selectById(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from user where userid = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			User user = null;
			if (rs.next()) {
				user = new User(
						rs.getString("userid"), 
						rs.getString("pwd"),
						rs.getString("name"), 
						rs.getString("nickname"), 
						rs.getString("address"), 
						rs.getString("account"), 
						rs.getString("location"));
			}
			return user;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}


	public void insert(Connection conn, User user) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement("insert into user values(?,?,?,?)")) {
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getNickname());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getAccount());
			pstmt.setString(7, user.getLocation());
			pstmt.executeUpdate();
		}
	}

	public void update(Connection conn, User user) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(
				"update user set name = ?, password = ? where userid = ?")) {
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getNickname());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getAccount());
			pstmt.setString(7, user.getLocation());
			pstmt.executeUpdate();
		}
	}
}
