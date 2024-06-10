package user.auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import user.Dao.LoginDAO;
import user.model.UserVO;


public class LoginService {

	public LoginDAO LoginDao = new LoginDAO();
	
	public User2 login(String id, String pwd) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			UserVO User = LoginDao.selectById(conn, id);
			if (User == null) {
				throw new LoginFailException();
			}
			if (!User.matchPassword(pwd)) {
				throw new LoginFailException();
			}
			return new User2(User.getId(),User.getNickname());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
