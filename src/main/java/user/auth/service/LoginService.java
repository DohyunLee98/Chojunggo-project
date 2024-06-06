package user.auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import user.Dao.UserDao;
import user.model.User;


public class LoginService {

	private UserDao UserDao = new UserDao();
	public User login(String id, String pwd) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			User User = UserDao.selectById(conn, id);
			if (User == null) {
				throw new LoginFailException();
			}
			if (!User.matchPassword(pwd)) {
				throw new LoginFailException();
			}
			return new User(User.getId(), User.getPwd(),User.getName(),User.getNickname(),User.getAddress(),User.getAccount(),User.getLocation());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
