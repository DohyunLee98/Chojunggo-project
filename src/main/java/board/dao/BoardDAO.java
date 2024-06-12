package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import board.service.Board;
import board.service.BoardContent;
import board.service.BoardDetail;
import board.service.Photo;
import jdbc.JdbcUtil;
import user.auth.service.User;
import user.auth.service.User2;

public class BoardDAO {

	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}

	public int insertBoard(Connection con, Board board) {
		Statement stmt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("insert into board (user_id, user_nickname, trade_status) values (?, ?, '판매 중')");
			ps.setString(1, board.getUser2().getId());
			ps.setString(2, board.getUser2().getNickname());
			int insertedCount = ps.executeUpdate();

			if (insertedCount > 0) {
				stmt = con.createStatement();
				rs = stmt.executeQuery("select last_insert_id() from board");
				if (rs.next()) {
					int boardNum = rs.getInt(1);
					return boardNum;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(stmt);
			JdbcUtil.close(ps);
			JdbcUtil.close(rs);
		}
		return -1;

	}

	public void insertBoardContent(Connection con, BoardContent boardContent) {
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(
					"insert into board_content (board_num, user_id, content, product_condition, delivery_fee) values (?, ?, ?, ?, ?)");
			ps.setInt(1, boardContent.getBoardNum());
			ps.setString(2, boardContent.getId());
			ps.setString(3, boardContent.getContent());
			ps.setString(4, boardContent.getProductCondition());
			ps.setInt(5, boardContent.getDeliveryFee());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(ps);
		}

	}

	public void insertBoardDetail(Connection con, BoardDetail boardDetail) {
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(
					"insert into board_detail (board_num, title, category, price, location, created_date, thumb_name) values (?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, boardDetail.getBoardNum());
			ps.setString(2, boardDetail.getTitle());
			ps.setString(3, boardDetail.getCategory());
			ps.setInt(4, boardDetail.getPrice());
			ps.setString(5, boardDetail.getLocation());
			ps.setTimestamp(6, toTimestamp(boardDetail.getCreatedDate()));
			ps.setString(7, boardDetail.getThumbName());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(ps);
		}

	}

	public void insertPhoto(Connection con, Photo photos) {
		PreparedStatement ps = null;
		try {
			for (int i = 0; i < photos.getImageName().size(); i++) {
				ps = con.prepareStatement("insert into photo (board_num, original_name) values (?, ?)");
				ps.setInt(1, photos.getBoardNum());
				ps.setString(2, photos.getImageName().get(i));
				ps.executeUpdate();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(ps);
		}
	}

	public Board selectBoard(Connection con, int boardNum) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Board board = null;
		try {
			ps = con.prepareStatement("select * from board where board_num = ?");
			ps.setInt(1, boardNum);
			rs = ps.executeQuery();
			if (rs.next()) {
				board = new Board(boardNum, new User2(rs.getString("user_id"), rs.getString("user_nickname")),
						rs.getString("trade_status"));

				return board;
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(ps);
		}
		return null;
	}

	public BoardContent selectContent(Connection con, int boardNum) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardContent content = null;
		try {
			ps = con.prepareStatement("select * from board_content where board_num = ?");
			ps.setInt(1, boardNum);
			rs = ps.executeQuery();
			if (rs.next()) {
				content = new BoardContent(boardNum, rs.getString("user_id"), rs.getString("content"),
						rs.getString("product_condition"), rs.getInt("delivery_fee"));
				return content;
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(ps);
		}
		return null;
	}

	public BoardDetail selectDetail(Connection con, Integer boardNum) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardDetail detail = null;
		try {
			ps = con.prepareStatement("select * from board_detail where board_num = ?");
			rs = ps.executeQuery();
			if (rs.next()) {
				detail = new BoardDetail(boardNum, rs.getString("title"), rs.getInt("price"), rs.getInt("likes_cnt"),
						rs.getString("category"), rs.getString("location"), toDate(rs.getTimestamp("created_date")),
						rs.getString("thumb_name"));
				return detail;
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(ps);
		}
		return null;
	}

	public Photo selectPhoto(Connection con, int boardNum) throws SQLException {
		List<String> imageList = new ArrayList<String>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Photo photo = null;
		try {
			ps = con.prepareStatement("select * from photo where board_num = ?");
			ps.setInt(1, boardNum);
			rs = ps.executeQuery();
			while (rs.next()) {
				imageList.add(rs.getString("original_name"));
			}
			photo = new Photo(boardNum, imageList);
			return photo;

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(ps);
		}
	}

	public void insertRecentBoard(Connection con, Board board) throws SQLException {
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into recent_board (board_num, user_id) values (?, ?)");
			ps.setInt(1, board.getBoardNum());
			ps.setString(1, board.getUser2().getId());
			ps.executeQuery();
		} finally {
			JdbcUtil.close(ps);
		}
	}

	public List<BoardDetail> selectAllDetail(Connection con) throws SQLException {
		List<BoardDetail> boardList = new ArrayList<BoardDetail>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("select * from board_detail");
			rs = ps.executeQuery();
			while (rs.next()) {
				boardList.add(new BoardDetail(rs.getInt("board_num"), rs.getString("title"), rs.getInt("price"),
						rs.getInt("likes_cnt"), rs.getString("category"), rs.getString("location"),
						toDate(rs.getTimestamp("created_date")), rs.getString("thumb_name")));
			}
			return boardList;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(ps);
		}
	}

	public List<Integer> selectRecentBoard(Connection con, User2 user) throws SQLException {
		List<Integer> boardNumList = new ArrayList<Integer>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("select board_num from recent_board where user_id = ?");
			ps.setString(1, user.getId());
			rs = ps.executeQuery();

			while (rs.next()) {
				boardNumList.add(rs.getInt("board_num"));
			}

			return boardNumList;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(ps);
		}
	}

	public List<BoardDetail> selectDetailById(Connection con, List<Integer> boardNumList) throws SQLException {
		List<BoardDetail> boardList = new ArrayList<BoardDetail>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			for (int i = 0; i < boardNumList.size(); i++) {
				ps = con.prepareStatement("select * from board_detail where board_num = ?");
				ps.setInt(1, boardNumList.get(i));
				rs = ps.executeQuery();

				if (rs.next()) {
					boardList.add(new BoardDetail(rs.getInt("board_num"), rs.getString("title"), rs.getInt("price"),
							rs.getInt("likes_cnt"), rs.getString("category"), rs.getString("location"),
							toDate(rs.getTimestamp("created_date")), rs.getString("thumb_name")));
				}
			}
			return boardList;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(ps);
		}
	}

	public int selectCount(Connection con) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select count(*) from board_detail");
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	public List<BoardDetail> select(Connection con, int startRow, int size, String category) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			if (category == null || category.equals("all")) {
				pstmt = con.prepareStatement("select * from board_detail " + "order by board_num desc limit ?, ?");
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, size);
			} else {
				pstmt = con.prepareStatement("select * from board_detail where category = ? order by board_num desc limit ?, ?");
				pstmt.setString(1, category);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, size);

			}
			rs = pstmt.executeQuery();
			List<BoardDetail> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertBoardDetail(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private BoardDetail convertBoardDetail(ResultSet rs) throws SQLException {
		return new BoardDetail(rs.getInt("board_num"), rs.getString("title"), rs.getInt("price"),
				rs.getInt("likes_cnt"), rs.getString("category"), rs.getString("location"),
				toDate(rs.getTimestamp("created_date")), rs.getString("thumb_name"));
	}

}