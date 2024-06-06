package user.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import user.Dao.UserDao;
import user.model.User;

public class ChangePasswordService {

	private UserDao UserDao = new UserDao();
	
	public void changePassword(String userId, String curPwd, String newPwd) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			User User = UserDao.selectById(conn, userId);
			if (User == null) {
				throw new UserNotFoundException();
			}
			if (!User.matchPassword(curPwd)) {
				throw new InvalidPasswordException();
			}
			User.changePassword(newPwd);
			UserDao.update(conn, User);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
