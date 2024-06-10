package user.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import user.Dao.JoinDAO;
import user.Dao.JoinDAO;
import user.model.UserVO;

public class JoinService {

	public JoinDAO joindao = new JoinDAO();
	
	public void join(JoinDTO joindto) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			UserVO User = joindao.selectById(conn, joindto.getId());
			if (User != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			
			joindao.insert(conn, 
					new UserVO(
							joindto.getId(), 
							joindto.getPwd(), 
							joindto.getName(), 
							joindto.getNickname(), 
							joindto.getAddress(), 
							joindto.getAccount(), 
							joindto.getLocation()
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
