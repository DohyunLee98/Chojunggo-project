package user.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import user.Dao.UserDao;
import user.model.User;

public class JoinService {

	private UserDao UserDao = new UserDao();
	
	public void join(JoinRequest joinReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			User User = UserDao.selectById(conn, joinReq.getId());
			if (User != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			
			UserDao.insert(conn, 
					new User(
							joinReq.getId(), 
							joinReq.getName(), 
							joinReq.getPwd(), 
							joinReq.getNickname(), 
							joinReq.getAddress(), 
							joinReq.getAccount(), 
							joinReq.getLocation()
					)
			);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
